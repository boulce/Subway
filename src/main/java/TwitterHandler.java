import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.List;

public class TwitterHandler extends JFrame {
    static String ConsumerKey = "oXMJIkH2byVZEqppPf6egvqnb";
    static String ConsumerSecret = "4scV8GJ1Wluc5v6WxSslDYzgB5J3sNz4I6uRSQb8UCMX7HeLLE";
    static String AccessToken = "1527944347013943296-a65fRT7dc7cSVZLkTK18LbNPNKKxxe";
    static String AccessTokenSecret = "eMxa5y0KyKswTl6Xj5ySxCykPExnHhpWI93atjlFEjhJl";

    public Twitter getTwitter() {

        ConfigurationBuilder cb = new ConfigurationBuilder();

        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(ConsumerKey)
                .setOAuthConsumerSecret(ConsumerSecret)
                .setOAuthAccessToken(AccessToken)
                .setOAuthAccessTokenSecret(AccessTokenSecret);

        TwitterFactory fac = new TwitterFactory(cb.build());
        Twitter twitter = fac.getInstance();
        return twitter;
    }

    public List<Status> getTweetList(String keyword) throws TwitterException {
        Twitter twitter = getTwitter();

        Query query = new Query(keyword);
        query.setCount(20);
        query.setResultType(Query.POPULAR);

        Status s;

        return twitter.search(query).getTweets();
    }

    TwitterHandler() {
        setSize(1300, 900);
        setTitle("Twitter");
        setLayout(new BorderLayout());

        makeTable();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void makeTable() {
        MultilineTableCellRenderer renderer = new MultilineTableCellRenderer();

        String header[]={"Index", "User", "Date", "contents"};
        String contents[][]={
                {"1","이정현", "50", "☃️ 홍대 야키토리 나루토 \uD83E\uDEF6\uD83C\uDFFB\uD83C\uDF61\n" +
                        "\n" +
                        "숏삐에 빙의해서 야무지게 꼬치 코스 먹고 왔습니다.\n" +
                        "츠쿠네 최고. (*’□’*)\n" +
                        "사와도 넘넘 맛있으니 같이 드시길 추천드려요...♡ "},
                {"2","김영호", "70", "80"},
                {"3","전수용", "80", "65"},
                {"4","김진희", "80", "65"},
                {"5","신정섭", "85", "60"},
                {"6","김승현", "80", "65"},
                {"7","김영석", "80", "65"},
                {"8","이정석", "80", "65"},
                {"8","이승근", "80", "65"},
        };

        JTable table = new JTable(contents, header) {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);

        JTextField textField = new JFormattedTextField();

        table.setDefaultRenderer(String.class, renderer);

        table.getColumnModel().getColumn(3).setCellRenderer(renderer);
        table.getColumn("Index").setPreferredWidth(5);
        table.getColumn("User").setPreferredWidth(10);
        table.getColumn("Date").setPreferredWidth(10);
        table.getColumn("contents").setPreferredWidth(875);
        table.setRowHeight(100);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Search for a word:"), BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);

        add(panel, BorderLayout.SOUTH);

        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String str = textField.getText();
                if (str.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    //(?i) means case insensitive search
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String str = textField.getText();
                if (str.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }
}

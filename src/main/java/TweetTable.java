import twitter4j.Status;
import twitter4j.TwitterException;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TweetTable extends JFrame {

    TweetTable(String keyword, Map<String, List<Status>> map) {

        setSize(1300, 900);
        setTitle("Twitter");
        setLayout(new BorderLayout());

        makeTable(map.get(keyword));

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void makeTable(List<Status> tweetList) {
        MultilineTableCellRenderer renderer = new MultilineTableCellRenderer();

        String header[]={"Index", "User", "Date", "contents"};

        Integer count = 1;
        List<List<String>> rawTweetList = new ArrayList<>();
        for (Status tweet : tweetList) {

            List<String> row = Arrays.asList(count.toString(), tweet.getUser().getName(), tweet.getCreatedAt().toString(), tweet.getText());
            count++;
            rawTweetList.add(row);
        }

        String contents[][] = new String[rawTweetList.size()][];

        int i =0;
        for (List<String> row : rawTweetList) {
            contents[i++] = row.toArray(new String[row.size()]);
        }

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
        panel.add(new JLabel("검색어를 입력하세요:"), BorderLayout.WEST);
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

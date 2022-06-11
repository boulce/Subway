import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        String header[]={"User", "Date", "contents"};
        String contents[][]={
                {"이정현", "50", "60"},
                {"김영호", "70", "80"},
                {"전수용", "80", "65"},
                {"김진희", "80", "65"},
                {"신정섭", "85", "60"},
                {"김승현", "80", "65"},
                {"김영석", "80", "65"},
                {"이정석", "80", "65"},
                {"이승근", "80", "65"},
        };

        JTable table = new JTable(contents, header);

        table.getColumn("User").setPreferredWidth(100);
        table.getColumn("Date").setPreferredWidth(100);
        table.getColumn("contents").setPreferredWidth(700);


        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
    }
}

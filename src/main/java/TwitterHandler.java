import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

public class TwitterHandler {
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
    }
}

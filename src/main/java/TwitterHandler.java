import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

public class TwitterHandler {
    static String ConsumerKey = "ER0ofYPsLidLLVtZy7ALYiJ6a";
    static String ConsumerSecret ="86GU2jwwXLp8IgYtYx1kCwTjMszoMa2yx0uDpVSkddTLwxrhdP";
    static String AccessToken = "1527554246966595585-u7dhuedqw7St5qAscybQrItNmYh88S";
    static String AccessTokenSecret = "027RCgdGuoVxuUqC46v85uDexLNX57urd1OxzphEnxdRm";

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

        Status s;

        return twitter.search(query).getTweets();
    }

    TwitterHandler() {
    }
}

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwitterHandler {
    static String ConsumerKey = "ER0ofYPsLidLLVtZy7ALYiJ6a";
    static String ConsumerSecret ="86GU2jwwXLp8IgYtYx1kCwTjMszoMa2yx0uDpVSkddTLwxrhdP";
    static String AccessToken = "1527554246966595585-u7dhuedqw7St5qAscybQrItNmYh88S";
    static String AccessTokenSecret = "027RCgdGuoVxuUqC46v85uDexLNX57urd1OxzphEnxdRm";

//    static String ConsumerKey = "oXMJIkH2byVZEqppPf6egvqnb";
//    static String ConsumerSecret = "4scV8GJ1Wluc5v6WxSslDYzgB5J3sNz4I6uRSQb8UCMX7HeLLE";
//    static String AccessToken = "1527944347013943296-a65fRT7dc7cSVZLkTK18LbNPNKKxxe";
//    static String AccessTokenSecret = "eMxa5y0KyKswTl6Xj5ySxCykPExnHhpWI93atjlFEjhJl";

    private Map<String, List<Status>> goodResMap = new HashMap<>();
    private Map<String, List<Status>> cafeMap = new HashMap<>();
    private Map<String, List<Status>> hotMap = new HashMap<>();

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

        List<Status> result = new ArrayList<>();

        System.out.println("안들어감");
        Query queryMat = new Query(keyword + " 맛집");
        queryMat.setCount(20);

        Query queryCa = new Query(keyword + " 카페");
        queryCa.setCount(20);

        Query queryHo = new Query(keyword + " 핫플");
        queryHo.setCount(20);

        List<Status> goodRes = twitter.search(queryMat).getTweets();
        result.addAll(goodRes);
        goodResMap.put(keyword, goodRes);

        List<Status> cafe = twitter.search(queryCa).getTweets();
        result.addAll(cafe);
        cafeMap.put(keyword, cafe);

        List<Status> hot = twitter.search(queryHo).getTweets();
        result.addAll(hot);
        hotMap.put(keyword, hot);

        return result;
    }

    TwitterHandler() {
    }

    public Map<String, List<Status>> getGoodResMap() {
        return goodResMap;
    }

    public Map<String, List<Status>> getCafeMap() {
        return cafeMap;
    }

    public Map<String, List<Status>> getHotMap() {
        return hotMap;
    }
}

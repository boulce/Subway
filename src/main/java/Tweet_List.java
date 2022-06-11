import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Tweet_List {
    Tweet_List(String a){new GraphicsDate(a);}
}

class GraphicsDate extends JFrame {
    GraphicsDate(String a) {
        setTitle("List of tweets");
        setContentPane(new MyPanel());
        setSize(700, 400);
        setVisible(true);
    }
    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            java.util.List<String> list_of_retweet = new ArrayList<>();
            list_of_retweet.add("asdfa32sdf");
            list_of_retweet.add("asdfasd3f");
            list_of_retweet.add("asdfasdf4");
            list_of_retweet.add("asdfasdf5");
            list_of_retweet.add("asdfasdf4");
            list_of_retweet.add("asdf45asdf");
            list_of_retweet.add("asdfa65sdf");
            list_of_retweet.add("asdfa64sdf");
            list_of_retweet.add("asdfa464355sdf");
            int count = 0;
            for(String s : list_of_retweet)
            {
                g.drawString(s,150,10 + count);
                count += 5;

            }
        }
    }
}


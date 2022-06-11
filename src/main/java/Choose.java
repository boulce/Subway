import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Choose extends  JFrame{
    Choose(String subwayName, TwitterHandler twitterHandler){
        super("Choose");
        JPanel jPanel = new JPanel();

        setSize(600, 400);

        add(jPanel);

        Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);
        setVisible(true);

        JButton btn1 = new JButton("맛집");
        jPanel.add(btn1);
        add(jPanel);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TweetTable(subwayName, twitterHandler.getGoodResMap());
            }
        });

        JButton btn2 = new JButton("카페");
        jPanel.add(btn2);
        add(jPanel);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TweetTable(subwayName, twitterHandler.getCafeMap());
            }
        });

        JButton btn3 = new JButton("핫플");
        jPanel.add(btn3);
        add(jPanel);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TweetTable(subwayName, twitterHandler.getHotMap());
            }
        });



        btn1.setBounds(190,50,200,30);
        btn2.setBounds(190,100,200,30);
        btn3.setBounds(190,150,200,30);

        jPanel.setLayout(null);
    }
}


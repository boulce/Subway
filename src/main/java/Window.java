import twitter4j.Status;
import twitter4j.TwitterException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class Window extends JFrame{
	public Window() {
		setSize(1300, 900);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("소프트웨어 프로젝트 Subway");
		setLayout(new BorderLayout());

		TwitterHandler twitterHandler = new TwitterHandler();

		List<String> subwayNameList = Arrays.asList(
				"개화", "김포공항", "공항시장", "신방화", "마곡나루", "양천향교", "가양", "증미", "등촌", "염창",
				"동작", "흑석", "노들", "노량진", "샛강", "여의도", "국회의사당", "당산", "선유도", "신목동",
				"반포", "신반포", "고속버스터미널", "사평", "신논현", "언주", "선정릉", "삼성중앙", "봉은사", "종합운동장",
				"중앙보훈병원", "둔촌오륜", "올림픽공원", "한성백제", "송파나루", "석촌", "석촌고분", "삼전"
				);

		List<Integer> subwaySearchNumList = new ArrayList<>();

		try {
			for (String subwayName : subwayNameList) {
				List<Status> tweetList = twitterHandler.getTweetList(subwayName);
				subwaySearchNumList.add(tweetList.size());
			}
		} catch (TwitterException exception) {
			exception.printStackTrace();
		}




		Color[] color = {new Color(0,0,255)};
		//1st line
		JRadioButton btn1 = new JRadioButton();
		JRadioButton btn2 = new JRadioButton();
		JRadioButton btn3 = new JRadioButton();
		JRadioButton btn4 = new JRadioButton();
		JRadioButton btn5 = new JRadioButton();
		JRadioButton btn6 = new JRadioButton();
		JRadioButton btn7 = new JRadioButton();
		JRadioButton btn8 = new JRadioButton();
		//1nd line
		JRadioButton btn9 = new JRadioButton();
		JRadioButton btn10 = new JRadioButton();
		JRadioButton btn11 = new JRadioButton();
		JRadioButton btn12 = new JRadioButton();
		JRadioButton btn13 = new JRadioButton();
		JRadioButton btn14 = new JRadioButton();
		JRadioButton btn15 = new JRadioButton();
		JRadioButton btn16 = new JRadioButton();
		JRadioButton btn17 = new JRadioButton();
		JRadioButton btn18 = new JRadioButton();
		//3rd line
		JRadioButton btn19 = new JRadioButton();
		JRadioButton btn20 = new JRadioButton();
		JRadioButton btn21 = new JRadioButton();
		JRadioButton btn22 = new JRadioButton();
		JRadioButton btn23 = new JRadioButton();
		JRadioButton btn24 = new JRadioButton();
		JRadioButton btn25 = new JRadioButton();
		JRadioButton btn26 = new JRadioButton();
		JRadioButton btn27 = new JRadioButton();
		JRadioButton btn28 = new JRadioButton();
		JRadioButton btn29 = new JRadioButton();
		//4th line
		JRadioButton btn30 = new JRadioButton();
		JRadioButton btn31 = new JRadioButton();
		JRadioButton btn32 = new JRadioButton();
		JRadioButton btn33 = new JRadioButton();
		JRadioButton btn34 = new JRadioButton();
		JRadioButton btn35 = new JRadioButton();
		JRadioButton btn36 = new JRadioButton();
		JRadioButton btn37 = new JRadioButton();
		JRadioButton btn38 = new JRadioButton();

		// ★ 버튼 위치와 크기 설정

		btn1.setContentAreaFilled(false);
		btn1.setBounds(361,714,16,14);
		btn2.setContentAreaFilled(false);
		btn2.setBounds(461,714,16,14);
		btn3.setContentAreaFilled(false);
		btn3.setBounds(561,714,16,14);
		btn4.setContentAreaFilled(false);
		btn4.setBounds(661,714,16,14);
		btn5.setContentAreaFilled(false);
		btn5.setBounds(761,714,16,14);
		btn6.setContentAreaFilled(false);
		btn6.setBounds(861,714,16,14);
		btn7.setContentAreaFilled(false);
		btn7.setBounds(961,714,16,14);
		btn8.setContentAreaFilled(false);
		btn8.setBounds(1061,714,16,14);
		//2nd line
		btn9.setContentAreaFilled(false);
		btn9.setBounds(161,544,16,14);
		btn10.setContentAreaFilled(false);
		btn10.setBounds(261,544,16,14);
		btn11.setContentAreaFilled(false);
		btn11.setBounds(361,544,16,14);
		btn12.setContentAreaFilled(false);
		btn12.setBounds(461,544,16,14);
		btn13.setContentAreaFilled(false);
		btn13.setBounds(561,544,16,14);
		btn14.setContentAreaFilled(false);
		btn14.setBounds(661,544,16,14);
		btn15.setContentAreaFilled(false);
		btn15.setBounds(761,544,16,14);
		btn16.setContentAreaFilled(false);
		btn16.setBounds(861,544,16,14);
		btn17.setContentAreaFilled(false);
		btn17.setBounds(961,544,16,14);
		btn18.setContentAreaFilled(false);
		btn18.setBounds(1061,544,16,14);
		//3rd line
		btn19.setContentAreaFilled(false);
		btn19.setBounds(161,374,16,14);
		btn20.setContentAreaFilled(false);
		btn20.setBounds(261,374,16,14);
		btn21.setContentAreaFilled(false);
		btn21.setBounds(361,374,16,14);
		btn22.setContentAreaFilled(false);
		btn22.setBounds(461,374,16,14);
		btn23.setContentAreaFilled(false);
		btn23.setBounds(561,374,16,14);
		btn24.setContentAreaFilled(false);
		btn24.setBounds(661,374,16,14);
		btn25.setContentAreaFilled(false);
		btn25.setBounds(761,374,16,14);
		btn26.setContentAreaFilled(false);
		btn26.setBounds(861,374,16,14);
		btn27.setContentAreaFilled(false);
		btn27.setBounds(961,374,16,14);
		btn28.setContentAreaFilled(false);
		btn28.setBounds(1061,374,16,14);
		//4th line
		btn29.setContentAreaFilled(false);
		btn29.setBounds(161,204,16,14);
		btn30.setContentAreaFilled(false);
		btn30.setBounds(261,204,16,14);
		btn31.setContentAreaFilled(false);
		btn31.setBounds(361,204,16,14);
		btn32.setContentAreaFilled(false);
		btn32.setBounds(461,204,16,14);
		btn33.setContentAreaFilled(false);
		btn33.setBounds(561,204,16,14);
		btn34.setContentAreaFilled(false);
		btn34.setBounds(661,204,16,14);
		btn35.setContentAreaFilled(false);
		btn35.setBounds(761,204,16,14);
		btn36.setContentAreaFilled(false);
		btn36.setBounds(861,204,16,14);
		btn37.setContentAreaFilled(false);
		btn37.setBounds(961,204,16,14);
		btn38.setContentAreaFilled(false);
		btn38.setBounds(1061,204,16,14);



		// ★ 프레임에다가 버튼 추가
		add(btn1); add(btn2); add(btn3); add(btn4); add(btn5); add(btn6); add(btn7); add(btn8);
		//2nd line
		add(btn9); add(btn10); add(btn11); add(btn12); add(btn13); add(btn14); add(btn15); add(btn16); add(btn17); add(btn18);
		//3rd line
		add(btn19); add(btn20); add(btn21); add(btn22); add(btn23); add(btn24); add(btn25); add(btn26); add(btn27); add(btn28);
		//4rd line
		add(btn29); add(btn30); add(btn31); add(btn32); add(btn33); add(btn34); add(btn35); add(btn36); add(btn37); add(btn38);

		btn37.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Tweet_List("ㅎㅎ");
			}
		});

		SubwayLinePanel slp = new SubwayLinePanel();
		add(slp);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}

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
		SubwayLinePanel slp = new SubwayLinePanel();

		java.util.List<String> subwayNameList = Arrays.asList(
				"중앙보훈병원", "둔촌오륜", "올림픽공원", "한성백제", "송파나루", "석촌", "석촌고분", "삼전", "구반포", "신반포",
				"고속터미널", "사평", "신논현", "언주", "선정릉", "삼성중앙", "봉은사", "종합운동장", "동작", "흑석",
				"노들", "노량진", "샛강", "여의도", "국회의사당", "당산", "선유도", "신목동", "개화", "김포공항",
				"공항시장", "신방화", "마곡나루", "양천향교", "가양", "증미", "등촌", "염창"
		);

		List<JRadioButton> buttonList = new ArrayList<>();

		int count = 0;
		for (int i = 0; i < 39; i++) {
			JRadioButton button = new JRadioButton();
			button.setContentAreaFilled(false);

			if (i <= 7)
				button.setBounds(361 + count*100,714,16,14);
			else if (i <= 17)
				button.setBounds(161 + count*100,544,16,14);
			else if (i <= 27)
				button.setBounds(161 + count*100,374,16,14);
			else if (i <= 37)
				button.setBounds(161 + count*100,204,16,14);

			count++;
			if (i == 7)
				count = 0;
			else if (i == 17)
				count = 0;
			else if (i == 27)
				count = 0;

			buttonList.add(button);
		}

		for (JRadioButton button : buttonList) {
			add(button);

			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(subwayNameList.get(buttonList.indexOf(button)));
					new Choose(subwayNameList.get(buttonList.indexOf(button)), slp.getTwitterHandler());
				}
			});
		}

		add(slp);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}

import twitter4j.Status;
import twitter4j.TwitterException;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class SubwayLinePanel extends JPanel {
	Shape platformNode[][] = new Shape[4][10];
	final int xInterval = 100;
	final int yInterval = 170;


	public SubwayLinePanel()
	{


		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 10; j++)
			{
				int x = xInterval * j + 160;
				int y = yInterval * i + 200;
				int diameter = 20;
				platformNode[i][j] = new Ellipse2D.Double(x, y, diameter, diameter);
			}
	}

	public void paintComponent(Graphics g)
	{

		TwitterHandler twitterHandler = new TwitterHandler();

		java.util.List<String> subwayNameList = Arrays.asList(
				"개화", "김포공항", "공항시장", "신방화", "마곡나루", "양천향교", "가양", "증미", "등촌", "염창",
				"동작", "흑석", "노들", "노량진", "샛강", "여의도", "국회의사당", "당산", "선유도", "신목동",
				"반포", "신반포", "고속버스터미널", "사평", "신논현", "언주", "선정릉", "삼성중앙", "봉은사", "종합운동장",
				"중앙보훈병원", "둔촌오륜", "올림픽공원", "한성백제", "송파나루", "석촌", "석촌고분", "삼전"
		);

		java.util.List<Integer> subwaySearchNumList = new ArrayList<>();

//		try {
//			for (String subwayName : subwayNameList) {
//				List<Status> tweetList = twitterHandler.getTweetList(subwayName);
//				subwaySearchNumList.add(tweetList.size());
//			}
//		} catch (TwitterException exception) {
//			exception.printStackTrace();
//		}

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.ORANGE);
		for(int i = 0; i < 4; i++)
		{
			/*
			 * 노선도 중 선 그리기
			 */
			// 가로 선 그리기
			int startX = (xInterval * 0 + 235) -100;// 선의 시작 X
			int   endX = (xInterval * 9 + 200) + 60; // 선의 끝 X
			int Y = (yInterval * i + 200) + 10;  // 각 원의 Y + 반지름
			g2d.setStroke(new BasicStroke(3));  // 선 굵기 설정
			g2d.drawLine(startX, Y, endX, Y);

			// 세로 선 그리기
			if(i == 0)
				g2d.drawLine(endX, Y, endX, Y + yInterval);
			else if(i == 1)
				g2d.drawLine(startX, Y, startX, Y + yInterval);
			else if(i == 2)
				g2d.drawLine(endX, Y, endX, Y + yInterval);
		}

		/*
		 * 노선도 중 원(노드) 그리기
		 */
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 10; j++)
			{
				// 마지막 행은 노드가 8개밖에 없으므로
				// (i = 3, j = 0, 1)인 노드는 그리지 않는다
				if( 1 <= subwaySearchNumList.get(i * 10 + j) && subwaySearchNumList.get(i * 10 + j) <= 7){
					g.setColor(Color.GREEN);
				}else if( subwaySearchNumList.get(i * 10 + j) <= 15){
					g.setColor(Color.YELLOW);
				}else{
					g.setColor(Color.RED);
				}
				if(i == 3 && j < 2)
					continue;
				g2d.fill(platformNode[i][j]);
				g2d.draw(platformNode[i][j]);
			}
		}


		Color color5 = new Color(127, 0, 255);
		Color colora = new Color(0, 236, 253);
		Color colorb = new Color(153, 76, 0);
		Color color4 = new Color(0, 128, 255);
		Color color2 = new Color(0, 204, 0);
		Color color3 = new Color(253, 68, 0);
		Color color7 = new Color(51, 102, 0);
		g.setFont(new Font("서울남산체 M", Font.BOLD, 50));
		g.setColor(Color.ORANGE);
		g.drawString("⑨", 85, 735);
		g.drawString("⑨", 85, 225);
		AffineTransform defaultAt = g2d.getTransform();

		// rotates the coordinate by 90 degree counterclockwise
		AffineTransform at = new AffineTransform();
		g.setFont(new Font("서울남산체 M", Font.BOLD, 30));
		at.rotate(-Math.PI / 4);
		g2d.setTransform(at);
		g2d.drawString("개화", -10, 270);
		g.setColor(Color.BLACK);
		g2d.drawString("김포공항", 55, 335);
		g.setColor(color5);
		g2d.drawString("⑤", 165, 335);
		g.setColor(colora);
		g.setFont(new Font("서울남산체 M", Font.BOLD, 21));
		g2d.drawString("공항", 195, 330);
		g.setColor(colorb);
		g2d.drawString("김포골드", 235, 330);
		g.setFont(new Font("서울남산체 M", Font.BOLD, 30));
		g.setColor(Color.GRAY);
		g2d.drawString("공항시장", 125, 405);
		g2d.drawString("신방화", 200, 480);
		g.setColor(Color.BLACK);
		g2d.drawString("마곡나루", 275, 555);
		g.setColor(colora);
		g.setFont(new Font("서울남산체 M", Font.BOLD, 21));
		g2d.drawString("공항", 390, 550);
		g.setFont(new Font("서울남산체 M", Font.BOLD, 30));
		g.setColor(Color.GRAY);
		g2d.drawString("양천향교", 340, 620);
		g2d.drawString("가양", 410, 690);
		g2d.drawString("증미", 480, 760);
		g2d.drawString("등촌", 555, 835);
		g2d.drawString("염창", 620, 900);
		//2nd line
		g.setColor(Color.BLACK);
		g2d.drawString("동작", -130, 390);
		g.setColor(color4);
		g2d.drawString("④", -70, 390);
		g.setColor(Color.GRAY);
		g2d.drawString("흑석", -60, 460);
		g2d.drawString("노들", 10, 530);
		g.setColor(Color.BLACK);
		g2d.drawString("노량진", 80, 600);
		g.setColor(Color.BLUE);
		g2d.drawString("①", 165, 600);
		g.setColor(Color.GRAY);
		g2d.drawString("샛강", 150, 675);
		g.setColor(Color.BLACK);
		g2d.drawString("여의도", 220, 745);
		g.setColor(color5);
		g2d.drawString("⑤", 305, 740);
		g.setColor(Color.GRAY);
		g2d.drawString("국회의사당", 290, 810);
		g.setColor(Color.BLACK);
		g2d.drawString("당산", 360, 885);
		g.setColor(color2);
		g2d.drawString("②", 420, 885);
		g.setColor(Color.GRAY);
		g2d.drawString("선유도", 430, 955);
		g2d.drawString("신목동", 505, 1025);
		//3rd line
		g2d.drawString("구반포", -250, 510);
		g2d.drawString("신반포", -180, 580);
		g.setColor(Color.BLACK);
		g.setFont(new Font("서울남산체 M", Font.BOLD, 27));
		g2d.drawString("고속버스터미널", -110, 645);
		g.setFont(new Font("서울남산체 M", Font.BOLD, 30));
		g.setColor(color3);
		g2d.drawString("②", -70, 615);
		g.setColor(color7);
		g2d.drawString("⑦", -25, 615);
		g.setColor(Color.GRAY);
		g2d.drawString("사평", -40, 720);
		g2d.drawString("신논현", 30, 790);
		g2d.drawString("언주", 100, 865);
		g.setColor(Color.BLACK);
		g2d.drawString("선정릉", 170, 935);
		g.setColor(Color.ORANGE);
		g.setFont(new Font("서울남산체 M", Font.BOLD, 21));
		g2d.drawString("분당", 255, 930);
		g.setFont(new Font("서울남산체 M", Font.BOLD, 30));
		g.setColor(Color.GRAY);
		g2d.drawString("삼성중앙", 240, 1000);
		g2d.drawString("봉은사", 310, 1070);
		g.setColor(Color.BLACK);
		g2d.drawString("종합운동장", 380, 1145);
		g.setColor(color2);
		g2d.drawString("②", 525, 1145);
		g.setColor(Color.GRAY);
		//last line
		g2d.drawString("중앙보훈병원", -230, 770);
		g2d.drawString("둔촌오륜", -160, 840);
		g.setColor(Color.BLACK);
		g2d.drawString("올림픽공원", -90, 910);
		g.setColor(color5);
		g2d.drawString("⑤", 50, 910);
		g.setColor(Color.GRAY);
		g2d.drawString("한성백제", -20, 980);
		g2d.drawString("송파나루", 50, 1050);
		g.setColor(Color.BLACK);
		g2d.drawString("석촌", 120, 1120);
		g.setColor(Color.magenta);
		g2d.drawString("⑧", 175, 1120);
		g.setColor(Color.GRAY);
		g2d.drawString("석촌고분", 190, 1190);
		g2d.drawString("삼전", 260, 1260);
		g2d.setTransform(defaultAt);
	}

}
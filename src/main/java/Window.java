import java.awt.BorderLayout;
import javax.swing.*;

public class Window extends JFrame{
	public Window()
	{
		setSize(1000, 800);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("����Ʈ���� ������Ʈ Subway");
		setLayout(new BorderLayout());
		
		SubwayLinePanel slp = new SubwayLinePanel();
		add(slp);
		setVisible(true);
	}
}

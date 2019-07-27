import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame;
	GamePanel gamePanel;
	final static int HEIGHT = 800;
	final static int WIDTH = 500;
	
public static void main(String[] args) {
LeagueInvaders leagueInvaders = new LeagueInvaders();
leagueInvaders.setup();
}
LeagueInvaders(){
		frame = new JFrame();
		gamePanel = new GamePanel();
}
private void setup() {
	frame.add(gamePanel);
	frame.addKeyListener(gamePanel);
	gamePanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.pack();
}
}
					
//ADD IMMAGES
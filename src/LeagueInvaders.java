import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame;
	GamePanel gamepanel;
	final static int HEIGHT = 800;
	final static int WIDTH = 500;
	
public static void main(String[] args) {
LeagueInvaders leagueInvaders = new LeagueInvaders();
leagueInvaders.setup();
}
LeagueInvaders(){
		frame = new JFrame();
		gamepanel = new GamePanel();
}
private void setup() {
	frame.add(gamepanel);
	gamepanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.pack();
}
}
					//PT2, step 12
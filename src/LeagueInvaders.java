import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame = new JFrame();
	GamePanel gamepanel;
	final int HEIGHT = 800;
	final int WIDTH = 500;
public static void main(String[] args) {
LeagueInvaders leagueInvaders = new LeagueInvaders();
leagueInvaders.setup();
}
LeagueInvaders(){
		frame = new JFrame();
		gamepanel = new GamePanel();
}
private void setup() {
	JPanel panel = new JPanel();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.setVisible(true);
	frame.setVisible(true);
}
}

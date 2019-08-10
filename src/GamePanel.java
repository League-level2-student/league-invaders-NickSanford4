import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
public static BufferedImage image;
final int MENU = 0;
Timer alienSpawn;
	final int GAME = 1;
	final int END = 2;
	ObjectManager om;
	Rocketship ship;
	int currentState = MENU;
	
	
	GamePanel() {
		Timer FrameDraw;
		FrameDraw = new Timer(1000 / 60, this);
		FrameDraw.start();
		ship = new Rocketship(250, 700, 50, 50);
		om = new ObjectManager(ship);
		try 
		{
			image = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	

	void updateMenuState() {
	}

	void updateGameState() {
		om.update();
		if (ship.isActive==false) {
			currentState=END;
			alienSpawn.stop();
		}
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.MAGENTA);
		g.drawString("LEAGE INVADERS", 40, 100);
		g.setFont(enter);
		g.setColor(Color.magenta);
		g.drawString("Press ENTER to Start", 120, 300);
		g.drawString("Press SPACE for Instructions", 85, 520);
	}

	void drawGameState(Graphics g) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
			om.Draw(g);
		
	}

	void drawEndState(Graphics g) {
		{
			g.setColor(Color.RED);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
			g.setFont(titleFont);
			g.setColor(Color.YELLOW);
			g.drawString("GAME OVER", 80, 100);
			g.setFont(enter);
			g.setColor(Color.yellow);
			g.drawString("You Killed "+om.getScore()+" Enemies", 125, 300);
			g.drawString("Press Enter to go to Home", 125, 520);

		}

	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	Font titleFont = new Font("Arial", Font.BOLD, 48);
	Font enter = new Font("arial", Font.PLAIN, 25);

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		System.out.println("action");
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				ship = new Rocketship(250, 700, 50, 50);
				om.setShip(ship);
			}
			if (currentState == END) {
				currentState = MENU;
			} else {
				if(currentState==MENU) {
				startGame();	
				}
				else if(currentState==GAME) {
					alienSpawn.stop();
				}
				currentState++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			ship.up();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ship.down();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ship.left();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ship.right();
		}
if(currentState == GAME && e.getKeyCode() == KeyEvent.VK_SPACE) {
	om.addProjectile(ship.getProjectile());
}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
void startGame() {
    alienSpawn = new Timer(1000 , om);
    alienSpawn.start();
}
}

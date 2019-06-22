import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{	
	Timer timer;
	
GamePanel(){
	timer=new Timer(1000/60,this);
}
void startGame() {
	timer.start();
}
final int MENU = 0;
final int GAME = 1;
final int END = 2;
int currentState = MENU;
void updateMenuState() {  }
void updateGameState() {  }
void updateEndState()  {  }

void drawMenuState(Graphics g) {g.setColor(Color.BLUE);
g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
g.setFont(titleFont);
g.setColor(Color.MAGENTA);
g.drawString("LEAGE INVADERS", 40, 100);
g.setFont(enter);
g.setColor(Color.magenta);
g.drawString("Press ENTER To Start", 120, 300);
g.drawString("Press SPACE For Instructions", 85, 520);
}
void drawGameState(Graphics g) {  }
void drawEndState(Graphics g)  {  }
@Override
public void paintComponent(Graphics g){
	if(currentState == MENU){
	    drawMenuState(g);
	}else if(currentState == GAME){
	    drawGameState(g);
	}else if(currentState == END){
	    drawEndState(g);
	}
}
Font titleFont = new Font("Arial", Font.BOLD, 48);
Font enter = new Font("arial",Font.PLAIN,25);
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}


	
}
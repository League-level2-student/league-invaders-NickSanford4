import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{	
	

GamePanel(){
	Timer FrameDraw;
	FrameDraw=new Timer(1000/60,this);
	FrameDraw.start();
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
void drawGameState(Graphics g) {{g.setColor(Color.BLACK);
g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
}}
void drawEndState(Graphics g)  {{g.setColor(Color.RED);
g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
g.setFont(titleFont);
g.setColor(Color.YELLOW);
g.drawString("GAME OVER", 80, 100);
g.setFont(enter);
g.setColor(Color.yellow);
g.drawString("You Killed _ Enemies", 125, 300);
g.drawString("Press Enter To Start", 125, 520);

}
	
	
}
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
	if(currentState == MENU){
    updateMenuState();
}else if(currentState == GAME){
    updateGameState();
}else if(currentState == END){
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
	if (e.getKeyCode()==KeyEvent.VK_ENTER) {
	    if (currentState == END) {
	        currentState = MENU;
	    } else {
	        currentState++;
	    }
	}   
	if (e.getKeyCode()==KeyEvent.VK_UP) {
	    System.out.println("UP");
	}if (e.getKeyCode()==KeyEvent.VK_DOWN) {
	    System.out.println("DOWN");
	}
	if (e.getKeyCode()==KeyEvent.VK_LEFT) {
	    System.out.println("LEFT");
	}
	if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
	    System.out.println("RIGHT");
	}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


	
}


//MODEL
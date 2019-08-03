import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Rocketship ship;
	ArrayList<Projectile> projectiles = new ArrayList();
	ArrayList<Alien> aliens = new ArrayList();
	Random random = new Random();
	ObjectManager(Rocketship ship) {
this.ship = ship;
}
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	void update() {
		for (int i = 0; i < aliens.size() ; i++) {
			if(aliens.get(i).y>LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive=false;
			}
		}
		
	}
	void Draw(Graphics g) {
		ship.draw(g);
		for (int i = 0; i < aliens.size() ; i++) {
		aliens.get(i).draw(g);
		}
	}
	void purgeObjects() {
		for(int i = aliens.size()-1; i >=0; i--) {
		if (aliens.get(i).isActive = false) {
			aliens.remove(i);
		}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
	
}

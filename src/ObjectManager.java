import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	int score = 0;
	Rocketship ship;
	ArrayList<Projectile> projectiles = new ArrayList();
	ArrayList<Alien> aliens = new ArrayList();
	Random random = new Random();
void setShip(Rocketship ship) {
	this.ship = ship;
}
 int getScore() {
	 return score;
 }
	ObjectManager(Rocketship ship) {
		this.ship = ship;
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).y > LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
			}
			aliens.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).y > LeagueInvaders.HEIGHT) {
				projectiles.get(i).isActive = false;
			}
			projectiles.get(i).update();
		}
		ship.update();
		checkCollision();
		purgeObjects();
	}

	void Draw(Graphics g) {
		ship.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}

	void purgeObjects() {
		for (int i = aliens.size() - 1; i >= 0; i--) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		for (int i = projectiles.size() - 1; i >= 0; i--) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();

	}

	void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if (ship.collisionBox.intersects(aliens.get(i).collisionBox)) {
				aliens.get(i).isActive = false;
				ship.isActive = false;
				projectiles.clear();
				aliens.clear();
			}
			for (int j = 0; j < projectiles.size(); j++) {
				if (projectiles.get(j).collisionBox.intersects(aliens.get(i).collisionBox)) {
					aliens.get(i).isActive = false;
					projectiles.get(j).isActive = false;
					score ++;
				}
			}

		}
	}
}

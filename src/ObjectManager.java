import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
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
		
	}
}

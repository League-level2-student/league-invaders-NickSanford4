import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

	}

	public void up() {
		y -= speed;
	}

	public void down() {
		y += speed;
	}

	public void left() {
		x -= speed;
	}

	public void right() {
		x += speed;
	}

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

}
//ADD IMMAGES
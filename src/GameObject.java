import java.awt.Rectangle;

public class GameObject {
	Rectangle collisionBox;
	int x;
	 int y;
	 int width;
	 int height;
	 int speed = 0;
	 boolean isActive = true;
GameObject(int x, int y, int width, int height){
	this.collisionBox = new Rectangle(x, y, width, height);
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	update();
}
 void update() {
	// TODO Auto-generated method stub
	  collisionBox.setBounds(x, y, width, height);

}
}
import java.awt.*;
public class Solid {
  public float x;
	public float y;
	public float tX;
	public float tY;
	public float tThespeed;
	public float tFalling;
	public boolean tOnGround;
	
	public Solid(int tempX, int tempY){
		x = tempX*32;
		y = tempY*32;
	}
	void draw(Graphics graphics){
		graphics.setColor(new Color(0,0,0,255));
		graphics.fillRect((int)x,(int)y,32,32);
	}
	void collision(float theirX, float theirY, float theirThespeed, float theirFalling, boolean theirOnGround){
		tX = theirX;
		tY = theirY;
		tOnGround = theirOnGround;
		tThespeed = theirThespeed;
		tFalling = theirFalling;
		if (tY + tFalling + 64 > y && tY + 64 <= y && tX+tThespeed < x+32 && tX+32+tThespeed > x){
			tY = y-64;
			tFalling = 0;
			tOnGround = true;
		}
		if (tY + tFalling < y+32 && tY >= y+32 && tX+tThespeed < x+32 && tX+32+tThespeed > x){
			tY = y+32;
			tFalling = 0;
		}
		if (tX + tThespeed + 32> x && tX + 32<= x && tY+tFalling < y+32 && tY+64+tFalling > y){
			tX = x-32;
			tThespeed = 0;
		}
		if (tX + tThespeed < x+32 && tX >= x+32 && tY+tFalling < y+32 && tY+64+tFalling > y){
			tX = x+32;
			tThespeed = 0;
		}
	}
}

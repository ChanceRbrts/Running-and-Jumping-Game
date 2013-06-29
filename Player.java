import java.awt.*;
public class Player {
  public float x;
	public float y;
	public float thespeed;
	public float falling;
	public boolean onGround;
	public boolean leftOrRight;
	public Color myColor;
	public Player(int tempX, int tempY){
		x = tempX*32;
		y = tempY*32;
		thespeed = 0;
		falling = 0;
		onGround = false;
		leftOrRight = true;
		myColor = new Color(255,255,255,255);
	}
	public void update(){
		if (constant.rightPressed == true && constant.leftPressed == false){
			leftOrRight = true;
		}
		if (constant.leftPressed == true && constant.rightPressed == false){
			leftOrRight = false;
		}
		if (constant.runPressed == false){
			if (leftOrRight == true){
				if (thespeed < 0){
					thespeed += 0.5;
				}
				else{
					thespeed += 0.25;
				}
				if (thespeed > 8){
					thespeed = 8;
				}
			}
			else{
				if (thespeed > 0){
					thespeed -= 0.5;
				}
				else{
					thespeed -= 0.25;
				}
				if (thespeed < -8){
					thespeed = -8;
				}
			}
		}
		else{
			if (constant.rightPressed == true && constant.leftPressed == false){
				if (thespeed > 4){
					thespeed -= 0.5;
				}
				else{
					thespeed += 0.25;
					if (thespeed > 4){
						thespeed = 4;
					}
				}
			}
			else if (constant.rightPressed == false && constant.leftPressed == true){
				if (thespeed < -4){
					thespeed += 0.5;
				}
				else{
					thespeed -= 0.25;
					if (thespeed < -4){
						thespeed = -4;
					}
				}
			}
			else if (constant.rightPressed == false && constant.leftPressed == false){
				if (thespeed >= 0.5){
					thespeed -= 0.5;
				}
				else if (thespeed <= -0.5){
					thespeed += 0.5;
				}
				else{
					thespeed = 0;
				}
			}
		}
		gravity();
	}
	public void gravity(){
		if (onGround == false){
		falling += 0.25;
			if (falling > 16){
				falling = 16;
			}
		}
		else{
			if (constant.jumpPressed == false){
				falling = -8;
				onGround = false;
			}
			onGround = false;
		}
	}
	public void draw(Graphics g){
		g.setColor(myColor);
		g.fillRect((int)x,(int)y,32,64);
	}
	public void endCollision(float tempX, float tempY, float tempThespeed, float tempFalling, boolean tempOnGround){
		x = tempX;
		y = tempY;
		thespeed = tempThespeed;
		falling = tempFalling;
		onGround = tempOnGround;
	}
	public void finishUpdate(){
		x += thespeed;
		y += falling;
	}
}

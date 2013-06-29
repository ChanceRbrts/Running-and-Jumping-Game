import java.awt.*;
public class Objects {
  Player player;
	Solid[] solid, tempsolid;
	public levels.Level_1 LevelOne;
	public int solidcount;
	String[] tempRoom;
	public Objects(){
		player = new Player(5,8);
		solid = new Solid[2];
		solid[0] = new Solid(10,9);
		solid[1] = new Solid(0,9);
		solidcount = 0;
		LevelOne = new levels.Level_1();
	}
	public void update(){
		player.update();
		for (int i = 0; i < solid.length; i++){
			solid[i].collision(player.x,player.y,player.thespeed,player.falling,player.onGround);
			player.endCollision(solid[i].tX,solid[i].tY,solid[i].tThespeed,solid[i].tFalling,solid[i].tOnGround);
		}
		player.finishUpdate();
	}
	public void draw(Graphics graphics){
		player.draw(graphics);
		for (int i = 0; i < solid.length; i++){
			solid[i].draw(graphics);
		}
	}
	public void Transition(float tempLev){
		if (tempLev == 1){
			tempRoom = LevelOne.level;
			for (int i = 0; i < tempRoom.length; i++){
				System.out.println(tempRoom[i]);
			}
		}
		solidcount = 0;
		for (int i = 0; i < tempRoom.length; i++){
			for (int j = 0; j < tempRoom[i].length();j++){
				if (tempRoom[i].charAt(j) == 'P'){
					player = new Player(j,i);
				}
				if (tempRoom[i].charAt(j) == 'S'){
					solidcount += 1;
					if (solidcount == 1){
						solid = new Solid[1];
						solid[0] = new Solid(j,i);
					}
					else if (solidcount > 1){
						tempsolid = solid;
						solid = new Solid[solidcount];
						for (int a = 0; a < solidcount-1; a++){
							solid[a] = tempsolid[a];
						}
						solid[solidcount-1] = new Solid(j,i);
					}
				}
			}
		}
	}
}

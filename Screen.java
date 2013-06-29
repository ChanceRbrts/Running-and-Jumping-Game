import java.awt.*;
public class Screen extends Canvas{
  Color background;
	Objects objects;
	Image doubleBuffer;
	Graphics dB;
	public Screen(){
		objects = new Objects();
	}
	public void BG(int red,int green,int blue,int alpha){
		background = new Color(red,green,blue,alpha);
	}
	public void draw(){
		objects.update();
		repaint();
	}
	public void paint(Graphics graphics){
		doubleBuffer = createImage(640,480);
		dB = doubleBuffer.getGraphics();
		objects.draw(dB);
		graphics.drawImage(doubleBuffer, 0, 0, this);
	}
}

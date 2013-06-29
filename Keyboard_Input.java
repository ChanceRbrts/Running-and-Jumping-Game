import java.awt.event.*;
public class Keyboard_Input implements KeyListener{
  public void keyPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			constant.leftPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			constant.rightPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			constant.downPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_Z){
			constant.runPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_X){
			constant.jumpPressed = true;
		}
	}
	public void keyReleased(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			constant.leftPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			constant.rightPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			constant.downPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_Z){
			constant.runPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_X){
			constant.jumpPressed = false;
		}
	}
	public void keyTyped(KeyEvent e){
		
	}
}

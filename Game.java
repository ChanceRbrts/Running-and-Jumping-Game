import javax.swing.*;
public class Game {
  JFrame window;
	Screen screen;
	Keyboard_Input keyput;
	int width, height;
	boolean gameLoop;
	public static void main(String[] args) {
		Game game = new Game();
		game.setup();
		game.draw();
	}
	public void setup(){
		width = 640;
		height = 480;
		gameLoop = true;
		keyput = new Keyboard_Input();
		window = new JFrame();
		window.addKeyListener(keyput);
		window.setVisible(true);
		window.setSize(width,height);
		window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		screen = new Screen();
		screen.objects.Transition(1);
		screen.BG(170,232,255,255);
		screen.setSize(width,height);
		screen.setBackground(screen.background);
		window.add(screen);
	}
	public void draw(){
		while (gameLoop == true){
			screen.draw();
			try {
				Thread.sleep(17);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

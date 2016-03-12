package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import utility.Constants;

public class Main extends JFrame implements KeyListener{
	
	private Screen screen;
	
	public Main(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Constants.width, Constants.height);
		setResizable(false);
		setTitle("RayTracer");
		
		initialise();
	}
	
	public void initialise(){
		setLocationRelativeTo(null);
		screen = new Screen(this);
		add(screen);
		setVisible(true);
		addKeyListener(this);
	}
	
	public static void main(String[] args){
		new Main();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
			screen.updateCamera(1);
		}
		else if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
			screen.updateCamera(-1);
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}

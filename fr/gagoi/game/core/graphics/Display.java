package fr.gagoi.game.core.graphics;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Display extends JFrame{
	private static final long serialVersionUID = 5490346374601668503L;
	private final Dimension size = new Dimension(960, 540);
	private GameCanvas canvas;
	
	
	public Display() {
		setTitle("AdcDodgeInFightOMATON");
		setResizable(false);
		setSize(size);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		canvas = new GameCanvas();
		add(canvas);
	}
	
	public void render() {
		canvas.render();
	}
	
	public void drawFinalScreen(){
		canvas.drawFinalScreen();
	}
}

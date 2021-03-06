package fr.gagoi.game.core.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fr.gagoi.game.core.Game;
import fr.gagoi.game.core.entities.Bomb;
import fr.gagoi.game.core.entities.Bullet;
import fr.gagoi.game.core.entities.Healer;

public class GameCanvas extends Canvas {
	private static final long serialVersionUID = 7242788760643934733L;
	
	private BufferedImage img = new BufferedImage(960, 540, BufferedImage.TYPE_INT_RGB);

	public GameCanvas() {
		requestFocus();
		addMouseListener(Game.p);
	}
	
	public void render() {
		Graphics g = img.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 960, 540);
		g.setColor(Color.WHITE);
		g.fillRect((int) Game.p.getPosX(),(int) Game.p.getPosY(), Game.p.getSize(), Game.p.getSize());
		

		for (int i = 0; i < Game.bombs.size(); i++) {
			Bomb b = Game.bombs.elementAt(i);
			g.setColor(b.getColor());
			g.fillOval((int) b.getPosX(),(int) b.getPosY(), b.getSize(), b.getSize());
		}

		for (int i = 0; i < Game.healers.size(); i++) {
			Healer h = Game.healers.elementAt(i);
			g.setColor(h.getColor());
			g.fillRect((int) h.getPosX(),(int) h.getPosY(), h.getSize(),h.getSize());
		}
		
		for (int i = 0; i < Game.bullets.size(); i++) {
			Bullet b = Game.bullets.elementAt(i);
			g.setColor(b.getColor());
			g.fillRect((int) b.getPosX(),(int) b.getPosY(), b.getSize(), b.getSize());
		}
		
		g.setColor(Color.WHITE);
		g.drawString("Score : " + Game.p.getScore(), 5, 10);
		g.drawString("Time survive : " + Game.timeInSec, 5, 20);
		getGraphics().drawImage(img, 0, 0, null);
	}

	public void drawFinalScreen() {
		Graphics g = img.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 960, 540);
		g.setColor(Color.PINK);
		g.drawString("Tu as tenu " + Game.timeInSec + " secondes !!", 400, 250);
		getGraphics().drawImage(img, 0, 0, null);
	}
}

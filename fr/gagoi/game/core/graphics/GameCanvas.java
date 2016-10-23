package fr.gagoi.game.core.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fr.gagoi.game.core.Game;
import fr.gagoi.game.core.entities.Bomb;
import fr.gagoi.game.core.entities.Bullet;

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
		
		for (int i = 0; i < Game.bullets.size(); i++) {
			Bullet b = Game.bullets.elementAt(i);
			g.setColor(b.getColor());
			g.fillRect((int) b.getPosX(),(int) b.getPosY(), b.getSize(), b.getSize());
		}
		for (int i = 0; i < Game.bombs.size(); i++) {
			Bomb b = Game.bombs.elementAt(i);
			g.setColor(b.getColor());
			g.fillRect((int) b.getPosX(),(int) b.getPosY(), b.getSize(), b.getSize());
		}
		
		g.setColor(Color.WHITE);
		g.drawString("Score : " + Game.p.getScore(), 5, 10);
		getGraphics().drawImage(img, 0, 0, null);
	}
}

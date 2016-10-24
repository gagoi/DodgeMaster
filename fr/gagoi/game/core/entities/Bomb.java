package fr.gagoi.game.core.entities;

import java.awt.Color;
import java.util.Random;

import fr.gagoi.game.core.Game;

public class Bomb implements IEntity {

	private int timer, posX, posY;
	private boolean isAlive = true;
	private Color color = Color.YELLOW;

	public Bomb() {
		posX = new Random().nextInt(961) - getSize();
		posY = new Random().nextInt(541) - getSize();
	}

	@Override
	public float getPosX() {
		return posX;
	}

	@Override
	public float getPosY() {
		return posY;
	}

	@Override
	public int getSize() {
		return Game.bombSize;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public float getSpeed() {
		return 0;
	}

	public boolean isAlive() {
		return isAlive;
	}
	

	@Override
	public boolean hitPlayer() {
		for (float x = Game.p.getPosX(); x <  Game.p.getPosX() +  Game.p.getSize(); x++) {
			for (float y =  Game.p.getPosY(); y <  Game.p.getPosY() +  Game.p.getSize(); y++) {
				double distX = x - posX;
				double distY = y - posY;
				double length = Math.sqrt(((distX * distX) + (distY * distY)));
				if (length < getSize()/2) return true;
			}
		}
		return false;
	}

	public void update() {
		if (timer == Game.bombMaxTime) {
			if (hitPlayer())
				Game.p.increaseScore(5);
			isAlive = false;
		}
		if (timer >= Game.bombMaxTime / 2)
			color = Color.ORANGE;
		if (timer >= Game.bombMaxTime * 3 / 4)
			color = Color.RED;
		timer++;
	}

}

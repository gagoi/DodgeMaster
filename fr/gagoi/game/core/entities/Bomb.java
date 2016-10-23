package fr.gagoi.game.core.entities;

import java.awt.Color;
import java.awt.Polygon;
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

	public boolean hitPlayer() {
		Polygon p = Game.p.getHitbox();
		for (float x = posX; x < posX + getSize(); x++) {
			for (float y = posY; y < posY + getSize(); y++) {
				if (p.contains(x, y))
					return true;
			}
		}
		return false;
	}

	public void update() {
		if (timer == Game.bombMaxTime) {
			if (hitPlayer())
				Game.p.increaseScore(100);
			isAlive = false;
		}
		if (timer >= Game.bombMaxTime / 2)
			color = Color.ORANGE;
		if (timer >= Game.bombMaxTime * 3 / 4)
			color = Color.RED;
		timer++;
	}

}

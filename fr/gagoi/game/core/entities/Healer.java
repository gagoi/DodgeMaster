package fr.gagoi.game.core.entities;

import java.awt.Color;
import java.util.Random;

import fr.gagoi.game.core.Game;

public class Healer implements IEntity {

	private int timer, posX, posY;
	private boolean isAlive = true;

	public Healer() {
		posX = new Random().nextInt(961);
		posY = new Random().nextInt(541);
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
		return Game.healerSize;
	}

	@Override
	public Color getColor() {
		return Color.GREEN;
	}

	@Override
	public float getSpeed() {
		return 0;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void update() {
		if (timer == Game.healerMaxTime)
			isAlive = false;
		if (hitPlayer()) {
			Game.p.increaseScore(-1 * Game.healerPower);
			isAlive = false;
		}
		timer++;
	}
}

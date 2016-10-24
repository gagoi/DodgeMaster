package fr.gagoi.game.core.entities;

import java.awt.Color;
import java.util.Random;

import fr.gagoi.game.core.Game;

public class Bullet implements IEntity {
	private float posX, posY, vecX, vecY;
	private boolean isAlive = true;
	private int size =  Game.bulletSize + new Random().nextInt(Game.bulletSize);

	public Bullet() {
		switch (new Random().nextInt(4)) {
		case 0:
			this.posY = 0;
			this.posX = new Random().nextInt(961);
			break;
		case 1:
			this.posY = 540;
			this.posX = new Random().nextInt(961);
			break;
		case 2:
			this.posX = 0;
			this.posY = new Random().nextInt(541);
			break;
		default:
			this.posX = 959;
			this.posY = new Random().nextInt(541);
			break;
		}
		this.vecX = (new Random().nextInt(30) - 15);
		this.vecY = (new Random().nextInt(30) - 15);
	}

	public float getPosX() {
		return posX;
	}

	public float getPosY() {
		return posY;
	}
;
	public int getSize() {
		return size;
	}

	public Color getColor() {
		return Color.CYAN;
	}

	private void isDead() {
		if (getPosX() < -5 || getPosY() < -5 || getPosX() > 970 || getPosY() > 550
				|| (vecX == getPosX() && vecY == getPosY()))
			isAlive = false;
	}

	public void update() {
		if (hitPlayer()) {
			Game.p.increaseScore(1);
			isAlive = false;
		}
		isDead();
		posX += vecX * getSpeed();
		posY += vecY * getSpeed();
	}

	public boolean isAlive() {
		return isAlive;
	}
	
	@Override
	public float getSpeed() {
		return 1 / Game.bulletSpeed;
	}
}

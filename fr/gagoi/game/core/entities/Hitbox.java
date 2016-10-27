package fr.gagoi.game.core.entities;

import java.awt.Polygon;

public class Hitbox {

	public static final int TYPE_RECT = 0;
	public static final int TYPE_CIRCLE = 1;

	private float posX, posY;
	private int size;
	private int type;

	private float velocityX, velocityY;

	public Hitbox(float posX, float posY, int size, int type) {
		this.posX = posX;
		this.posY = posY;
		this.size = size;
		this.type = type;
	}

	public int getSize() {
		return this.size;
	}

	public int getType() {
		return this.type;
	}

	public float getPosX() {
		return this.posX;
	}

	public float getPosY() {
		return this.posY;
	}

	public int getPosXInPixel() {
		return (int) this.posX;
	}

	public int getPosYInPixel() {
		return (int) this.posY;
	}

	public float getVelocityX() {
		return this.velocityX;
	}

	public float getVelocityY() {
		return this.velocityY;
	}

	public boolean isHiting(Hitbox b) {
		Polygon playerPolygon = new Polygon(
				new int[] { b.getPosXInPixel(), b.getPosXInPixel() + b.getSize(),
						b.getPosXInPixel() + b.getSize(), b.getPosXInPixel() },
				new int[] { b.getPosYInPixel(), b.getPosYInPixel(),
						b.getPosYInPixel() + b.getSize(),
						b.getPosYInPixel() + b.getSize() },
				4);
		switch (getType()) {
		case TYPE_RECT:

			for (int x = getPosXInPixel(); x < getPosXInPixel() + getSize(); x++)
				for (int y = 0; y < b.getSize(); y++)
					if (playerPolygon.contains(x, y))
						return true;

			return false;
		case TYPE_CIRCLE:
			int centerX = getPosXInPixel() + getSize() / 2;
			int centerY = getPosYInPixel() + getSize() / 2;
			int length = getSize() / 2;
			
			for (int x = getPosXInPixel(); x < getPosXInPixel() + getSize(); x++)
				for (int y = 0; y < b.getSize(); y++)
					if (playerPolygon.contains(x, y))
						return true;
		}
		return false;
	}

	public void moove() {
		this.posX += velocityX;
		this.posY += velocityY;
	}
}

package fr.gagoi.game.core.entities;

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
	
	public float getVelocityX() {
		return this.velocityX;
	}

	public float getVelocityY() {
		return this.velocityY;
	}

	public void moove() {
		this.posX += velocityX;
		this.posY += velocityY;
	}
}

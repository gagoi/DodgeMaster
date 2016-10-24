package fr.gagoi.game.core.entities;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fr.gagoi.game.core.Game;

public class Player implements IEntity, MouseListener {
	private float posX = 480, posY = 250, targetX = posX, targetY = posY;
	private double velocityX, velocityY;
	private int score;

	public float getPosX() {
		return posX;
	}

	public float getPosY() {
		return posY;
	}

	public int getSize() {
		return Game.playerSize;
	}

	public Color getColor() {
		return Color.BLUE;
	}

	public void update() {
		double newX = targetX;
		double newY = targetY;
		double distX = newX - posX;
		double distY = newY - posY;
		double length = Math.sqrt(((distX * distX) + (distY * distY)));

		if (length >= 2) {
			this.velocityX = distX / length * getSpeed();
			this.velocityY = distY / length * getSpeed();
		} else {
			this.velocityX = 0;
			this.velocityY = 0;
		}

		posX += this.velocityX;
		posY += this.velocityY;
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
		targetX = arg0.getX();
		targetY = arg0.getY();
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public float getSpeed() {
		return Game.playerSpeed;
	}

	public void increaseScore(int i) {
		score += i;
	}

	public int getScore() {
		return score;
	}

	public Polygon getHitbox() {
		return new Polygon(
				new int[] { (int) getPosX(), (int) getPosX() + getSize(), (int) getPosX() + getSize(),
						(int) getPosX() },
				new int[] { (int) getPosY(), (int) getPosY(), (int) getPosY() + getSize(),
						(int) getPosY() + getSize() },
				4);
	}

}

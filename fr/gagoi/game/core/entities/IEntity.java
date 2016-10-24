package fr.gagoi.game.core.entities;

import java.awt.Color;
import java.awt.Polygon;

import fr.gagoi.game.core.Game;

public interface IEntity {

	public float getPosX();

	public float getPosY();

	public int getSize();

	public Color getColor();

	public default boolean hitPlayer() {
		Polygon p = new Polygon(
				new int[] { (int) getPosX(), (int) getPosX() + getSize(), (int) getPosX() + getSize(),
						(int) getPosX() },
				new int[] { (int) getPosY(), (int) getPosY(), (int) getPosY() + getSize(),
						(int) getPosY() + getSize() },
				4);

		for (float x = Game.p.getPosX(); x < Game.p.getPosX() + Game.p.getSize(); x++) {
			for (float y = Game.p.getPosY(); y < Game.p.getPosY() + Game.p.getSize(); y++) {
				if (p.contains(x, y))
					return true;
			}
		}
		return false;
	};

	public float getSpeed();
}

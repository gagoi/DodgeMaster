package fr.gagoi.game.core.entities;

import java.awt.Color;
import java.awt.Polygon;

public interface IEntity {

	public float getPosX();

	public float getPosY();

	public int getSize();
	
	public Color getColor();
	
	public default Polygon getHitbox(){
		return new Polygon(new int[] { (int) getPosX(), (int) getPosX() + getSize(), (int) getPosX() + getSize(), (int) getPosX() },
				new int[] { (int) getPosY(), (int) getPosY(), (int) getPosY() + getSize(), (int) getPosY() + getSize() }, 4);
	};

	public float getSpeed();
}

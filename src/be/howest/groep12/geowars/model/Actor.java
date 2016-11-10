package be.howest.groep12.geowars.model;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.collision.shapes.*;

public abstract class Actor {
	private PolygonShape shape;
	private final List<Power> powers;
	private int posX;
	private int posY;
	private int attack;
	private int defense;

	public Actor(PolygonShape shape, int posX, int posY, int attack, int defense) {
		this.shape = shape;
		this.posX = posX;
		this.posY = posY;
		this.attack = attack;
		this.defense = defense;
		powers = new ArrayList<>();
	}

	public PolygonShape getShape() {
		return shape;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void addPower(Power power) {
		powers.add(power);
	}

	public void clearPowers() {
		powers.clear();
	}

	public void ishit() {
		defense--;
	}

	public boolean isDead() {
		return defense <= 0;
	}

	public int fire() {
		return attack;
	}
}

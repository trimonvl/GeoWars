/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.model;

/**
 *
 * @author Jonas Lauwers
 */
public class Player {

	private final String name;
	private int currency;
	private int highScore;
	private Ship ship;

	public Player(String name, int currency, int highscore) {
		this.name = name;
		this.currency = currency;
		this.highScore = highscore;
	}

	public String getName() {
		return name;
	}

	public int getCurrency() {
		return currency;
	}

	public void addCurrency(int addAmount) {
		this.currency += addAmount;
	}

	public int getHighscore() {
		return highScore;
	}

	public void setHighScore(int newHighScore) {
		if (newHighScore > this.highScore) {
			this.highScore = newHighScore;
		}
	}

	public void loadShip(Ship ship) {
		this.ship = ship;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonas Lauwers
 */
public class Ship {

	private final List<Drone> drones;

	public Ship() {
		drones = new ArrayList<>();
	}

	public void addDrones(Drone drone) {
		drones.add(drone);
	}

	public void clearDrones() {
		drones.clear();
	}
}

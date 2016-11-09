/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.gui;

import java.util.Observer;

/**
 *
 * @author Jonas Lauwers
 */
public interface ColorObservable {
    public void addColorObserver(Observer o);
    public void removeColorObserver(Observer o);
    public void notifyColorObservers();
}

package org.isep.weather;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zkazi
 */
public interface Observer {
    public void update(float temp, float humidity, float pressure);

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isep.coffe;
/**
 *
 * @author zkazi
 */
public abstract class Beverage {
    String description = "Unknown brevage !!!";
    public String getDescription(){
        return description;
    }
    public abstract double cost();

}

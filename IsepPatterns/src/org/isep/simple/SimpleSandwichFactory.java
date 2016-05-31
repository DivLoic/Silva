package org.isep.simple;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zkazi
 */
public class SimpleSandwichFactory {

    public Sandwich createSandwich(String type) {
        Sandwich sand = null;

        if (type.equals("bacon")){
            sand = new BaconSandwich();
        } else if (type.equals("chicken")){
            sand = new ChickenSandwich();
        } else if (type.equals("salmon")){
            sand = new SalmonSandwich();
        } else if (type.equals("vegetarian")){
            sand = new VegetarianSandwich();
        }

        
        return sand;
    }
}

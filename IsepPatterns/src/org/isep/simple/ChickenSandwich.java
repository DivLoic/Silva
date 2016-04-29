package org.isep.simple;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zkazi
 */
public class ChickenSandwich extends Sandwich {

    public ChickenSandwich() {
        name = "Chicken Sandwich";
        bread = "baguette";
        sauce = "mayonnaise sauce";
        toppings.add("Chicken");
        toppings.add("Gruyere");
        toppings.add("lettuce");
        toppings.add("tomato");
    }
}

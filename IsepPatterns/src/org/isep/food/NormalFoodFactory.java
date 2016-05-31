package org.isep.food;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zkazi
 */
public class NormalFoodFactory implements FoodFactory {

    public Sandwich createSandwich() {
        return new NormalSandwich();
    }

    public Drink createDrink() {
        return new NormalDrink();
    }
}

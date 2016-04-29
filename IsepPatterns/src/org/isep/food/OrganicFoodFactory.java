package org.isep.food;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zkazi
 */
public class OrganicFoodFactory implements FoodFactory{
    
	public Sandwich createSandwich(){
        return new OrganicSandwich();
    }
    public Drink createDrink(){
        return new OrganicDrink();
    }

}

package org.isep.method;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zkazi
 */
public class AmericanSandwichStore extends SandwichStore {
	Sandwich createSandwich(String item) {
		if (item.equals("bacon")) {
			return new AmericanStyleBaconSandwich();
		} else if (item.equals("chicken")) {
			return new AmericanStyleChickenSandwich();
		} else if (item.equals("salmon")) {
			return new AmericanStyleSalmonSandwich();
		} else if (item.equals("vegetarian")) {
			return new AmericanStyleVegetarianSandwich();
		} else return null;
	}
}
package org.isep.method;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zkazi
 */
public class FrenchSandwichStore extends SandwichStore {
	Sandwich createSandwich(String item) {
		if (item.equals("bacon")) {
			return new FrenchStyleBaconSandwich();
		} else if (item.equals("chicken")) {
			return new FrenchStyleChickenSandwich();
		} else if (item.equals("salmon")) {
			return new FrenchStyleSalmonSandwich();
		} else if (item.equals("vegetarian")) {
			return new FrenchStyleVegetarianSandwich();
		} else return null;
	}
}

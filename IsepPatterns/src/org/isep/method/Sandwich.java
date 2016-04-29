package org.isep.method;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zkazi
 */

import java.util.ArrayList;

abstract public class Sandwich {
	String name; //nom
	String bread; //pain
	String sauce; //sauce
	ArrayList toppings = new ArrayList(); //garniture

	public String getName() {
		return name;
	}

	public void prepare() {
		System.out.println("Preparing " + name);
	}

	public void pack() {
		System.out.println("Baking " + name);
	}

	@Override
	public String toString() {
		// code to display sandwich name and ingredients
		StringBuffer sb = new StringBuffer();
		sb.append("---- ").append(" ----\n");
		sb.append(bread ).append(" ----\n");
		sb.append(sauce ).append(" ----\n");
            for (Object topping : toppings) {
                sb.append((String) topping).append(" ----\n");
            }
                
		return sb.toString(); 
	}
}

package org.isep.method;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zkazi
 */
public abstract class SandwichStore {

    public Sandwich orderSandwich(String type) {
        Sandwich sand=createSandwich(type);
        System.out.println("--- Making a " + sand.getName() + " ---");
        sand.prepare();
        sand.pack();
        return sand;
    }

    abstract Sandwich createSandwich(String type);
}


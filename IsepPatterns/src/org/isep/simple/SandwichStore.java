package org.isep.simple;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zkazi
 */
public class SandwichStore {

    SimpleSandwichFactory factory;

    public SandwichStore(SimpleSandwichFactory factory) {
        this.factory = factory;
    }

    public Sandwich orderSandwich(String type) {
        Sandwich sand;
        sand = factory.createSandwich(type);

        sand.prepare();
        sand.pack();
        return sand;
    }
//other methods here
}

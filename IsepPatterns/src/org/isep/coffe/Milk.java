/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isep.coffe;
/**
 *
 * @author zkazi
 */
public class Milk extends CondimentDecorator {

    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }


    public double cost() {
        return 0.10 + beverage.cost();
    }
}

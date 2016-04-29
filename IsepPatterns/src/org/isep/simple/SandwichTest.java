package org.isep.simple;
/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zkazi
 */
public class SandwichTest {
    public static void main(String[] args){
        SimpleSandwichFactory sandFactory = new SimpleSandwichFactory(); //sand is an abstract class of sandwiches
        SandwichStore store = new SandwichStore(sandFactory);

        Sandwich sand = store.orderSandwich("bacon");
        System.out.println(sand);

        sand = store.orderSandwich("vegetarian");
        System.out.println(sand);

    }
}

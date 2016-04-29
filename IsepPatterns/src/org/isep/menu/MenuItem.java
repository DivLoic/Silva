/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.isep.menu;

/**
 *
 * @author zkazi
 */
public class MenuItem extends MenuComponent{
    String name;
    String description;
    double price;
    boolean notSpicy;
    boolean spicy;
    boolean verySpicy;

    public MenuItem (String name, String description, double price, boolean notSpicy, boolean spicy, boolean verySpicy){
        this.name=name;
        this.description=description;
        this.price=price;
        this.spicy=spicy;
        this.notSpicy=notSpicy;
        this.spicy=spicy;
        this.verySpicy=verySpicy;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isNotSpicy() {
        return notSpicy;
    }
    public boolean isSpicy() {
        return spicy;
    }
    public boolean isVerySpicy() {
        return verySpicy;
    }

    public void print() {
        String spice="Not Spicy";
        if (isSpicy()) spice="Spicy";
        if (isVerySpicy()) spice="Very Spicy !!!!";
        System.out.println(getName()+": "+getDescription()+"("+spice+").");
    }

}

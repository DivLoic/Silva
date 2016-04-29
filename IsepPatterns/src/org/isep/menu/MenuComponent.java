/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isep.menu;

/**
 *
 * @author zkazi
 */
public abstract class MenuComponent {
    
    //Because some of the methods above interest only MenuItems, others only 
    //make sense for Menus, the default implementation is UnsupportedOperationException().
    //That way, if MenuItem or Menu doesn't support an operation, 
    //they don't have to do anything, they can just inherit the default implementation

    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isNotSpicy() {
        throw new UnsupportedOperationException();
    }
    public boolean isSpicy() {
        throw new UnsupportedOperationException();
    }
    public boolean isVerySpicy() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isep.menu;

import java.util.ArrayList;

/**
 *
 * @author zkazi
 */
public class MenuComposite extends MenuComponent {

    ArrayList menuComponents = new ArrayList();
    String name;
    String description;

    public MenuComposite(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return (MenuComponent)menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.println("-"+getName() + ", " + getDescription() + ":");
        for (int i=0;i<menuComponents.size();i++)
           ((MenuComponent)menuComponents.get(i)).print();
    }
}

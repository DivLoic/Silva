/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.isep.menu;

/**
 *
 * @author zkazi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

         
		   MenuComponent menu= new MenuComposite ("Menu","Spicy or not Thai !");
		   
		   
		   MenuComponent starter = new MenuComposite ("Starter","Let's begin with");
		   MenuComponent dish = new MenuComposite ("Dish","Then");
		   MenuComponent dessert = new MenuComposite ("Dessert","Before you leave");
		
		   //starter
		   MenuComponent soup = new MenuComposite (" -- Soup","un peu de soupe");
		   //dish
		   MenuComponent noodle = new MenuComposite (" -- Noodle","un peu de Noudle");
		   MenuComponent pad = new MenuComposite (" -- Pad","un peu de pad");
		   //desert
		   MenuComponent fruits = new MenuComposite (" -- Fruits","un peu de Fruit");
		   MenuComponent iceCream = new MenuComposite (" -- IceCram","un peu de IceCram");
		   
		   // Pad Thai
		   MenuComponent chicken = new MenuItem (" --  -- chicken","un peu de chicken", 2, false, false, false);
		   MenuComponent beef = new MenuItem (" --  -- beef","un peu de beef", 2, false, false, false);
		   MenuComponent shrimp = new MenuItem (" --  -- shrimp","un peu de shrimp", 2, false, false, false);
		   //fruits
		   MenuComponent mango = new MenuItem (" --  -- mango","un peu de mango", 2, false, false, false);
		   MenuComponent dragon = new MenuItem (" --  -- dragon","un peu de dragon", 2, false, false, false);
		   //icecream
		   MenuComponent vanilla = new MenuItem (" --  -- vanilla","un peu de vanilla", 2, false, false, false);
		   MenuComponent chocolate = new MenuItem (" --  -- chocolate","un peu de chocolate", 2, false, false, false);
		   
		   //soup OK
		   pad.add(chicken);
		   pad.add(beef);
		   pad.add(shrimp);
		   // pad OK
		   fruits.add(mango);
		   fruits.add(dragon);
		   //fruits ok
		   iceCream.add(vanilla);
		   iceCream.add(chocolate);
		   
		   // -- OK pour les feuilles
		   
		   // -- niveau 1
		   starter.add(soup);
		   //starter OK
		   dish.add(noodle);
		   dish.add(pad);
		   //dish OK
		   dessert.add(fruits);
		   dessert.add(iceCream);
		   // -- niveau 2 OK
		   
		   // -- dernier niveau
		   menu.add(starter);
		   menu.add(dish);
		   menu.add(dessert);
		   
		   
		   
		   menu.print();
  
       
    }

}

package org.isep.duck;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zkazi
 */
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){

    }

    public abstract void display();

    public void performFly () {
        flyBehavior.fly();
    }

    public void performQuack () {
        quackBehavior.quack();
    }


   public void setFlyBehavior(FlyBehavior fb) {
       flyBehavior = fb;
   }

   public void setQuackBehavior(QuackBehavior qb) {
       quackBehavior = qb;
   }

    public void swim () {
        System.out.println("Every type of duck can swim");
    }

}

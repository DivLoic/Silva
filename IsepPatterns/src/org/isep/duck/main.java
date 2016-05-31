package org.isep.duck;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duck d = new MallardDuck();
		d.performQuack();
		d.performFly();
		d.setFlyBehavior(new FlyNoWay());
		d.performFly();
		d.setQuackBehavior(new Squeak());
		d.performQuack();
	}

}

package org.isep.coffe;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Beverage MyCup = new Espresso();
		MyCup = new Milk(MyCup);
		MyCup = new Milk(MyCup);
		MyCup = new Mocha(MyCup);
		System.out.print(MyCup.cost() + "\n");
		System.out.print(MyCup.getDescription());
	}

}

package edu.mtc.egr283.project05;

import java.util.Scanner;

public class ShoppingListDriver {

	/**
	 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
	 * 
	 * @author JackVan20010312
	 * @version 1.00 2021-03-08
	 * @Due  03/18/2021
	 * @Professor William Sims
	 */
	static ShoppingList sshopper = new ShoppingList();
	public static void main(String[] args) {

		boolean conTinue = true;
		do {
			conTinue = x();
		}while(conTinue);
		System.out.println("Thank you for using the Shopping List");

	}//ending bracket of main method
	public static boolean x() {
		Scanner myObj = new Scanner(System.in);

		System.out.println("*********** Shopping List ***********\r\n"
				+ "\r\n"
				+ "Select any option (1 to 5)\r\n"
				+ "1. Delete an item \r\n"
				+ "2. Add an item at a specific location \r\n"
				+ "3. Add an item at the end of the list \r\n"
				+ "4. Display Shopping List\r\n"
				+ "5. Exit");

		String temp = myObj.next();
		switch(Integer.parseInt(temp)) {
		case 1:
			System.out.println("Enter the item which you want to delete from shopping list:");
			temp = myObj.next();
			System.out.println(sshopper.removeShoppingItem(temp));
			break;
		case 2:
			System.out.println("Enter the item which you want to add in shopping list:\r\n"
					+ "Enter a specific location where you want to add an item:\r\n"
					+ "");
			temp = myObj.next();
			int tempInt = myObj.nextInt();
			sshopper.addShoppingItem(temp, tempInt);
			break;
		case 3:
			System.out.println("Enter the item which you want to add in shopping list:\n");
			temp = myObj.next();
			sshopper.addShoppingItem(temp);
			break;
		case 4:
			System.out.println("Items in shopping list are: ");
			System.out.println(sshopper.toString());
			break;
		case 5:
			System.out.println("Thank you for using the Shopping List");
			System.exit(0);
			myObj.close();
			return true;
		default: 
			System.out.println("Your input could not be understood. Please try again.");
			myObj.close();
			return true;
		}//end of switch
		System.out.println("Do you want to continue? (Yes/No)");
		temp=myObj.next();
		myObj.close();
		if(temp.charAt(0)==('y')) {
			return true;
		}else {
			return false;
		}

	}
}//ending bracket of Class gameCatalogueDriver

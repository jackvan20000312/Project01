package edu.mtc.egr283.project05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import edu.mtc.egr283.dll.DLL;
//import edu.mtc.egr283.sll.SLL;

/**
 * Class for handling activity at the level of the Catalogue.
 * This class has an <code>SLL</code> of
 * <code>ShoppingItem</code> data and an index list for sorting,
 * methods to access, the two <code>SLL</code>,
 * methods to read and to <code>toString</code>
 * @author Jacob Vaught
 * @version 1.00 03.08.2021
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 *
 */
public class ShoppingList {

		private DLL<String> shoppingList;

		/**
		 * Constructor.
		 * Initialize the <code>SLL</code> variables.
		 */
		public ShoppingList() {
			this.shoppingList = new DLL<String>();
		}// Ending bracket of the constructor

		/**
		 * Adds A ShoppingItem to The Shopping List
		 * @param String <code>newShoppingItem</code>
		 */
		public String addShoppingItem(String newShoppingItem) {
			this.shoppingList.addAtTail(newShoppingItem);
			return ("Item \""+newShoppingItem+"\" Succesfully Added!");
		}//ending bracket of addShoppingItem
		
		/**
		 * Adds A ShoppingItem to The Shopping List
		 * @param int <code>position</code>
		 * @param String <code>newShoppingItem</code>
		 */
		public String addShoppingItem(String newShoppingItem, int position) {
			if(newShoppingItem!="") {
			this.shoppingList.add(newShoppingItem, position-1);
			return ("Item \""+newShoppingItem+"\" Succesfully Added!");
			}else {
				return "Blank Input, Please try Again";
			}
		}//ending bracket of addShoppingItem

		/**
		 * Method to get the size of the <code>SLL</code> of data.
		 * @return the size of the SLL
		 */
		public int getSize() {
			return this.shoppingList.size();
		}// Ending bracket of method getSize

		/**
		 * Method to read the file from an input <code>Scanner</code> 
		 * This reads the entire file. As we read and store the records,
		 * also store the subscripts in the index.
		 * @param outputFile the <code>Scanner</code> from which to read
		 */
		public void readFile(File inputFile) {
			Scanner inFile= null;
			try {
				inFile = new Scanner(inputFile);
			} catch(FileNotFoundException fnfe) {
				System.out.println("ERROR opening file ");
				System.out.println(fnfe.getMessage());
				System.out.println("in" + System.getProperty("user.dir"));
				System.exit(1);
			}// Ending bracket of try-catch block
			while(inFile.hasNext()) {
				this.shoppingList.addAtTail(inFile.next().replace("_", " "));
			}// Ending bracket of while(inFile)
		}// Ending bracket of method readFile
		
		public void outputFile(File outputFile) {
			PrintWriter outFile = null;
			try {
				outFile = new PrintWriter(outputFile);
			} catch(FileNotFoundException fnfe) {
				System.out.println("ERROR opening file ");
				System.out.println(fnfe.getMessage());
				System.out.println("in" + System.getProperty("user.dir"));
				System.exit(1);
			}// Ending bracket of try-catch block
			outFile.printf(this.toString());
			outFile.close();
		}

		/**
		 * Removes A ShoppingItem from The catalogue/catalog
		 * @param String <code>itemName</code>
		 */
		public String removeShoppingItem(String itemName) {
			for(int i = 0; i < this.getSize(); ++i) {
				if(this.shoppingList.getDataAtPosition(i).equalsIgnoreCase(itemName)) {
					this.shoppingList.remove(i);
					return ("Item \""+itemName+"\" removed.");
				}// Ending bracket of if
			}// Ending bracket of for loop
			return ("Item \""+itemName+"\" not in the Shopping List.");
		}//ending bracket of addShoppingItem

		/**
		 * Usual <code>toString</code> method.
		 * @return the <code>String</code> value of the file.
		 */
		public String toString() {
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < this.getSize(); ++i) {
				if(this.shoppingList.getDataAtPosition(i)!=null) {
					sb.append((i+1)+". ");
					sb.append(this.shoppingList.getDataAtPosition(i).toString()+"\n");
				}
			}// Ending bracket of for loop
			return sb.toString();
		}// Ending bracket of method toString

	}//ending bracket of class ShoppingItemCatalogue


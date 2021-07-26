/*
 * Author - Khyre Hill
 */
package assg8_hillkh19;
import java.io.*;
import java.util.*;



public class CustomerRoster {

	final String fileName = "assg8_CustomerRoster.txt";
	
	BinarySearchTree<Customer, String> custTree = new BinarySearchTree<Customer, String> ();
	
	
	/***
	 * Loads data or gives error if the file cant be found
	 */
	public void LoadData(){
		Scanner readFile = null;
		try {
			readFile = new Scanner (new File (fileName));
		} catch (FileNotFoundException e) {
			System.out.println("This file" + readFile + " could not be found");
			System.exit(1);
		}
		while (readFile.hasNextLine()) {
			String custID = readFile.next();
			String custName = readFile.next() + " " + readFile.next();
			String custPNumber = readFile.nextLine().trim();
			Customer newCust = new Customer(custID, custName, custPNumber);
			custTree.insert(newCust);
		}
		readFile.close();
	}
	
	/***
	 * displays full tree with all customers inside
	 */
	public void Display() {
		TreeIterator<Customer> displayIterator = new TreeIterator<Customer> (custTree);
		displayIterator.setInorder();
		
		while (displayIterator.hasNext()) {
			Customer newCust = displayIterator.next();
			System.out.println(newCust.toString());
		}
	}
	
	/***
	 * 
	 * @param newID
	 * @param newcustName
	 * @param newcustPNum
	 * ask user to add customer to the roster and adds
	 * name id and phone number
	 */
	public void Add(String newID, String newcustName, String newcustPNum) {
		if (custTree.retrieve(newID) != null) {
			System.out.println("This ID Is Already Within The Roster: " + newID);
			return;
		}
		Customer newCustomer = new Customer(newID, newcustName, newcustPNum);
		custTree.insert(newCustomer);
		System.out.println("A New Customer Has Been Added To The Roster");
	}
	
	/***
	 * 
	 * @param searchKey
	 * deletes customer based on ID that customer put in
	 */
	public void Delete(String searchKey) {
		if (custTree.retrieve(searchKey) == null) {
			System.out.println("This ID Does Not Exist Within The Roster: " + searchKey);
			return;
		}
		custTree.delete(searchKey);
		System.out.println("A Customer Has Been Removed From The Roster");
	}
	
	/***
	 * 
	 * @param searchKey
	 * Searches for customer by ID and shows their information
	 */
	public void Search(String searchKey) {
		if (custTree.retrieve(searchKey) == null) {
			System.out.println("This ID Does Not Exist Within The Roster: " + searchKey);
			return;
		}
		Customer newCustomer = custTree.retrieve(searchKey);
		System.out.println(newCustomer.toString());
		
	}
	
	/***
	 * 
	 * @param searchKey
	 * @param newCustName
	 * @param newcustPNum
	 * updates customer by asking user to search for an existing customer and 
	 * then asking them to update their id name and phone number
	 */
	public void Update(String searchKey, String newCustName, String newcustPNum) {
		if (custTree.retrieve(searchKey) == null) {
			System.out.println("This ID Does Not Exist Within The Roster: " + searchKey);
			return ;
		}
		custTree.delete(searchKey);
		Customer newCust = new Customer(searchKey,newCustName,newcustPNum);
		custTree.insert(newCust);
		System.out.println("Customer has Been Updated");
	}
	/***
	 * Saves the roster to the file 
	 */
	public void Save() {

        TreeIterator<Customer> saveTree = new TreeIterator<Customer>(custTree);
        Customer newCust;
        saveTree.setInorder();

        PrintWriter outputStream = null;

        try {
            outputStream = new PrintWriter(fileName);

        } catch (IOException e) {
            System.out.println("Error openning the file " + fileName);
        }

        while (saveTree.hasNext() == true) {
            newCust = (Customer) saveTree.next();
            outputStream.println(newCust.getKey() + "\t" + newCust.getcustName() + "\t" + newCust.getphoneNum());
        }

        outputStream.close();
    }
	
}

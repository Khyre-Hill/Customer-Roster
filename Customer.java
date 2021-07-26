/*
 * Author - Khyre Hill
 */
package assg8_hillkh19;

public class Customer extends KeyedItem<String> {

	private String custName, phoneNum;

	public Customer(String custID, String personName, String custPNumber) {
		super(custID);
		custName = personName;
		phoneNum = custPNumber;
	}
/*
 * Getters and setters for customer name and phone number
 */
	public String getcustName() {
		return custName;
	}

	public String getphoneNum() {
		return phoneNum;
	}
	
	public String setcustName() {
		return custName;
	}
	
	public String setphoneNum() {
		return phoneNum;
	}
	
	public String toString() {
		String thisString = "Customer Id: " + getKey() + "\tCustomer Name: " + getcustName() + "\tCustomer Phone Number: " + getphoneNum();
			return thisString;	
	}
}

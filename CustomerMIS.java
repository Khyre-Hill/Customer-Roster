/*
 * Author - Khyre Hill
 */
package assg8_hillkh19;

import java.util.Scanner;



public class CustomerMIS {
	static Scanner a = new Scanner(System.in);

	public static void main(String[] args) {
		
	
		
		CustomerRoster Roster = new CustomerRoster();
		Roster.LoadData();
		
			
		int userChoice = 0;
		
		
			
		while(userChoice !=6) {
				

			System.out.println("\n1. Display All Roster.");
			System.out.println("2. Add A Customer.");
			System.out.println("3. Delete A Customer");
			System.out.println("4. Search For A Customer");
			System.out.println("5. Update Customer.");
			System.out.println("6. Save Data And Exit\n");
			userChoice = a.nextInt();
			
			if (userChoice == 1) {
				Roster.Display();
			}
			
			else if (userChoice == 2) {
				
				System.out.println("Enter The ID Of The Customer You Want To Add");
				String newID = a.next();
				a.nextLine();
				
				
				System.out.println("Enter The Name Of The Customer You Want To Add");
				String newcustName = a.nextLine();
				
				
				System.out.println("Enter The Phone Number Of The Customer You Want To Add");
				String newcustPNum = a.next();
				a.nextLine();
				
				
				Roster.Add(newID,newcustName,newcustPNum);
				userChoice = a.nextInt();
			}
			else if (userChoice == 3) {
				System.out.println("Enter The ID Of The Customer You Want To Delete");
				String newID = a.next();
				a.nextLine();
				
				
				
				Roster.Delete(newID);
				userChoice = a.nextInt();

			}
			else if (userChoice == 4) {
				System.out.println("Enter The ID Of A Customer To Search For");
				String searchKey = a.next();
				
				
				
				Roster.Search(searchKey);
				userChoice = a.nextInt();
			}
			else if (userChoice == 5) {
				System.out.println("Please Enter Customer ID You Would Like To Update");
				
				String searchKey = a.next();
				a.nextLine();
				
				
				System.out.println("Please Enter New Customer Name");
				
				String newcustName = a.nextLine();
				
				
				
				System.out.println("Please Enter New Customer Phone Number");
				
				String newcustPNum = a.next();
				a.nextLine();
				
				
				Roster.Update(searchKey, newcustName, newcustPNum);
				userChoice = a.nextInt();
			}
			
			else {
				Roster.Save();
				System.out.println("Program Ended");
				break;
			}
				
					
			
				
		}
		
			
	}	
}



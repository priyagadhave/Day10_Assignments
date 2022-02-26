
package com.addressBookSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UC6_MultipleAddressBook {

	static Scanner sc=new Scanner(System.in);
	static HashMap<String, ArrayList<Contacts>> addressbooks = new HashMap<>();
	static ArrayList<Contacts> person=new ArrayList<Contacts>();

	public  static void addNewContact(){
		//variables
		String firstName,lastName,address,city,state,email;
		long phonenumber;
		int zip;
		
		System.out.println("Enter your First name:");
		firstName=sc.next();
		System.out.println("Enter your Last name:");
		lastName=sc.next();
		System.out.println("Enter your Address:");
		address=sc.next();
		System.out.println("Enter your City:");
		city=sc.next();
		System.out.println("Enter your State:");
		state=sc.next();
		System.out.println("Enter your email-id:");
		email=sc.next();
		System.out.println("Enter your Phone Number:");
	    phonenumber=sc.nextLong();
	    System.out.println("Enter your ZIP code:");
		zip=sc.nextInt();
		Contacts contacts=new Contacts(firstName,lastName,address,city,state,phonenumber,zip);
		person.add(contacts);
		}
	public static void displayContacts() {
		int n=1;
		System.out.println("Your contacts are:");
		for(Contacts contacts :person){
			System.out.print(n+")");
			System.out.println(contacts);
			n++;
		}
		System.out.println(" ");
	}
	public static void editContacts() {
		System.out.println("In the edit");
		System.out.println("Enter your first name:");
		String s=sc.next();
		for(Contacts contacts:person) {
			if(contacts.getFirstName().equals(s)) {
				System.out.println("Enter what you want to edit");
				System.out.println("1)First Name 2)Last Name 3)Address 4)City 5)State 6)Phone Number 7)ZIP code");
				int i=sc.nextInt();
				switch(i) {
				case 1:System.out.println("Enter your new First name:");
				contacts.setFirstName(sc.next());
				break;
				case 2:System.out.println("Enter your new Lirst name:");
				contacts.setLastName(sc.next());
				break;
				case 3:System.out.println("Enter your new Address:");
				contacts.setAddress(sc.next());
				break;
				case 4:System.out.println("Enter your new City:");
				contacts.setCity(sc.next());
				break;
				case 5:System.out.println("Enter your new State:");
				contacts.setState(sc.next());
				break;
				case 6:System.out.println("Enter your new Phone Number:");
				contacts.setPhoneNumber(sc.nextLong());
				break;
				case 7:System.out.println("Enter your new ZIP code:");
				contacts.setZip(sc.nextInt());
				break;
				default:
					break;
					}
				}
			else {
				System.out.println("Invalid option");
			}
		}
	}

	public static void deleteContact(){
			System.out.println("Enter your First Name");
			// stores user input's first name
			String s=sc.next();
			for(Contacts contacts:person){
				if(contacts.getFirstName().equals(s)){
					person.remove(contacts);
					System.out.println("Deleted sucessfully.");
				}
				else{
					System.out.println("Invalid first name");
				}
			}
	}
	public static void createNewBook() {
		boolean z=true;
		while(z) {
		System.out.println("Press: 1 to Add a new Address Book. 2 to display names of books. 0 to exit");
		int y=sc.nextInt();
		if(y==1)
		{
			System.out.println("Enter the name of the Book");
			String s=sc.next();
		if(addressbooks.containsKey(s)) {
			System.out.println("This name is already in use.Try different name...");
		}
		else {
			addressbooks.put(s, person);
			boolean b=true;
			while(b){
				System.out.println("Press 1 to Add a contact.");
				System.out.println("Press 2 to Edit Contact.");
				System.out.println("Press 3 to Delete contact");
				System.out.println("Press 4 to Display contacts");
				System.out.println("Press 0 to exit");
				int option=sc.nextInt();
				switch(option){
				case 1:
					addNewContact();
					break;
				case 2:
					editContacts();
					break;
				case 3:
					deleteContact();
					break;
				case 4:
					displayContacts();
					break;
				case 0:
					b=false;
					break;
				default:
					break;
				}
			}
		}
		}else if(y==0) {
			z=false;
		}
		else if(y==2) {
			int n=1;
			 if (!addressbooks.isEmpty()) {
                 System.out.println("The names of your Address Books are : ");
                 for (String key : addressbooks.keySet()) {
                	 System.out.print(n+")");
                     System.out.println(key);
                     n++;
                 }
             } else {
                 System.out.println("Your Address Book is Empty.");
             } 
		}
		else {
			System.out.println("Invalid option");
		}
		}
	
		}
	public static void main(String[] args){
		System.out.println("Welcome to Address Book Program");
		createNewBook();
		sc.close();
	}
}
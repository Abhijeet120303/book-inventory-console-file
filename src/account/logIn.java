package account;

import java.io.IOException;
import java.util.Scanner;

import book_store.BooKStoreManagement;
import user_management.User_Managemnt;

public class logIn {
	public static void logIn() throws IOException {
		Scanner sc=new Scanner(System.in);
		System.out.println("*** Enter Valid Details ***");
		System.out.println("Enter Your Username :");
		String username=sc.next();
		System.out.println("Enter Your Password :");
		String password=sc.next();
		if(!User_Managemnt.login(username, password)) {
			System.out.println("!!! Login Failed !!!");
			return;	
		}else {
			System.out.println("****Login Successful****");
		}
		boolean canIKeepRunningTheProgram=true;
		while(canIKeepRunningTheProgram==true) {
			System.out.println("\n");
			System.out.println("$$$$ What Action To Be Performed $$$$");
			System.out.println("1.User Management");
			System.out.println("2.Book Inventory");
			System.out.println("3.Quit");
			int option=sc.nextInt();
			if(option==1) {
				User_Managemnt.usermanagemnet();
			}else if(option==2) {
				BooKStoreManagement.bookManagement();
			}else {
				canIKeepRunningTheProgram=false;
			}
			
		}
	}							
}



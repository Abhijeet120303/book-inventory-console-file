package book_main;
import java.io.IOException;
import java.util.Scanner;

import account.logIn;
import account.signIn;
import book_store.BooKStoreManagement;
import user_management.User_Managemnt;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		boolean canIKeepRunningTheProgram=true;
		while(canIKeepRunningTheProgram==true) {
			System.out.println("@@@@ WELCOME @@@@");
			System.out.println("1.LOG IN");
			System.out.println("2.CREATE ACCOUNT");
			System.out.println("3.QUIT");
			int option=sc.nextInt();
			if(option==1) {
				logIn.logIn();
			}else if(option==2) {
				signIn.signin();
			}else {
				canIKeepRunningTheProgram=false;
			}
		}
	}
}
		
		
		
		
		



		
	

	
	

	



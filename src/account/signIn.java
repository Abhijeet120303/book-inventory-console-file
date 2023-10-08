package account;

import java.io.IOException;

import user_management.User_Managemnt;

public class signIn {
	public static void signin() throws IOException {
		System.out.println("***** SIGN IN *****");
		User_Managemnt.addUser();
		User_Managemnt.writeData();
		System.out.println("User Has Been Successfully Register");
	}	

}

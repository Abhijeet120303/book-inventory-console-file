package user_management;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class User_Managemnt {
	static ArrayList<user> al=new ArrayList();
	static{
		try {
			loadData();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void usermanagemnet() throws IOException {
		Scanner sc=new Scanner(System.in);
		boolean caniKeepRunningTheProgram=true;
		while(caniKeepRunningTheProgram==true) {
			System.out.println("$$$$ Welcome To User Management $$$$");
			System.out.println("1.ADD USER");
			System.out.println("2.SEARCH USER");
			System.out.println("3.EDIT USER");
			System.out.println("4.DELETE USER");
			System.out.println("5.QUIT");
			
			int choise=sc.nextInt();
			if(choise==user_option.ADD_USER) {
				addUser();
				System.out.println("\n");
			}else if(choise==user_option.SEARCH_USER) {
				System.out.println("Enter Username Which Want To Search :");
				sc.nextLine();
				String s=sc.nextLine();
				searchUser(s);
			}else if(choise==user_option.EDIT_USER) {
				System.out.println("Enter Username Which Want To Edit :");
				sc.nextLine();
				String e=sc.nextLine();
				editUser(e);
			}else if(choise==user_option.DELETE_USER) {
				System.out.println("Enter Username Which Want To Deleted :");
				sc.nextLine();
				String d=sc.nextLine();
				deleteUser(d);
			}else if(choise==user_option.QUIT_USER) {
				writeData();
				caniKeepRunningTheProgram=false;
				System.out.println("!!! User Management Closed !!!");
			}
		}

	}
	public static void addUser() {
		Scanner sc=new Scanner(System.in);
		user u=new user();
		System.out.println("Enter Your Username :");
		u.username=sc.nextLine();
		System.out.println("Enter Your Password :");
		u.password=sc.nextLine();
		System.out.println("Enter Your Student ID :");
		u.id=sc.nextLine();
		System.out.println("Enter Your Age:");
		u.age=sc.nextLine();
		
		System.out.println("Username :"+u.username);
		System.out.println("Password :"+u.password);
		System.out.println("ID :"+u.id);
		System.out.println("Age :"+u.age);
		
		al.add(u);
		
		
	}
	public static void searchUser(String s) {
		for(user u:al) {
			if(u.username.equalsIgnoreCase(s)) {
				System.out.println("Username :"+u.username);
				System.out.println("Password :"+u.password);
				System.out.println("ID :"+u.id);
				System.out.println("Age :"+u.age);
				return;
			}
		}
		System.out.println("User Not Found");
	}
	public static void editUser(String e) {
		Scanner sc=new Scanner(System.in);
		for(user u:al) {
			if(u.username.equalsIgnoreCase(e)) {
				System.out.println("Edited Name Is :"+u.username);
				System.out.println("Enter Your New Username :");
				u.username=sc.nextLine();
				System.out.println("Enter Your New Password :");
				u.password=sc.nextLine();
				System.out.println("Enter Your  New ID :");
				u.id=sc.nextLine();
				System.out.println("Enter Your  New Age  :");
				u.id=sc.nextLine();
				System.out.println("User "+u.username+" Has Been Updated");
				return;
			}
		}
		System.out.println("User Not Found");
		
	}
	public static void deleteUser(String d) {
		Iterator<user> itr=al.iterator();
		while(itr.hasNext()) {
			user u=itr.next();
			if(u.username.equalsIgnoreCase(d)) {
				itr.remove();
				System.out.println("User "+u.username+" Has Been Deleted :");
				return;
			}
		}
		System.out.println("User Not Found");
	}
	public static void writeData() throws IOException {
		File file=new File("C:\\Users\\Abhijeet\\eclipse-workspace\\BooKInventory\\src\\userManagement1\\file1.csv");
		FileWriter fw=new FileWriter(file,false);
		BufferedWriter bw=new BufferedWriter(fw);
		for(user u:al) {
			bw.write(u.username+","+u.password+","+u.id+","+u.age+","+"\n");
		}
		bw.close();
		fw.close();
		file=null;
		
	}
	public static void loadData() throws IOException {
		File file=new File("C:\\Users\\Abhijeet\\eclipse-workspace\\BooKInventory\\src\\userManagement1\\file1.csv");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line="";
		while((line=br.readLine())!=null) {
			user u=new user();
			String[] str=line.split(",");
			if(str.length>3) {
				u.username=str[0].trim();
				u.password=str[1].trim();
				u.id=str[2].trim();
				u.age=str[3].trim();
				al.add(u);
				
			}
		}
		br.close();
		fr.close();
		file=null;	
   }
	public static boolean login(String username, String password) throws IOException {
		Iterator<user> itr=al.iterator();
		while(itr.hasNext()) {
			user u=itr.next();
			if(u.username.equalsIgnoreCase(username) && u.password.equalsIgnoreCase(password)) {
				return true;
			}
		}
		return false;
	}
}







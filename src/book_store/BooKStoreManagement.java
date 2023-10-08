package book_store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BooKStoreManagement {
	static List<book> al=new ArrayList();
	static{
		try {
			loadData();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void bookManagement() throws IOException {
	
		Scanner sc=new Scanner(System.in);
		boolean canIKeepRunningTheProgram=true;
		while(canIKeepRunningTheProgram==true) {
			System.out.println("@@@ WElcome To Book Management System @@@");
			System.out.println("1.Add Book");
			System.out.println("2.Search Book");
			System.out.println("3.Edit Book");
			System.out.println("4.Delete Book");
			System.out.println("5.Display Book Tittla");
			System.out.println("6.Quit");
			
			int choise=sc.nextInt();
			if(choise==book_options .ADD_BOOK) {
				addBook();
				System.out.println("\n");
			}else if(choise==book_options.SEARCH_BOOK) {
				System.out.println("Enter Name Which Want To Serach :");
				sc.nextLine();
				String s=sc.nextLine();
				serachBook(s);
				System.out.println("\n");
			}else if(choise==book_options .EDIT_BOOK) {
				System.out.println("Enter Book Name Which Want To Edit :");
				sc.nextLine();
				String e=sc.nextLine();
				editBook(e);
				System.out.println("\n");
			}else if(choise==book_options .DELETE_BOOK) {
				System.out.println("Enter Book Name Which Want To Delete :");
				sc.nextLine();
				String d=sc.nextLine();
				deleteBook(d);
				System.out.println("\n");
			}else if(choise==book_options .QUIT_BOOK) {
				System.out.println("**** Display Book Titles ****");
				System.out.println("\n");
				for(book b:al) {
					System.out.println("Tittle :"+b.name);
				}
				System.out.println("\n");
			}
			else {
				writeData();
				System.out.println("!!! Closed !!!");
				canIKeepRunningTheProgram=false;
			}
		}

	}
	public static void addBook() {
		Scanner sc=new Scanner(System.in);
		book b=new book();
		System.out.println("Enter Book Name :");
		b.name=sc.next();
		System.out.println("Enter Author Name :");
		b.author=sc.next();
		System.out.println("Enter Book Price :");
		b.price=sc.next();
		System.out.println("Enter Book Quantity :");
		b.quantity=sc.next();
		System.out.println("Enter Book Type :");
		b.type=sc.next();
		
		System.out.println("Name :"+b.name);
		System.out.println("Author :"+b.author);
		System.out.println("Price :"+b.price);
		System.out.println("Quantity :"+b.quantity);
		System.out.println("Type :"+b.type);
		
		al.add(b);
		
	}
	public static void serachBook(String s) {
		for(book b:al) {
			if(b.name.equalsIgnoreCase(s)) {
				System.out.println("Name :"+b.name);
				System.out.println("Author :"+b.author);
				System.out.println("Price :"+b.price);
				System.out.println("Quantity :"+b.quantity);
				System.out.println("Type :"+b.type);
				return;
			}
		}
		System.out.println("Book Not Found");
	}
	public static void editBook(String e) {
		Scanner sc=new Scanner(System.in);
		for(book b:al) {
			if(b.name.equalsIgnoreCase(e)) {
				System.out.println("Edited Book Is :"+b.name);
				System.out.println("Enter Book Name :");
				b.name=sc.next();
				System.out.println("Enter Author Name :");
				b.author=sc.next();
				System.out.println("Enter Book Price :");
				b.price=sc.next();
				System.out.println("Enter Book Quantity :");
				b.quantity=sc.next();
				System.out.println("Enter Book Type :");
				b.type=sc.next();
				
				return;
			}
		}
		System.out.println("Book Not Found");
	}
	public static void deleteBook(String d) {
		Iterator<book> itr=al.iterator();
		while(itr.hasNext()) {
			book b=itr.next();
			if(b.name.equalsIgnoreCase(d)) {
				itr.remove();
				System.out.println("Book "+b.name+" Has Been Deleted");
				return;
			}
		}
		System.out.println("Book Not Found");
	}
	public static void writeData() throws IOException {
		File file=new File("C:\\Users\\Abhijeet\\eclipse-workspace\\BooKInventory\\src\\BookStore\\book.csv");
		FileWriter fw=new FileWriter(file,false);
		BufferedWriter bw=new BufferedWriter(fw);
		for(book b:al) {
			bw.write(b.name+","+b.author+","+b.price+","+b.quantity+","+b.type+"\n");
		}
		bw.close();
		fw.close();
		file=null;
		
	}
	public static void loadData() throws IOException {
		File file=new File("C:\\Users\\Abhijeet\\eclipse-workspace\\BooKInventory\\src\\BookStore\\book.csv");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line="";
		while((line=br.readLine())!=null) {
			book b=new book();
			String[] arr=line.split(",");
			if(arr.length>4) {
				b.name=arr[0].trim();
				b.author=arr[1].trim();
				b.price=arr[2].trim();
				b.quantity=arr[3].trim();
				b.type=arr[4].trim();
				al.add(b);
			}
		}
		br.close();
		fr.close();
		file=null;
	}

	
}

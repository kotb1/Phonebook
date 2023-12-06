package Program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;

public class Main {
	private static ArrayList <ArrayList<String>> phonebook= new ArrayList <ArrayList<String>>();
	//dah 2d array 3shan matlob list of contacts kol contact 3ando first,last name wa address wa city wa phonebook
	//fa bnsbalak el last name hyb2a index el zero beta3 el contact el 2walany wa el tany el first name el index 1 wa hakaza .... 
	public static Scanner input = new Scanner(System.in);//3shan ta5od inputs mn el user
	public static void main(String[] args) throws IOException {
		boolean x = true;//hena 3shan el program yefdal sha8al le7ad mydos quit gowa el while loop
		while(x==true) 
		{
			System.out.println("LOAD or QUERY or ADD or DELETE or MODIFY or PRINT or SAVE or QUIT");
			String choice = input.nextLine();
			if(choice.equalsIgnoreCase("LOAD"))//hena betshoof hwa 25tar eh wa ignore el case 3shan law katabha capital aw small mayedrabsh 
			{
				load();
			}
			else if(choice.equalsIgnoreCase("QUERY")) 
			{
				query();
			}
			else if(choice.equalsIgnoreCase("ADD")) 
			{
				add();
			}
			else if(choice.equalsIgnoreCase("DELETE")) 
			{
				delete();
			}
			else if(choice.equalsIgnoreCase("MODIFY")) 
			{
				modify();
			}
			else if(choice.equalsIgnoreCase("PRINT")) 
			{
				print();
			}
			else if(choice.equalsIgnoreCase("SAVE")) 
			{
				save();
			}
			else if(choice.equalsIgnoreCase("QUIT")) 
			{
				x=false;
			}
			else 
			{
				System.out.println("Choice is not available :(");
			}
		}
	}
	public static void load() throws IOException //esta3melna buffer reader 3shan ne2ra mn el file wa nesagel fil array
	{
		String Filename ="phonebook.txt";
		File file = new File(Filename);
	    BufferedReader br= new BufferedReader(new FileReader(file));
	    String st;
	    while ((st = br.readLine()) != null) {
	       	String[] arrOfStr = st.split(",");
	       	ArrayList <String> contact = new ArrayList();
	       	contact.add(arrOfStr[0]);
	       	contact.add(arrOfStr[1]);
	       	contact.add(arrOfStr[2]);
	       	contact.add(arrOfStr[3]);
	       	contact.add(arrOfStr[4]);
	       	phonebook.add(contact);
	    }
	    System.out.println("Loaded Successfully :)");
	}
	public static void query() 
	{
		System.out.println("Please Enter Last name");
		String last_name=input.nextLine();
		for(int i=0;i<phonebook.size();i++) 
		{
			if(phonebook.get(i).get(0).equalsIgnoreCase(last_name))
			{
				System.out.println("Your contact First Name: "+phonebook.get(i).get(1));
				System.out.println("Your contact Address: "+phonebook.get(i).get(2));
				System.out.println("Your contact City: "+phonebook.get(i).get(3));
				System.out.println("Your contact PhoneNumber: "+phonebook.get(i).get(4));
			}
			System.out.println();
		}
	}
	public static void add() 
	{
		System.out.println("Please Enter the First Name:");
		String First_name=input.nextLine();
		System.out.println("Please Enter the Last Name:");
		String Last_name=input.nextLine();
		System.out.println("Please Enter the Address:");
		String Address=input.nextLine();
		System.out.println("Please Enter the City:");
		String City=input.nextLine();
		System.out.println("Please Enter the PhoneNumber:");
		String PhoneNumber=input.nextLine();
		ArrayList <String> contact = new ArrayList();
		contact.add(Last_name); //hena 3shan el tasgil fil file matlob bl last name el 2wal
		contact.add(First_name);
		contact.add(Address);
		contact.add(City);
		contact.add(PhoneNumber);
		phonebook.add(contact);
	}
	public static void delete() 
	{
		System.out.println("Please enter the Last Name");
		String Last_name=input.nextLine();
		System.out.println("Please enter the First Name");
		String First_name=input.nextLine();
		boolean deleted=false;
		for(int i=0;i<phonebook.size();i++) 
		{
			if(phonebook.get(i).get(0).equalsIgnoreCase(Last_name) && phonebook.get(i).get(1).equalsIgnoreCase(First_name))
			{
				phonebook.remove(i);
				deleted=true;
			}
		}
		if(deleted) 
			System.out.println("Contact Deleted Successfully :)");
		else
			System.out.println("Contact Not Found :(");
	}
	public static void modify() 
	{
		System.out.println("Please Enter the Last Name: ");
		String last_name=input.nextLine();
		boolean updated=false;
		for(int i=0;i<phonebook.size();i++) 
		{
			if(phonebook.get(i).get(0).equalsIgnoreCase(last_name))
			{
				ArrayList<String> new_contact = new ArrayList();
				System.out.println("Please Enter new First Name:");
				String First_name=input.nextLine();
				System.out.println("Please Enter new Address:");
				String Address=input.nextLine();
				System.out.println("Please Enter new City:");
				String City=input.nextLine();
				System.out.println("Please Enter new PhoneNumber:");
				String PhoneNumber=input.nextLine();
				new_contact.add(last_name);//3shan lama tegy t3mel update hatshil contact kamel wa hat7ot wa7ed gedid fa lazem ta5od m3ak el last name
				new_contact.add(First_name);
				new_contact.add(Address);
				new_contact.add(City);
				new_contact.add(PhoneNumber);
				phonebook.set(i, new_contact);//update fil arraylist bl contact el gedid
				updated=true;
			}
		}
		if(updated) 
			System.out.println("Contact Updated Successfully :)");
		else
			System.out.println("Contact Not Found :(");
	}
	public static void print() 
	{
		ArrayList <String> temp;
		for (int i = 0; i < phonebook.size(); i++) {
		    for (int j = i + 1; j < phonebook.size(); j++) 
		    {	                
		     // to compare one string with other strings
		        if (phonebook.get(i).get(0).compareTo(phonebook.get(j).get(0)) > 0) 
		        {
		        	if(phonebook.get(i).get(0).equalsIgnoreCase(phonebook.get(j).get(0))) 
		        	{
		        		if (phonebook.get(i).get(1).compareTo(phonebook.get(j).get(1)) > 0) 
		        		{
		        			// swapping
		        			temp = phonebook.get(i);
				            phonebook.set(i, phonebook.get(j));
				            phonebook.set(j, temp);
		        		}
		        	}
		        	else 
		        	{
		        		// swapping
		        		temp = phonebook.get(i);
			            phonebook.set(i, phonebook.get(j));
			            phonebook.set(j, temp);
		        	}
		        }
		     }
		   }
		for(int i=0;i<phonebook.size();i++) 
		{
			System.out.println(i+1+"-");
			System.out.println("First Name: "+phonebook.get(i).get(1));
			System.out.println("Last Name: "+phonebook.get(i).get(0));
			System.out.println("Address: "+phonebook.get(i).get(2));
			System.out.println("City: "+phonebook.get(i).get(3));
			System.out.println("PhoneNumber: "+phonebook.get(i).get(4));
		}
	}
	public static void save() throws IOException 
	{
		//delete all contents in file to update it
		PrintWriter writer = new PrintWriter("phonebook.txt");
		writer.print("");
		writer.close();
		FileWriter myWriter = new FileWriter("phonebook.txt");
		for(int i=0;i<phonebook.size();i++) 
		{
			myWriter.write(phonebook.get(i).get(0)+","+phonebook.get(i).get(1)+","+phonebook.get(i).get(2)+","+phonebook.get(i).get(3)+","+phonebook.get(i).get(4));
			myWriter.write("\n");
		}
	    myWriter.close();
	    System.out.println("Saved Successfully in phonebook.txt :)");
	}

}

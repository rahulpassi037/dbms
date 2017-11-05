import java.sql.*;
import java.util.Scanner;


public class interfaceMenu {
	
	private static boolean ReadAdmin(String username,String password)
	{
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jail_system","root","");
			
			Statement stmt;
			stmt = conn.createStatement();
			
		    String sql = "select * from admin"+" where username='"+username+"'";
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    rs.next();
		    
		    String pass = rs.getString("password");
		    
		    rs.close();
		    
		    if(pass.equals(password))
		    {
			    return true;
		    }
		    else
		    	return false;
		}
		catch(Exception e){
			System.err.println(e);
			return false;
		}
	}
	
	private static void AddPrisoner()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the id of the prisoner : ");
		String id = sc.next();
		System.out.print("Enter the cell of the prisoner : ");
		String cell = sc.next();
		sc.nextLine();
		System.out.print("Enter the name of the prisoner : ");
		String name = sc.nextLine();
		System.out.print("Enter the age of the prisoner : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the address of the prisoner : ");
		String address = sc.nextLine();
		System.out.print("Enter the personal belongings of the prisoner : ");
		String personal = sc.next();
		System.out.print("Enter the flags of the prisoner : ");
		int flags = sc.nextInt();
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jail_system","root","");
			
			Statement stmt;
			stmt = conn.createStatement();
			
		    String sql = "insert into prisoners (id, cell, name, age, address, personal_belongings, flags) values "+"('"+id+"','"+cell+"','"+name+"',"+age+",'"+address+"','"+personal+"',"+flags+");";
		    stmt.executeUpdate(sql);
		}
		catch(Exception e){
			System.err.println(e);
		}
		
		sc.close();
	}
	
	private static void RemovePrisoner()
	{
        Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the id of the prisoner to be deleted : ");
		String id = sc.next();
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jail_system","root","");
			
			Statement stmt;
			stmt = conn.createStatement();
			
		    String sql = "delete from prisoners where id = '"+id+"';";
		    stmt.executeUpdate(sql);
		}
		catch(Exception e){
			System.err.println(e);
		}
		
		sc.close();
	}
	
	private static void AddAdmin()
	{
        Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the username of the admin : ");
		String username = sc.next();
		System.out.print("Enter the password : ");
		String password = sc.next();
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jail_system","root","");
			
			Statement stmt;
			stmt = conn.createStatement();
			
		    String sql = "insert into admin values "+"('"+username+"','"+password+"');";
		    stmt.executeUpdate(sql);
		}
		catch(Exception e){
			System.err.println(e);
		}
		
		sc.close();
	}
	
	private static void PrisonerInfo()
	{
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jail_system","root","");
			
			Statement stmt;
			stmt = conn.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("");
			String id = sc.next();
			sc.close();
			
		    String sql = "select * from prisoners"+" where id='"+id+"'";
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    while(rs.next())
		    {
		    	 String cell  = rs.getString("cell");
		    	 String name  = rs.getString("name");
		         int age = rs.getInt("age");
		    	 String address  = rs.getString("address");
		    	 String pb  = rs.getString("personal_belongings");
		    	 int flags  = rs.getInt("flags");

		         System.out.print("\nID: " + id);
		         System.out.print("\nCell: " + cell);
		         System.out.print("\nName: " + name);
		         System.out.print("\nAge: " + age);
		         System.out.print("\nAddress: " + address);
		         System.out.print("\nPersonal belongings: " + pb);
		         System.out.print("\nFlag: " + flags);
		    }
		    
		    rs.close();
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	
	private static void SearchByName()
	{
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jail_system","root","");
			
			Statement stmt;
			stmt = conn.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("\nEnter the name of the prisoner to be searched : ");
			String name = sc.next();
			sc.close();
			
		    String sql = "select * from prisoners"+" where name='"+name+"'";
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    while(rs.next())
		    {
		    	 String id  = rs.getString("id");
		    	 String cell  = rs.getString("cell");
		    	 String name1  = rs.getString("name");
		         int age = rs.getInt("age");
		    	 String address  = rs.getString("address");
		    	 String pb  = rs.getString("personal_belongings");
		    	 int flags  = rs.getInt("flags");

		         System.out.print("\nID: " + id);
		         System.out.print("\nCell: " + cell);
		         System.out.print("\nName: " + name1);
		         System.out.print("\nAge: " + age);
		         System.out.print("\nAddress: " + address);
		         System.out.print("\nPersonal belongings: " + pb);
		         System.out.print("\nFlag: " + flags);
		    }
		    
		    rs.close();
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	
	private static void SearchByCell()
	{
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jail_system","root","");
			
			Statement stmt;
			stmt = conn.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("\nEnter the cell number of the prisoner to be searched : ");
			String cell = sc.next();
			sc.close();
			
		    String sql = "select * from prisoners"+" where cell='"+cell+"'";
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    while(rs.next())
		    {
		    	 String id  = rs.getString("id");
		    	 String name1  = rs.getString("name");
		         int age = rs.getInt("age");
		    	 String address  = rs.getString("address");
		    	 String pb  = rs.getString("personal_belongings");
		    	 int flags  = rs.getInt("flags");

		         System.out.print("\nID: " + id);
		         System.out.print("\nCell: " + cell);
		         System.out.print("\nName: " + name1);
		         System.out.print("\nAge: " + age);
		         System.out.print("\nAddress: " + address);
		         System.out.print("\nPersonal belongings: " + pb);
		         System.out.print("\nFlag: " + flags);
		    }
		    
		    rs.close();
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	
	private static void HighSecurity()
	{
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jail_system","root","");
			
			Statement stmt;
			stmt = conn.createStatement();
			
		    String sql = "select * from cell where block = 'high security';";
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    while(rs.next())
		    {
		    	 String id  = rs.getString("id");
		    	 String block  = rs.getString("block");
		    	 String cell  = rs.getString("cell_no");

		         System.out.print("\nCell ID : " + id);
		         System.out.print("\nBlock :  " + block);
		         System.out.print("\nCell Number : " + cell);
		    }
		    
		    rs.close();
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	
	private static void AddMedical()
	{
        Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the injury : ");
		String injury = sc.next();
		System.out.print("Enter the id of the prisoner : ");
		String id = sc.next();
		System.out.print("Enter the doctor name : ");
		String doc_name = sc.next();
		System.out.print("Enter the id of the doctor : ");
		String doc_id = sc.next();
		System.out.print("Enter the date of injury : ");
		String injury_date = sc.next();
		System.out.print("Enter the date of last check : ");
		String date = sc.next();
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jail_system","root","");
			
			Statement stmt;
			stmt = conn.createStatement();
			
		    String sql = "insert into health_record values "+"('"+injury+"','"+id+"','"+doc_name+"','"+doc_id+"','"+injury_date+"','"+date+"');";
		    stmt.executeUpdate(sql);
		}
		catch(Exception e){
			System.err.println(e);
		}
		
		sc.close();
	}
	
	private static void EmptyCells()
	{
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jail_system","root","");
			
			Statement stmt;
			stmt = conn.createStatement();
			
		    String sql = "select * from cell where id is NULL ;";
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    while(rs.next())
		    {
		    	 String id  = rs.getString("id");
		    	 String block  = rs.getString("block");
		    	 String cell  = rs.getString("cell_no");

		         System.out.print("\nCell ID : " + id);
		         System.out.print("\nBlock :  " + block);
		         System.out.print("\nCell Number : " + cell);
		    }
		    
		    rs.close();
		}
		catch(Exception e){
			System.err.println(e);
		}
	}


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
        System.out.println("\t\t\t\t\t\t\t\t\t\tCentral jail");
        System.out.print("\n\n\nEnter the username : ");
        String username = sc.next();
        System.out.print("\n\n\nEnter the password : ");
        String password = sc.next();
        System.out.println("\n\n\n");
        if(ReadAdmin(username,password))
        {
        	System.out.println("\n\n\t\t\t\t\t\t\t\t\tWhat do you want to do");
        	System.out.println("1.Add a prisoner");
        	System.out.println("2.Remove a prisoner");
        	System.out.println("3.Add an admin");
        	System.out.println("4.Search prisoner by id");
        	System.out.println("5.Search prisoner by name");
        	System.out.println("6.Search prisoner by cell number");
        	System.out.println("7.Get cell numbers with high security");
        	System.out.println("8.Add medical report of the prisoner");
        	System.out.println("9.Get list of empty cells");
        	System.out.println("\n\n\n");
        	
        	int choice = sc.nextInt();
        	
        	switch(choice)
        	{
        	case 1 : System.out.println("\n\n\n");
        		     AddPrisoner();
        	
        	break;
        	
        	case 2 : System.out.println("\n\n\n");
        	         RemovePrisoner();
        	
        	break;
        	
        	case 3 : System.out.println("\n\n\n");
        	         AddAdmin();
        	
        	break;
        	
        	case 4 : System.out.println("\n\n\n");
        	         PrisonerInfo();
        	
        	break;
        	
        	case 5 : System.out.println("\n\n\n");
        	         SearchByName();
        	
        	break;
        	
        	case 6 : System.out.println("\n\n\n");
        	         SearchByCell();
        	
        	break;
        	
        	case 7 : System.out.println("\n\n\n");
        	         HighSecurity();
        	
        	break;
        	
        	case 8 : System.out.println("\n\n\n");
        	         AddMedical();
        	         
        	break;
        	
        	case 9 : System.out.println("\n\n\n");
        	         EmptyCells();
        	
        	break;
        	
        	default : System.out.println("\n\n\nEnter a valid choice");
        	
        	break;
        	}
        }
        else
        {
        	System.out.println("Wrong Password");
        }
        sc.close();
	}

}

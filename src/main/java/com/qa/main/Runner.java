package com.qa.main;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {

	private static Scanner scan = new Scanner(System.in);
	
    public static void main(String[] args) throws SQLException {
        DatabaseConnector db = new DatabaseConnector();
        
        String action = "";
        action = getAction();
        
        try {
        	do {
        		switch (action) {
        		
        		case "create":
        			System.out.println("Please enter forename");
        			String forename = scan.nextLine();
        			System.out.println("Please enter surname");
        			String surname = scan.nextLine();
        			db.createActor(forename, surname);
        			break;
        		
        		case "read":
        			db.readAllActors();
        			break;
        		
        		case "update":
        			System.out.println("Enter ID of actor you want to update");
        			int updateId = Integer.parseInt(scan.nextLine());
        			System.out.println("Enter the new forename");
                    String newForename = scan.nextLine();
                    System.out.println("Enter the new surname");
                    String newSurname = scan.nextLine();
                    db.updateActor(newForename, newSurname, updateId);
                    break;
        		
        		case "delete":
        			System.out.println("Enter ID of actor you wish to delete");
        			 int deleteId = scan.nextInt();
                     db.deleteActor(deleteId);
                     break;
                default:
                	System.out.println("You haven't selected anything sweetheart!?!?!?!!");
        			
        		}
        		action = getAction();
        	} while (!action.equals("exit"));
        		System.out.println("Cheerio! Farewell! Pip-Pip!");
        } finally {
        	scan.close();
        	db.close();
        }
    }
    
        
        
      //  db.readAllActors();
      //  db.createActor("Geoff", "Rush");
       // db.readAllActors();
       // db.updateActor("Avi", "Nissim", 1);
       // db.readAllActors();
       // db.deleteActor("Geoff", "Rush");
        //db.readAllActors();
    

    private static String getAction() {
    	System.out.println("Please enter the desired CRUD method");
    	System.out.println("create, read, update, delete, exit");
    	return scan.nextLine();
    }
}

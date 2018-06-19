/**
 * Demo.java
 * 
 * Template method example.
 *
 * @author Dr.Fenwick
 * @version Sum2018
 */

import java.util.Scanner;
import java.util.HashMap;

public class Demo {
    private static void error(String[] a) {
	System.out.println("******** ERROR ********\n");
	for (int i=0; i < a.length; i++) {
	    System.out.println("command["+i+"]: '"+ a[i] + "'");
	}
	System.out.println("******** ERROR ********\n");
    }
    public static void main(String[] args) {
	boolean done = false;
	Library library = new Library();
	Scanner keyboard = new Scanner(System.in);
	
	while (! done) {
	    System.out.println("\nEnter commands, stop with \"done\"");
	    System.out.println("\tadd <name>");
	    System.out.println("\tcheckout <item> by <name>");
	    try {
		String commandText = keyboard.nextLine();
		commandText = commandText.trim();
		String[] command = commandText.split("\\s+");
		
		if ("done".equals(command[0])) { done = true; }
		else if ("add".equals(command[0])) {
		    library.addPatron(command[1]);
		}
		else if ("checkout".equals(command[0])) {
		    library.checkout(command[1], command[3]);
		}
		else {
		    error(command);
		}
	    }
	    catch (java.util.NoSuchElementException e) {
		done = true;
	    }
	    catch (java.lang.IllegalStateException e) {
		done = true;
	    }
	}
    }
}



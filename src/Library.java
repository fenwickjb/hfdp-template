
import java.util.HashMap;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Library {

    private HashMap<String,Patron> patrons;

    public Library() {
	patrons = new HashMap<String,Patron>();
    }

    public void addPatron(String patronName) {
	patrons.put(patronName, new Patron(patronName));
    }

    private boolean checkPatronAccount(Patron p) {
	System.out.println("checking account...");
	return p.numCheckedOut() < 8;
    }

    private String getSuggestion(String item) {
	System.out.println("looking up suggestions...");
	return "NC-centric suggested items...";
    }

    private void printReceipt(Patron p, String item, int days, String suggestion) {
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
	Date date = new Date();
	String datetimeString = formatter.format(date);  	
	
	System.out.println("--------------------------------------");
	System.out.println("--  L I B R A R Y     R E C E I P T --");
	System.out.println();
	System.out.println(" " + datetimeString);
	System.out.println(" Patron: " + p.getName());
	System.out.println(" Item: " + item);
	Date due = new Date(date.getTime()+(days*24*60*60*1000));
	formatter = new SimpleDateFormat("MM/dd/yyyy");  
	datetimeString = formatter.format(due);  	
	System.out.println(" Due: " + datetimeString);
	System.out.println();
	System.out.println(" Suggested title:");
	System.out.println("   " + suggestion);
	System.out.println("--------------------------------------");
    }

    private int getDuration(Patron p) {
	return p.ckoutDuration();
    }

    public void checkout(String item, String name) {
	Patron p = patrons.get(name);

	boolean okayToCheckout = checkPatronAccount(p);

	if (okayToCheckout) {
	    int days = getDuration(p);
	    p.checkout(item);
	    String s = getSuggestion(item);
	    printReceipt(p, item, days, s);
	}
    }

}

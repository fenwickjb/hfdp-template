/**
 * Patron.java
 *
 * Template method example.
 *
 * @author Dr.Fenwick
 * @version Sum2018
 */

import java.util.ArrayList;

class Patron {
    private String name;
    private ArrayList<String> checkedOut;

    public Patron(String name) {
	this.name = name;
	checkedOut = new ArrayList<String>();
    }
    public String getName() { return name; }
    public int ckoutDuration() { return 14; }
    public void checkout(String itemName) {
	checkedOut.add(itemName);
    }
    public int numCheckedOut() {
        return checkedOut.size();
    }
}


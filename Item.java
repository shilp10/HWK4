/*
* Name:Shilp Pancholi, Nimalan Chandrasekara
* Description:This is the items class. It deals with all items
*/






import java.io.IOException;//import IOExceptionHandler

public abstract class Item { //class for Item
	public abstract void getInfo() throws IOException; //gets the Info of the item
	public abstract int getPrice(); //gets the Price of the item
	 
	protected int price; //Price can only be used by Item
	protected int sNo; //Serial number can only be used by Item
	protected int quantity; // Quantity can only be used by Item
	protected String productName; // productName can only be used by Item

}

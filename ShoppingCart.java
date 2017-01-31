/*
* Name:Shilp Pancholi, Nimalan Chandrasekara
* Description:This is the shopping cart. It deals with adding to the cart file and checkout related things.
*/

import java.io.BufferedReader; //importing BufferedReader
import java.io.BufferedWriter; //importing BufferedWrite 
import java.io.File; //importing File 
import java.io.FileNotFoundException; //importing File Exception Handler 
import java.io.FileReader; //importing FileReader 
import java.io.FileWriter;//importing FileWriter 
import java.io.IOException;//importing IOHandler 
import java.io.StringReader;//importing StringReader 
import java.util.*;//importing files from io directory 
public class ShoppingCart { //shoppingcart class 
private String username; //username is a string that can be only accessed by shoppingcart
FileWriter userlistwriter; //filewriter has a variable  
FileReader userlistreader; //filereader has varibale 
String CartItems=" "; //cart items variable is an empty string 
String stuff;
public ShoppingCart(String username) throws IOException{ //shoppingcart has variable username passed and might get rethrown
		this.username=username; //points to username 
		
		try{ //try statement 
			File file=new File("cart["+username+"].txt"); //write to the user's cart
			if(!file.exists()){ //if file doesnt exist 
				System.out.print("File does not exists");//print this
				this.userlistwriter=new FileWriter("cart["+username+"].txt",true); //writ
				this.userlistreader=new FileReader("cart["+username+"].txt");
				
				//this.userlist=new FileWriter("users.txt");
			}
			
			}finally{ //run when try block exits 
				
			}
	}
	public void getContent() throws IOException //getCart might get rethrown
	{
		System.out.println(); //print whitespace
		
		BufferedReader br=new BufferedReader(new FileReader("cart["+username+"].txt")); //read from the user's cart
	boolean exists=false; //if file exists 
		while(true){//while it does 
			String line=br.readLine(); //read from it 
		if(line!=null){ //check to see if line is not empty 
			exists=true; //items are in there 
		}
		   if(line==null){ //check to see if line has nothing 
			   if(exists==false){//if it has nothing 
				   System.out.println("There is nothing in your shopping cart."); //print cart has nothing
			   }
			   
			   break;//exit 
		   }
			System.out.println(line);	//print stuff from cart 
			
		}
		br=null; //empty 
	}
	
	public void addItem(String newline) throws IOException{ //writes to Cart
		BufferedWriter bw=new BufferedWriter(new FileWriter("cart["+username+"].txt",true)); //writes to the User's cart
		BufferedReader br=new BufferedReader(new FileReader("cart["+username+"].txt"));//reads from the users cart 

		bw.write(newline); //write whatever they buy
		bw.newLine();
		bw.close(); //close file 
		bw=null;//clear write
		br=null;//clear reader
		}
		
	public void createCheckOut() throws IOException{ //checkout might get rethrown
		System.out.println("Billing Information"); //prints billing info 
		System.out.format("%20s%20s%20s","Name","Quantity","Price");	// prints the info about the item(s) bought
		BufferedReader br = new BufferedReader(new FileReader("cart["+username+"].txt"));//reads from the users cart.txt file
	while(true){//while file exits
		String line=br.readLine();//read each line 
		if(line==null){//checking to see if line is empty 
			break;//exit 
		}
		CartItems+=line;	//new line if more than 2 item 
	}
	br=null; //br is cleared 
	}
	
	public void getDetails() throws IOException{ //getDetails might get rethrown
	BufferedReader br = new BufferedReader(new FileReader("cart["+username+"].txt"));//read from users cart.txt file
	int quantity; //quantity is an int
	int price=0; //initial price is 0 
	while(true){ //while true 
		String line=br.readLine(); //read first line 
		if(line==null){//if nothing 
			break;//exit 
			
		}
		if(line.equals("")){//if blank 
			line=br.readLine();//read line 
		}
		if(line==null){//if nothing 
			break;//exit 
			
		}
		String product=(line.substring(nthIndexOf(line,',',1)+1,nthIndexOf(line,',',2)));	//get the product user bought
		
		String quantitystring=line.substring(nthIndexOf(line,',',4)+1,line.length()); //get quantity of item bought 
				
		price+=Integer.parseInt(line.substring(nthIndexOf(line,',',4)+1,line.length()).trim())*Integer.parseInt(line.substring(nthIndexOf(line,',',3)+1,nthIndexOf(line,',',4)).trim());
		System.out.println(); //prints new line
		String pricestring=line.substring(nthIndexOf(line,',',3)+1,nthIndexOf(line,',',4)); //
		System.out.format("%20s%20s%20d",product,quantitystring,price); //prints the product with quantiy and price 
		stuff=product+ " "+quantitystring+ " "+pricestring+"\n";
	}
	br=null; //br is cleared 
	
	System.out.println(); //print new line
	//System.out.println("Enviorment Tax\t\t\t"+((0.02)*price));
	System.out.format("%20s%10s%30f","Enviromental Tax","2%",0.02*price); //prints environmental tax + price with tax
System.out.println(); //prints new line 
System.out.format("%20s%10s%30f","HST","19%",0.12*price); //prints HST + price with tax
System.out.println();
System.out.format("%20s%10s%30f","Shipping","10%",0.10*price); //prints shipping + price with tax
System.out.println(); //prints new line 


	double total=((0.02)*price)+((0.13)*price)+((0.10)*price)+price; //calculates the total
	System.out.format("%60s","______________________"); //prints empty line 
	System.out.println();
	System.out.format("%30s%30f","Total",total); //prints users total 
	System.out.println();
	System.out.println("Are you sure you want to pay? yes or no"); //print this 
	Scanner input= new Scanner(System.in); //allows user to input yes or no 
	String s=input.next();//gets user input
	switch(s.toLowerCase().trim()){//allows all forms of yes and no 
	case "no"://if user entered no 
		
		break;//exit 
	case "yes"://if user entered yes 
		removeCart(stuff);//removes cart 
		break;//exit 
	
	}

	}
	
	public void removeCart(String write) throws IOException{//removeCart might get rethrown
		ItemsBought writeItems=new ItemsBought();//new ItemsBought variable
		System.out.println("Confirmation ID: U"+writeItems.getConfirmationId());//print this
		write="U"+writeItems.getConfirmationId()+"\n"+write; //writes to file
		writeItems.writeItems(write);//changes whatever is in write
		
		//System.out.prinln(writeItems.getConfirmationId());
		BufferedWriter bw=new BufferedWriter(new FileWriter("cart["+username+"].txt"));//write to users cart.txt file
		bw.write("");//write a blank space
		bw.close();//close bw
		
	}
	
	public static int nthIndexOf(String source, char sought, int n) {
	    int index = source.indexOf(sought);
	    if (index == -1) return -1;

	    for (int i = 1; i < n; i++) {
	        index = source.indexOf(sought, index + 1);
	        if (index == -1) return -1;
	    }
	    return index; //return index
	}
	
	}
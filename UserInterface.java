/*
* Name:Shilp Pancholi, Nimalan Chandrasekara
* Description:This is the user interface. It is the connection of every page.
*/





import java.io.IOException; //import ioexception handler
import java.util.*; //import files from io directory 



public class UserInterface { //class for UserInterface
	private String username; //user name is a string only accessible by UserInterface
	private boolean itemShow; //itemShow is a boolean only accessible by UserInterface
	public UserInterface() throws IOException{ //UserInterface deals with anything wrong in the file
	}
	public UserInterface(String username) throws IOException{ //user name is input as a string 
	this.username=username; //points to username
	itemShow=false;//item does not exist
	}
	public void p1() throws IOException{ //might have to rethrow p1() 
		System.out.println("1.Sign In"); //print sign in, in the userinterface
		System.out.println("2.Sign Up"); //print sign up, in the userinterface
		System.out.print("Choose Your Option: "); //print choose your option, in the userinterface
		Scanner input=new Scanner(System.in); //allow user to write 
		int userInput=input.nextInt(); //get user input 
		Scanner usernameinput=new Scanner(System.in); //using a scanner for the user input
		
		if(userInput==1){ //checking to see what input
		System.out.print("Enter your username: "); //if 1 print this
		String a=usernameinput.nextLine(); //allow user to print username
		username=a; //store username 
		User user=new User(a); //get user to print username
		
		
	    if(!user.checkUserName()){ //checking to see if username works 
	    	System.out.println("No Access"); //if it doesnt no access 
	    	input=null; //input contains nothing 
	    	usernameinput=null; //usernameinput therefor has nothing 
	    	p1();//refer back to p1() function  in main class
	    }
		if(user.checkUserName()){ //if username exists 
			System.out.println("Welcome Mr." + a); //print hello to the user
			p5(); // refer to function p5()
		}
		}
		if(userInput==2){ //if user input 2 do this 
			System.out.println("Choose your username"); //tell user to pick a username
			String a=usernameinput.nextLine(); //allow user to write their desired username 
			username=a; //store the username 

			User user=new User(a); //username is a new variable to check if username exists 
			if(user.checkUserName()){ //checking to see if username exists 
				System.out.print("User already exists. Pick another one!"); //if it does print this 
		    	input=null; //input is empty 
		    	usernameinput=null; //usernameinput is empty 

			p1();//refer back to p1()
			}
			else{//if username doesnt exist run this 
				user.addUserName(); //add the new user
				p1(); //refer back to p1()
			}
		}
		if(userInput!=1||userInput!=2){ //checking if option is not 1 or 2 
			if(!itemShow){ 
			System.out.println("Invalid input"); //print this if option entered isnt 1 or 2 
	    	input=null; //input is empty 
	    	usernameinput=null; //usernameinput is empty 

			p1(); //refer back to p1()
			}
		}

	}
	
	public void p5() throws IOException{ //p5 might be rethrown 
		Scanner input=new Scanner(System.in); //allows user to input option 
		System.out.println("1.View Item Catagories"); //print this  
		System.out.println("2.Your Shopping Cart"); //print this 
		System.out.println("3.Sign out"); //print this 
		System.out.println("4.View Previous Orders");//print this
		switch(input.nextInt()){ //checking to see what user input 
		case 1:input=null; //input is empty to start 
			itemCategories(); // if 1 go to class itemCategories 
			break;//exit 
		case 2:input=null; //user input again 
			cartView(); //if 2 go to class cartView  
			break; //exit 
		case 3: //third case 
			input=null; //empty input 
			p1(); //refer back to p1()
			break;//exit 
		case 4:
			itemShow=true;//shows items
			ItemsBought();//itemsbought variable 
			break;//exit
		default:System.out.println("Invalid input"); //tell user input outside of 1 or 2 is invalid
			itemCategories();//itemcategories varaible
		break;//exit
		}
		
	}
public void itemCategories() throws IOException{//itemCategories might get rethrown 
	Scanner newinput=new Scanner(System.in); //allow user to input choice 
	System.out.println("-1. Return to Previous Page"); //print this
	System.out.println("1. Readables"); //print this 
	System.out.println("2. Audio"); //print this 
	switch(newinput.nextInt()){ //checking to see what case 
	case -1: //if -1 
		p5(); //refer back to p5()
		break; //exit 
	case 1:ReadableView(); //if 1 go to ReadableView
		break; //exit 
	case 2:AudioView(); //if 2 go to AudioView 
		break;//exit 
		
	default:System.out.println("Invalid input"); //if none print this 
		break; //exit 
	}
	
}

public void ReadableView() throws IOException{ //ReadableView might get rethrown 
	Readable readable=new Readable(); //new readable varaible 
	readable.username=username; //username pointed back to 
	readable.getInfo(); //show readable file 
	itemShow=true; //if its true 
	Scanner newinput=new Scanner(System.in); //allow user to input something 
    int input = newinput.nextInt(); //user input stored in a variable 

    if(input==-1){ //if option is -1 
    	itemCategories(); //go to itemCategories 
    }else{ //otherwise 
    
    
    readable.ReadLine(input); //input from user is passed into readable 
    } 
    if(readable.shopping){ //allows user to shop
    	itemCategories(); //shows item categories  

    }
    else{ //otherwise 
    	 
    	p10(); //refers to function p10()
    }
    }


public void AudioView() throws IOException{ //AudioView might get rethrown 
	Audio audio=new Audio(); //new audio variable 
	audio.username=username; //username accessed 
	audio.getInfo(); //checks variable 
	itemShow=true; //if variable exits 
	Scanner newinput=new Scanner(System.in); //allow user to input option 
    int input = newinput.nextInt(); // get useri nput 
  
    
    if(input==-1){ //check if input = -1 
    	itemCategories(); //show this 
    }else{ //otherwise 
    
    audio.ReadLine(input); //input from user is passed into audio 
    }
    
  
    }

public void cartView() throws IOException{ //cartView might get rethrown 
	itemShow=true; //if files exist show the items 
	System.out.println("This is your shopping cart: ");//print this
	ShoppingCart userCart=new ShoppingCart(username); //new variable userCart created for user
	userCart.getContent(); //get info from cart 
p5(); //refer to function p5()
	
}

public void p10() throws IOException{ //p10() might get rethrown 
	ShoppingCart Cart=new ShoppingCart(username); //new Cart variable created for user 
	Cart.createCheckOut(); //allows user to checkout 
	Cart.getDetails(); //gets the details of the user 
p5(); //refers to function p5()
}
	
public void ItemsBought() throws IOException{//ItemsBought might get rethrown
	ItemsBought item=new ItemsBought();// new itembought variable 
	item.getItems();//get items
	p5();//refer to function p5
}


}	

/*
* Name:Shilp Pancholi, Nimalan Chandrasekara
* Description:This is the Audio class. It deals with buying audio related products.
*/

import java.io.BufferedReader; //importing BufferedReader 
import java.io.BufferedWriter; //importing BufferedWriter
import java.io.FileReader; //importing FileReader
import java.io.FileWriter; //importing FileWrite
import java.io.IOException; //importing IO Exception Handler
import java.io.StringReader; //importing StringReader 
import java.util.Scanner; //importing Scanners

//audio class extends item class
public class Audio extends Item {

	//declares variables
	public String artist; //variable author is decalred as a string 
	public String line; //variable line is decalred as a string 
	public String ReadableText=""; //variable ReadableText is decalred as a string  
	private String CDText=""; //variable CDText is decalred as a string and is private 
	private String MP3Text=""; //variable MP3Test is decalred as a string and is private
	public boolean shopping; //variable shopping is decalred as a boolean 
	public String username; //variable username is decalred as a string 
	private boolean foundserialnumber; //variable foundserialnumber is decalred as a boolean and is private 
	public Audio(){ //Audio class 
		
		
	}
	@Override
	public int getPrice() {//get price
		// TODO Auto-generated method stub
		
		return price; //returns price
	}
	@Override
	public void getInfo() throws IOException {// gets info about product
		// TODO Auto-generated method stub
		 System.out.format("%4s%30s%20s%10s%20s%6s","S.No","Name","Artist","Price($)","Quantity in Store","Type"); // shows the products as a formatted string

		 CD cd=new CD(); //new CD variable 
	    cd.getLine(); //gets content from CD file in a line
	    MP3 mp3=new MP3(); //new MP3 variable 
	    mp3.getLine(); //gets content in MP3 file in a line
	    ReadableText+=cd.returnCDString()+mp3.returnMP3String(); //concatenating the two lines from MP3 and CD
	    CDText=cd.returnCDStringwithoutType();  //returning the CD string without knowing its type so all forms of strings can be used
	    MP3Text=mp3.returnMP3StringwithoutType(); //returning the MP3 string without knowing its type so all forms of strings can be used
	 
	    System.out.println(); //print new line
System.out.println("Choose your option:"); //print this
System.out.println("Press -1 to return to previous menu."); //print this 
	

	}

	public void ReadLine(int SerialNumber) throws IOException{ //serialnumber is passed as an int in Readline and might get rethrown
		
		BufferedReader reader=new BufferedReader(new StringReader(ReadableText)); //new bufferedreader created 
		String temp=reader.readLine(); //variable to read lines 
	
if((temp.substring(0,temp.indexOf(',')).equals(Integer.toString(SerialNumber)))){ //checking if serials numbers are equal
	foundserialnumber=true; //here they are 
}
else{//else
	while(temp.substring(0,temp.indexOf(','))!=Integer.toString(SerialNumber)){  //looks for serial number
	
		temp=reader.readLine(); //temp reads lines in the file
		if(temp==null){ //checking to see if temp has nothing
		System.out.println("Product Not Found, Please Try Again");//prints this line 
		foundserialnumber=false; //therefore no serial number found
			break; //exits
		}
		if((temp.substring(0,temp.indexOf(',')).equals(Integer.toString(SerialNumber)))){ //looks for serials number 
			foundserialnumber=true; //serial number found in this case 
			break;//no error exits
		}
		
	}
}
		
		if(foundserialnumber){ //runs if serial number is found 
			buyReadable(temp); //temp gets passed to buyReadable
		}
	}
	
	public void buyReadable(String productline) throws IOException{//buys buys a mp3 or cd

		Scanner input=new Scanner(System.in); //scanner to allow user input
		System.out.println("Enter Quantity: "); //tells user to input something 
		int subtraction=input.nextInt(); //subtracts quantity user chooses
		String type=gettype(productline); //gets the product 
		
		String productname=productline.substring(productline.indexOf(',')+1,nthIndexOf(productline,',',2)); //all info of the product user chose 
		
		
		System.out.println("The following item has been added to the cart");//prints out that product has been added to cart
		//System.out.println(productline);
		quantity=Integer.parseInt(productline.substring(nthIndexOf(productline,',',4)+1,nthIndexOf(productline,',',5)).trim());	//prints quanity of the product without whitespaces
	
		if(quantity-subtraction>=0&&subtraction>0){ //checks to see if number is greater than 0 
		System.out.println("The following item has been added to the cart");//print this
		quantity=quantity-subtraction; //does the subtraction 
		shopping=false;//set boolean false //if less than 0 no shopping done
		} 
		else{ //else 
		while(true){ //while shopping is done 
			System.out.println("We do not have enough quantity. "); //print this
		System.out.println("Please enter another quantity: ");	//print this
		subtraction=input.nextInt();//try again //get quantity from user
		if(quantity-subtraction>=0){//try again //checks if quantity is greater than 0
			quantity=quantity-subtraction; //new quantity updated 
			shopping=false; //shopping done 

			break; //exits

		}
		}
			
		}
		
		System.out.println(Integer.toString(subtraction)+" "+ productname+" "+type+"s have been added to your cart" ); //tells user whats been added to cart
		
		String finalstring=""; //empty string
		String cartstring=""; //empty string

		
		productline=productline.substring(0,nthIndexOf(productline,',',5)); //product line for 5th index of string
		BufferedReader br; //new bufferedreader variable 
		//if product is cd
		if(type.equals("CDs")){
		 br=new BufferedReader(new StringReader(CDText)); //new bufferedreader variable for CD
		}
		else{ //else 
			
			 br=new BufferedReader(new StringReader(MP3Text)); //new bufferedreader variable for MP3

		}
		while(true){ //while true 
			String a=br.readLine(); //reads line from either file MP3 or CD
		 
			if(a==null){ //a is empty 
				break; //exit 
			}
			if(a.equals(productline)){ //if a has productline 
				finalstring+=a.substring(0, nthIndexOf(a,',',4))+","+Integer.toString(quantity)+"\n"; //update quantity 
				cartstring+=a.substring(0, nthIndexOf(a,',',4))+","+Integer.toString(subtraction)+"\n"; //update subtraction

			}
			else{ //else 
				finalstring+=a+"\n"; //new line and increment a by 1
				
			}	
			
		}
	
		//System.out.println("THIS IS OUR "):
		

		ShoppingCart cart=new ShoppingCart(username); // new cart variable for users shopping cart
		cart.addItem(cartstring); //write to file 
	    if(type.equals("CDs")){ //checks if type is cd
  
	CD cd=new CD(); //new cd varibale 
	    	cd.writeNewCD(finalstring); //cd variable updated with finalstring
    	
	    }

	    if(type.equals("MP3")){	//if product is mp3
    	
	    	MP3 mp3=new MP3(); //new mp3 variable 
	    	mp3.writeNewMP3(finalstring); //mp3 variable updated with final string 
	    	
	    }
	//options for customer
	    System.out.println("Press -2 to continue shopping or 0 to proceed to CheckOut"); //prints this
	  	UserInterface user=new UserInterface(username); //user variable
	    switch(input.nextInt()){ //swtiches between pages 
	  		case -2://if user presses -2 
	  			user.itemCategories();//go to itemcategories
	  			break;//exits
	  		case 0: //if user presses 0 
	  			user.p10(); //refers to function p10
	  			break; //exits
	  		
	  		}

	}
	public static int nthIndexOf(String source, char sought, int n) { //gets source, sought and n
	    int index = source.indexOf(sought); //gets index of sought
	    if (index == -1) return -1; //checks if index ==-1 returns -1

	    for (int i = 1; i < n; i++) { //loop to find nth occurrence of a character in a string
	        index = source.indexOf(sought, index + 1); //loops through index
	        if (index == -1) return -1; //returns -1
	    }
	    return index; //returns index 
	}
	public String gettype(String type){//gets type

		return type.substring(nthIndexOf(type, ',',5)+1,type.length()); //returns 5th index of substring
	}

	public String changeCharInPosition(int position, char ch, String str){ //changes positon 
	    char[] charArray = str.toCharArray(); //string conversion 
	    charArray[position] = ch; //new position of ch 
	    return new String(charArray); //charArray is a string
	}
	
}
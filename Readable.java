/*
* Name:Shilp Pancholi, Nimalan Chandrasekara
* Description:This is the Readable class. It deals with ebook and book. It adds to the cart and buys products.
*/

import java.io.BufferedReader;//import BufferedReader
import java.io.BufferedWriter;//import BufferedWriter
import java.io.FileReader;//import FileReader
import java.io.FileWriter;//import FilerWriter
import java.io.IOException;//import IOException Handler
import java.io.StringReader;//import StringReader
import java.util.Scanner;//import Scanners

public class Readable extends Item {//readable class extends item

	//declares variables
	public String author;//author variable
	public String line;//line variable
	public String ReadableText="";//empty string
	private String EbookText="";//empty string
	private String BookText="";//empty string
	public String username;//username variable
	private boolean foundserialnumber;//foundserialnumber is a boolean
	public boolean shopping;//shopping variable is a boolean
	public Readable(){//readable class
		//this.username=username;
		
	}
	//gets price
		@Override
		public int getPrice() {
			// TODO Auto-generated method stub
			
			return price;//returns price
		}
		
	//gets info
	@Override
	public void getInfo() throws IOException {
		// TODO Auto-generated method stub
		 System.out.format("%4s%30s%20s%10s%20s%6s","S.No","Name of Book","Author","Price","Quantity in Store","Type");//shows products as a formatted string 

		eBook Ebook=new eBook();//new ebook variable
	    Ebook.getLine();//gets content from eBook file in a line
	    Book book=new Book();//new book variable
	    book.getLine();//gets content from book file in a line
	    ReadableText+=Ebook.returnEbookString()+book.returnbookString();//concatenating the two lines from book and ebook
	    EbookText=Ebook.returnEbookStringwithoutType();////returning the ebook string without knowing its type so all forms of strings can be used
	    BookText=book.returnBookStringwithoutType();//returning the book string without knowing its type so all forms of strings can be used
	    System.out.println();//prints new line
System.out.println("Choose your option:");//print this
System.out.println("Press -1 to return to previous menu.");	//print this

	}
	
	public void ReadLine(int SerialNumber) throws IOException{//serialnumber is passed as an int in Readline and might get rethrown
		
		BufferedReader reader=new BufferedReader(new StringReader(ReadableText));//new bufferedreader created
		String temp=reader.readLine();//variable to read line

if(Character.toString(temp.charAt(0)).equals(Integer.toString(SerialNumber))){//checking if serial numbers are equal
	foundserialnumber=true;//here they are
}
else{//else 
	while(Character.toString(temp.charAt(0))!=Integer.toString(SerialNumber)){//look for serial number
		temp=reader.readLine();//temp reads lines in the file
		if(temp==null){//checking to see if temp has nothing
		System.out.println("Product Not Found, Please Try Again");//prints this
			break;//exits
		}
		if(Character.toString(temp.charAt(0)).equals(Integer.toString(SerialNumber))){//looks for serial number
			foundserialnumber=true;//serial number found here
			break;//exits
		}
		
	}
}
		
		if(foundserialnumber){//runs if serial number is found
			buyReadable(temp);//temp gets passed to buyReadable
		}
	}

	public void buyReadable(String productline) throws IOException{//buying book or ebook
		
		Scanner input=new Scanner(System.in);//allows user to enter something
		System.out.println("Enter Quantity: ");//prints this
		int subtraction=input.nextInt();//subtracts quantity user chooses
		String type=gettype(productline);//gets the product
		
		String productname=productline.substring(productline.indexOf(',')+1,nthIndexOf(productline,',',2));//info of the product the user chooses
		
		//added to cart
		
		quantity=Integer.parseInt(productline.substring(nthIndexOf(productline,',',4)+1,nthIndexOf(productline,',',5)).trim());	//prints quantity of product without whitespaces
		if(quantity-subtraction>=0&&subtraction>0){//checks to see if number is greater than 0
			System.out.println("The following item has been added to the cart");//print this

			quantity=quantity-subtraction;//new quanitity updated
			shopping=false;//if less than 0 no shopping done
			}
			else{//else
			while(true){//while shopping is not done
				System.out.println("We do not have enough quantity. "); //print this

			System.out.println("Please enter another quantity: ");	//print this
			subtraction=input.nextInt();//gets quantity from user
			if(quantity-subtraction>=0){//checks if quantity is greater than 0
				quantity=quantity-subtraction;//new quantity updated

				break;//exits

			}
			}
				
			}	
		System.out.println(Integer.toString(subtraction)+" "+ productname+" "+type+"s have been added to your cart" );//tells user whats been added to cart

		String finalstring="";//empty string
		String cartstring="";//empty string
		
		productline=productline.substring(0,nthIndexOf(productline,',',5));//product line for 5th index of string
		BufferedReader br;//new bufferedreader variable

		if(type.equals("Ebook")){//if product is eBook
		 br=new BufferedReader(new StringReader(EbookText));//new bufferedreader varible for ebook
		}
		else{//else
			
			 br=new BufferedReader(new StringReader(BookText));//new bufferedreader variable for book

		}
		while(true){//while true
			String a=br.readLine();//read line from either book or ebook
		
			if(a==null){//if a has nothing
				break;//exit
			}
			if(a.equals(productline)){//if a has productline
				finalstring+=a.substring(0, nthIndexOf(a,',',4))+","+Integer.toString(quantity)+"\n";//update quantity
				cartstring+=a.substring(0, nthIndexOf(a,',',4))+","+Integer.toString(subtraction)+"\n";//update subtraction
			}
			else{//else
				finalstring+=a+"\n";//new line and increment by 1
				
			}	
		}
	
		ShoppingCart cart=new ShoppingCart(username);//new cart variable for users shopping cart
		cart.addItem(cartstring);//write to file
	    if(type.equals("Ebook")){//check if type is ebook
    
	eBook ebook=new eBook();//new ebook variable
	    	ebook.writeNewEbook(finalstring);   //ebook variable updated with finalstring 	
	  
	    }

//if book
	    if(type.equals("Book")){
	    
	    	Book book=new Book();//new book variable 
	    	book.writeNewbook(finalstring);    	//book variable updated with finalstring
	    }
	        
	    // options for customer
	    
	    System.out.println("Press -2 to continue shopping or 0 to proceed to CheckOut");//print this
		UserInterface user=new UserInterface(username);//user variable
	    switch(input.nextInt()){//switches between pages
	  		case -2://if -2
	  			user.itemCategories();//go to item categories
	  			break;//exits
	  		case 0://if 0
	  			user.p10();//refer to function p10
	  			break;//exits
	  		
	  		}
	}
	public static int nthIndexOf(String source, char sought, int n) {//gets source, sought ,n
	    int index = source.indexOf(sought);//gets index of sought
	    if (index == -1) return -1;//check if index == -1 , return -1

	    for (int i = 1; i < n; i++) {//loop to find nth occurrence of a character in a string
	        index = source.indexOf(sought, index + 1);//loop through index
	        if (index == -1) return -1;//returns -1
	    }
	    return index;//returns index
	}
	public String gettype(String type){//gets type
		return type.substring(nthIndexOf(type, ',',5)+1,type.length());//returns 5th index of substring
	}
	public String changeCharInPosition(int position, char ch, String str){//changes position
	    char[] charArray = str.toCharArray();//string conversion
	    charArray[position] = ch;//new position of ch
	    return new String(charArray);//charArray is a string
	}
	
}
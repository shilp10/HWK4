/*
* Name:Shilp Pancholi, Nimalan Chandrasekara
* Description:This is the Book class. It deals with reading and writing the Book file.
*/


import java.io.BufferedReader; //import BufferedReader
import java.io.BufferedWriter; //import BufferedWriter
import java.io.File; //import File 
import java.io.FileReader; //import FileReader 
import java.io.FileWriter;//import FileWriter
import java.io.IOException; //import IO Exception Handler
import java.io.StringReader; //import StringReader

public class Book extends Readable { //book class extends readable class
	public String username; //username is a string 
	FileWriter Bookwriter; //bookwriter variable created 
	FileReader Bookreader;//bookreader variable created

//creates file book
String BookText="";//empty string
	public Book() throws IOException{ //book class 
		this.username=username;//gets username
		try{//try
		File file=new File("Books.txt"); //new book.txt file 
		if(!file.exists()){ //checks if file doesnt exist
			this.Bookwriter=new FileWriter("Books.txt",true); //if it does write in it
			this.Bookreader=new FileReader("Books.txt"); //then read from it
			
		}
		
		}finally{//runs when try block exits 
			
		}

	
	};
	public int getPrice(){//gets Price
		return price;//returns price
	}

//reads in file

public void getLine() throws IOException{
	BufferedReader br=new BufferedReader(new FileReader("Books.txt")); //new bufferedreader for book.txt
	
	while(true){//while true
		 line=br.readLine();//read line
		 
		 if(line==null){//if nothing
				break;//exit
			}
		 System.out.println();//print new line
		 line+=",Book"; //add line with book
		 sNo=Integer.parseInt(line.substring(0,nthIndexOf(line,',',1)));
		 String book=line.substring(nthIndexOf(line,',',1)+1,nthIndexOf(line,',',2)).trim();
		 author=line.substring(nthIndexOf(line,',',2)+1,nthIndexOf(line,',',3));
		 price=Integer.parseInt(line.substring(nthIndexOf(line,',',3)+1,nthIndexOf(line,',',4)).trim());
		 quantity=Integer.parseInt(line.substring(nthIndexOf(line,',',4)+1,nthIndexOf(line,',',5)).trim());
		 String type=line.substring(nthIndexOf(line,',',5)+1,line.length());
		 System.out.format("%4d%30s%20s%10d%20d%6s",sNo,book,author,price,quantity,type);

	}
	}
//returns book file	
public String returnbookString() throws IOException{ //returnbookString class might get rethrown 
BufferedReader br=new BufferedReader(new FileReader("Books.txt")); //new bufferedreader for book.txt
	
	while(true){ //while it exists 
		 line=br.readLine();//read line from file
		 
		 if(line==null){//if nothing
				break;//exit
			} 
		 line+=",Book\n";//adds book + new line
		 this.BookText+=line;//adds line 
	}
	return this.BookText;//returns booktext 
	
}

public String returnBookStringwithoutType() throws IOException{ //returnBookStringwithoutType might get rethrown
BufferedReader br=new BufferedReader(new FileReader("Books.txt")); //new bufferedreadre for book.txt
this.BookText="";	//booktext has whitespace
while(true){//while true
		 line=br.readLine(); //reads line
		 
		 if(line==null){//if nothing
				break;//exit
			}
		 line+="\n";//add new line
		 this.BookText+=line;//add line
	}
	
	return this.BookText;//return booktext
}

//write new book file and replace old one
public void writeNewbook(String replace) throws IOException{
File file=new File("Book.txt");//creates new book.txt file	
file.delete();//deletes old one
BufferedReader reader=new BufferedReader(new StringReader(replace));//new bufferedreader for new file

FileWriter newwriter=new FileWriter("Books.txt"); //new filewriter for new file
BufferedWriter write=new BufferedWriter(newwriter);//new bufferedwriter for new file
while(true){//while true

	String a=reader.readLine();//read line from file
	if(a==null){//if nothing
		break;//exit
	}
	write.write(a); //write whatever a has
	write.newLine();//new line write
	
}
write.close();//closes filewriter 

}

}
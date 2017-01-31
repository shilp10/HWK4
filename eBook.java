/*
* Name:Shilp Pancholi, Nimalan Chandrasekara
* Description:This is the eBook class. It deals with reading and writing the ebook file.
*/

import java.io.BufferedReader;//import BufferedReader
import java.io.BufferedWriter;//import BufferedWriter 
import java.io.File;//import File
import java.io.FileNotFoundException;//import FileNotFoundException
import java.io.FileReader;//import FileReader
import java.io.FileWriter;//import FilerWriter
import java.io.IOException;//import IOException Handler
import java.io.StringReader;//import StringReader

//extends the readable class

public class eBook extends Readable { //class ebook 

	//declaring variables
	FileWriter eBookwriter; //declares ebook writier
	FileReader eBookreader; //declares ebook reader
	String EbookText=""; //declare ebooktext
	
	public int getPrice(){
		return price;
	}
	//catches IO exception and if file exists or not
	public eBook() throws IOException{ //method ebook
		//ebook text file
		try{ //try
		File file=new File("Ebooks.txt"); //new file ebook
		if(!file.exists()){ //if statement that runs when file does not exist
			System.out.print("File does not exists"); //statement to display file does not exist
			this.eBookwriter=new FileWriter("Ebooks.txt",true); //ebook for writer
			this.eBookreader=new FileReader("Ebooks.txt");//ebook for reader
			
			//this.userlist=new FileWriter("users.txt"); 
		}
		
		}finally{
			
		}
	}
//reads in information

public void getLine() throws IOException{ //getline method
	//new reader for ebook text
	BufferedReader br=new BufferedReader(new FileReader("Ebooks.txt"));
	//while loop to read in line by line
	while(true){
		 line=br.readLine(); //reads line
		 
		 if(line==null){ //if satement that runs if line is null
				break; //break
			}
		 line+=",Ebook"; //inputs into file
//		 line=line.replaceAll(",", "\t"); //replaces commas
		 System.out.println(); //next line
		 sNo=Integer.parseInt(line.substring(0,nthIndexOf(line,',',1))); //reads in line and parses it into int type
		 String book=line.substring(nthIndexOf(line,',',1)+1,nthIndexOf(line,',',2)).trim(); //reads in book
		 author=line.substring(nthIndexOf(line,',',2)+1,nthIndexOf(line,',',3)); //reads in author
		 price=Integer.parseInt(line.substring(nthIndexOf(line,',',3)+1,nthIndexOf(line,',',4)).trim()); //reads in price
		 quantity=Integer.parseInt(line.substring(nthIndexOf(line,',',4)+1,nthIndexOf(line,',',5)).trim()); //reads in quantity
		 String type=line.substring(nthIndexOf(line,',',5)+1,line.length()); //reads in type
		 System.out.format("%4d%30s%20s%10d%20d%6s",sNo,book,author,price,quantity,type); //formatting display
 
	}
	}
//returns ebook
public String returnEbookString() throws IOException{ //method to return
//reader to return ebook file
BufferedReader br=new BufferedReader(new FileReader("Ebooks.txt"));
this.EbookText="";	
//while loop that reads in line by line and displays the file
while(true){
		 line=br.readLine(); //reads in line
		 
		 if(line==null){ //if statement that runs if line is null
				break;
			}
		 line+=",Ebook\n";
		 this.EbookText+=line; //adds it to the file
		
	}
	//return the file
	return this.EbookText;
	
}
//returns file without type
public String returnEbookStringwithoutType() throws IOException{ //method for return
//reader to return ebook file
BufferedReader br=new BufferedReader(new FileReader("Ebooks.txt"));
this.EbookText="";	
//while loop that reads in line by line and then returns file
while(true){
		 line=br.readLine(); //reads in line
		 
		 if(line==null){ //runs if line is null
				break;
			}
		 line+="\n"; 
		 this.EbookText+=line; //puts it to the file
		
	}
	//returns file
	return this.EbookText;	
}
//tracker 
public static int nthIndexOf(String source, char sought, int n) { //method for index
//initiating index variable
    int index = source.indexOf(sought); //declare and initiate variable
    if (index == -1) return -1; //if statement that runs if index is equal to -1
    //for loop to keep track
    for (int i = 1; i < n; i++) {
        index = source.indexOf(sought, index + 1); //puts it into variable index
        if (index == -1) return -1; //if variable index is -1, returns -1
    }
    //returns variable index
    return index;
}

//write new ebook

public void writeNewEbook(String replace) throws IOException{ //method that writes new ebook file
//creates new file ebook
File file=new File("Ebook.txt");	
//deletes old file
file.delete();
//buffer to replace lines
BufferedReader reader=new BufferedReader(new StringReader(replace));
//filewriter for ebook
FileWriter newwriter=new FileWriter("Ebooks.txt");
BufferedWriter write=new BufferedWriter(newwriter);
//replace=replace.format("%n");
//while loop to read in line and write new lines
while(true){

	String a=reader.readLine(); //reads in file
	if(a==null){ //if statement that runs if a is null
		break;
	}
	write.write(a); 
	write.newLine(); //writes new line
	
}
//closes it 
write.close();

}
	
}
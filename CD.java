/*
* Name:Shilp Pancholi, Nimalan Chandrasekara
* Description:This is the CD class. It deals with reading and writing to the CD file.
*/


import java.io.BufferedReader;//import BufferedReader
import java.io.BufferedWriter;//import BufferedWriter 
import java.io.File;//import File
import java.io.FileNotFoundException;//import FileNotFoundException
import java.io.FileReader;//import FileReader
import java.io.FileWriter;//import FilerWriter
import java.io.IOException;//import IOException Handler
import java.io.StringReader;//import StringReader

public class CD extends Audio {//cd class extends audio class 
	public String username;//username is a string
	FileWriter eBookwriter;//eBookwriter variable
	FileReader eBookreader;//eBookreader variable
	String CDText="";//empty string
	
	public int getPrice(){//gets price
		return price;//returns price
	}

//checks IO Exception and checks if file exits or not
	public CD() throws IOException{
		this.username=username;//gets username
		try{//try
		File file=new File("CDs.txt");//new cd.txt file
		if(!file.exists()){//if file does not exist
			System.out.print("File does not exists");//print this
			this.eBookwriter=new FileWriter("CDs.txt",true); //if file does write to it
			this.eBookreader=new FileReader("CDs.txt");//then read from it
			
			//this.userlist=new FileWriter("users.txt");
		}
		
		}finally{//runs after try block exits
			
		}

	
	};

//reads in line from file
public void getLine() throws IOException{//getLine might get rethrown
	BufferedReader br=new BufferedReader(new FileReader("CDs.txt"));//new bufferedreader for cd
	
	while(true){ //while true
		 line=br.readLine();//read line
		 
		 if(line==null){//if nothing
				break;//exit
			}
		 line+=",CD";//adds CD
		 System.out.println();//prints new line
		 sNo=Integer.parseInt(line.substring(0,nthIndexOf(line,',',1)));
		 String book=line.substring(nthIndexOf(line,',',1)+1,nthIndexOf(line,',',2)).trim();
		 artist=line.substring(nthIndexOf(line,',',2)+1,nthIndexOf(line,',',3));
		 price=Integer.parseInt(line.substring(nthIndexOf(line,',',3)+1,nthIndexOf(line,',',4)).trim());
		 quantity=Integer.parseInt(line.substring(nthIndexOf(line,',',4)+1,nthIndexOf(line,',',5)).trim());
		 String type=line.substring(nthIndexOf(line,',',5)+1,line.length());
		 System.out.format("%4d%30s%20s%10d%20d%6s",sNo,book,artist,price,quantity,type);
		 		
	}
	}

//returns cd file
public String returnCDString() throws IOException{//returnCDString might get rethrown
BufferedReader br=new BufferedReader(new FileReader("CDs.txt"));//new bufferedreader for cd.txt
this.CDText="";	//adds white space
while(true){//white true
		 line=br.readLine();//reads line
		 
		 if(line==null){//if nothing
				break;//exit
			}
		 line+=",CDs\n";//ads new line with cd
		 this.CDText+=line;//new line
		
	}
	
	return this.CDText;//returns CDText
	
}

public String returnCDStringwithoutType() throws IOException{//returnCDStringwithoutType might get rethrown
BufferedReader br=new BufferedReader(new FileReader("CDs.txt"));//new bufferedreader for cd.txt
this.CDText="";	//adds whitespace
while(true){//while true
		 line=br.readLine();//read line
		 
		 if(line==null){//if nothing
				break;//exit
			}
		 line+="\n";//new line
		 this.CDText+=line;//new line in CDText
		
	}
	
	return this.CDText;//returns CDText
	
}

//writes new cd file and replaces old one
public void writeNewCD(String replace) throws IOException{
File file=new File("CD.txt");	//new cd.txt file
file.delete();//deletes old file
BufferedReader reader=new BufferedReader(new StringReader(replace));//new bufferedreader for new file

FileWriter newwriter=new FileWriter("CDs.txt");//newwriter for cd.txt
BufferedWriter write=new BufferedWriter(newwriter);//write has newwriter passed through it
//replace=replace.format("%n");
while(true){//while true

	String a=reader.readLine();//variable a reads line
	if(a==null){//if nothing
		break;//exits
	}
	write.write(a);//writes whatever a has
	write.newLine();//writes newLine
	
}
write.close();//closes FileWriter

}
	
}
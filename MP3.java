/*
* Name:Shilp Pancholi, Nimalan Chandrasekara
* Description:This is the MP3 class. It reals from the MP3 file.
*/


import java.io.BufferedReader;//import BufferedReader
import java.io.BufferedWriter;//import BufferedWriter 
import java.io.File;//import File
import java.io.FileNotFoundException;//import FileNotFoundException
import java.io.FileReader;//import FileReader
import java.io.FileWriter;//import FilerWriter
import java.io.IOException;//import IOException Handler
import java.io.StringReader;//import StringReader

//mp3 extends class audio

public class MP3 extends Audio {//mp3 class
	public String username;//variable username
	FileWriter eBookwriter;//varibale eBookWriter
	FileReader eBookreader;//variable eBookreader
	String MP3Text="";//empty string
	
	public int getPrice(){//gets price
		return price;//returns price
	}

//catches IO exception and if file exists
	public MP3() throws IOException{//MP3 might get rethrown
		this.username=username;//get username
		try{//try
		File file=new File("MP3.txt");//new mp3.txt file 
		if(!file.exists()){//check if file does not exist
			System.out.print("File does not exists");//print this
			this.eBookwriter=new FileWriter("MP3.txt",true);//if file does exist
			this.eBookreader=new FileReader("MP3.txt");//then read from it
			
			//this.userlist=new FileWriter("users.txt");
		}
		
		}finally{//runs after try block exits
			
		}

	
	};

//read in line from file

public void getLine() throws IOException{//getLine might get rethrown
	BufferedReader br=new BufferedReader(new FileReader("MP3.txt"));//new buffered reader for mp3.txt
	
	while(true){//while true
		 line=br.readLine();//read line
		 
		 if(line==null){//if nothing
				break;//exits
			}
		 line+=",MP3";//add line with MP3
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

public String returnMP3String() throws IOException{//returnMP3String might get rethrown
BufferedReader br=new BufferedReader(new FileReader("MP3.txt"));//new bufferedreader for mp3.txt
this.MP3Text="";	//adds whitespace
while(true){//while true
		 line=br.readLine();//reads line
		 
		 if(line==null){//if nothing
				break;//exits
			}
		 line+=",MP3\n";//adds new line
		 this.MP3Text+=line;//adds line
		
	}
	
	return this.MP3Text;//returns mp3text
	
}



public String returnMP3StringwithoutType() throws IOException{//returnmp3stringwithouttype might get rethrown
BufferedReader br=new BufferedReader(new FileReader("MP3.txt"));//new bufferedreader for mp3.txt
this.MP3Text="";	//adds whtiespace
while(true){//while true
		 line=br.readLine();//reads line 
		 
		 if(line==null){//if nothing
				break;//exits 
			}
		 line+="\n";//add new line
		 this.MP3Text+=line;//add line
		
	}
	
	return this.MP3Text; //returns mp3text
	
}

//writes new mp3 file and replaces old one

public void writeNewMP3(String replace) throws IOException{
File file=new File("MP3.txt");	//new mp3.txt file
file.delete();//deletes old file
BufferedReader reader=new BufferedReader(new StringReader(replace));//new bufferedreader for new file

FileWriter newwriter=new FileWriter("MP3.txt");//new filewriter for mp3.txt
BufferedWriter write=new BufferedWriter(newwriter);//write has newwriter passed through it
//replace=replace.format("%n");
while(true){//while true

	String a=reader.readLine();//varibale a reads line
	if(a==null){//if nothing
		break;//exits 
	}
	write.write(a);//writes whatever a has
	write.newLine();//writes new line
	
}
write.close();//closes filewriter 
}
	
}
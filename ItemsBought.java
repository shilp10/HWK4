/*
* Name:Shilp Pancholi, Nimalan Chandrasekara
* Description:This is the Items brought class. It adds to the file, and keeps track of what has been bought.
*/

import java.io.BufferedReader;//import BufferedReader
import java.io.BufferedWriter;//import BufferedWriter
import java.io.File;//import File
import java.io.FileNotFoundException;//importFileNotFoundException
import java.io.FileReader;//import FileReader
import java.io.FileWriter;//import FileWriter
import java.io.IOException;//import IOException Handler

public class ItemsBought {//itemsbought class 
	FileWriter itemWriter;//new variable itemWriter
	FileReader itemReader;//new variable itemReader
	String stuff;//stuff is a string
	public ItemsBought() throws IOException{//itemsbought might get rethrown
		try{//try
			File file=new File("ItemsBought.txt");//new file itemsbought.txt created
			if(!file.exists()){//if file does not exist
				System.out.print("File does not exists");//prints this
				this.itemWriter=new FileWriter("ItemsBought.txt",true);//if itemsbought.txt exists write from it
				this.itemReader=new FileReader("ItemsBought.txt");//reads from itemsbought.txt

			}
			
			}finally{//runs after try block exits
				
			}
		
	}
	
	public void setStuff(String write){//setStuff has write passed through it
		this.stuff=write;//writes 
		
	}
	
	
	public String getConfirmationId() throws IOException{
		String confirmationid;//confirmationid is a string 
		BufferedReader br=new BufferedReader(new FileReader("ItemsBought.txt"));
		int id=0;
String a;		
String b = null;
		while(true){
a=br.readLine();//readline
if(a==null){//if a is null
				break;//break
			}
id+=1;	//increment id	
		
		}
		
		
		
		
		 confirmationid="00";//finds the id 
		 confirmationid=confirmationid+Integer.toString(id);//updates the id
		
		

	return confirmationid;//returns confirmationid
	
	}
	
	
	public void writeItems(String a) throws IOException{//writeItems has a passed through it as a string and might get rethrown 
		BufferedWriter bw=new BufferedWriter(new FileWriter("ItemsBought.txt",true));//new bufferedreader for itemsbought.txt
		
		bw.write(a);//writes to itemsbought.txt
		bw.newLine();//adds new line to itemsbought.txt
		bw.close();//closes buffered writer
		
		
		
	}
	public void getItems() throws IOException{//getItems might get rethrown
		BufferedReader br=new BufferedReader(new FileReader("ItemsBought.txt"));//new bufferedreader for itemsbought.txt
		while(true){//while true
			String line=br.readLine();//reads line
			if(line==null){//if line has nothing
				break;//exits
			}
			System.out.println(line); //prints line		
		}
			
	}
}
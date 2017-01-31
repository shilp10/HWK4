/*
* Name:Shilp Pancholi, Nimalan Chandrasekara
* Description:This is the user. It deals with creation and retrieval of users.
*/



import java.io.*; //import input output 

public class User{ //user class
	 String username; //making username a string
	FileWriter userlistwriter; //Assigning a name for filewriter
	FileReader userlistreader; //Assigning a name for filereader 
	public User(String username) throws IOException{
		this.username=username; //pointing back to username
		try{ //try statement for file reading
		File file=new File("Users.txt"); //creating file user.txt
		if(!file.exists()){ //checking to see if file exists 
			System.out.print("File does not exists"); //if it doesnt print this
			this.userlistwriter=new FileWriter("Users.txt",true); //if it does write in it
			this.userlistreader=new FileReader("Users.txt"); //once written read from the file
			
		}
		
		}finally{ //runs when try block exits 
			

		}

	
	};
	
	public boolean checkUserName() throws IOException{ //checking for username as true or false
		BufferedReader br=new BufferedReader(new FileReader("Users.txt")); //creating a bufferedreader to read from user.txt
		
		while(true){ //if true 

			String line=br.readLine(); //read lines in file
			if(line==null){ //checking to see if theres anything in the file
				return false; //if nothing it moves onto the next if statement 
			}
			if(line.equals(this.username)){ //checking to see if usernames for login are the same
				return true; //if they are its true;user logs in
			}
		}
		
		
	}
	
	public void addUserName() throws IOException{ //adding a new user
		BufferedReader br=new BufferedReader(new FileReader("Users.txt")); //user.txt file is created for a new user
		BufferedWriter bw=new BufferedWriter(new FileWriter("Users.txt",true)); // checking to see if file has been created

		while(true){ //once the file is written 
			String line=br.readLine(); //read from it 
			if(line==null){// checking to see if anything in file 
				bw.newLine(); //when empty start to write 
				bw.write(username);//write in username
				bw.close();//close file
				System.out.println("Username written"); //creating the user with confirmation 
				break; //exits 
			}
			if(line.equals(username)){ //checking to see if username exists already
				System.out.println("Username already exists"); //prints username exists to inform user to make a new one
				break;//exits 
				
			}		
		}		
	};
}

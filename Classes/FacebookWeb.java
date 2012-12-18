/** Defines an individual user's web of Facebook connections
 * @author Margaret-Ann Seger
 1 December 2012
 CS230 Final Project
 */

 import java.util.*;
 import java.io.*;
 import java.net.*;

public class FacebookWeb{

 	// instance variables
 	private HashMap<Integer, LinkedList<Connection>> myWeb; 

 	public FacebookWeb(){
 		this.myWeb = new HashMap<Integer, LinkedList<Connection>>(); // hashmap from the "level" of connection eg. "level 0" 															 // to the list of Connections at this level
 	}

    public HashMap<Integer, LinkedList<Connection>> getMyWeb(){
        return myWeb;
    }


    public HashMap<Integer, LinkedList<Connection>> populateWeb(){
        // populates the FB Web by filling immediate and extended webs
        fillImmediateWeb();
        fillExtendedWeb();
        return myWeb;
    }

 	public LinkedList<Connection> fillImmediateWeb(){
         // fills the "Oth" level of your FacebookWeb, ie. a LinkedList of all your immediate FB friends

         // parse the JSON objects in my immediate friends list into a list of Connections
         FBJSONOutputParser fbParser = new FBJSONOutputParser("outputFriends.txt");
         LinkedList<Connection> myImmediateFriends = fbParser.parseFBfriendList();

         // set this list of Connections to the "O" level in the HashMap
         myWeb.put(0, myImmediateFriends);
         return myImmediateFriends;
 	}


    public void fillExtendedWeb(){
        // gets two of my FB friends Peter and Filip's friend lists, any connections that we don't have in common
        // are divided up between the first and second tiers of my FB web (for demo purposes)

        // Peter's friends, going in at index 1 in my FB WEB
        FBJSONOutputParser friend1Parser = new FBJSONOutputParser("PeterFriends.txt");
        LinkedList<Connection> peterFriends = friend1Parser.parseFBfriendList();
        myWeb.put(1, peterFriends);

        // Filip's friends, going in at index 2 in my FB WEB
        FBJSONOutputParser friend2Parser = new FBJSONOutputParser("FilipFriends.txt");
        LinkedList<Connection> filipFriends = friend2Parser.parseFBfriendList();
        myWeb.put(2, filipFriends);
    }

    public static LinkedList<Connection> fillInputNameWeb(String name){
        if(name.equals("Peter")){
            // Peter's friends, going in at index 1 in my FB WEB
            FBJSONOutputParser peterParser = new FBJSONOutputParser("PeterFriends.txt");
            LinkedList<Connection> peterFriends = peterParser.parseFBfriendList();
            return peterFriends;
        }else{
            // Filip's friends, going in at index 2 in my FB WEB
            FBJSONOutputParser filipParser = new FBJSONOutputParser("FilipFriends.txt");
            LinkedList<Connection> filipFriends = filipParser.parseFBfriendList();
            return filipFriends;
        }
    }

    // this is the original method I used to grab my friends list & store in a text file for later use
    // this is now a deprecated method because my FB Auth token is only temporary and unique to each user
 	public void runFriendListScrape(String friendListLocation, String writeToLocation) throws Exception{
 		// goes to Facebook URL, scrapes the JSON associated with all friend objects for a given user
 		// and converts them to Connection objects
 		try{
	 		URL urlEndpt = new URL(friendListLocation);
	 		BufferedReader in = new BufferedReader(new InputStreamReader(urlEndpt.openStream()));
	 		
	 		File writeFile = new File(writeToLocation);
	 		// if the file doesn't exist, create it
	 		if(!writeFile.exists()){
	 			writeFile.createNewFile();
	 		}
	 		FileWriter fw = new FileWriter(writeFile.getAbsoluteFile());
	 		BufferedWriter bw = new BufferedWriter(fw);

	 		String line; 
	 		while((line = in.readLine())!= null){
	 			System.out.println(line); // check
	 			bw.write(line);
	 		}
	 		in.close();
	 		bw.close();

	 		}catch(IOException e){
	 			e.printStackTrace();
	 		}
	 	}

    // taking the scraped info from the output text file, analyzing, and inputting into my Facebook web


 	public static void main(String[] args){
 		FacebookWeb fbWeb = new FacebookWeb();
         fbWeb.fillImmediateWeb();

        // get temp data for experimental purposes --> I chose to grab my data, write to a text file, re-use for demo (as token expires)
        // I ran this for myself and two FB friends
        /*fbWeb.populateWeb(new User("Filip Kaliszan", "filip.kaliszan"), 1);
 		String tempFriendsAccessPt = "https://graph.facebook.com/213843/friends?access_token=AAAAAAITEghMBAPDPNVjOXzZBemqDiIFeGbXaUCwhIFgKPk1a1myx2LGpVw0bJ4F7F8zZB6h0nuJNJSFgHzWxpo6k3VzCXJrN0DdEZBMIXsDcKYlGcaC";
 		String writeToLocation = "FilipFriends.txt";
 		try{
 			fbWeb.runFriendListScrape(tempFriendsAccessPt, writeToLocation);
 		}catch(Exception ex){
 			System.out.println("Failure due to: " + ex);
 		} */
 	}
 }
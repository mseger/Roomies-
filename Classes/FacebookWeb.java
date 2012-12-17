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
 		this.myWeb = new HashMap<Integer, LinkedList<Connection>>(); // hashmap from the "level" of connection eg. "level 0" 
 																	 // to the list of Connections at this level
 	}

 	// getters and setters
 	public HashMap<Integer, LinkedList<Connection>> getWeb(){
 		return myWeb;
 	}

 	public void setWeb(HashMap<Integer, LinkedList<Connection>> newWeb){
 		myWeb = newWeb;
 	}

 	public HashMap<Integer, LinkedList<Connection>> populateWeb(User seed, int numLevels){
 		// populates the seed's FacebookWeb, by pulling/ crawling out a specified 
 		// number of "degrees" (represented by numLevels) outward from the seed
 		return new HashMap<Integer, LinkedList<Connection>>(); 
 	}

 	public LinkedList<Connection> runFriendListScrape(String friendListLocation, String writeToLocation) throws Exception{
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

	 		return new LinkedList<Connection>();
	 		}catch(IOException e){
	 			e.printStackTrace();
	 		}
	 		return new LinkedList<Connection>();
	 	}

	public Connection parseRawFriendInput(String line){
		// parses each line of the raw JSON output from scraping Facebook and creates
		// a new Connection for each raw friend, populates relevant fields

		// intend to use a downloaded JSON parsing lib here, so as not to reinvent the wheel 
		String[] elements = new String[5];
		for(String element : line.split("[\\s,;]+")){
			System.out.println(element);
		}

		return new Connection("", "");
	}

 	public static void main(String[] args){
 		FacebookWeb fbWeb = new FacebookWeb();
 		fbWeb.populateWeb(new User("Margaret-Ann Seger", "margaretann.seger"), 1);

 		// get temp data for experimental purposes
 		String tempFriendsAccessPt = "https://graph.facebook.com/me/friends?access_token=AAAAAAITEghMBAO2mvbNeqDIRV1krzt0WDMfOhZBsuQXXapgjndobfPIfqeQ4RZCnOTZCepZAx9auLEkFcKe9F00nJmVDZAncvVAOGXq6wHM0a919rSmuL";
 		String writeToLocation = "/home/mseger/Documents/DataStructures/FinalProject/Classes/outputFriends.txt";
 		try{
 			fbWeb.runFriendListScrape(tempFriendsAccessPt, writeToLocation);
 		}catch(Exception ex){
 			System.out.println("Failure due to: " + ex);
 		}
 		//parseRawFriendInput("{"name":"Filip Kaliszan","id":"213843"}");
 	}
 }
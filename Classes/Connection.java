/** Defines a Facebook Connection object of a user in the Roommate Match system
 * @author Margaret-Ann Seger
 1 December 2012
 CS230 Final Project
 */

 import java.util.*;
 import java.io.*;
 import java.net.*;

 public class Connection{

 	// instance variables
 	private String name;
 	private String userID;
 	private String profPicURL;
 	private HashMap<String, String> criteria; 
 	private FacebookWeb fbWeb;
 	private Stack<String> pathToUser;

 	public Connection(String name, String userID){
 		this.name = name; // user's name (for display purposes)
 		this.userID = userID; // user's Facebook ID, for searching and storage purposes
 		this.profPicURL = "https://graph.facebook.com/" + name + "/picture"; // URL for public profpic icon	
 		this.criteria = new HashMap<String, String>(); // this Connection's criteria, for matching purposes
 		this.fbWeb = new FacebookWeb(); // will replace this with "getFacebookWeb()" method
 		this.pathToUser = new Stack<String>(); // path from the original user to this connection
 	}

 	// getters and setters
 	public String getName(){
 		return name;
 	}

 	public String getUID(){
 		return userID;
 	}

 	public String getProfPicURL(){
 		return profPicURL;
 	}

 	public void setProfPicURL(String newProfPicURL){
 		profPicURL = newProfPicURL;
 	}

 	public HashMap<String, String> getCriteria(){
 		return criteria;
 	}

 	public void setCriteria(HashMap<String, String> newCriteria){
 		criteria = newCriteria;
 	}

 	public FacebookWeb getFBWeb(){
 		return fbWeb;
 	}

 	public void setFBWeb(FacebookWeb newFBWeb){
 		fbWeb = newFBWeb;
 	}

 	public Stack<String> getPathToUser(){
 		return pathToUser;
 	} 
 }
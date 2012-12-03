/** Defines a user of the Roommate Match system
 * @author Margaret-Ann Seger
 1 December 2012
 CS230 Final Project
 */

 import java.util.*;
 import java.io.*;
 import java.net.*;

 public class User{

 	// instance variables
 	private String name;
 	private String userID;
 	private HashMap<String, String> criteria;
 	private FacebookWeb fbWeb;
 	private MatchList matches; 

 	public User(String name, String userID){
 		this.name = name;
 		this.userID = userID;
 		this.criteria = new HashMap<String, String>();
 		this.fbWeb = new FacebookWeb(); // will replace this with "getFacebookWeb()" method
 		this.matches = new MatchList();
 	}

 	// getters and setters
 	public String getName(){
 		return name;
 	}

 	public String getUID(){
 		return userID;
 	}

 	public HashMap<String, String> getCriteria(){
 		return criteria;
 	}

 	public void setCriteria(HashMap<String, String> inputCriteria){
 		criteria = inputCriteria;
 	}

 	public FacebookWeb getFBWeb(){
 		return fbWeb;
 	}

 	public void setFBWeb(FacebookWeb newFBWeb){
 		fbWeb = newFBWeb;
 	}

 	public MatchList getMatches(){
 		return matches;
 	}

 	public void setMatches(MatchList newMatchList){
 		matches = newMatchList;
 	}

 }
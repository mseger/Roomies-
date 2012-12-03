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
 	private String name;
 	private String userID;
 	private Hashmap<String, String> criteria;
 	private FacebookWeb fbWeb;
 	private MatchList matches; 

 	public User(String name, String userID){
 		this.name = name;
 		this.userID = userID;
 		this.criteria = new Hashmap<String, String>();
 		this.fbWeb = new FacebookWeb(); // will replace this with "getFacebookWeb()" method
 		this.matches = new MatchList();
 	}

 	// getters and setters
 	public String getName(){
 		return name;
 	}

 	public void setName(String newName){
 		name = newName;
 	}

 	public String getUID(){
 		return userID;
 	}

 	public void setUID(String newUID){
 		userID = newUID;
 	}

 	public Hashmap<String, String> getCriteria(){
 		return criteria;
 	}

 	public void setCriteria(Hashmap<String, String> inputCriteria){
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
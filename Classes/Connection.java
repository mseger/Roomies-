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
 	private URL profPicURL;
 	private Hashmap<String, String> criteria; 
 	private FacebookWeb fbWeb;
 	private Stack<String> pathToUser;

 	public Connection(String name, String userID){
 		this.name = name;
 		this.userID = userID;
 		this.profPicURL = new URL("https://graph.facebook.com/" + name + "/picture"); 		
 		this.criteria = new Hashmap<String, String>();
 		this.fbWeb = new FacebookWeb(); // will replace this with "getFacebookWeb()" method
 		this.pathToUser = new Stack<String>();
 	}

 	// getters and setters
 	public String getName(){
 		return name;
 	}

 	public String getUID(){
 		return userID;
 	}

 	public URL getProfPicURL(){
 		return profPicURL;
 	}

 	public void setProfPicURL(URL newProfPicURL){
 		profPicURL = newProfPicURL;
 	}

 	public Hashmap<String, String> getCriteria(){
 		return criteria;
 	}

 	public void setCriteria(Hashmap<String, String> newCriteria){
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

 	public String pathToUser_pop(){
 		return pathToUser.pop();
 	}

 	public void pathToUser_push(String toAdd){
 		pathToUser.push(toAdd);
 	}

 }
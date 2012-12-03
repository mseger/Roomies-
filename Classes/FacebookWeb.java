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
 		this.myWeb = new HashMap<Integer, LinkedList<Connection>>();
 	}

 	// getters and setters
 	public HashMap<Integer, LinkedList<Connection>> getWeb(){
 		return myWeb;
 	}

 	public void setWeb(HashMap<Integer, LinkedList<Connection>> newWeb){
 		myWeb = newWeb;
 	}

 	public HashMap<Integer, LinkedList<Connection>> populateWeb(int numLevels){
 		// populates the seed's FacebookWeb, by pulling/ crawling out a specified 
 		// number of "degrees" (represented by numLevels) outward from the seed
 		return new HashMap<Integer, LinkedList<Connection>>(); 
 	}

 }
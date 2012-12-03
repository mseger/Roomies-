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
 	private User seed;
 	private Hashmap<Integer, LinkedList<Connection>> myWeb; 

 	public FacebookWeb(User seed){
 		this.seed = seed;
 		this.criteria = new Hashmap<Integer, LinkedList<Connection>>();
 	}

 	// getters and setters
 	public User getSeed(){
 		return seed;
 	}

 	public Hashmap<Integer, LinkedList<Connection>> getWeb(){
 		return myWeb;
 	}

 	public void setWeb(Hashmap<Integer, LinkedList<Connection>> newWeb){
 		myWeb = newWeb;
 	}

 	public Hashmap<Integer, LinkedList<Connection>> populateWeb(int numLevels){
 		// populates the seed's FacebookWeb, by pulling/ crawling out a specified 
 		// number of "degrees" (represented by numLevels) outward from the seed
 		return new Hashmap<Integer, LinkedList<Connection>>(); 
 	}

 }
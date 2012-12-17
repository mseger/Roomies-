/** Defines the output best matches of a user in Roommate Match
 * @author Margaret-Ann Seger
 1 December 2012
 CS230 Final Project
 */

 import java.util.*;
 import java.io.*;
 import java.net.*;

 public class MatchList{

 	// instance variables
 	private User seed;
 	private LinkedList<Connection> matchList; 
 	private FacebookWeb fbWeb;

 	public MatchList(User seed, FacebookWeb fbWeb){
 		this.seed = seed; // User we are evaluating all potential candidates against
 		this.matchList = new LinkedList<Connection>(); // list of best-fit matches for the seed User
 		this.fbWeb = fbWeb; // this user's Facebook web, which will be used to crawl over and generate best matches
 	}

 	// getters and setters
 	public User getSeed(){
 		return seed;
 	}

 	public LinkedList<Connection> getMatchList(){
 		return matchList;
 	}

 	public void setMatchList(LinkedList<Connection> newMatchList){
 		matchList = newMatchList;
 	}

 	public LinkedList<Connection> populateMatchList(){
 		// uses the incoming seed and FacebookWeb to distill the seed's top matches, 
 		// then uses these matches to populate and return the matchList
 		return new LinkedList<Connection>();
 	}

 	public boolean goodMatch(User seed, Connection inQuestion){
 		// helper function to populateMatchList to determine if a given Connection should
 		// or should not be added to the seed User's matchList
 		return true;
 	}

 }
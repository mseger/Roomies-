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
 		this.seed = seed;
 		this.matchList = new LinkedList<Connection>();
 		this.fbWeb = fbWeb;
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

 }
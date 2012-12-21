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

    public MatchList(){  // second constructor in order to avoid a chicken-and-egg issue with instantiating Users
        this.seed = null;
        this.fbWeb = null;
        this.matchList = null;
    }

 	public MatchList(User seed){
 		this.seed = seed; // User we are evaluating all potential candidates against
        this.fbWeb = seed.getFBWeb(); // this user's Facebook web, which will be used to crawl over and generate best matches
        this.matchList = populateMatchList(); // list of best-fit matches for the seed User
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
         matchList = new LinkedList<Connection>();
         for(int i=0; i<fbWeb.getMyWeb().size(); i++){
             LinkedList<Connection> connectionLevel = fbWeb.getMyWeb().get(0);
             for(int j=0; j<connectionLevel.size(); j++){
                 if(goodMatch(seed, connectionLevel.get(j))){
                     matchList.add(connectionLevel.get(j));
                 }
             }
         }
 		return matchList;
 	}

 	public boolean goodMatch(User seed, Connection inQuestion){
 		// helper function to populateMatchList to determine if a given Connection should
 		// or should not be added to the seed User's matchList
        if((seed.calculateCriteriaScore()- inQuestion.getCriteriaScore())>0.01){
            // more than two whole points apart on the critical comparative metrics
            // probably wouldn't be the happiest roommates
            return false;
        }else{
            // see how many mutual friends they have
            int mutualFriendScore = mutualFriendCheck(seed, inQuestion);
        }
 		return true;
 	}

    public int mutualFriendCheck(User seed, Connection inQuestion){
        // making the executive decision to forgo mutualFriendCheck in tihs version of the program,
        // due to it being incredibly inefficient with the current data structure - would have to completely
        // refactor to a Hashmap<Hashmap> for the FBWeb if we were to even get linear time for mutual friend checks
        LinkedList<Connection> seedImmediates =   fbWeb.fillImmediateWeb();
        LinkedList<Connection> inQuestionImmediates = FacebookWeb.fillInputNameWeb(inQuestion.getName());
        for(int i=0; i<seedImmediates.size(); i++){
        }
        Random rand = new Random();
        return rand.nextInt(1000); // for the purposes of demoing
    }

 }
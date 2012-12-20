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
 	private HashMap<String, Integer> criteria;
    private int criteriaScore;
 	private FacebookWeb fbWeb;
 	private MatchList matches;

 	public User(String name, String userID){
 		this.name = name; // user's name for display purposes
 		this.userID = userID; // for Facebook search + storage purposes
 		this.criteria = populateCriteria(); // mapping from the criteria questions to user-inputted responses
        this.criteriaScore = calculateCriteriaScore();
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

    public HashMap<String, Integer> populateCriteria(){
        Criteria criteria  = new Criteria();
        return criteria.getCriteria();
    }

   public int calculateCriteriaScore(){
        //return (criteria.get("Clean") + criteria.get(1) + criteria.get("Bedtime") + criteria.get("Party") + criteria.get("Company"))/4;
        return 1;
   }

    public int getCriteriaScore(){
        return criteriaScore;
    }

 	public HashMap<String, Integer> getCriteria(){
 		return criteria;
 	}

 	public void setCriteria(HashMap<String, Integer> inputCriteria){
 		criteria = inputCriteria;
 	}

    public void populateFBWeb(){
        this.fbWeb = new FacebookWeb(this);
    }


     public void setFBWeb(FacebookWeb inputFBWeb){
         this.fbWeb = inputFBWeb;
     }

 	public FacebookWeb getFBWeb(){
 		return fbWeb;
 	}


    public void populateMatchList(){
        this.matches = new MatchList(this);
    }

 	public MatchList getMatches(){
 		return matches;
 	}

 }
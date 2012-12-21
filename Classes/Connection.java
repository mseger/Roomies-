/** Defines a Facebook Connection object of a user in the Roommate Match system
 * @author Margaret-Ann Seger
 1 December 2012
 CS230 Final Project
 */

 import java.security.PrivateKey;
 import java.util.*;

 public class Connection{

 	// instance variables
 	private String name;
 	private String userID;
 	private String profPicURL;
 	private HashMap<String, Integer> criteria;
    private double criteriaScore;
 	private LinkedList<Connection> immediateConnections;
 	private Stack<String> pathToUser;

 	public Connection(String name, String userID){
 		this.name = name; // user's name (for display purposes)
 		this.userID = userID; // user's Facebook ID, for searching and storage purposes
 		this.profPicURL = "https://graph.facebook.com/" + userID + "/picture"; // URL for public profpic icon
 		this.criteria = new HashMap<String, Integer>(); // this Connection's criteria, for matching purposes
        this.criteriaScore = generateNewRandomCriteriaScore();
        this.immediateConnections = new LinkedList<Connection>(); // FacebookWeb.fillInputNameWeb(name);
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

 	public HashMap<String, Integer> getCriteria(){
 		return criteria;
 	}

 	public void setCriteria(HashMap<String, Integer> newCriteria){
 		criteria = newCriteria;
 	}

    public double generateNewRandomCriteriaScore(){
        // generates a new, random set of "responses" to the criteria questions, then combines them
        // into one coherent criteria score
        Random r = new Random();
        int cleanScore = r.nextInt(3);
        int bedScore = r.nextInt(4);
        int partyScore = r.nextInt(2);
        int companyScore = r.nextInt(5);

        double avg = (cleanScore + bedScore + partyScore + companyScore)/4.0;
        return avg;
    }

     public double getCriteriaScore(){
         return criteriaScore;
     }

     public LinkedList<Connection> getImmediateConnections(){
         return immediateConnections;
     }

 	public Stack<String> getPathToUser(){
 		return pathToUser;
 	} 
 }
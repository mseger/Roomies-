import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: mseger
 * Date: 12/17/12
 * Time: 1:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){
        // going to initialize + test all aspects of a user

        /* --------------------------------------------------------- USER = ME ----------------------------------------------------------*/
        // user has: name, User ID, criteria
        String name = "Margaret-Ann";
        String userID = "margaretann.seger";
        HashMap<String, Integer> criteria;
        FacebookWeb fbWeb;
        MatchList matches;

        // populate the criteria
        Criteria criteriaGetter = new Criteria();
        criteriaGetter.grabUserInfo();

        criteria = criteriaGetter.getCriteria();

        // populate the FBWeb
        fbWeb = new FacebookWeb();
        fbWeb.fillImmediateWeb();
        System.out.println("MADE IT TO THIS PT!!!");

        // test that we're indeed filling the Facebook Web
        LinkedList<Connection> myConnections = fbWeb.getMyWeb().get(0);
        for(int i=0; i<myConnections.size(); i++){
            System.out.println("Connection: " + myConnections.get(i).getName() + ", " + myConnections.get(i).getUID());
        }

        // my MatchList!
        User MA = new User(name, userID);
        MA.setCriteria(criteria);
        FacebookWeb MAFbWeb = new FacebookWeb(MA);
        MA.setFBWeb(MAFbWeb);
        matches = new MatchList(MA);
        LinkedList<Connection> matchList = matches.getMatchList();
        System.out.println("The size of the matchList is: " + matchList.size());
        for(int j=0; j<matchList.size()/20; j++){
            System.out.println("Match number " + j + ": " + matchList.get(j).getName());
        }

        // now that we have the matches generated, update the GUI with Matches
        criteriaGetter.refreshWithPopulatedMatchList(matchList);

        /* -------------------------------------------------------- USER = Peter --------------------------------------------------------*/



        /* --------------------------------------------------------- USER = Filip ----------------------------------------------------------*/

    }
}

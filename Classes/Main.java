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
        boolean filledOut = criteriaGetter.filledOut;
        System.out.println(filledOut);
        while(!filledOut){
            filledOut = criteriaGetter.filledOut;
            if(filledOut)
                break;
        }
        criteria = criteriaGetter.getCriteria();

        // populate the FBWeb
        fbWeb = new FacebookWeb();
        fbWeb.fillImmediateWeb();
        // test that we're indeed filling the Facebook Web
        LinkedList<Connection> myConnections = fbWeb.getMyWeb().get(0);
        for(int i=0; i<myConnections.size(); i++){
            System.out.println("Connection: " + myConnections.get(i).getName() + ", " + myConnections.get(i).getUID());
        }

        // my MatchList!
       /* User MA = new User(name, userID);
        MatchList matcher = new MatchList(MA);
        LinkedList<Connection> matchList = matcher.getMatchList();
        for(int j=0; j<matchList.size(); j++){
            System.out.println("Match number " + j + ": " + matchList.get(j).getName());
        }*/

        /* -------------------------------------------------------- USER = Peter --------------------------------------------------------*/



        /* --------------------------------------------------------- USER = Filip ----------------------------------------------------------*/

    }
}

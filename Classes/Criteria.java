import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: mseger
 * Date: 12/17/12
 * Time: 2:43 AM
 * To change this template use File | Settings | File Templates.
 */

public class Criteria extends JFrame{

        private static Toolkit tk = Toolkit.getDefaultToolkit();
        //private static final int WIDTH = (int)tk.getScreenSize().getWidth();
        //private static final int HEIGHT = (int)tk.getScreenSize().getHeight();

        private JPanel matchPanel_empty, matchPanel_full;
         private JLabel titleLabel,cleanLabel, bedtimeLabel, partyLabel, companyLabel;
        private JComboBox cleanChoice, bedtimeChoice, partyChoice, companyChoice;
        private JButton calculateB, exitB;

        HashMap<String, Integer> QAResponses; // represents the mapping from preference questions to user-inputted responses
        boolean filledOut;  // represents whether there are responses to the questions to return from the GUI yet

        public Criteria()
        {
            // roommate-matcher title bar
            String imgStr = "roommateMatch_logo.png";
            ImageIcon image = new ImageIcon(imgStr);
            titleLabel = new JLabel(" ", image, JLabel.CENTER);

            // criteria user-generated responses
            QAResponses = new HashMap<String, Integer>();
            filledOut = false;
            JPanel userInfo = grabUserInfo();

            //Set the window's title.
            setTitle("Roommate Match");

            //Get the content pane (CP).
            Container pane = getContentPane();
            validate();

            // initialize the CardLayout imageGridPanel, which will switch between TBA matches and generated matches
            matchPanel_empty = emptyImageGrid(2, 2);

            //put everything into one JPanel, so that we can make this scrollable eventually
            JPanel scrollableContainer = new JPanel();
            scrollableContainer.setLayout(new VerticalFlowLayout());   // using a custom layout found online (thanks Internet!)

            // centering the scrollableContainer within the JFrame
            scrollableContainer.setBackground(Color.WHITE);

            //Add things to the pane in the order you want them to appear (left to right, top to bottom)
            scrollableContainer.add(titleLabel);
            scrollableContainer.add(userInfo);
            //scrollableContainer.add(matchPanel_empty);

            // now add this "master JPanel" to a JScrollPane and then to the Frame
            JScrollPane jsp = new JScrollPane(scrollableContainer, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            pane.add(jsp);

            //Other JFrame stuff.
            //setSize(WIDTH, HEIGHT);
            pack();
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

        // displays, takes in, and stores all user-inputted preference data
        public JPanel grabUserInfo(){
            JPanel userInputPanel = new JPanel();
            userInputPanel.setBackground(Color.WHITE);

            //Instantiate the labels:
            cleanLabel = new JLabel("I am... ", SwingConstants.RIGHT);
            bedtimeLabel = new JLabel("I usually go to bed at: ", SwingConstants.RIGHT);
            partyLabel = new JLabel("I'm okay with parties: ", SwingConstants.RIGHT);
            companyLabel = new JLabel("I'm working at: ", SwingConstants.RIGHT);

            //Combo boxes next:
            String[] cleanliness = {"Meticulous", "Pretty Clean", "Total Slob"};
            cleanChoice = new JComboBox(cleanliness);
            cleanChoice.setSelectedIndex(1);

            String[] bedtimes = {"11 PM", "midnight", "1 AM", "2 AM"};
            bedtimeChoice = new JComboBox(bedtimes);
            bedtimeChoice.setSelectedIndex(2);

            String[] parties = {"Sure!", "No way!"};
            partyChoice = new JComboBox(parties);
            partyChoice.setSelectedIndex(0);


            String[] companies = {"Facebook", "Google", "One King's Lane", "New Relic", "MemSQL"};
            companyChoice = new JComboBox(companies);
            companyChoice.setSelectedIndex(0);

            //Buttons too:
            calculateB = new JButton("Calculate");
            exitB = new JButton("Exit");

            userInputPanel.add(cleanLabel);
            userInputPanel.add(cleanChoice);
            userInputPanel.add(bedtimeLabel);
            userInputPanel.add(bedtimeChoice);
            userInputPanel.add(partyLabel);
            userInputPanel.add(partyChoice);
            userInputPanel.add(companyLabel);
            userInputPanel.add(companyChoice);
            userInputPanel.add(calculateB);
            userInputPanel.add(exitB);

            //SPecify handlers for each button and add (register) ActionListeners to each button.
            CalculateButtonHandler cbHandler = new CalculateButtonHandler();
            calculateB.addActionListener(cbHandler);
            ExitButtonHandler ebHandler = new ExitButtonHandler();
            exitB.addActionListener(ebHandler);

            return userInputPanel;
        }

    public JPanel emptyImageGrid(int width, int length){
        JPanel emptyGridPanel = new JPanel();
        JButton[][] grid; //names the grid of buttons
        JLabel[][] rail;

        emptyGridPanel.setLayout(new GridLayout(width, length));
        rail = new JLabel[width][length];
        for(int y=0; y<length; y++){
            for(int x=0; x<width; x++){
                // get the image icon, scale down, then reset the icon
                ImageIcon icon = createImageIcon("unknownMatch.jpg", "");
                /*Image img = icon.getImage();
                Image newImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                icon = new ImageIcon(newImg); */
                JLabel toAdd = new JLabel(icon);
                toAdd.setBorder(new MatteBorder(20, 20, 20, 20, Color.GRAY));
                rail[x][y] = toAdd;
                emptyGridPanel.add(rail[x][y]);
            }
        }
        return emptyGridPanel;
    }

    public JPanel populateImageGrid(int width, int length, LinkedList<Connection> matches){
        JButton[][] grid; //names the grid of buttons
        JLabel[][] rail;

        final LinkedList<Connection> matchList = matches; // have to make this final in order to pass into inner mouseClicked class

        matchPanel_full = new JPanel();
        matchPanel_full.setLayout(new GridLayout(width, length));
        rail = new JLabel[width][length];

        int k= 0; // counter for which index of the matches LinkedList we're on
        for(int y=0; y<length; y++){
            for(int x=0; x<width; x++){
                System.out.println("Grabbing image from: " + matchList.get(k).getProfPicURL());
                ImageIcon matchProfPic = createImageIconFromFB(matchList.get(k).getProfPicURL());
                JLabel toAdd = new JLabel(matchProfPic);
                toAdd.setBorder(new MatteBorder(20, 20, 20, 20, Color.GRAY));
                final int temp = k; // convert the variable int k into final for mouseClicked class purposes
                toAdd.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent me) {
                        System.out.println(matchList.get(temp).getName());
                    }
                });
                rail[x][y] = toAdd;
                matchPanel_full.add(rail[x][y]);
                k++;
            }
        }

        return matchPanel_full;
    }

    public ImageIcon createImageIconFromFB(String address){
        Image matchImage = null;
        ImageIcon matchIcon = null;
        try{
            URL url = new URL(address);
            matchImage = ImageIO.read(url);
            matchIcon = new ImageIcon(matchImage);
        } catch (IOException e) {
            System.out.println("Exception downloading image: " + e);
        }
        return matchIcon;
    }

    public static ImageIcon createImageIcon(String path,String description) {
        java.net.URL imgURL = ImageGrid.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {

            return null;
        }
    }

    public void refreshWithPopulatedMatchList(LinkedList<Connection> matches){
        // roommate-matcher title bar
        JFrame newJFrame = new JFrame();

        String imgStr = "roommateMatch_logo.png";
        ImageIcon image = new ImageIcon(imgStr);
        titleLabel = new JLabel(" ", image, JLabel.CENTER);

        // criteria user-generated responses

        //Set the window's title.
        newJFrame.setTitle("Roommate Match");

        //Get the content pane (CP).
        Container pane = newJFrame.getContentPane();
        newJFrame.validate();

        // initialize the CardLayout imageGridPanel, which will switch between TBA matches and generated matches
        matchPanel_full = populateImageGrid(10, 16, matches);  // larger one: do this for a cooler generated matchList

        //put everything into one JPanel, so that we can make this scrollable eventually
        JPanel scrollableContainer = new JPanel();
        scrollableContainer.setLayout(new VerticalFlowLayout());   // using a custom layout found online (thanks Internet!)
        scrollableContainer.setBackground(Color.WHITE);

        //Add things to the pane in the order you want them to appear (left to right, top to bottom)
        scrollableContainer.add(titleLabel);
        scrollableContainer.add(matchPanel_full);

        // now add this "master JPanel" to a JScrollPane and then to the Frame
        JScrollPane jsp = new JScrollPane(scrollableContainer, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pane.add(jsp);

        //Other JFrame stuff.
        newJFrame.setSize((int)tk.getScreenSize().getWidth(), (int)tk.getScreenSize().getHeight());
        newJFrame.setVisible(true);
        newJFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

        private class CalculateButtonHandler implements ActionListener {
            public void actionPerformed(ActionEvent e){
                Integer  cleanlinessPref, bedtimePref, partyPref, company;  // the integer represents the index
                // selected of the different given options for each question

                // grab the input from the GUI
                cleanlinessPref = new Integer(cleanChoice.getSelectedIndex());
                bedtimePref = new Integer(bedtimeChoice.getSelectedIndex());
                partyPref = new Integer(partyChoice.getSelectedIndex());
                company = new Integer(companyChoice.getSelectedIndex());

                // fill QAResponses HashMap
                QAResponses.put("Clean", cleanlinessPref);
                QAResponses.put("Bedtime", bedtimePref);
                QAResponses.put("Party", partyPref);
                QAResponses.put("Company", company);

                // user has: name, User ID, criteria
                String name = "Margaret-Ann";
                String userID = "margaretann.seger";
                HashMap<String, Integer> criteria = QAResponses;
                FacebookWeb fbWeb;
                MatchList matches;

                // populate the FBWeb
                fbWeb = new FacebookWeb();
                fbWeb.fillImmediateWeb();

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
                refreshWithPopulatedMatchList(matchList);
            }
        }

        public HashMap<String, Integer> getCriteria(){
            if(QAResponses.size()!=0){
                return QAResponses;
            }else{
                return null;
            }
        }

        public class ExitButtonHandler implements ActionListener{
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        }

        public static void main(String[] args){
            Criteria criteriaDisplay = new Criteria();
        }
}

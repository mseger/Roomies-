import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
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

        private static final int WIDTH = 400;
        private static final int HEIGHT = 300;

        private JLabel cleanLabel, bedtimeLabel, partyLabel, companyLabel;
        private JComboBox cleanChoice, bedtimeChoice, partyChoice, companyChoice;
        private JButton calculateB, exitB;

        HashMap<String, Integer> QAResponses; // represents the mapping from preference questions to user-inputted responses
        boolean filledOut;  // represents whether there are responses to the questions to return from the GUI yet

        public Criteria()
        {
            QAResponses = new HashMap<String, Integer>();
            filledOut = false;
            JPanel userInfo = grabUserInfo();

            //Set the window's title.
            setTitle("Roommate Match");

            //Get the content pane (CP).
            Container pane = getContentPane();
            validate();

            //Set the layout.
            pane.setLayout(new GridLayout());

            //Add things to the pane in the order you want them to appear (left to right, top to bottom)
            pane.add(userInfo);

            //Other JFrame stuff.
            setSize(WIDTH, HEIGHT);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

        // displays, takes in, and stores all user-inputted preference data
        public JPanel grabUserInfo(){
            JPanel userInputPanel = new JPanel();

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

                filledOut = true;
            }
        }

        public HashMap<String, Integer> getCriteria(){
            if(filledOut){
                return QAResponses;
            }else{
                System.out.println("Survey questions have not been answered yet.");
                return null;
            }
        }

        public class ExitButtonHandler implements ActionListener{
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        }

        public static void main(String[] args){
            Criteria rectObj = new Criteria();
        }
}

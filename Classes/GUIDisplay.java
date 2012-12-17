import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.net.*;

 
public class GUIDisplay extends JFrame
{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
     
    private JLabel cleanLabel, bedtimeLabel, partyLabel, companyLabel;
    private JComboBox cleanChoice, bedtimeChoice, partyChoice, companyChoice;
    private JButton calculateB, exitB;
    private BufferedImage userProfPic; 
     
    public GUIDisplay()
    {
        JPanel userInfo = grabUserInfo();
        JPanel profPicPanel = populateProfilePic();
        JPanel candidatePanel =  populateCandidatePanel();

         
        //Set the window's title.
        setTitle("Roommate Match");
         
        //Get the content pane (CP).
        Container pane = getContentPane();
         
        //Set the layout.
        pane.setLayout(new FlowLayout());

        //Add things to the pane in the order you want them to appear (left to right, top to bottom)
		pane.add(userInfo);
        pane.add(profPicPanel);
        //pane.add(candidatePanel);

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
        userInputPanel.add(exitB);
        
        //SPecify handlers for each button and add (register) ActionListeners to each button.
        CalculateButtonHandler cbHandler = new CalculateButtonHandler();
        calculateB.addActionListener(cbHandler);
        ExitButtonHandler ebHandler = new ExitButtonHandler();
        exitB.addActionListener(ebHandler);

        return userInputPanel;

    }

    public JPanel populateProfilePic(){
        JPanel profPicPanel = new JPanel(); 

        try{
            URL profPicLink = new URL("http://poponandon.com/wp-content/uploads/2011/03/example-kickstarts.jpg");
            Image img = ImageIO.read(profPicLink);
            ImageIcon icon = new ImageIcon(img);
            JLabel label = new JLabel();
            label.setIcon(icon);
            profPicPanel.add(label); 
            return profPicPanel;
        }catch(Exception ex){
            System.out.println("Profile Pic Load failed: " + ex);
            return null;
        }
    }


    public JPanel populateCandidatePanel(){
        JPanel candidatePanel = new JPanel(new FlowLayout()); 
        for(int i=0; i<16; i++){
            JPanel candidateBox = populateCandidateBox();
            candidatePanel.add(candidateBox);
        }
        return candidatePanel;
    }

    public JPanel populateCandidateBox(){
        JPanel candidateBox = populateProfilePic();
        return candidateBox; 
    }


	private class CalculateButtonHandler implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	        double width, length, area;
	             
	        //length = Double.parseDouble(lengthTF.getText()); //We use the getText & setText methods to manipulate the data entered into those fields.
	        //width = Double.parseDouble(widthTF.getText());
	        //area = length * width;
	             
	        //areaTF.setText("" + area);
	    }
	}
	     
	public class ExitButtonHandler implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	System.exit(0);
	    }
	}
	     
	public static void main(String[] args){
	    GUIDisplay rectObj = new GUIDisplay();
	}
	     
}
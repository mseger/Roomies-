import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
public class GUITest extends JFrame
{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
     
    private JLabel lengthL, widthL, areaL, perimeterL;
    private JTextField lengthTF, widthTF, areaTF, perimeterTF;
    private JButton calculateB, exitB;
     
    public GUITest()
    {
        //Instantiate the labels:
        lengthL = new JLabel("Enter the length: ", SwingConstants.RIGHT);
        widthL = new JLabel("Enter the width: ", SwingConstants.RIGHT);
        areaL = new JLabel("Area: ", SwingConstants.RIGHT);
        perimeterL = new JLabel("Perimeter: ", SwingConstants.RIGHT);
         
        //Text fields next:
        lengthTF = new JTextField(10);
        widthTF = new JTextField(10);
        areaTF = new JTextField(10);
        perimeterTF = new JTextField(10);
         
        //Buttons too:
        calculateB = new JButton("Calculate");
        exitB = new JButton("Exit");
        
        //SPecify handlers for each button and add (register) ActionListeners to each button.
        CalculateButtonHandler cbHandler = new CalculateButtonHandler();
        calculateB.addActionListener(cbHandler);
        ExitButtonHandler ebHandler = new ExitButtonHandler();
        exitB.addActionListener(ebHandler);
         
        //Set the window's title.
        setTitle("Sample Title: Area of a Rectangle");
         
        //Get the content pane (CP).
        Container pane = getContentPane();
         
        //Set the layout.
        pane.setLayout(new GridLayout(5, 2));

        //Add things to the pane in the order you want them to appear (left to right, top to bottom)
		pane.add(lengthL);
		pane.add(lengthTF);
		pane.add(widthL);
		pane.add(widthTF);
		pane.add(areaL);
		pane.add(areaTF);
		pane.add(calculateB);
		pane.add(exitB);
         
        //Other JFrame stuff.
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

	private class CalculateButtonHandler implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	        double width, length, area;
	             
	        length = Double.parseDouble(lengthTF.getText()); //We use the getText & setText methods to manipulate the data entered into those fields.
	        width = Double.parseDouble(widthTF.getText());
	        area = length * width;
	             
	        areaTF.setText("" + area);
	    }
	}
	     
	public class ExitButtonHandler implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	System.exit(0);
	    }
	}
	     
	public static void main(String[] args){
	    GUITest rectObj = new GUITest();
	}
	     
}
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.net.*;


public class ButtonGrid {

    JFrame frame=new JFrame(); //creates frame

    JButton[][] grid; //names the grid of buttons
    JLabel[][] rail = new JLabel[5][5];

    public ButtonGrid(int width, int length){ //constructor with 2 parameters
            frame.getContentPane().setLayout (new GridLayout(width,length)); //set layout of frame
            grid=new JButton[width][length]; //allocate the size of grid
            for(int y=0; y<length; y++){ 
                    for(int x=0; x<width; x++){
                            //grid[x][y]=new JButton("("+x+","+y+")");   
                            //frame.add(grid[x][y]); //adds button to grid
                        ImageIcon icon = createImageIcon("http://poponandon.com/wp-content/uploads/2011/03/example-kickstarts.jpg", "");
                        //JLabel lab = new JLabel(icon);
                        rail[x][y] = new JLabel(icon);
                        frame.getContentPane().add(rail[x][y]);
                    }
            }
    }
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            frame.pack(); 
            frame.setVisible(true);
    }

     public static ImageIcon createImageIcon(String path,String description) {
            java.net.URL imgURL = ButtonGrid.class.getResource(path);
            if (imgURL != null) {
                return new ImageIcon(imgURL, description);
            } else {

                return null;
            }
    }


    public static void main(String[] args) {
        new ButtonGrid(5,5);//makes new ButtonGrid with 2 parameters
}


}
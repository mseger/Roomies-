/**
 * Created with IntelliJ IDEA.
 * User: mseger
 * Date: 12/20/12
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class ImageGrid {

    JFrame frame=new JFrame(); //creates frame

    JButton[][] grid; //names the grid of buttons
    JLabel[][] rail;

    public ImageGrid(int width, int length){ //constructor with 2 parameters
        rail = new JLabel[width][length];
        frame.getContentPane().setLayout (new GridLayout(width,length)); //set layout of frame
        grid=new JButton[width][length]; //allocate the size of grid
        for(int y=0; y<length; y++){
            for(int x=0; x<width; x++){
                ImageIcon icon = createImageIcon("jia.jpg", "");
                JLabel toAdd = new JLabel(icon);
                toAdd.setBorder(new MatteBorder(20, 20, 20, 20, Color.GRAY));
                rail[x][y] = toAdd;
                frame.getContentPane().add(rail[x][y]);
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static ImageIcon createImageIcon(String path,String description) {
        java.net.URL imgURL = ImageGrid.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {

            return null;
        }
    }


    public static void main(String[] args) {
        new ImageGrid(3,3);//makes new ButtonGrid with 2 parameters
    }


}

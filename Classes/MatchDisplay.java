import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: mseger
 * Date: 12/20/12
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatchDisplay extends JFrame {

    private static final int WIDTH = 1100;
    private static final int HEIGHT = 1100;

    private JLabel imageLabel;
    private JButton calculateB, exitB;

    public void showImage() {

        // Inserts the image icon
        String imgStr = "roommateMatch_logo.png";
        ImageIcon image = new ImageIcon(imgStr);
        JLabel label1 = new JLabel(" ", image, JLabel.CENTER);
        Container pane = getContentPane();
        validate();

        //Set the layout.
        pane.setLayout(new FlowLayout());
        pane.setBackground(Color.WHITE);

        //Add things to the pane in the order you want them to appear (left to right, top to bottom)
        add(label1);

        // setup the frame
        setTitle("Easily find your best-match roommates!");
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        MatchDisplay show1 = new MatchDisplay();
        show1.showImage();
    }



}

//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
class gui {
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Citation Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
         
        
        //Creating A Panel 
        JPanel panel = new JPanel();
        panel.setLayout(null); 

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");
        
        //Adding menu options to the menu  bar
        mb.add(m1);
        mb.add(m2);
        
        //Creating Drop Down Options for each menu option 
        JMenuItem m11 = new JMenuItem("Exit");
        JMenuItem m22 = new JMenuItem("About");
        JMenuItem m23 = new JMenuItem("User Manual"); 
        
        //Adding the drop down menu options to the menu bar selections
        m1.add(m11);
        m2.add(m22);
        m2.add(m23); 

        
        JLabel test= new JLabel ("Citation Generator");
        
        test.setBounds(100,100,30,20); 
        
       
        panel.add(test); 
        
        
       System.out.println( "Label X: " + test.getX() + " Label Y: " + test.getY()); 
        
        frame.add(panel); 
        
        
        
        
        frame.setVisible(true);
    }
}
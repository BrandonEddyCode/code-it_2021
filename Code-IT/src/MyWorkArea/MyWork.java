package MyWorkArea;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;


/*to do make the boxes around the frame
look up how to make small openable click boxes
make 4 boarders.
*/

public class MyWork extends JPanel{
JPanel myLabel;
JButton addButton;


//another class
MyWorkAreaItems myWorkAreaItems;



// Main frame that houses everything for my work tab

 public MyWork(){ 

        // settings of mywork FRAME
        this.setBackground(Color.black);
        this.setLayout(new BorderLayout());
        this.setVisible(false);
        this.setSize(500,500);
        this.setOpaque(true);
    

         JPanel topPanel = new JPanel();                    //TOP RED PANEL
         JPanel rearPanel = new JPanel(new BorderLayout());
         JPanel searchPanel = new JPanel();                 // SEARCH BAR PANEL
         

         topPanel.setBackground(Color.RED);        // TOP PANEL
         rearPanel.setBackground(Color.MAGENTA);   // REAR CENTER PANEL
         searchPanel.setBackground(Color.GREEN);   // TOP SEARCH PANEL
         
         
         topPanel.setPreferredSize(new Dimension(100,100));
         rearPanel.setPreferredSize(new Dimension(100,100));
         searchPanel.setPreferredSize(new Dimension(2000, 50));


         this.add(topPanel, BorderLayout.NORTH);
         this.add(rearPanel, BorderLayout.CENTER);
         rearPanel.add(searchPanel,BorderLayout.NORTH); 

         // My Work center tabs

         rearPanel.setLayout(new BoxLayout(rearPanel, BoxLayout.Y_AXIS));
         rearPanel.add(new MyWorkAreaItems("Overdue /"));
         rearPanel.add(new MyWorkAreaItems("Today /"));
         rearPanel.add(new MyWorkAreaItems("This week /"));
         rearPanel.add(new MyWorkAreaItems("Next week /"));
         rearPanel.add(new MyWorkAreaItems("Later /"));
         rearPanel.add(new MyWorkAreaItems("Without a date /"));


        

         
    
         //topsidecentrepanel
            //this.add(new MyWorkAreaItems("Overdue"));

        //centrerpanel

 }

 
}
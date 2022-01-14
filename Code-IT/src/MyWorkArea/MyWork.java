package MyWorkArea;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
//import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;


/*to do make the boxes around the frame
look up how to make small openable click boxes
make 4 boarders.
*/

public class MyWork extends JPanel{
JPanel myLabel;
JButton addButton;


//another class
MyWorkAreaItems myWorkAreaItems;


 public MyWork(){
     // settings of mywork
        this.setBackground(Color.black);
        this.setLayout(new BorderLayout(10,10));
        this.setVisible(false);
        this.setSize(500,500);
        this.setOpaque(true);
    

         //topsidepanel
         JPanel panel1 = new JPanel();
         JPanel panel2 = new JPanel();
         JPanel panel3 = new JPanel();
         

         panel1.setBackground(Color.RED); // TOP PANEL
         panel2.setBackground(Color.MAGENTA); // CENTER PANEL
         panel3.setBackground(Color.GREEN);// TOP CENTER PANEL
         


        // panel2.setLayout(new BorderLayout(50,50));
    
         
         panel1.setPreferredSize(new Dimension(100,100));
         panel2.setPreferredSize(new Dimension(100,100));
         panel3.setPreferredSize(new Dimension(2000, 100));

         panel2.add(panel3,BorderLayout.NORTH); 
         this.add(panel1, BorderLayout.NORTH);
         this.add(panel2, BorderLayout.CENTER);

         
    
         //topsidecentrepanel
            //this.add(new MyWorkAreaItems("Overdue"));

        //centrerpanel

 }

 
}
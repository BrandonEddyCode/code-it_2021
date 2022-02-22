package MyWorkArea;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;


// MY WORK TAB
public class MyWork extends JPanel{


MyWorkAreaItems myWorkAreaItems = new MyWorkAreaItems("nameTab");

JPanel mainPanel;
JPanel myWorkPadding;




// Main frame that houses everything for my work tab

 public MyWork(){ 

       
        // settings of mywork FRAME
        this.setBackground(Color.black);
        this.setLayout(new BorderLayout());
        this.setSize(500,500);
        this.setSize(2000,2000);
        this.setOpaque(true);
        this.setVisible(true);
        
       

         JPanel topPanel = new JPanel(new BorderLayout());    // TOP RED PANEL
         JPanel rearPanel = new JPanel(new BorderLayout());   // WHERE THE MIDDLE TABS (OVERDUE.. ETC) ARE ATTACHED TO 
         JPanel searchPanel = new JPanel();                   // SEARCH BAR PANEL
         
         JScrollPane myWorkScroll = new JScrollPane(rearPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         

         topPanel.setBackground(Color.RED);        // TOP PANEL
         rearPanel.setBackground(Color.MAGENTA);   // REAR CENTER PANEL
         searchPanel.setBackground(Color.GREEN);   // TOP SEARCH PANEL
         
         
         topPanel.setPreferredSize(new Dimension(100,100));
         rearPanel.setPreferredSize(new Dimension(100,100));
         searchPanel.setPreferredSize(new Dimension(100, 100));

       
        this.add(topPanel, BorderLayout.NORTH);
        JTextArea title = new JTextArea("My Work");            // creates text box
        title.setFont(new Font("Helvetica",Font.BOLD, 40));    // sets the font of the title
        title.setOpaque(false);                                // makes the text have no background
        topPanel.add(title, BorderLayout.WEST);                // adds title to left side of top panel
        myWorkScroll.setPreferredSize(new Dimension(100,1000));
        this.add(myWorkScroll, BorderLayout.CENTER);
        
        


         // My Work center tabs

         rearPanel.setLayout(new BoxLayout(rearPanel, BoxLayout.Y_AXIS));
         rearPanel.add(searchPanel);
         rearPanel.add(new MyWorkAreaItems("Overdue /"));
         rearPanel.add(BorderLayout.WEST);
         rearPanel.add(new MyWorkAreaItems("Today / "));
         rearPanel.add(new MyWorkAreaItems("This week /"));
         rearPanel.add(new MyWorkAreaItems("Next week /"));
         rearPanel.add(new MyWorkAreaItems("Later /"));
         rearPanel.add(new MyWorkAreaItems("Without a date /"));


 }

 
}
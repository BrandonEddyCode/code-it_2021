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

public class MyWork extends JPanel{


MyWorkAreaItems myWorkAreaItems = new MyWorkAreaItems("nameTab");

JPanel mainPanel;

//JScrollPane scrollWork = new JScrollPane(myWorkAreaItems,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


// Main frame that houses everything for my work tab

 public MyWork(){ 

        // settings of mywork FRAME
        this.setBackground(Color.black);
        this.setLayout(new BorderLayout());
        this.setSize(500,500);
        this.setSize(2000,2000);
        this.setOpaque(true);
        this.setVisible(true);
        //add(scrollWork);
       

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
        JTextArea title = new JTextArea("My Work");
        topPanel.add(title);
        this.add(rearPanel, BorderLayout.CENTER);
        rearPanel.add(searchPanel,BorderLayout.CENTER);


         // My Work center tabs

         rearPanel.setLayout(new BoxLayout(rearPanel, BoxLayout.Y_AXIS));
         rearPanel.add(new MyWorkAreaItems("Overdue /"));
         rearPanel.add(new MyWorkAreaItems("Today / "));
         rearPanel.add(new MyWorkAreaItems("This week /"));
         rearPanel.add(new MyWorkAreaItems("Next week /"));
         rearPanel.add(new MyWorkAreaItems("Later /"));
         rearPanel.add(new MyWorkAreaItems("Without a date /"));
        // rearPanel.add(scrollWork);


 }

 
}
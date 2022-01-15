package MyWorkArea;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;

public class MyWork extends JPanel{
JPanel myLabel;
JButton addButton;


//another class
MyWorkAreaItems myWorkAreaItems;


 public MyWork(){
     // settings of mywork
        this.setBackground(Color.green);
        this.setLayout(new GridLayout());
        this.setVisible(false);
        this.setPreferredSize(new Dimension(300,300));
        this.setOpaque(true);
    

         //topsidepanel
        
        
         //centrerpanel
         //topsidecentrepanel
         this.add(new MyWorkAreaItems("Overdue"));
         this.add(new MyWorkAreaItems("coglionbe"));
         this.add(new MyWorkAreaItems("Overdue"));
         this.add(new MyWorkAreaItems("Overdue"));
         this.add(new MyWorkAreaItems("Overdue"));

 }

 
}
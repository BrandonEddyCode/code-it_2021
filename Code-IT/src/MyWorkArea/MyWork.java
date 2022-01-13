package MyWorkArea;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;


/*to do make the boxes around the frame
look up how to make small openable click boxes
make 4 boarders.
*/

public class MyWork extends JPanel{
JPanel myLabel;
JButton addButton;


 public MyWork(){
     // settings of mywork
        this.setBackground(Color.BLUE);
        this.setLayout(new BorderLayout(0,0));
        this.setVisible(false);
        this.setPreferredSize(new Dimension(300,300));
        this.setOpaque(true);
    //setting for mylable
    myLabel= new JPanel();
    //setting for addbutton
    addButton = new JButton("Add");
    addButton.addActionListener(e -> addButtonFunction());


        
        myLabel.setPreferredSize(new Dimension(150,150));
        myLabel.setBackground(Color.lightGray);
        
        
        myLabel.add(new JButton("Delete"));
        myLabel.add(new JButton("Subtract"));
        this.add(myLabel);
        this.add(addButton);
 }

 void addButtonFunction(){
    System.out.println("hello cornuto");
 }
}
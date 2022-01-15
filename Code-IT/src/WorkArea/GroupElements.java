package WorkArea;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GroupElements extends JPanel {
    JTextField descriptionField;
    JButton statusButton;
    JButton dateButton;
    JTextField textField;
    JTextField numbersField;
    JCheckBox checkBox;
    JButton filebButton;
    JButton timelineButton;
    GroupElements(){
        
        this.setLayout(new GridLayout(1,7,3,10));
        

        //instances
        descriptionField = new JTextField();
        statusButton = new JButton();
        dateButton = new JButton();
        textField = new JTextField();
        numbersField = new JTextField();
        checkBox = new JCheckBox();
        filebButton = new JButton();
        timelineButton = new JButton();


        //settings
        descriptionField.setPreferredSize(new Dimension(30,20));

        statusButton.setPreferredSize(new Dimension(20,20));
        dateButton.setPreferredSize(new Dimension(20,20));
        textField.setPreferredSize(new Dimension(20,20));
        numbersField.setPreferredSize(new Dimension(20,20));
        checkBox.setPreferredSize(new Dimension(20,20));
        filebButton.setPreferredSize(new Dimension(20,20));
        
        timelineButton.setPreferredSize(new Dimension(20,20));

        //addings
        this.add(descriptionField);
        this.add(statusButton);
        this.add(dateButton);
        this.add(textField);
        this.add(numbersField);
        this.add(checkBox);
        this.add(filebButton);
        this.add(timelineButton);
    }
}

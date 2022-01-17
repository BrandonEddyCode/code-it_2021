package WorkArea;

import javax.swing.JButton;
import javax.swing.JFrame;

import filesReadWrite.CreateFile;
import filesReadWrite.ReadFile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.awt.Frame;



final class StatusButtonFrame extends JFrame {
    final  JButton doneButton = new JButton();
    JButton progressButton = new JButton();
    JButton blockedButton = new JButton();
    HashMap<String, String> currentStatusButtonMap;
    String filteredMap;
    String finalFilteredMap;
    String currentButtonSelected;
    StatusButtonFrame(HashMap<String, String> statusButtonValuesMap,String currentButton){
        currentStatusButtonMap = statusButtonValuesMap;
        currentButtonSelected = currentButton;
        
        
        setBounds(400,200,467,315);
        setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3,0));
        setResizable(false);


        doneButton.setPreferredSize(new Dimension(100,50));
        progressButton.setPreferredSize(new Dimension(100,50));
        blockedButton.setPreferredSize(new Dimension(100,50));


        doneButton.setBackground(Color.green);
        doneButton.setText("Done");
        doneButton.addActionListener(e -> setStatus("done"));
        
        progressButton.setBackground(Color.yellow);
        progressButton.setText("in Progress..");
        progressButton.addActionListener(e -> setStatus("progress"));

        blockedButton.setBackground(Color.red);
        blockedButton.setText("Blocked");
        blockedButton.addActionListener(e -> setStatus("blocked"));

        

        this.add(doneButton);
        this.add(progressButton);
        this.add(blockedButton);


        

    }
    void setStatus(String Choise){
        currentStatusButtonMap.replace(currentButtonSelected, currentStatusButtonMap.get(currentButtonSelected), Choise);
        filteredMap = currentStatusButtonMap.toString().replaceAll("[{},]","");
        finalFilteredMap = filteredMap.replace("=", ":");
        

        CreateFile.writeFile(GroupElements.currentName,
        ReadFile.readFile(GroupElements.currentSelected, "group"),
        ReadFile.readFile(GroupElements.currentSelected, "fileType"),
        ReadFile.readFile(GroupElements.currentSelected, "description"),
        ReadFile.readFile(GroupElements.currentSelected, "tabs"),
        ReadFile.readFile(GroupElements.currentSelected, "task"),
        finalFilteredMap,
        ReadFile.readFile(GroupElements.currentSelected, "Date"),
        ReadFile.readFile(GroupElements.currentSelected, "deadline"),
        ReadFile.readFile(GroupElements.currentSelected, "People"),
        ReadFile.readFile(GroupElements.currentSelected, "checkbox"),
        ReadFile.readFile(GroupElements.currentSelected, "numbers"),
        ReadFile.readFile(GroupElements.currentSelected, "Text")); 
        GroupTabs.takeTabsFromFile();
        this.dispose();

    }
}

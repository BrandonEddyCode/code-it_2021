package WorkArea;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.HashMap;


import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import filesReadWrite.CreateFile;
import filesReadWrite.ReadFile;

public class GroupElements extends JPanel {
    JTextField descriptionField;
    JButton statusButton;
    JButton dateButton;
    JTextField textField;
    JTextField numbersField;
    JCheckBox checkBox;
    JButton filebButton;
    JButton timelineButton;

    static String currentSelected;
    static String currentName;
    //
    static HashMap<String,String> taskValuesMap = new HashMap<>();
    private String taskValues;
    private String[] parts;


    //actions
    Action descriptionFiledAction = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            setTaskField();
            String finalValue = taskValuesMap.toString().replaceAll("[{},]", "");
            
            CreateFile.writeFile(currentName,
             ReadFile.readFile(currentSelected, "group"),
             ReadFile.readFile(currentSelected, "type"),
             ReadFile.readFile(currentSelected, "description"),
             ReadFile.readFile(currentSelected, "tabs"),
             finalValue.replace("=", ":")); // nameofthe counte 1,2,3.. + ":" + text of field
        }
    };
   


    GroupElements(String tabName,String a){
        getTaskFieldHashset();
        
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


        //names 
        descriptionField.setName(tabName);
        statusButton.setName(tabName);
        dateButton.setName(tabName);
        textField.setName(tabName);
        numbersField.setName(tabName);
        checkBox.setName(tabName);
        filebButton.setName(tabName);
        timelineButton.setName(tabName);


        //texts 
        String taskText = taskValuesMap.get(tabName);
        String finalTaskText = taskText.replace("_", " ");
        descriptionField.setText(finalTaskText);
       
        //actionslistener
        descriptionField.addActionListener(descriptionFiledAction);
       


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
    static void setCurrentSelected(String Current,String currentname){
        
        currentSelected = Current;
        currentName = currentname;
    }
    //for taskfield
    void getTaskFieldHashset(){
        taskValues = ReadFile.readFile(currentSelected, "task");
            
        parts = taskValues.split(" ");
        taskValuesMap.clear();
        for (String part : parts){
            String data[] = part.split(":");
            String key = data[0].trim();
            String value = data[1].trim();
            taskValuesMap.put(key, value); 
        }
    }
    void setTaskField(){
        taskValuesMap.put(descriptionField.getName(), descriptionField.getText().replace(" ", "_"));
    }

    //for current status
    void setCurrentStatus(){

    }
}

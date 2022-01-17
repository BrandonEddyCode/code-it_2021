package WorkArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.HashMap;


import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import filesReadWrite.CreateFile;
import filesReadWrite.ReadFile;

public class GroupElements extends JPanel {
    JTextField descriptionField;
    static JButton statusButton;
    JButton dateButton;
    JTextField textField;
    JTextField numbersField;
    JCheckBox checkBox;
    JTextField peopleTextField;
    JButton deadlineButton;

    static String currentSelected;
    static String currentName;
    // taskField
    public static HashMap<String,String> taskValuesMap = new HashMap<>();
    private String taskValues;
    private String[] taskValuesParts;
    // statusButton
    StatusButtonFrame statusButtonFrame;
    static String statusButtonChoise;
    public static HashMap<String,String> statusButtonValuesMap = new HashMap<>();
    private String statusButtonValues;
    private String[] statusButtonValuesParts;
    //date
    public static HashMap<String,String> dateButtonMap = new HashMap<>();
    private String dateButtonValues;
    private String[] dateButtonValuesParts;
    //deadline
    public static HashMap<String,String> deadLineButtonMap = new HashMap<>();
    private String deadLineButtonValues;
    private String[] deadLineButtonValuesParts;
    //people
    public static HashMap<String,String> peopleFieldMap = new HashMap<>();
    private String peopleFieldValues;
    private String[] peopleFieldValuesParts;
    //checkbox
    public static HashMap<String,String> checkBoxMap = new HashMap<>();
    private String checkBoxValues;
    private String[] checkBoxValuesParts;
    //Numbers
    public static HashMap<String,String> numbersFielMap = new HashMap<>();
    private String numbersFielValues;
    private String[] numbersFielParts;
    //Text
    public static HashMap<String,String> textFieldMap = new HashMap<>();
    private String textFieldValues;
    private String[] textFieldValuesParts;
    //actions
    Action descriptionFiledAction = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e) {

           
            
            if (descriptionField.getText().isEmpty()){
                taskValuesMap.put(descriptionField.getName(),"_");
            }else {
                setTaskField();
            }
            String finalValue = taskValuesMap.toString().replaceAll("[{},]", "");
            
            


            CreateFile.writeFile(currentName,
             ReadFile.readFile(currentSelected, "group"),
             ReadFile.readFile(currentSelected, "fileType"),
             ReadFile.readFile(currentSelected, "description"),
             ReadFile.readFile(currentSelected, "tabs"),
             finalValue.replace("=", ":"),
             ReadFile.readFile(currentSelected, "status"),
             ReadFile.readFile(BoardMainTab.currentSelected, "Date"),
             ReadFile.readFile(GroupElements.currentSelected, "deadline"),
             ReadFile.readFile(GroupElements.currentSelected, "People"),
             ReadFile.readFile(GroupElements.currentSelected, "checkbox"),
            ReadFile.readFile(GroupElements.currentSelected, "numbers"),
            ReadFile.readFile(GroupElements.currentSelected, "Text"));
        }
    };


    Action peopleTextfiledAction = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(peopleTextField.getText().isEmpty()){
                peopleFieldMap.put(peopleTextField.getName(),"_");
            } else {
                setPeopleField();
            }

            
            String finalValuepeople = peopleFieldMap.toString().replaceAll("[{},]", "");
            CreateFile.writeFile(currentName,
             ReadFile.readFile(currentSelected, "group"),
             ReadFile.readFile(currentSelected, "fileType"),
             ReadFile.readFile(currentSelected, "description"),
             ReadFile.readFile(currentSelected, "tabs"),
             ReadFile.readFile(currentSelected, "task"),
             ReadFile.readFile(currentSelected, "status"),
             ReadFile.readFile(BoardMainTab.currentSelected, "Date"),
             ReadFile.readFile(GroupElements.currentSelected, "deadline"),
             finalValuepeople.replace("=", ":"),
             ReadFile.readFile(GroupElements.currentSelected, "checkbox"),
            ReadFile.readFile(GroupElements.currentSelected, "numbers"),
            ReadFile.readFile(GroupElements.currentSelected, "Text")
             ); 
        }
    };

    Action checkBoxAction = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(checkBox.isSelected()){
                checkBoxMap.put(checkBox.getName(), "True");
            }
            else {
                checkBoxMap.put(checkBox.getName(), "False");
            }


            String finalValue = checkBoxMap.toString().replaceAll("[{},]", "");
            CreateFile.writeFile(currentName,
             ReadFile.readFile(currentSelected, "group"),
             ReadFile.readFile(currentSelected, "fileType"),
             ReadFile.readFile(currentSelected, "description"),
             ReadFile.readFile(currentSelected, "tabs"),
             ReadFile.readFile(currentSelected, "task"),
             ReadFile.readFile(currentSelected, "status"),
             ReadFile.readFile(BoardMainTab.currentSelected, "Date"),
             ReadFile.readFile(GroupElements.currentSelected, "deadline"),
             ReadFile.readFile(GroupElements.currentSelected, "People"),
             finalValue.replace("=", ":"),
             ReadFile.readFile(GroupElements.currentSelected, "numbers"),
             ReadFile.readFile(GroupElements.currentSelected, "Text")

             ); 
        }
    };
    Action NumbersFieldAction = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(numbersField.getText().isEmpty()) {
                numbersFielMap.put(numbersField.getName(), "_");
            }
            else if (!(numbersField.getText().matches("[0-9]+"))) {
                JFrame error = new JFrame();
            JOptionPane.showMessageDialog(error,
              "Need To be a Number!.",
              "Inane error",
              JOptionPane.ERROR_MESSAGE);
            }
            else {
            setNumbersField();
            }

          

            String finalValue = numbersFielMap.toString().replaceAll("[{},]", "");
            CreateFile.writeFile(currentName,
             ReadFile.readFile(currentSelected, "group"),
             ReadFile.readFile(currentSelected, "fileType"),
             ReadFile.readFile(currentSelected, "description"),
             ReadFile.readFile(currentSelected, "tabs"),
             ReadFile.readFile(currentSelected, "task"),
             ReadFile.readFile(currentSelected, "status"),
             ReadFile.readFile(BoardMainTab.currentSelected, "Date"),
             ReadFile.readFile(GroupElements.currentSelected, "deadline"),
             ReadFile.readFile(GroupElements.currentSelected, "People"),
             ReadFile.readFile(GroupElements.currentSelected, "checkbox"),
             finalValue.replace("=", ":"),
             ReadFile.readFile(GroupElements.currentSelected, "Text")

             ); 
        }
    };
    Action textFieldAction = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(textField.getText().isEmpty()) {
                textFieldMap.put(textField.getName(), "_");
            }
            else if (textField.getText().matches("[0-9]+")) {
                JFrame error = new JFrame();
            JOptionPane.showMessageDialog(error,
              "Need To be a TexT!.",
              "Inane error",
              JOptionPane.ERROR_MESSAGE);
            }
            else {
            setTextField();
            }

          

            String finalValue = textFieldMap.toString().replaceAll("[{},]", "");
            CreateFile.writeFile(currentName,
             ReadFile.readFile(currentSelected, "group"),
             ReadFile.readFile(currentSelected, "fileType"),
             ReadFile.readFile(currentSelected, "description"),
             ReadFile.readFile(currentSelected, "tabs"),
             ReadFile.readFile(currentSelected, "task"),
             ReadFile.readFile(currentSelected, "status"),
             ReadFile.readFile(BoardMainTab.currentSelected, "Date"),
             ReadFile.readFile(GroupElements.currentSelected, "deadline"),
             ReadFile.readFile(GroupElements.currentSelected, "People"),
             ReadFile.readFile(GroupElements.currentSelected, "checkbox"),
             ReadFile.readFile(GroupElements.currentSelected, "numbers"),
             finalValue.replace("=", ":")

             ); 
        }
    };
    private DatePicker dataPicker;

    
   


    GroupElements(String tabName,String a){
        retrieveAllHashMaps();
        
        
        this.setLayout(new GridLayout(1,7,3,10));
        

        //instances
        descriptionField = new JTextField();
        statusButton = new JButton();
        dateButton = new JButton();
        textField = new JTextField();
        numbersField = new JTextField();
        checkBox = new JCheckBox();
        peopleTextField = new JTextField();
        deadlineButton = new JButton();


        //settings
        descriptionField.setPreferredSize(new Dimension(30,20));

        statusButton.setPreferredSize(new Dimension(20,20));
        dateButton.setPreferredSize(new Dimension(20,20));
        textField.setPreferredSize(new Dimension(20,20));
        numbersField.setPreferredSize(new Dimension(20,20));
        checkBox.setPreferredSize(new Dimension(20,20));
        peopleTextField.setPreferredSize(new Dimension(20,20));
        
        deadlineButton.setPreferredSize(new Dimension(20,20));


        //names 
        descriptionField.setName(tabName);
        statusButton.setName(tabName);
        dateButton.setName(tabName);
        textField.setName(tabName);
        numbersField.setName(tabName);
        checkBox.setName(tabName);
        peopleTextField.setName(tabName);
        deadlineButton.setName(tabName);


        //texts of descriptionfield
        String taskText = taskValuesMap.get(tabName);
        String finalTaskText = taskText.replace("_", " ");
        descriptionField.setText(finalTaskText);
        //text of peoplefield
        String peopleText = peopleFieldMap.get(tabName);
        String finalPeopleText = peopleText.replace("_", " ");
        peopleTextField.setText(finalPeopleText);

        //status of statusButtons
        
            setStatusButtons(statusButtonValuesMap.get(tabName));
        //date
        dateButton.setText(dateButtonMap.get(tabName));
        //deadline
        deadlineButton.setText(deadLineButtonMap.get(tabName));
        //checkbox
        
         String isSelectedcheck = checkBoxMap.get(tabName);
         
         if (isSelectedcheck.equals("True")){
             checkBox.setSelected(true);
         }
         else if (isSelectedcheck.equals("False")) {
             checkBox.setSelected(false);
         }
         //numberfield
        String numbersFieldText = numbersFielMap.get(tabName);
        String finalnumbersText = numbersFieldText.replace("_", " ");
         numbersField.setText(finalnumbersText);

         //textField
         String textFieldText = textFieldMap.get(tabName);
        String finaltextText = textFieldText.replace("_", " ");
         textField.setText(finaltextText);
        
        
        
       
        //actionslistener
        descriptionField.addActionListener(descriptionFiledAction);
        statusButton.addActionListener(e -> statusButtonPressed(tabName));
        dateButton.addActionListener(e-> dateButtonAction(dateButtonMap,tabName,1));
        deadlineButton.addActionListener(e -> dateButtonAction(deadLineButtonMap ,tabName,2));
        peopleTextField.addActionListener(peopleTextfiledAction);
        checkBox.addActionListener(checkBoxAction);
        numbersField.addActionListener(NumbersFieldAction);
        textField.addActionListener(textFieldAction);

       


        //addings
        this.add(descriptionField);
        this.add(statusButton);
        this.add(dateButton);
        this.add(textField);
        this.add(numbersField);
        this.add(checkBox);
        this.add(peopleTextField);
        this.add(deadlineButton);
    }
    
    static void setCurrentSelected(String Current,String currentname){
        
        currentSelected = Current;
        currentName = currentname;
    }
    //for taskfield
    void retrieveAllHashMaps(){
        taskValues = ReadFile.readFile(currentSelected, "task");
            
        taskValuesParts = taskValues.split(" ");
        taskValuesMap.clear();
        for (String part : taskValuesParts){
            String data[] = part.split(":");
            String key = data[0].trim();
            String value = data[1].trim();
            taskValuesMap.put(key, value); 
        }

        //status button
        statusButtonValues = ReadFile.readFile(currentSelected, "status");
        
            
        statusButtonValuesParts = statusButtonValues.split(" ");
        statusButtonValuesMap.clear();
        for (String part : statusButtonValuesParts){
            String data[] = part.split(":");
            String key = data[0].trim();
            String value = data[1].trim();
            statusButtonValuesMap.put(key, value); 
        }
        //date
        dateButtonValues = ReadFile.readFile(currentSelected, "Date");
        
            
        dateButtonValuesParts = dateButtonValues.split(" ");
        dateButtonMap.clear();
        for (String part : dateButtonValuesParts){
            String data[] = part.split(":");
            String key = data[0].trim();
            String value = data[1].trim();
            dateButtonMap.put(key, value); 
        }
        //deadline
        deadLineButtonValues = ReadFile.readFile(currentSelected, "deadline");
        
            
        deadLineButtonValuesParts = deadLineButtonValues.split(" ");
        deadLineButtonMap.clear();
        for (String part : deadLineButtonValuesParts){
            String data[] = part.split(":");
            String key = data[0].trim();
            String value = data[1].trim();
            deadLineButtonMap.put(key, value); 
        }

        //people


        peopleFieldValues = ReadFile.readFile(currentSelected, "People");
        
            
        peopleFieldValuesParts = peopleFieldValues.split(" ");
        peopleFieldMap.clear();
        for (String part : peopleFieldValuesParts){
            String data[] = part.split(":");
            String key = data[0].trim();
            String value = data[1].trim();
            peopleFieldMap.put(key, value); 
        }
        //checkbox 
        checkBoxValues = ReadFile.readFile(currentSelected, "checkbox");
        
            
        checkBoxValuesParts = checkBoxValues.split(" ");
        checkBoxMap.clear();
        for (String part : checkBoxValuesParts){
            String data[] = part.split(":");
            String key = data[0].trim();
            String value = data[1].trim();
            checkBoxMap.put(key, value); 
        }
        

        //numbers
        numbersFielValues = ReadFile.readFile(currentSelected, "numbers");
        
            
        numbersFielParts = numbersFielValues.split(" ");
        numbersFielMap.clear();
        for (String part : numbersFielParts){
            String data[] = part.split(":");
            String key = data[0].trim();
            String value = data[1].trim();
            numbersFielMap.put(key, value); 
        }
        //text
        textFieldValues = ReadFile.readFile(currentSelected, "Text");
        
            
        textFieldValuesParts = textFieldValues.split(" ");
        textFieldMap.clear();
        for (String part : textFieldValuesParts){
            String data[] = part.split(":");
            String key = data[0].trim();
            String value = data[1].trim();
            textFieldMap.put(key, value); 
        }


    }
    void setTaskField(){
        taskValuesMap.put(descriptionField.getName(), descriptionField.getText().replace(" ", "_"));
    }
    void setPeopleField(){
        peopleFieldMap.put(peopleTextField.getName(), peopleTextField.getText().replace(" ", "_"));
    }
    void setNumbersField(){
        numbersFielMap.put(numbersField.getName(), numbersField.getText().replace(" ", "_"));
    }
    void setTextField(){
        textFieldMap.put(textField.getName(), textField.getText().replace(" ", "_"));
    }

    //for current status
    
    void statusButtonPressed(String tabName){
        if(statusButtonFrame == null) {
            statusButtonFrame = new StatusButtonFrame(statusButtonValuesMap,tabName);
        }
        statusButtonFrame.setVisible(true);
    }
    void setStatusButtons(String status){
        
        
        statusButton.setText(status);
       
         
    }
    void dateButtonAction(HashMap<String,String> map, String tabName,int whatdate){
        dataPicker = new DatePicker(map,tabName,whatdate);

    }
}
    


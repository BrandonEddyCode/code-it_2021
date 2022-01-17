package WorkArea;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import filesReadWrite.CreateFile;
import filesReadWrite.ReadFile;

import java.awt.GridLayout;
import java.util.HashMap;


class GroupTabs extends JPanel{
    

    static HashMap<String,String> tabsElements = new HashMap<>();

    static JPanel tab;

    static JPanel centre = new JPanel(new BorderLayout());
    JPanel top = new JPanel(new GridLayout(1,7));
    static JPanel bottom = new JPanel(new GridLayout(100,8));
    static JScrollPane bottomScrollPane = new JScrollPane(bottom,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    static GroupElements elements;
    static int height = 55;
    //labels
    static JLabel groupName;
    JLabel currentStatus;
    JLabel date;
    JLabel text;
    JLabel numbers;
    JLabel checkbox;
    JLabel file;
    JLabel timeline;
    //buttons

    private static String fileName;

    private static String currentGroupNameFile; //
    static String currentGroup;
    static String values;
    static String parts[];

    private static int counter;
    

    


    GroupTabs(String GroupName, String CurrentgroupName){
        this.setLayout(new BorderLayout());
        tab = new JPanel();
        this.add(tab);
        currentGroupNameFile = CurrentgroupName;
        currentGroup = GroupName;
        
        tab.setBackground(Color.BLACK);
        tab.setOpaque(true);
        tab.setPreferredSize(new Dimension(50,height));
        tab.setLayout(new BorderLayout());

        //istances
        
            //labels
        groupName = new JLabel();
        currentStatus  = new JLabel();
        date  = new JLabel();
        text  = new JLabel();
        numbers  = new JLabel();
        checkbox  = new JLabel();
        file  = new JLabel();
        timeline = new JLabel();
            //buttons
        


        //settings
            //groupname
        groupName.setText(GroupName);
        groupName.setName(GroupName);
        groupName.setPreferredSize(new Dimension(20,20));
            //currentStatus
        currentStatus.setText("Current Status");
        currentStatus.setPreferredSize(new Dimension(0,20));
            //date
        date.setText("Date");
        date.setPreferredSize(new Dimension(0,20));
            //text
        text.setText("Text");
        text.setPreferredSize(new Dimension(0,20));
            //numbers
        numbers.setText("Numbers");
        numbers.setPreferredSize(new Dimension(0,20));
            //checkbox
        checkbox.setText("CheckBox");
        checkbox.setPreferredSize(new Dimension(0,20));
            //file
        file.setText("People/Team");
        file.setPreferredSize(new Dimension(0,20));
            //timeline
        timeline.setText("Deadline");
        timeline.setPreferredSize(new Dimension(0,20));
        //adds
        tab.add(centre);
        centre.add(top,BorderLayout.NORTH);
        centre.add(bottomScrollPane);

        top.add(groupName);
        top.add(currentStatus);
        top.add(date);
        top.add(text);
        top.add(numbers);
        top.add(checkbox);
        top.add(file);
        top.add(timeline);

        
        takeTabsFromFile();
      
    }
    static void takeTabsFromFile(){
         
        tabsElements.clear();
            
            

            values = ReadFile.readFile(currentGroupNameFile, "tabs");
            
            parts = values.split(" ");
            
            bottom.removeAll();
            bottom.repaint();
            bottom.revalidate();
            height = 55;
            

        for (String part : parts){
            String data[] = part.split(":");
            
            String key = data[0].trim();
            
            String value = data[1].trim();
            

            tabsElements.put(key, value);
            
            
        }
        counter = 0;
        for (String i : tabsElements.values()) {
            if (groupName.getName() == currentGroup){
                counter += 1;
            height += 28;
            tab.setPreferredSize(new Dimension(50,height));
            elements = new GroupElements(String.format("%d", counter),"");
            bottom.add(elements);
            }
        }

        JButton addTab = new JButton();
        addTab.setText("+");
        addTab.addActionListener(e -> addTabAction());
        bottom.add(addTab);

    
}
static void addTabAction(){
    counter += 1;
    String value = "DefaultTab";
    
    

    CreateFile.writeFile(fileName,
             "1:Default",
             ReadFile.readFile(BoardMainTab.currentSelected, "fileType"),
             ReadFile.readFile(BoardMainTab.currentSelected, "description"),
             makeTrim(tabsElements),
             makeTrim(GroupElements.taskValuesMap),
             makeTrim(GroupElements.statusButtonValuesMap),
             makeTrim(GroupElements.dateButtonMap),
             makeTrim(GroupElements.deadLineButtonMap),
             makeTrim(GroupElements.peopleFieldMap),
             makeTrim(GroupElements.checkBoxMap),
             makeTrim(GroupElements.numbersFielMap),
             makeTrim(GroupElements.textFieldMap));

  takeTabsFromFile();
  
  centre.revalidate();
  centre.repaint();
}

static java.lang.String makeTrim(HashMap<String,String> mapToTrim){
    mapToTrim.put(String.format("%d", counter), "_");
    String firstInteraction = mapToTrim.toString().replaceAll("[{},]","");
    String secondInteraction = firstInteraction.replace("=", ":");
return secondInteraction;
}
static void setFileName(String FileName){
    fileName = FileName;
}
}
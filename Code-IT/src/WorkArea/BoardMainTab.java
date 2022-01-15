package WorkArea;

import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import filesReadWrite.ReadFile;



public class BoardMainTab extends JPanel {

    
  
    JLabel groupName = new JLabel();
    static String currentSelected;
    
    static String values;
    static String parts[];
    static HashMap<String, String> groupNames = new HashMap<>();

    static JPanel centre = new JPanel();
    static JScrollPane scrollcentre = new JScrollPane(centre,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED) ;
    static GroupTabs groups;
    BoardMainTab (){
        
        this.setLayout(new BorderLayout());
        centre.setOpaque(true);
        centre.setBackground(Color.BLUE);
        centre.setLayout(new GridLayout(200, 0,10,10));
        
        this.add(scrollcentre);
        setGroups();

    }
    public static void setGroups(){
        
        if (currentSelected != null){
            
            groupNames.clear();
            
            

            values = ReadFile.readFile(currentSelected, "group");
            
            parts = values.split(" ");
            
            

        for (String part : parts){
            String data[] = part.split(":");
            
            String key = data[0].trim();
            
            String value = data[1].trim();
            

            groupNames.put(key, value);
            
        }
        

        centre.removeAll();
        centre.repaint();
        centre.revalidate();
        for(String i : groupNames.values()){
            
            
            
            groups = new GroupTabs(i,currentSelected); //let's saparate

            
            
            
            centre.add(groups);
        }
    
    }
}

    
    static void setCurrentSelected(String selected){
        currentSelected = selected;
    }
}

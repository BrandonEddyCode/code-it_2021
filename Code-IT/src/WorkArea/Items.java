package WorkArea;


import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import filesReadWrite.ReadFile;


public class Items extends JLabel {
    JButton items_button;
    
    String description;
    
    ImageIcon imageIcon;
    
    
    
    Items(String file){
        this.setName(file);
        String readFileFuctionString = "files/" + SideBarMenuFunctions.comboBox_JComboBoxSelection + "/" +this.getName()+ ".csv";
        setDescription(readFileFuctionString);
        
        items_button = new JButton();
        
        items_button.setSize(new Dimension(200,20));
        
        imageIcon = new ImageIcon(new ImageIcon("res/BoardImage.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        items_button.setOpaque(false);
        items_button.setContentAreaFilled(false);
        items_button.addActionListener(e -> setBoard(description));
        
       
        
        
        this.setPreferredSize(new Dimension(200,20));
        

        //this.setBackground(Color.CYAN);
        this.setOpaque(true);
        this.setIcon(imageIcon);
        
        this.setText(file + " " + ReadFile.readFile(readFileFuctionString,"fileType"));
        

        //System.out.println(ReadFile.readFile("files/" +file + ".csv","fileType"));
        this.setHorizontalTextPosition(JLabel.RIGHT);
    
        this.add(items_button);
        
    }

    private void setDescription(String f) {
        this.description = ReadFile.readFile(f, "description");
    }

    private void setBoard(String description) {
        
        WorkArea.centre_jPanel.setVisible(true);
        BoardPanel.setBoardName(this.getName());
        setDescription("files/" + SideBarMenuFunctions.comboBox_JComboBoxSelection + "/" +this.getName()+ ".csv");
        BoardPanel.setBoardDescription(this.description);
        BoardMainTab.setCurrentSelected("files/" + SideBarMenuFunctions.comboBox_JComboBoxSelection + "/" +this.getName()+ ".csv");
        GroupElements.setCurrentSelected("files/" + SideBarMenuFunctions.comboBox_JComboBoxSelection + "/" +this.getName()+ ".csv",this.getName());
      
        GroupTabs.setFileName(this.getName());
        BoardMainTab.setGroups();
        GroupTabs.takeTabsFromFile();
        
        
    }
    
    
}

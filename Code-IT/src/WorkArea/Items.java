package WorkArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import filesReadWrite.ReadFile;
import WorkArea.WorkArea;

public class Items extends JLabel {
    JButton items_button;
    
   

    ImageIcon imageIcon;
    
    
    Items(String file){
        String readFileFuctionString = "files/" + SideBarMenuFunctions.comboBox_JComboBoxSelection + "/" +file+ ".csv";
        String description = ReadFile.readFile(readFileFuctionString, "description");
        items_button = new JButton();
        
        items_button.setSize(new Dimension(200,20));
        
        imageIcon = new ImageIcon(new ImageIcon("res/BoardImage.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        items_button.setOpaque(false);
        items_button.setContentAreaFilled(false);
        items_button.addActionListener(e -> makeBoardVisible(description));
        
        this.setName(file);
        this.setPreferredSize(new Dimension(200,20));
        

        //this.setBackground(Color.CYAN);
        this.setOpaque(true);
        this.setIcon(imageIcon);
        
        this.setText(file + " " + ReadFile.readFile(readFileFuctionString,"fileType"));
        

        //System.out.println(ReadFile.readFile("files/" +file + ".csv","fileType"));
        this.setHorizontalTextPosition(JLabel.RIGHT);
    
        this.add(items_button);
        
    }

    private void makeBoardVisible(String description) {
        
        WorkArea.centre_jPanel.setVisible(true);
        BoardPanel.setBoardName(this.getName());
        BoardPanel.setBoardDescription(description);
    }
    
}

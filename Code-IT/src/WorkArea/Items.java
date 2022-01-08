package WorkArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import filesReadWrite.ReadFile;

public class Items extends JLabel {
    JButton items_button;

    ImageIcon imageIcon;
    
    Items(String file){
        
        items_button = new JButton();
        items_button.setSize(new Dimension(200,20));

        items_button.setOpaque(false);
        items_button.setContentAreaFilled(false);

        this.setName(file);
        this.setPreferredSize(new Dimension(200,20));
        
        this.setText(file + " " + ReadFile.readFile("files/" + SideBarMenuFunctions.comboBox_JComboBoxSelection + "/" +file+ ".csv","fileType"));

        this.setBackground(Color.CYAN);
        this.setOpaque(true);
        
        imageIcon = new ImageIcon(new ImageIcon("res/BoardImage.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        this.setIcon(imageIcon);

        //System.out.println(ReadFile.readFile("files/" +file + ".csv","fileType"));
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.CENTER);
        this.add(items_button);
    }
    
}

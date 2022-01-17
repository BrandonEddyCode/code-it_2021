import java.awt.Dimension;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Image;

public class SideBar extends JPanel{
    JButton button;
    JButton button2;
    JButton button3;
    
    ImageIcon button_image = new ImageIcon("res/home.png");
    ImageIcon button2_image = new ImageIcon(new ImageIcon("res/WorkArea.png").getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT));
    ImageIcon button3_image = new ImageIcon(new ImageIcon("res/MyWork.png").getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT));
    


    SideBar(){      
        button = new JButton();
        button2 = new JButton();
        button3 = new JButton();
    
        
        
        button.setPreferredSize(new Dimension(55,55));
        button.setIcon(button_image);
        button2.setIcon(button2_image);
        button3.setIcon(button3_image);
        button2.setPreferredSize(new Dimension(55,55));
        button3.setPreferredSize(new Dimension(55,55));
    

       

        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(100,0));
        this.setVisible(false);


        this.add(button);
        this.add(button2);
        this.add(button3);
     

        
    }
}

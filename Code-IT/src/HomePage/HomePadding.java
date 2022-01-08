package HomePage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;


import javax.swing.JLabel;

public class HomePadding extends JLabel{
    HomeFeed homeFeed_Jlabel = new HomeFeed();
    JLabel a = new JLabel();
    JLabel b = new JLabel(); // right side
    


    
    HomePadding(){
        paddingSettings();
        this.add(homeFeed_Jlabel,BorderLayout.CENTER);

        this.a.setPreferredSize(new Dimension(100,50));
        
        this.b.setPreferredSize(new Dimension(500,50));
        
        this.add(a,BorderLayout.WEST);
        this.add(b,BorderLayout.EAST);

    }
    void paddingSettings(){
        this.setPreferredSize(new Dimension(250,250));
        this.setOpaque(true);
        this.setBackground(new Color(0,0,0,50));
        
        this.setLayout(new BorderLayout(10,10));
    }




    
}

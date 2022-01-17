package HomePage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;


class TopSideHome extends JPanel {
    JLabel welcomeText_topSideHome_JLabel = new JLabel(); 
    JButton rapidResearchButton_JButton = new JButton();
    JTextArea topTextArea_JLabel = new JTextArea(" Hello  \n Welcome back!");
    JLabel topSide_JLabel = new JLabel();

    
// left side top button 
    TopSideHome(){
        this.setBackground(Color.GREEN);
        this.setPreferredSize(new Dimension(50,50));
        this.setLayout(new BorderLayout(5,5));
        welcomeTextSettings();
       
        topSideSettings();
    }
    // Left hadside top button
    void welcomeTextSettings(){
        welcomeText_topSideHome_JLabel.setPreferredSize(new Dimension(250,250));
        welcomeText_topSideHome_JLabel.setOpaque(true);
        welcomeText_topSideHome_JLabel.setBackground(Color.yellow); 
        this.add(topTextArea_JLabel,BorderLayout.WEST);
    }

  
        

    
    void topSideSettings(){
        topSide_JLabel.setPreferredSize(new Dimension(150,250));
        topSide_JLabel.setText("<html>          To Start Click The Gear Button! </html>");
        topSide_JLabel.setOpaque(true);
        topSide_JLabel.setBackground(Color.orange);
        this.add(topSide_JLabel);
    }
  


}
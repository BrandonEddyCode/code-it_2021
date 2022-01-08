package HomePage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;


class TopSideHome extends JPanel {
    JLabel welcomeText_topSideHome_JLabel = new JLabel(); //label with
    JButton rapidResearchButton_JButton = new JButton();
    JLabel topSide_JLabel = new JLabel();
    
// muidauofbeav w ew siweo  :))
    TopSideHome(){
        this.setBackground(Color.GREEN);
        this.setPreferredSize(new Dimension(100,100));
        
        this.setLayout(new BorderLayout(5,5));
        welcomeTextSettings();
        rapidResearchButtonSetiings();
        topSideSettings();
    }
    void welcomeTextSettings(){
        welcomeText_topSideHome_JLabel.setPreferredSize(new Dimension(250,250));
        welcomeText_topSideHome_JLabel.setOpaque(true);
        welcomeText_topSideHome_JLabel.setBackground(Color.yellow); //
        this.add(welcomeText_topSideHome_JLabel,BorderLayout.WEST);
    }
    void rapidResearchButtonSetiings(){
        rapidResearchButton_JButton.setPreferredSize(new Dimension(100,100));
        this.add(rapidResearchButton_JButton,BorderLayout.EAST);
    }
    void topSideSettings(){
        topSide_JLabel.setPreferredSize(new Dimension(250,250));
        topSide_JLabel.setText("<html>Welcome back!<br/>Im Happy to see you!</html>");
        topSide_JLabel.setOpaque(true); 
        topSide_JLabel.setBackground(Color.orange);
        this.add(topSide_JLabel);
    }


}
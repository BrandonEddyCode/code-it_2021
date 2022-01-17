package HomePage;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;

public class HomePage extends JPanel {

    TopSideHome topSideHome_Jpanel = new TopSideHome();
    JLabel welcomeText_topSideHome_JLabel = new JLabel(); //label with
    HomePadding homePadding_Jpanel = new HomePadding();
    JScrollPane homepaddinginside = new JScrollPane(homePadding_Jpanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    public HomePage(){ 
        this.setBackground(Color.RED);
        
        this.setLayout(new BorderLayout(10,10));
        makeHome();
        this.setVisible(false);
    }
    void makeHome(){
        this.add(topSideHome_Jpanel,BorderLayout.NORTH); 
        this.add(homepaddinginside);
    }
    

} 
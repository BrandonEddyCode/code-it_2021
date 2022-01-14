package HomePage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import WorkArea.SideBarMenuFunctions;


public class HomePadding extends JPanel{
    HomeFeed homeFeed_Jlabel = new HomeFeed();
    JLabel a = new JLabel();
    JLabel b = new JLabel();
    private String Text1 = "Use";
    private String Text2 = "Preview";
    JPanel mainPanel_homePadding;
  
  
    HomePadding(){
    paddingSettings();

        
    this.a.setPreferredSize(new Dimension(100,50));
   a.setOpaque(true);
   a.setBackground(Color.YELLOW);
   b.setLayout(new BorderLayout());
    this.b.setPreferredSize(new Dimension(100,50));
    b.setOpaque(true);
    b.setBackground(Color.yellow);
    JScrollBar hbar = new JScrollBar(JScrollBar.HORIZONTAL, 30, 20, 0, 500);
    JScrollBar vbar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500);


    b.add(hbar);
    b.add(vbar);


    this.add(a,BorderLayout.WEST);
    this.add(b,BorderLayout.EAST);

       
    }


    void paddingSettings(){
        homeFeed_Jlabel.setLayout(new BorderLayout());     
        JScrollPane scrollFrame = new JScrollPane(homeFeed_Jlabel);
        this.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension(800,300));
        this.add(scrollFrame);
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        this.setLayout(new BorderLayout(0,0));
    
        

// Main panel 

         mainPanel_homePadding = new JPanel( new FlowLayout(FlowLayout.CENTER, 10, 10) );
         mainPanel_homePadding.setBackground(Color.GRAY);
         
            
        // Panel 1

                JPanel panel = new JPanel();
                panel.setPreferredSize(new Dimension(150,150));
                panel.setBackground(Color.lightGray);
                panel.setLayout(new FlowLayout());
                panel.add(new JButton(Text1));
                panel.add(new JButton(Text2));
                mainPanel_homePadding.add(panel);
        
        // Panel 2

                JPanel panel2 = new JPanel();
                panel2.setPreferredSize(new Dimension(150,150));
                panel2.setBackground(Color.lightGray);
                panel2.setLayout(new FlowLayout());
                panel2.add(new JButton("Use"));
                panel2.add(new JButton("Preview"));
                mainPanel_homePadding.add(panel2);

        // Panel 3

                JPanel panel3 = new JPanel();
                panel3.setPreferredSize(new Dimension(150,150));
                panel3.setBackground(Color.lightGray);
                panel3.setLayout(new FlowLayout());
                panel3.add(new JButton("Use"));
                panel3.add(new JButton("Preview"));
                panel.setVerifyInputWhenFocusTarget(true);
                mainPanel_homePadding.add(panel3);

        this.add(mainPanel_homePadding);
        
        
}
 
   
    
    
}
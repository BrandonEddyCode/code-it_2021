package WorkArea;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
public class WorkArea extends JPanel {
    final SideBarMenu sideBarMenu = new SideBarMenu();
    final static JPanel centre_jPanel = new JPanel(new CardLayout());
    JPanel caso = new JPanel();
    BoardPanel boardPanel = new BoardPanel();



    public WorkArea(){
        
        
        this.setLayout(new BorderLayout());
        makeSideBarMenu();
        
    }
    void makeSideBarMenu(){
        this.add(sideBarMenu,BorderLayout.WEST);
        this.add(centre_jPanel,BorderLayout.CENTER);
        this.setBackground(Color.black);
        centre_jPanel.add(boardPanel);
        centre_jPanel.add(caso);
        centre_jPanel.setVisible(false);
    }
    
}

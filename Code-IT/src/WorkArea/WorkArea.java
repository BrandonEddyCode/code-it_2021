package WorkArea;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
public class WorkArea extends JPanel {
    final SideBarMenu sideBarMenu = new SideBarMenu();
    final BoardPanel boardPanel = new BoardPanel();


    public WorkArea(){
        
        this.setBackground(Color.RED);
        
        this.setLayout(new BorderLayout(10,10));
        makeSideBarMenu();
        this.setVisible(false);
    }
    void makeSideBarMenu(){
        this.add(sideBarMenu,BorderLayout.WEST);
    }
    
}

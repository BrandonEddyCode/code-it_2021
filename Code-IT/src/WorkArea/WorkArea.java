package WorkArea;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
public class WorkArea extends JPanel {
    final SideBarMenu sideBarMenu = new SideBarMenu();
    final static JPanel centre_jPanel = new JPanel(new CardLayout());
    JPanel caso = new JPanel();
    BoardPanel boardPanel = new BoardPanel();
    ImageIcon backGround = new ImageIcon(new ImageIcon("res/backGroundWorkArea.png").getImage().getScaledInstance(2000,  1100, Image.SCALE_DEFAULT));



    public WorkArea(){
        
        
        this.setLayout(new BorderLayout());
        
        makeSideBarMenu();
        
    }
    void makeSideBarMenu(){
        this.add(sideBarMenu,BorderLayout.WEST);
        this.add(centre_jPanel,BorderLayout.CENTER);
        
        centre_jPanel.add(boardPanel);
        centre_jPanel.add(caso);
        centre_jPanel.setVisible(false);
    }
    @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(backGround.getImage(), 0, 0, null);
}
    
}

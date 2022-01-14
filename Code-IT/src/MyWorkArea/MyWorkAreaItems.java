package MyWorkArea;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyWorkAreaItems extends JPanel {

    

    MyWorkAreaItems (String nameTab) {
        JLabel a = new JLabel(nameTab);
        a.setPreferredSize(new Dimension(200,200));
        a.setVisible(true);
        a.setOpaque(true);
        a.setBackground(Color.BLACK);
        this.add(a);
    }

}

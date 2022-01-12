package WorkArea;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

class BoardPanel extends JPanel {
    JPanel topSideBoardPanel;
    JPanel topSettingsBoardPanel;
    JPanel centreBoardPanel;

        BoardPanel(){
            topSideBoardPanel = new JPanel();
            topSettingsBoardPanel = new JPanel();
            centreBoardPanel = new JPanel();

            topSideBoardPanel.setBackground(Color.BLACK);
            topSettingsBoardPanel.setBackground(Color.blue);
            centreBoardPanel.setBackground(Color.GREEN);


            this.setLayout(new BorderLayout());
            this.add(topSideBoardPanel,BorderLayout.NORTH);
            this.add(centreBoardPanel,BorderLayout.CENTER);
        }
}
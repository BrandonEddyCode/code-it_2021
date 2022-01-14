package WorkArea;


import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import filesReadWrite.CreateFile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;


class BoardPanel extends JPanel{




    

    JPanel topSideBoardPanel;
    JPanel topSettingsBoardPanel;
    JPanel centreBoardPanel;


    //topsideBoard
    JPanel topSideBoardPanelTop = new JPanel();
    JPanel topSideBoardPanelBottom = new JPanel();
    //on top
    

    static JLabel boardNameText_JLabel = new JLabel();
    JButton infoBoardButton = new JButton();
    //on bottom
    static String descriptionText;
    static JTextField boardDescriptionText = new JTextField(20);
    JLabel emptySpace = new JLabel();


    //centreBoard
    JPanel centreBoardPanlTop = new JPanel();
    JTabbedPane tabs = new JTabbedPane();

    //Todo Panels

    //action
    Action action = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            CreateFile.writeFile(boardNameText_JLabel.getName(),"Board",boardDescriptionText.getText());
            
        }
    };

        BoardPanel(){
            
            //instances
            topSideBoardPanel = new JPanel(new BorderLayout());
            topSettingsBoardPanel = new JPanel();
            centreBoardPanel = new JPanel(new BorderLayout());


            //colors
            topSideBoardPanel.setBackground(Color.BLACK);
            topSettingsBoardPanel.setBackground(Color.blue);
            centreBoardPanel.setBackground(Color.GREEN);

            //settings
            this.setLayout(new BorderLayout());

            topSideBoardPanel.setPreferredSize(new Dimension(0,75));
            topSideBoardPanel.add(topSideBoardPanelTop,BorderLayout.NORTH);
            topSideBoardPanel.add(topSideBoardPanelBottom,BorderLayout.SOUTH);


            topSideBoardPanelSettings();
            centreBoardPanelSettings();

            
            
            

            

            this.add(topSideBoardPanel,BorderLayout.NORTH); //black
            this.add(centreBoardPanel,BorderLayout.CENTER); // green
            this.setVisible(false);
        }

        void topSideBoardPanelSettings(){
            

            topSideBoardPanelTop.setLayout(new BoxLayout(topSideBoardPanelTop, BoxLayout.X_AXIS));
            topSideBoardPanelBottom.setLayout(new GridLayout());


            topSideBoardPanelBottom.setPreferredSize(new Dimension(20,20));
            topSideBoardPanelTop.setPreferredSize(new Dimension(50,55));

            
            topSideBoardPanelTop.add(boardNameText_JLabel);
            topSideBoardPanelBottom.add(boardDescriptionText);
            topSideBoardPanelBottom.add(emptySpace);

         
            boardNameText_JLabel.setVerticalTextPosition(JLabel.BOTTOM);
            
            
            boardNameText_JLabel.setPreferredSize(new Dimension(250,100));
            boardNameText_JLabel.setFont(new Font("Commons",Font.BOLD,35));
            boardNameText_JLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
            boardNameText_JLabel.setVerticalAlignment(JLabel.NORTH);
            infoBoardButton.setPreferredSize(new Dimension(2,2));
            infoBoardButton.setAlignmentX(JLabel.RIGHT);
            topSideBoardPanelTop.add(infoBoardButton);

            boardDescriptionText.setPreferredSize(new Dimension(50,25));
            boardDescriptionText.setBackground(Color.LIGHT_GRAY);
            boardDescriptionText.addActionListener(action);
            
            emptySpace.setPreferredSize(new Dimension(50,25));
            
            
            



        }
        static void setBoardName(String Name){
            boardNameText_JLabel.setName(Name);
            boardNameText_JLabel.setText(Name);
        }
        static void setBoardDescription(String Description){
            
            boardDescriptionText.setText(Description);
        }

        //a new item every tab need to separate other class for each
        void centreBoardPanelSettings(){
            JPanel one = new JPanel(); // temporary
            JPanel two = new JPanel();// temporary
            tabs.addTab("Main Table", one);
            tabs.addTab("Graphic", two);
            centreBoardPanel.add(tabs);
        }
}
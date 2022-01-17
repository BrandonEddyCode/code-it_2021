package WorkArea;


import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


import filesReadWrite.CreateFile;
import filesReadWrite.ReadFile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.Image;


class BoardPanel extends JPanel{
    BoardMainTab mainCard = new BoardMainTab();



    

    JPanel topSideBoardPanel;
    JPanel topSettingsBoardPanel;
    JPanel centreBoardPanel;


    //topsideBoard
    JPanel topSideBoardPanelTop = new JPanel();
    JPanel topSideBoardPanelBottom = new JPanel();
    //on top
    
    ImageIcon preferiteStartIcon = new ImageIcon(new ImageIcon("res/Star.png").getImage().getScaledInstance(20,  20, Image.SCALE_DEFAULT));

    static JLabel boardNameText_JLabel = new JLabel();
    static JLabel boardPreferiteButton_Jlabel = new JLabel();
    JButton favouriteTabButton = new JButton(preferiteStartIcon);
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
            
            CreateFile.writeFile(boardNameText_JLabel.getName(),
            ReadFile.readFile(BoardMainTab.currentSelected,"group"),
            "Board",boardDescriptionText.getText(),
            ReadFile.readFile(BoardMainTab.currentSelected, "tabs"),
            ReadFile.readFile(BoardMainTab.currentSelected, "task"),
            ReadFile.readFile(BoardMainTab.currentSelected, "status"),
            ReadFile.readFile(BoardMainTab.currentSelected, "Date"),
            ReadFile.readFile(GroupElements.currentSelected, "deadline"),
            ReadFile.readFile(GroupElements.currentSelected, "People"),
            ReadFile.readFile(GroupElements.currentSelected, "checkbox"),
            ReadFile.readFile(GroupElements.currentSelected, "numbers"),
            ReadFile.readFile(GroupElements.currentSelected, "Text"));
            
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

            topSideBoardPanel.setPreferredSize(new Dimension(0,85));
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
            topSideBoardPanelTop.setPreferredSize(new Dimension(50,65));
            topSideBoardPanelTop.setAlignmentX(JLabel.LEFT_ALIGNMENT);
            topSideBoardPanelTop.setAlignmentY(JLabel.TOP_ALIGNMENT);
            
            topSideBoardPanelTop.add(boardNameText_JLabel);
            topSideBoardPanelTop.add(boardPreferiteButton_Jlabel);

            topSideBoardPanelBottom.add(boardDescriptionText);
            topSideBoardPanelBottom.add(emptySpace);

         
            boardNameText_JLabel.setVerticalTextPosition(JLabel.BOTTOM);
            boardNameText_JLabel.setOpaque(true);
            
            boardNameText_JLabel.setBounds(0,0,50,55);
            
            //boardNameText_JLabel.setPreferredSize(new Dimension(250,100));
            boardNameText_JLabel.setFont(new Font("Commons",Font.BOLD,35));
           // boardNameText_JLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
            boardNameText_JLabel.setVerticalAlignment(JLabel.NORTH);

            boardPreferiteButton_Jlabel.setBounds(0,0,50,55);
            //boardPreferiteButton_Jlabel.setSize(new Dimension(50,55));
            boardPreferiteButton_Jlabel.setText("     ");
            boardPreferiteButton_Jlabel.setHorizontalTextPosition(JLabel.CENTER);
            boardPreferiteButton_Jlabel.setFont(new Font("Commons",Font.BOLD,35));
            
            
            favouriteTabButton.setIcon(preferiteStartIcon);
            favouriteTabButton.setBounds(10,10,25,27);
            favouriteTabButton.setOpaque(true);
            favouriteTabButton.setContentAreaFilled(false);
            favouriteTabButton.addActionListener(e -> setFavouriteTab());
            boardPreferiteButton_Jlabel.add(favouriteTabButton);
            
            
            

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
            
            JPanel two = new JPanel();// temporary
            tabs.addTab("Main Table", mainCard);
            tabs.addTab("Graphic", two);
            centreBoardPanel.add(tabs);
        }
        void setFavouriteTab(){

            //TODO i have to make preferite
            /*
            CreateFile.writeFile(GroupElements.currentName,
             ReadFile.readFile(GroupElements.currentSelected, "group"),
              ReadFile.readFile(GroupElements.currentSelected, "type"),
               ReadFile.readFile(GroupElements.currentSelected, "Description"),
               ReadFile.readFile(GroupElements.currentSelected, "tabs"),
               ReadFile.readFile(GroupElements.currentSelected, "task"));

            ;
            */
        }
}
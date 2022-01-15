package WorkArea;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.awt.Frame;

import filesReadWrite.CreateFile;
import filesReadWrite.ReadFile;

final class WorkArea_AddWorkArea extends JFrame{
    final JPanel workArea_MainPanel = new JPanel();
    final JPanel workArea_MainPanel_Centre = new JPanel(new CardLayout());
    final JButton newBoard_JButton = new JButton();
    final JButton newWorkArea_JButton = new JButton();
    final JPanel makeNewBoard_JPanel = new JPanel();
    final JPanel makeNewWorkArea_JPanel = new JPanel();

    WorkArea_AddWorkArea(){
        setBounds(400,200,467,315);
        setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);


        

        this.add(workArea_MainPanel_Centre);
        //to centre

        //new board button
        newBoard_JButton.setText("New Board");
        newBoard_JButton.addActionListener(e -> setVisibleNewBoardPanel());
        //newworkarea button
        newWorkArea_JButton.setText("New WorkArea");
        newWorkArea_JButton.addActionListener(e -> setVisibleNewWorkAreaPanel());


        //buttons on the main panel.
        workArea_MainPanel.add(newBoard_JButton);
        workArea_MainPanel.add(newWorkArea_JButton);


        //lables on the centre Cards.
        workArea_MainPanel_Centre.add(workArea_MainPanel);
        workArea_MainPanel_Centre.add(makeNewBoard_JPanel);
        workArea_MainPanel_Centre.add(makeNewWorkArea_JPanel);
        
        //colors
        workArea_MainPanel.setBackground(Color.BLACK);
        makeNewBoard_JPanel.setBackground(Color.blue);

        makeNewBoard_JPanel.setVisible(false);
        makeNewWorkArea_JPanel.setVisible(false);

        makeNewBoardPanel();
        makeNewWorkAreaPanel();

       

        
        
        WindowListener listener = new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
            Frame frame = (Frame) evt.getSource();
            System.out.println("Closing = "+frame.getTitle());
            newBoard_JButton.setVisible(true);
            newWorkArea_JButton.setVisible(true);
            workArea_MainPanel.setVisible(true);
            makeNewWorkArea_JPanel.setVisible(false);
            makeNewBoard_JPanel.setVisible(false);
            }
        };
        addWindowListener(listener);
        
    }
    
    void makeNewBoardPanel(){
        //for  makeNewBoard_Jpanel
        final JLabel textMakeBoard = new JLabel();
        final JLabel textNameBoard = new JLabel();
        final JTextField nameBoard = new JTextField();

        final JButton makeBoardButton_jButton = new JButton();
        final JButton cancelButton = new JButton();

        textMakeBoard.setText("Create Board");
       
        nameBoard.setText("new Board");
        textNameBoard.setText("Board Name");
        makeBoardButton_jButton.setText("Create Board");
        cancelButton.setText("Cancel");

        cancelButton.addActionListener(e -> CancelButton());
        makeBoardButton_jButton.addActionListener(e -> createBoard(nameBoard.getText()));
        
        makeNewBoard_JPanel.add(textMakeBoard);
        makeNewBoard_JPanel.add(textNameBoard);
        makeNewBoard_JPanel.add(nameBoard);
        makeNewBoard_JPanel.add(makeBoardButton_jButton);
        makeNewBoard_JPanel.add(cancelButton);

    }
    void makeNewWorkAreaPanel(){
        //for  makeNewBoard_Jpanel
        final JLabel textMakeWorkArea = new JLabel();
        final JLabel textNameWorkArea = new JLabel();
        final JTextField nameWorkArea = new JTextField();

        final JButton makeWorkAreaButton_jButton = new JButton();
        final JButton cancelButton = new JButton();

        textMakeWorkArea.setText("Create WorkArea");
       
        nameWorkArea.setText("new WorkArea");
        textNameWorkArea.setText("WorkArea Name");
        makeWorkAreaButton_jButton.setText("Create WorkArea");
        cancelButton.setText("Cancelaa");

        cancelButton.addActionListener(e -> CancelButton());
        makeWorkAreaButton_jButton.addActionListener(e -> createWorkArea(nameWorkArea.getText()));
        
        makeNewWorkArea_JPanel.add(textMakeWorkArea);
        makeNewWorkArea_JPanel.add(textNameWorkArea);
        makeNewWorkArea_JPanel.add(nameWorkArea);
        makeNewWorkArea_JPanel.add(makeWorkAreaButton_jButton);
        makeNewWorkArea_JPanel.add(cancelButton);
        
    }
    void CancelButton(){
        newBoard_JButton.setVisible(true);
        newWorkArea_JButton.setVisible(true);
        workArea_MainPanel.setVisible(true);
        makeNewWorkArea_JPanel.setVisible(false);
        makeNewBoard_JPanel.setVisible(false);
    }
    void setVisibleNewBoardPanel(){
        newBoard_JButton.setVisible(false);
        workArea_MainPanel.setVisible(false);
        makeNewBoard_JPanel.setVisible(true);
    }
    void createBoard(String text){
        if (!(ReadFile.getAllFolders().isEmpty())) {
        //this will create boards.
        CreateFile.createFile(text);
        CreateFile.writeFile(text,"1:default","Board","no Description","1:DefaultTab");
        
        SideBarMenuFunctions.addItemsToSecondSide(text);
        SideBarMenuFunctions.repaintThis();
        this.dispose();
        }
        else {
            JFrame error = new JFrame();
            JOptionPane.showMessageDialog(error,
              "You Need To create A WorkArea First.",
              "Inane error",
              JOptionPane.ERROR_MESSAGE);
        }
    }

    void createWorkArea(String WorkArea){
        CreateFile.createFolder(WorkArea); 
        SideBarMenuFunctions.comboBox_JComboBox.addItem(WorkArea);
       
    }
    void setVisibleNewWorkAreaPanel(){
        newBoard_JButton.setVisible(false);
        workArea_MainPanel.setVisible(false);
        makeNewWorkArea_JPanel.setVisible(true);
    }

}
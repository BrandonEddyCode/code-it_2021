package WorkArea;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;

import filesReadWrite.*;


import java.util.HashSet;

public final class SideBarMenuFunctions extends JPanel implements ActionListener{


    
    
    JPanel firstHalfSideJPanel = new JPanel();
    public static JPanel secondHalfSidPanel = new JPanel();
    static JPanel secondHalfContent = new JPanel();
    static JPanel secondHalfCenter = new JPanel();
    //on first
    static JComboBox<String> comboBox_JComboBox = new JComboBox<>();
    public static String comboBox_JComboBoxSelection = (String) comboBox_JComboBox.getSelectedItem();
    JButton workAreaAdd_JButton = new JButton();

    //on second

    JScrollPane scrollPane = new JScrollPane(secondHalfContent,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JLabel items = new JLabel(); // this just an example
    WorkArea_AddWorkArea addWorkArea;
    

    //files
    static HashSet<String> files_jlabelNames = new HashSet<String>();
    static HashSet<String> workAreaListDirectory = new HashSet<>();
    static Items files_JLabel;
    //static JLabel files_JLabel;


    SideBarMenuFunctions(){
        
        setBackground(Color.MAGENTA);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        firstHalfSideJPanel.setSize(new Dimension(50,50));
        secondHalfContent.setLayout(new BoxLayout(secondHalfContent, BoxLayout.PAGE_AXIS));
        firstHalfSideJPanel.setLayout(new BoxLayout(firstHalfSideJPanel,BoxLayout.PAGE_AXIS));
        add(firstHalfSideJPanel);
        add(secondHalfSidPanel);

        workAreaListDirectory = ReadFile.getAllFolders();
        
        
        
        for (String items : workAreaListDirectory){
            comboBox_JComboBox.addItem(items);
            
           
        }
        
        
        firstHalfSideJPanel.add(comboBox_JComboBox);
        comboBox_JComboBox.setPreferredSize(new Dimension(200,20));
        comboBox_JComboBox.addActionListener(this);

        firstHalfSideJPanel.add(workAreaAdd_JButton);
        workAreaAdd_JButton.setText("+ Add");
        workAreaAdd_JButton.addActionListener(e -> addNewAreaSettings());

        //this.add();

        //here will effectvly add all the items that will rappresent the files in json.
        //this just an example
        items.setSize(new Dimension(10,10));
        items.setText("<html>Welcome back!<br/>Select A WorkArea</html>");
        secondHalfSidPanel.setLayout(new BorderLayout());
        secondHalfSidPanelSettings();
        
        addItemsToSecondSide("");
        secondHalfSidPanel.repaint();
        secondHalfSidPanel.revalidate();
        
        
    }
    void secondHalfSidPanelSettings(){
        secondHalfContent.add(items);
        
        secondHalfSidPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPane.setPreferredSize(new Dimension(450, 450));
        
        
        
        //secondHalfContent.setBounds(10, 11, 464, 439);
        
        secondHalfSidPanel.add(scrollPane,BorderLayout.SOUTH);
       
        
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox_JComboBox){
        // TODO Auto-generated method stub
        //System.out.println(comboBox_JComboBox.getSelectedItem());
        comboBox_JComboBoxSelection = (String) comboBox_JComboBox.getSelectedItem();
        System.out.println(comboBox_JComboBoxSelection);
        secondHalfContent.removeAll();
        files_jlabelNames.clear();
        secondHalfSidPanelSettings();
        addItemsToSecondSide("");
        
        repaintThis();

        }
    }
    void addNewAreaSettings(){ 
        if(addWorkArea == null){
            addWorkArea = new WorkArea_AddWorkArea();
        }
        addWorkArea.setVisible(true);
        addWorkArea.workArea_MainPanel.setVisible(true);
        addWorkArea.makeNewBoard_JPanel.setVisible(false);
        addWorkArea.newBoard_JButton.setVisible(true);
    }
    static void addItemsToSecondSide(String newFilename){
        
        if (comboBox_JComboBoxSelection != null) {
        File folder = new File("files/" + comboBox_JComboBoxSelection + "/");   
       
        HashSet<String> files = ReadFile.getReadAllFilesName(folder);

        for (final String file : files){
           // if(files_JLabel.getName() == file) {}
           if (ReadFile.readFile("files/" + SideBarMenuFunctions.comboBox_JComboBoxSelection + "/" +file+ ".csv","fileType") != "nodata")
           if(!(files_jlabelNames.contains(file))) {

            files_JLabel = new Items(file);

            secondHalfContent.add(files_JLabel);
            
            files_jlabelNames.add(file);
            if(newFilename != null && newFilename != "") {
                
                files_jlabelNames.add(newFilename);
            }
            System.out.println("I added this item in the halfmenu - : " + files_JLabel.getName());
           }
        }}
    }
    static void repaintThis(){
        secondHalfSidPanel.repaint();
        secondHalfSidPanel.revalidate();
    }
}

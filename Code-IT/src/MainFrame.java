import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import HomePage.HomePage;
import WorkArea.BoardMainTab;
import WorkArea.WorkArea;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFileChooser;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import MyWorkArea.*;


class MainFrame extends JFrame{
    String data;
    JPanel mainFrame = new JPanel(); //this is the actual Mainframe , invisible panel where all the elements will bi attached
    JPanel centre = new JPanel(new CardLayout());
    StartupVideo intro_Jlabel = new StartupVideo(); // startup video component reference
    SideBar leftSideBar = new SideBar(); //this is the left side bar with all the buttons
   // SideBarMenu leftSideBarMenu = new SideBarMenu(); //?? i dont remember
    HomePage homePage = new HomePage(); // this is the homepage
    WorkArea workArea = new WorkArea(); // this is the workArea Page
    MyWork myWork = new MyWork();
    

    Boolean useStartupVideo = false; // setting if want to use the initial video


    Action exportFileAction = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            

            if(BoardMainTab.currentSelected != null){

            JFileChooser chooser = new JFileChooser();
            int result = chooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    
                    File dataObj = new File(BoardMainTab.currentSelected);
                    try (Scanner dataScanner = new Scanner(dataObj)) {
                        while (dataScanner.hasNextLine()) {
                            data = dataScanner.nextLine();
                            //System.out.println(data);
                        }
                    }
                    
                    File file = chooser.getSelectedFile();
                    FileWriter writer = new FileWriter(file);
                    writer.write(data);
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }else {
            JFrame error = new JFrame();
            JOptionPane.showMessageDialog(error,
              "You Need To Select A Board First!",
              "Inane error",
              JOptionPane.ERROR_MESSAGE);
        }
    }
    };

    /**
     * MainFrame Constructor. it it will be the main winwow where all the components
     * will be attached to it.
     */

    MainFrame() {

        

        this.setVisible(true); // make the frame visible when inizialized
        this.setTitle("Code-it"); // set the window name
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this is necessary to closing the window.

        this.setMinimumSize(new Dimension(1280, 720)); // just a mininum size
        intro_Jlabel.setLocation(700,500);
        this.add(intro_Jlabel); // add the intro compotent

            //little if statement to use or not the initial video
        if (useStartupVideo) {
            startupVideo();
        } else {
            main();
        }
        // call the startup method
    }

    /*
     * startup method:
     * it will instantiate a ActionListener to be used as parameter for a timer of
     * 5000ms
     * the timer will run the action of the actionlistener after 5000ms.
     * what this essentialy do. is adding an initial video when open the program
     * then remove the intro component after 50000 second.
     */
    void startupVideo() {

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // ...Perform a task...
                stopStartupVideo();
            }
        };
        Timer timer = new Timer(6500, taskPerformer);
        timer.setRepeats(false);
        timer.start();
    }

    // this method is called when the startupvideo is finish and will call a main
    // method
    void stopStartupVideo() {
        this.remove(intro_Jlabel); // remove intro componet
        main();

    }
    //a initial method.
    void main() {
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.repaint(); // refresh the window
        this.add(mainFrame); // the actual main frame panel added
        mainFrame.setBackground(Color.BLACK); // make the mainframe black
        

        JMenuBar menuBar = new JMenuBar();

        JMenu save = new JMenu("File");
        JMenuItem exportItem = new JMenuItem("Export");
        exportItem.addActionListener(exportFileAction);
       



        menuBar.add(save);
        save.add(exportItem);

        this.setJMenuBar(menuBar);
        mainFrame.setLayout(new BorderLayout()); //use the borderlayout manager
        mainFrame.add(leftSideBar, BorderLayout.LINE_START); // left side bar added.
       // mainFrame.add(leftSideBarMenu, BorderLayout.CENTER);
        mainFrame.add(centre); // this is the centre of the screen / by default is BorderLayout.center
        centre.add(homePage); //homepage added 
        centre.add(workArea); // work area page added 
        centre.add(myWork);
        
    
        
        sideBarButtonsListeners(); //call the method to add listeners
        leftSideBar.setVisible(true); //i mean.. 
        this.pack();
    }


    // method to add eventlistener to the buttons of the sidebar
    void sideBarButtonsListeners(){
        leftSideBar.button.addActionListener(e -> switchhomes(homePage));
        leftSideBar.button2.addActionListener(e -> switchhomes(workArea));
        leftSideBar.button3.addActionListener(e -> switchhomes(myWork));
        
    }


    // mainpage switcher
    void switchhomes(JPanel Panel){
        homePage.setVisible(false);
        workArea.setVisible(false);
        myWork.setVisible(false);
        Panel.setVisible(true);
    }
    void exportFile(){

    }
   
}

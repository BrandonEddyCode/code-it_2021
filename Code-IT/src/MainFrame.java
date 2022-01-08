import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import HomePage.HomePage;
import WorkArea.WorkArea;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

class MainFrame extends JFrame{
    JPanel mainFrame = new JPanel(); //this is the actual Mainframe , invisible panel where all the elements will bi attached
    JPanel centre = new JPanel(new CardLayout());
    StartupVideo intro_Jlabel = new StartupVideo(); // startup video component reference
    SideBar leftSideBar = new SideBar(); //this is the left side bar with all the buttons
   // SideBarMenu leftSideBarMenu = new SideBarMenu(); //?? i dont remember
    HomePage homePage = new HomePage(); // this is the homepage
    WorkArea workArea = new WorkArea(); // this is the workArea Page
    

    Boolean useStartupVideo = false; // setting if want to use the initial video

    /**
     * MainFrame Constructor. it it will be the main winwow where all the components
     * will be attached to it.
     */

    MainFrame() {

        

        this.setVisible(true); // make the frame visible when inizialized
        this.setTitle("Code-it"); // set the window name
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH); // maximize the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this is necessary to closing the window.

        this.setMinimumSize(new Dimension(1280, 720)); // just a mininum size
        
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
        Timer timer = new Timer(5000, taskPerformer);
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
        
        this.repaint(); // refresh the window
        this.add(mainFrame); // the actual main frame panel added
        mainFrame.setBackground(Color.BLACK); // make the mainframe black
        
        mainFrame.setLayout(new BorderLayout()); //use the borderlayout manager
        mainFrame.add(leftSideBar, BorderLayout.LINE_START); // left side bar added.
       // mainFrame.add(leftSideBarMenu, BorderLayout.CENTER);
        mainFrame.add(centre); // this is the centre of the screen / by default is BorderLayout.center
        centre.add(homePage); //homepage added 
        centre.add(workArea); // work area page added 
        
    
        
        sideBarButtonsListeners(); //call the method to add listeners
        leftSideBar.setVisible(true); //i mean.. 
        this.pack();
    }


    // method to add eventlistener to the buttons of the sidebar
    void sideBarButtonsListeners(){
        leftSideBar.button.addActionListener(e -> switchhomes(homePage));
        leftSideBar.button2.addActionListener(e -> switchhomes(workArea));
        leftSideBar.button3.addActionListener(e -> switchhomes(null));
        leftSideBar.button4.addActionListener(e -> switchhomes(null));
        leftSideBar.button5.addActionListener(e -> switchhomes(null));
    }


    // mainpage switcher
    void switchhomes(JPanel Panel){
        homePage.setVisible(false);
        workArea.setVisible(false);
        Panel.setVisible(true);
    }
   
}

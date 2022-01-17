import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;

class StartupVideo extends JLabel{
    ImageIcon video = new ImageIcon(new ImageIcon("res/test.gif").getImage().getScaledInstance(1280,  720, Image.SCALE_DEFAULT));
    StartupVideo(){
        
        this.setIcon(video);
    }
}
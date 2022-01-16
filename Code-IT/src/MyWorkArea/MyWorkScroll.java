package MyWorkArea;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class MyWorkScroll extends JPanel {

MyWork myWork = new MyWork();
JScrollPane myScrollPane = new JScrollPane(myWork, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


public MyWorkScroll () {
this.setLayout(new BorderLayout());
this.add(myScrollPane);

}
    
}

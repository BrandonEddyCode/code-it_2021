package WorkArea;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.HashMap;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;


import filesReadWrite.CreateFile;
import filesReadWrite.ReadFile;

public class DatePicker extends JFrame{

    JDatePickerImpl datePicker;
    HashMap<String,String> dateMap = new HashMap<>();
    private String filteredMap;
    private String finalFilteredMap;

    DatePicker(HashMap<String,String> date, String current,int whatdate){
        
        setBounds(400,200,400,150);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        dateMap = date;
        SqlDateModel model = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.day", "Day");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl panel = new JDatePanelImpl(model,p);
        datePicker = new JDatePickerImpl(panel, new AbstractFormatter() {

            
                

                @Override
                public Object stringToValue(String text) throws ParseException {
                    // TODO Auto-generated method stub
                    
                    return "";
                }
        
                @Override
                public String valueToString(Object value) throws ParseException {
                    // TODO Auto-generated method stub
                    if(value != null) {
                    Calendar cal = (Calendar) value;
                    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                    String strDate = format.format(cal.getTime());
                        if( whatdate == 1){
                        
                        dateMap.replace(current, dateMap.get(current), strDate);

                        filteredMap =  dateMap.toString().replaceAll("[{},]","");
                        finalFilteredMap = filteredMap.replace("=", ":");


                        CreateFile.writeFile(GroupElements.currentName,
                        ReadFile.readFile(GroupElements.currentSelected, "group"),
                        ReadFile.readFile(GroupElements.currentSelected, "fileType"),
                        ReadFile.readFile(GroupElements.currentSelected, "description"),
                        ReadFile.readFile(GroupElements.currentSelected, "tabs"),
                        ReadFile.readFile(GroupElements.currentSelected, "task"),
                        ReadFile.readFile(GroupElements.currentSelected, "status"),
                        finalFilteredMap,
                        ReadFile.readFile(GroupElements.currentSelected, "deadline"),
                        ReadFile.readFile(GroupElements.currentSelected, "People"),
                        ReadFile.readFile(GroupElements.currentSelected, "checkbox"),
                        ReadFile.readFile(GroupElements.currentSelected, "numbers"),
                        ReadFile.readFile(GroupElements.currentSelected, "Text")); // 1 : date
                        GroupTabs.takeTabsFromFile();
                    return strDate;
                        }
                        else if( whatdate == 2){
                        
                            dateMap.replace(current, dateMap.get(current), strDate);
    
                            filteredMap =  dateMap.toString().replaceAll("[{},]","");
                            finalFilteredMap = filteredMap.replace("=", ":");
    
    
                            CreateFile.writeFile(GroupElements.currentName,
                            ReadFile.readFile(GroupElements.currentSelected, "group"),
                            ReadFile.readFile(GroupElements.currentSelected, "fileType"),
                            ReadFile.readFile(GroupElements.currentSelected, "description"),
                            ReadFile.readFile(GroupElements.currentSelected, "tabs"),
                            ReadFile.readFile(GroupElements.currentSelected, "task"),
                            ReadFile.readFile(GroupElements.currentSelected, "status"),
                            ReadFile.readFile(GroupElements.currentSelected, "Date"),
                            finalFilteredMap,
                            ReadFile.readFile(GroupElements.currentSelected, "People"),
                            ReadFile.readFile(GroupElements.currentSelected, "checkbox"),
                            ReadFile.readFile(GroupElements.currentSelected, "numbers"),
                            ReadFile.readFile(GroupElements.currentSelected, "Text")); // 1 : date
                            GroupTabs.takeTabsFromFile();
                        return strDate;
                            }
                } return "";
                    
                    
                } });
        this.add(datePicker);


        this.pack();
    }
    
}

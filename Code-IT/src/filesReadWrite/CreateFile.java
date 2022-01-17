package filesReadWrite;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



import WorkArea.SideBarMenuFunctions;


public class CreateFile {
    public static void createFile(String filename){
        try {
            File myObj = new File("files/" + SideBarMenuFunctions.comboBox_JComboBoxSelection + "/" + filename + ".csv");
            if (myObj.createNewFile()) {
                System.out.println("File Created: " + myObj.getName());

            } else {
                System.out.println("File already exist.");
            }
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public static void writeFile(String filename,String group,String Type,String Description,String Tabs,String Task,String Status,String Date,String DeadLine,String People,String CheckBox,String Numbers,String Text){
        try {
            FileWriter myWriter = new FileWriter("files/" + SideBarMenuFunctions.comboBox_JComboBoxSelection + "/" + filename + ".csv",false);
            myWriter.write("Type,");
            myWriter.write("Name,");
            myWriter.write("tabs,");
            myWriter.write("Group,");
            myWriter.write("task,");
            myWriter.write("Status,");
            myWriter.write("Date,");
            myWriter.write("Text,");
            myWriter.write("Numbers,");
            myWriter.write("Checkbox,");
            myWriter.write("People,");
            myWriter.write("DeadLine,");
            myWriter.write("Description,");
            myWriter.write("favourite");
           
            myWriter.write("\n"+Type+","); // type
            myWriter.write(filename+","); //filename
            myWriter.write(Tabs + ","); //options
            myWriter.write(group + ","); //group
            myWriter.write(Task +",");
            myWriter.write(Status + ","); //status 
            myWriter.write(Date+","); // date 
            myWriter.write(Text+","); // text
            myWriter.write(Numbers +","); //numbers
            myWriter.write(CheckBox + ","); //checkbox
            myWriter.write(People+ ","); //people
            myWriter.write(DeadLine+","); //deadline
            myWriter.write(Description + ","); //Description
            myWriter.write("false,");
            
            myWriter.close();
            System.out.println("i successfully write");

        } catch (IOException e){
            System.out.println("an error occured.");
            e.printStackTrace();
        }
    }

    public static void createFolder(String workArea){
        File newDirectory = new File("files/"+workArea);
        if (!newDirectory.exists()){
            newDirectory.mkdirs();
            
        }
        
    }
}

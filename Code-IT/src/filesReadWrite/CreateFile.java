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

    public static void writeFile(String filename,String Type){
        try {
            FileWriter myWriter = new FileWriter("files/" + SideBarMenuFunctions.comboBox_JComboBoxSelection + "/" + filename + ".csv");
            myWriter.write("Type,");
            myWriter.write("Name,");
            myWriter.write("Options,");
            myWriter.write("\n"+Type+",");
            myWriter.write(filename+",");
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
            System.out.println("x");
        }
        
    }
}

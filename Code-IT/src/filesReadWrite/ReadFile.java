package filesReadWrite;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;




//todo , muste read files from the folder file and check wich file have the name of file.
public class ReadFile {
    public static String data;
    public static HashSet<String> files = new HashSet<String>();
    static String fileType;

    public static HashSet<String> getReadAllFilesName(final File folder){
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                    getReadAllFilesName(fileEntry);
                    
            } else {
                
                String fileName = fileEntry.getName();
                
                String finalName = fileName.replace(".csv", "");
                //System.out.println(fileEntry.getName());
                files.add(finalName);
                //System.out.println(files);
                
            }
        }
        
        return files;
    }
   
    public static HashSet<String> getAllFolders(){
        HashSet<String> folders = new HashSet<>();
        File dir = new File("files");
        File[] files = dir.listFiles();
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        files = dir.listFiles(fileFilter);
        if (files.length == 0) {
            //System.out.println("Either dir does not exist or is not a directory");
         } else {
            for (int i = 0; i< files.length; i++) {
               File filename = files[i];
               String trim = filename.toString().replace("files\\", "");
               folders.add(trim);
               
            }
         }
         return folders;
         
    }

    public static String readFile(String filename,String WhatReturn){
        
        
        
        try {
            File dataObj = new File(filename);
            //for the second scanner
            File typeObj = new File(filename);

            //this read all the files
            Scanner dataScanner = new Scanner(dataObj);
            //this read the type of the file
            Scanner typeScanner = new Scanner(typeObj);
            typeScanner.useDelimiter(",|\\n");

            //first scanner
            while (dataScanner.hasNextLine()) {
                data = dataScanner.nextLine();
                //System.out.println(data);
            }
            //secondScanner
            typeScanner.nextLine();
            
            fileType = typeScanner.next();
            //close Scanners
            switch(WhatReturn){
                case "data":
                dataScanner.close();
                typeScanner.close();
                return data;
                case "fileType":
                dataScanner.close();
                typeScanner.close();
                return fileType;
                case "fileName":
                fileType = typeScanner.next();
                dataScanner.close();
                typeScanner.close();
                return fileType;
                case "options":
                typeScanner.next();
                fileType = typeScanner.next();
                dataScanner.close();
                typeScanner.close();
                return fileType;
                case "group":
                typeScanner.next();
                typeScanner.next();
                fileType = typeScanner.next();
                dataScanner.close();
                typeScanner.close();
                return fileType;
                case "Status":
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                fileType = typeScanner.next();
                dataScanner.close();
                typeScanner.close();
                return fileType;
                case "Date":
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                fileType = typeScanner.next();
                dataScanner.close();
                typeScanner.close();
                return fileType;
                case "Text":
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                fileType = typeScanner.next();
                dataScanner.close();
                typeScanner.close();
                return fileType;
                case "numbers":
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                fileType = typeScanner.next();
                dataScanner.close();
                typeScanner.close();
                return fileType;
                case "checkbox":
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                fileType = typeScanner.next();
                dataScanner.close();
                typeScanner.close();
                return fileType;
                case "description":
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                typeScanner.next();
                fileType = typeScanner.next();
                
                dataScanner.close();
                typeScanner.close();
                return fileType;
                
            }

            dataScanner.close();
            typeScanner.close();
            

            //System.out.println(fileType);
            
        } catch (FileNotFoundException e ){
            
        } 

        
        return "nodata";
    }
}

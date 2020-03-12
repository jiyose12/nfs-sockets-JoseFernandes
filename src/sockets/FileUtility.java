package sockets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FileUtility {

    public FileUtility() {
    }

    String basePath = "C:\\Users\\Jiyose\\Documents\\Jiyose Dell\\teste_nfs";

    public ArrayList listFiles(ArrayList myList){
        try (Stream<Path> paths = Files.walk(Paths.get(this.basePath))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(item->myList.add(item));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myList;
    }

    public boolean renameFile(String oldName, String newName){
        File f1 = new File(this.basePath + oldName + ".txt");
        File f2 = new File(this.basePath + newName + ".txt");
        return f1.renameTo(f2);
    }

    public boolean createFile(String newFile) throws IOException {

            File myObj = new File(this.basePath + newFile + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                System.out.println("Absolute path: " + myObj.getAbsolutePath());

                return true;
            }
            return false;
    }

    public boolean deleteFile(String deletedFile) throws IOException {

//        Path fileToDeletePath = Paths.get(this.basePath + deletedFile + ".txt");
//        try {
//            Files.delete(fileToDeletePath);
//                return true;
//        }
//        catch (IOException e){
//            return false;
//        }
        File myObj = new File(this.basePath + deletedFile + ".txt");
        if (myObj.delete()) {
            System.out.println("File deleted: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());

            return true;
        }
        return false;
    }

}
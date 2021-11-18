import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    //stringList.add("memberID;name;birthday;active;restance");

    private final File swimResults;
    private final File members;


    FileHandler(String pathSwimResults, String pathMembers){
        this.swimResults = new File(pathSwimResults);
        this.members = new File(pathMembers);
    }

    public ArrayList<String> loadSwimResults(){
        return loadFromSave(swimResults);
    }
    public ArrayList<String> loadMembers(){
        return loadFromSave(members);
    }

    private ArrayList<String> loadFromSave(File file){
        ArrayList<String> stringList = new ArrayList<>();

        try {
            FileInputStream fileHandler = new FileInputStream(file);
            Scanner scanner = new Scanner(fileHandler);

            scanner.nextLine(); // To get header removed

            while (scanner.hasNextLine()){
                stringList.add(scanner.nextLine());
            }
        }
        catch (Exception e){
            System.out.println("failed");
        }

     return stringList;
    }



}

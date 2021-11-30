import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

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
            System.out.println("Failed Saving");
        }

        return stringList;
    }

    public void saveSwimResults(ArrayList<String> toFile){
        // Header for swimResult.
        toFile.add(0,"memberID;name;date;time;type;isJunior;competitionName;position");
        saveList(swimResults, toFile);
    }
    public void saveMemberList(ArrayList<String> toFile){
        // Header for member.
        toFile.add(0,"memberID;name;birthday;active;restance;memberType;SwimTypes");
        saveList(members, toFile);
    }
    private void saveList(File file, ArrayList<String> toFile){
        try {
            PrintStream save = new PrintStream(file);

            for (int i = 0; i < toFile.size(); i++){
                save.println(toFile.get(i));
            }
        }

        catch (Exception e){
            System.out.println("Failed Saving file");
        }
    }

}

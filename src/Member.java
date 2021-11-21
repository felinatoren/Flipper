import java.util.ArrayList;
import java.util.Scanner;

public abstract class Member {

    public int memberID;
    public  String name;
    public String birthday;
    public boolean active;
    public int restance;



    Member(String name, String birthday){
        this.name = name;
        this.birthday = birthday;

        //todo lavet en ordentlig måde at få et unikt memberID til hvert person.
        this.memberID = 0;

        // A new member always starts out as with no dept and active set to true.
        this.restance = 0;
        this.active = true;
    }
    Member(String fromFile){
        Scanner scanner = new Scanner(fromFile);
        scanner.useDelimiter(";");

        this.memberID = scanner.nextInt();
        this.name = scanner.next();
        this.birthday = scanner.next();
        this.active = scanner.nextBoolean();
        this.restance = scanner.nextInt();
    }



}



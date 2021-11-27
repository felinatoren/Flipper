import java.util.Scanner;

public abstract class Member {

    public int memberID;
    public  String name;
    public String birthday;
    public boolean active;
    public int restance;

    public static int idCounter;

    Member(String name, String birthday){
        idCounter++;
        this.name = name;
        this.birthday = birthday;
        this.memberID = idCounter;

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

    public int getMemberID() {
        return memberID;
    }
    public String getBirthday() {
        return birthday;
    }
    public boolean isActive() {
        return active;
    }
}



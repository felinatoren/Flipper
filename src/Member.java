import java.util.ArrayList;
import java.util.Scanner;

public class Member {

    public boolean active;
    public String birthday;
    public  String name;
    public int restance;
    public int memberID;


    Member(){}

    Member(String fromFile){
        Scanner scanner = new Scanner(fromFile);
        scanner.useDelimiter(";");

        this.memberID = scanner.nextInt();
        this.name = scanner.next();
        this.birthday = scanner.next();
        this.active = scanner.nextBoolean();
        this.restance = scanner.nextInt();
    }




    public String toFile(){
        return memberID + ";" + name + ";" + birthday + ";" + active + ";" + restance + ";" + "member";
    }

    @Override
    public String toString() {
        return "Member{" +
                "active=" + active +
                ", birthday='" + birthday + '\'' +
                ", name='" + name + '\'' +
                ", restance=" + restance +
                ", memberID=" + memberID +
                '}';
    }
}



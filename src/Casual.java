import java.util.ArrayList;
import java.util.Scanner;

public class Casual extends Member{


    Casual(String name, String birthday){
        super(name, birthday);
    }

    Casual(String fromFile) {
        super(fromFile);
    }

    public String toFile(){
        return memberID + ";" + name + ";" + birthday + ";" + active + ";" + restance + ";" + "member";
    }


    @Override
    public String toString() {
        return "Casual{" +
                "active=" + active +
                ", birthday='" + birthday + '\'' +
                ", name='" + name + '\'' +
                ", restance=" + restance +
                ", memberID=" + memberID +
                '}';
    }
}

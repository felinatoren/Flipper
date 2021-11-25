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
        return memberID + ";" + name + ";" + birthday + ";" + active + ";" + restance + ";" + "casual";
    }


    @Override
    public String toString() {
        return "Casual{" +
                ", memberID=" + memberID +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                "active=" + active +
                ", restance=" + restance +
                '}';
    }
}

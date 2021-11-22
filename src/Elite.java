import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Elite extends Member {

    private ArrayList<SwimType> swimType = new ArrayList<>();



    Elite(String name, String birthday, ArrayList<SwimType> swimType){
        super(name, birthday);
        this.swimType = swimType;
    }
    // from file
    Elite(String fromFile) {
        super(fromFile);

        String[] list = fromFile.split(";");

        this.swimType = loadSwimTypesFromString(list[6]);
    }

    private ArrayList<SwimType> loadSwimTypesFromString(String fromFile) {

        String[] listOfSwimTypes = fromFile.split(",");

        ArrayList<SwimType> swimTypes = new ArrayList<>();

        for (int i = 0; i < listOfSwimTypes.length; i++) {

            switch (listOfSwimTypes[i]) {

                case "CRAWL":
                    swimTypes.add(SwimType.CRAWL);
                    break;
                case "BACKSTROKE":
                    swimTypes.add(SwimType.BACKSTROKE);
                    break;
                case "FREE":
                    swimTypes.add(SwimType.FREE);
                    break;
                case "BUTTERFLY":
                    swimTypes.add(SwimType.BUTTERFLY);
                    break;
                case "BREAST":
                    swimTypes.add(SwimType.BREAST);
                    break;
            }
        }

        return swimTypes;
    }
    public String toFile() {
        StringBuilder swimTypes = new StringBuilder(";");

        for (int i = 0; i < swimType.size(); i++) {

            if (i == 0) {
                swimTypes.append(swimType.get(i));
            } else
                swimTypes.append(",").append(swimType.get(i));
        }

        return memberID + ";" + name + ";" + birthday + ";" + active + ";" + restance + ";" + "elite" + ";" + swimTypes;
    }

    @Override
    public String toString() {
        return "Elite{" +
                "swimType=" + swimType +
                ", active=" + active +
                ", birthday='" + birthday + '\'' +
                ", name='" + name + '\'' +
                ", restance=" + restance +
                ", memberID=" + memberID +
                '}';
    }
}

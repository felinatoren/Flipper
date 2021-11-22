import java.util.ArrayList;

public class RecordTime {

    ArrayList<SwimResult> breastResults = new ArrayList<>();
    ArrayList<SwimResult> crawlResults = new ArrayList<>();
    ArrayList<SwimResult> backStrokeResults = new ArrayList<>();
    ArrayList<SwimResult> freeResults = new ArrayList<>();
    ArrayList<SwimResult> butterflyResults = new ArrayList<>();

    ArrayList<SwimResult> recordTime;

    public RecordTime(ArrayList<String> fromFile){
        this.recordTime = fileToTime(fromFile);
    }

    public ArrayList<SwimResult> fileToTime(ArrayList<String> fromFile){

        ArrayList<SwimResult> listOfResults = new ArrayList<>();

        for(int i = 0; i < fromFile.size(); i++){
            //String stringResult = fromFile.get(i);
            // String[] list = stringResult.split(";"); later use

            listOfResults.add(new SwimResult(fromFile.get(i)));
        }

       return listOfResults;
    }
}

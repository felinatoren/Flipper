import java.util.ArrayList;

public class RecordTime{

    Input input = new Input();
    Print print = new Print();

    ArrayList<SwimResult> breastResults = new ArrayList<>();
    ArrayList<SwimResult> crawlResults = new ArrayList<>();
    ArrayList<SwimResult> backStrokeResults = new ArrayList<>();
    ArrayList<SwimResult> freeResults = new ArrayList<>();
    ArrayList<SwimResult> butterflyResults = new ArrayList<>();

    ArrayList<SwimResult> recordTime;

    public RecordTime(ArrayList<String> fromFile){
        this.recordTime = fileToTime(fromFile);
    }
    public void assignResultsBySwimType(ArrayList<SwimResult> recordTime){

        for(int i = 0; i < recordTime.size(); i++){

            if(recordTime.get(i).getType().equalsIgnoreCase("BREAST")){
                breastResults.add(recordTime.get(i));
            }
            else if(recordTime.get(i).getType().equalsIgnoreCase("CRAWL")){
                crawlResults.add(recordTime.get(i));
            }
            else if(recordTime.get(i).getType().equalsIgnoreCase("BACKSTROKE")){
                backStrokeResults.add(recordTime.get(i));
            }
            else if(recordTime.get(i).getType().equalsIgnoreCase("BUTTERFLY")){
                butterflyResults.add(recordTime.get(i));
            }
            else if(recordTime.get(i).getType().equalsIgnoreCase("FREE")){
                freeResults.add(recordTime.get(i));
            }
        }
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

    public ArrayList<String> saveResultListToFile() {
        ArrayList<String> resultListToFile = new ArrayList<>();

        for (int i = 0; i < recordTime.size(); i++) {
            SwimResult swimResult = recordTime.get(i);
            String resultToFile;

            resultToFile = swimResult.toFile();

            resultListToFile.add(resultToFile);
        }

        return resultListToFile;
    }

    public void newCompetitiveResult(){

        SwimResult compResult = new SwimResult();

        compResult.setMemberID(input.getInt("ID:"));
        compResult.setName(input.getString("Navn:"));
        compResult.setDate(input.getDay("Dato:"));
        compResult.setTime(input.getInt("Tid:"));
        print.printSwimTypesDisplayForResult();
        compResult.setType(input.getSwimTypForResults());
        compResult.setCompetitionName(input.getString("Stævne navn:"));
        compResult.setPosition(input.getInt("Placering:"));

        recordTime.add(compResult);
    }
    public void newTrainingResult(){
        SwimResult trainingResult = new SwimResult();

        trainingResult.setMemberID(input.getInt("ID:"));
        trainingResult.setName(input.getString("Navn:"));
        trainingResult.setDate(input.getDay("Dato:"));
        trainingResult.setTime(input.getInt("Tid:"));
        print.printSwimTypesDisplayForResult();
        trainingResult.setType(input.getSwimTypForResults());

        recordTime.add(trainingResult);
    }

}

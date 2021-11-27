import java.util.ArrayList;

public class RecordTime{


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
        breastResults.clear();
        crawlResults.clear();
        backStrokeResults.clear();
        freeResults.clear();
        butterflyResults.clear();

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

    public void newCompetitiveResult(int memberID, String name, String date, int time, String swimType, String competitionName, int position){

        SwimResult compResult = new SwimResult();

        compResult.setMemberID(memberID);
        compResult.setName(name);
        compResult.setDate(date);
        compResult.setTime(time);
        compResult.setType(swimType);
        compResult.setCompetitionName(competitionName);
        compResult.setPosition(position);

        recordTime.add(compResult);
    }
    public void newTrainingResult(int memberID, String name, String date, int time, String swimType){
        SwimResult trainingResult = new SwimResult();

        trainingResult.setMemberID(memberID);
        trainingResult.setName(name);
        trainingResult.setDate(date);
        trainingResult.setTime(time);
        trainingResult.setType(swimType);

        recordTime.add(trainingResult);
    }

}

import java.util.Scanner;

public class SwimResult implements Comparable<SwimResult>{
    private int memberID;
    private String name;
    private String date;
    private int time;           // seconds only
    private String type;
    private String competitionName;
    private int position;
    private boolean isJunior;

    public SwimResult(){}

    public SwimResult(String fromFile){
        Scanner scanner = new Scanner(fromFile).useDelimiter(";");
        this.memberID = scanner.nextInt();
        this.name = scanner.next();
        this.date = scanner.next();
        this.time = scanner.nextInt();
        this.type = scanner.next();
        this.isJunior = scanner.nextBoolean();
        if(scanner.hasNext()){
        this.competitionName = scanner.next();
        this.position = scanner.nextInt();
        }

    }

    public SwimResult(int memberID, String name, String date, int time, String type){
        this.memberID = memberID;
        this.name = name;
        this.date = date;
        this.time = time;
        this.type = type;
    }

    public String toFile(){
        if(this.competitionName == null)
            return memberID + ";" + name + ";" + date + ";" + time + ";" + type + ";" + isJunior;

        return memberID + ";" + name + ";" + date + ";" + time + ";" + type + ";" + isJunior + ";" + competitionName + ";" + position;
    }

    @Override
    public int compareTo(SwimResult s) {
        return this.time - s.time;
    }

    public String toString(){
        return memberID + " " + name;
    }

    public String getType(){
        return type;
    }
    public String getName(){
        return name;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public int getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public int getPosition() {
        return position;
    }

    public boolean isJunior() {
        return isJunior;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public void setJunior(boolean junior) {
        isJunior = junior;
    }
}

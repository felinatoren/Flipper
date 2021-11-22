import java.util.Scanner;

public class SwimResult {
    private int memberID;
    private String name;
    private String date;
    private int time;           // seconds only
    private String type;
    private String competitionName;
    private int position;


    public SwimResult(){}

    public SwimResult(String fromFile){
        Scanner scanner = new Scanner(fromFile).useDelimiter(";");
        this.memberID = scanner.nextInt();
        this.name = scanner.next();
        this.date = scanner.next();
        this.time = scanner.nextInt();
        this.type = scanner.next();
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



    public String toString(){
        return memberID + " " + name;
    }
}

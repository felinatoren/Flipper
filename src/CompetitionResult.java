public class CompetitionResult extends SwimResult {
    private String competitionName;
    private int position;

    public CompetitionResult(){}

    public CompetitionResult(int memberID, String name, String date, int time, String type, String competitionName, int position){
        super(memberID, name, date, time, type);
        this.competitionName = competitionName;
        this.position = position;
    }
}

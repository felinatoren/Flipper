import java.util.ArrayList;

public class MemberList {



    private ArrayList<Member> memberList;

    MemberList(ArrayList<String> fromFile){
        this.memberList = fileToMember(fromFile);
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public ArrayList<Member> fileToMember(ArrayList<String> fromFile){

        ArrayList<Member> listOfMembers = new ArrayList<>();

        for (int i = 0; i< fromFile.size(); i++){
            String stringMember = fromFile.get(i);
            String[] list = stringMember.split(";");


            if (list[5].equals("member")){
                listOfMembers.add(new Member(fromFile.get(i)));
            } else if (list[5].equals("elite")){
                listOfMembers.add(new Elite(fromFile.get(i)));
            }

            /*
            (list[5].equals("elite")) {
                member = new Elite(fromFile.get(i));
            }


             */
        }

        return listOfMembers;
    }




}

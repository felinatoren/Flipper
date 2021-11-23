import java.util.ArrayList;

public class MemberList {


    private ArrayList<Member> memberList;


    MemberList(ArrayList<String> fromFile) {
        this.memberList = fileToMember(fromFile);
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public ArrayList<Member> fileToMember(ArrayList<String> fromFile) {

        ArrayList<Member> listOfMembers = new ArrayList<>();

        for (int i = 0; i < fromFile.size(); i++) {
            String stringMember = fromFile.get(i);
            String[] list = stringMember.split(";");

            if (list[5].equals("casual")) {
                listOfMembers.add(new Casual(fromFile.get(i)));
            } else if (list[5].equals("elite")) {
                listOfMembers.add(new Elite(fromFile.get(i)));
            }

        }
        return listOfMembers;
    }


    public void addEliteMember(String name, String birthday, ArrayList<SwimType> swimType) {
        Member member = new Elite(name, birthday, swimType);
        memberList.add(member);

    }

    public void addCasualMember(String name, String birthday) {

        Member member = new Casual(name, birthday);
        memberList.add(member);

    }

    public ArrayList<String> saveMemberListToFile() {
        ArrayList<String> memberListToFile = new ArrayList<>();

        for (int i = 0; i < memberList.size(); i++) {
            Member member = memberList.get(i);
            String memberToFile;

            if (member instanceof Elite) {
                memberToFile = ((Elite) member).toFile();
                memberListToFile.add(memberToFile);
            } else if (member instanceof Casual) {
                memberToFile = ((Casual) member).toFile();
                memberListToFile.add(memberToFile);
            } else {
                memberListToFile.add("failed");
            }



        }

        return memberListToFile;
    }
}
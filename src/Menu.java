import java.util.ArrayList;
import java.util.Collections;

public class Menu {

    Input input = new Input();
    Print print = new Print();
    Date date = new Date();
    Payment payment = new Payment();

    FileHandler file = new FileHandler("Files/SwimResults", "Files/Member");
    MemberList memberList = new MemberList(file.loadMembers());
    RecordTime timeList = new RecordTime(file.loadSwimResults());

    public void run() {
        boolean running = true;
        int menuChoice;

        do {
            print.mainMenuDisplay(date.toString(date.today));
            menuChoice = input.getInt(print.chooseMenuPoint(), 1, 4);

            switch (menuChoice) {
                case 1:
                    boolean memberMenuRunning = true;
                    do {
                        print.memberMenuDisplay();
                        menuChoice = input.getInt(print.chooseMenuPoint(), 1, 4);
                        switch (menuChoice) {
                            case 1:
                                print.registerNewMember();
                                addMember();
                                break;
                            case 2:
                                System.out.println("Rediger medlem"); // evt
                                break;
                            case 3:
                                printMemberList();
                                break;
                            case 4:
                                print.returnToMainMenu();
                                memberMenuRunning = false;
                                break;
                        }
                    }
                    while (memberMenuRunning);
                    break;
                case 2:
                    boolean finansMenuRunning = true;
                    do {
                        print.financeMenuDisplay();
                        menuChoice = input.getInt(print.chooseMenuPoint(), 1, 3);
                        switch (menuChoice) {
                            case 1:
                                getTotalPayments();
                                break;
                            case 2:
                                showMemberArrears();
                                break;
                            case 3:
                                print.returnToMainMenu();
                                finansMenuRunning = false;
                                break;
                        }
                    }
                    while (finansMenuRunning);
                    break;
                case 3:
                    boolean swimResultMenuRunning = true;
                    do {
                        print.swimResultsMenuDisplay();
                        menuChoice = input.getInt(print.chooseMenuPoint(), 1, 5);
                        switch (menuChoice) {
                            case 1:
                                showSeniorHOF();
                                break;
                            case 2:
                               juniorHOF();
                                break;
                            case 3:
                                addCompetitiveResult();
                                break;
                            case 4:
                                trainingResultAdd();
                                break;
                            case 5:
                                print.returnToMainMenu();
                                swimResultMenuRunning = false;
                                break;
                        }
                    }
                    while (swimResultMenuRunning);
                    break;
                case 4:
                    print.exitProgramMSG();
                    running = false;
                    break;
            }
        }
        while (running);
    }

    public void addMember() {
        String name, birthday, memberType;
        boolean isCorrectMember = false;

        do {
            print.printString("Navn: ");
            name = input.getString();

            print.askForBirthday();
            birthday = input.getDay();

            print.askMemberType();
            memberType = input.getMemberType();

            if (memberType.equals("Motionist")) {

                print.printString("Navn: " + name);
                print.printString("Fødselsdag: " + birthday);
                print.printString("Medlemstype: " + memberType);

                // TODO Hvis mere tid kan man sætte en abort in her
                print.acceptMember();
                isCorrectMember = input.getBoolean();

                if (isCorrectMember) {
                    memberList.addCasualMember(name, birthday);
                }

            } else if (memberType.equals("Elite")) {

                ArrayList<SwimType> swimTypes = new ArrayList<>();
                boolean moreSwimTypes = true;

                do {
                    print.printSwimTypesDisplay(swimTypes);

                    SwimType newSwimType = input.getSwimType(swimTypes);

                    if (newSwimType == null) {
                        moreSwimTypes = false;
                    } else {
                        swimTypes.add(newSwimType);
                    }
                } while (moreSwimTypes);


                print.printString("Navn: " + name);
                print.printString("Fødselsdag: " + birthday);
                print.printString("Medlemstype: " + memberType);
                print.printSwimTypes(swimTypes);

                // TODO Hvis mere tid kan man sætte en abort in her
                print.acceptMember();
                isCorrectMember = input.getBoolean();

                if (isCorrectMember) {
                    memberList.addEliteMember(name, birthday, swimTypes);
                }
            }
            file.saveMemberList(memberList.saveMemberListToFile());

        } while (!isCorrectMember);
    }

    public void addCompetitiveResult() {
        timeList.newCompetitiveResult(input.getInt("ID:"), input.getString("Navn:"),
                 input.getDay("Dato:"), input.getInt("Tid:"),
                input.getSwimTypForResults(print.printSwimTypesDisplayForResult()), input.getBoolean(print.isJunior()),
                input.getString("Stævne navn:"), input.getInt("Placering:"));
        file.saveSwimResults(timeList.saveResultListToFile());
    }

    public void trainingResultAdd() {
        timeList.newTrainingResult(input.getInt("ID:"), input.getString("Navn:"),
                input.getDay("Dato:"), input.getInt("Tid:"),
                input.getSwimTypForResults(print.printSwimTypesDisplayForResult()), input.getBoolean(print.isJunior()));
        file.saveSwimResults(timeList.saveResultListToFile());
    }

    public void getTotalPayments() {
        ArrayList<Member> members = memberList.getMemberList();
        int totalPayments = 0;

        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            String birthday = member.getBirthday();
            int age = date.howOldIsMember(birthday);
            boolean isActive = member.isActive();

            totalPayments += payment.calculatedPayment(age, isActive);
        }
        print.totalYearlyPayment(totalPayments);
    }

    public void printMemberList() {
        ArrayList<Member> members = memberList.getMemberList();
        print.printMemberList(members);
    }

    public void showMemberArrears(){
       ArrayList<Member> members = memberList.getMemberList();
       ArrayList<Member> arrearMemberList = new ArrayList<>();

       for(int i = 0; i < members.size(); i++){
           if(members.get(i).restance > 0){
               arrearMemberList.add(members.get(i));
           }
       }
       print.showMembersInArrears(arrearMemberList);
    }
    public void showSeniorHOF(){
        timeList.assignResultByAge(timeList.recordTime);
        timeList.assignResultsBySwimType(timeList.senior);
        Collections.sort(timeList.freeResults);
        Collections.sort(timeList.crawlResults);
        Collections.sort(timeList.backStrokeResults);
        Collections.sort(timeList.breastResults);
        Collections.sort(timeList.butterflyResults);

        print.hallOfFame(timeList.freeResults, timeList.crawlResults, timeList.butterflyResults,
                timeList.breastResults, timeList.backStrokeResults);
    }
    public void juniorHOF(){
        timeList.assignResultByAge(timeList.recordTime);
        timeList.assignResultsBySwimTypeJunior(timeList.junior);
        Collections.sort(timeList.juniorFreeResults);
        Collections.sort(timeList.juniorCrawlResults);
        Collections.sort(timeList.juniorBackStrokeResults);
        Collections.sort(timeList.juniorBreastResults);
        Collections.sort(timeList.juniorButterflyResults);

        print.hallOfFame(timeList.juniorFreeResults, timeList.juniorCrawlResults, timeList.juniorButterflyResults,
                timeList.juniorBreastResults, timeList.juniorBackStrokeResults);
    }
}

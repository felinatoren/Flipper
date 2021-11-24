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

        timeList.assignResultsBySwimType(timeList.recordTime); // kan evt flyttes til res menu, skal slette tidligere resultater så

        //System.out.println(timeList.freeResults.toString());



        do {
            print.mainMenuDisplay(date.toString(date.today));
            menuChoice = input.getInt(print.chooseMenuPoint(), 1, 4);

            switch (menuChoice) {
                case 1:
                    boolean memberMenuRunning = true;
                    do {
                        print.memberMenuDisplay();
                        menuChoice = input.getInt(print.chooseMenuPoint(), 1, 3);
                        switch (menuChoice) {
                            case 1:
                                print.registerNewMember();
                                addMember();
                                break;
                            case 2:
                                System.out.println("Rediger medlem");
                                break;
                            case 3:
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
                                System.out.println("se oversigt over medlemmer i restance");
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
                        menuChoice = input.getInt(print.chooseMenuPoint(), 1, 4);
                        switch (menuChoice) {
                            case 1:
                                Collections.sort(timeList.freeResults);
                                Collections.sort(timeList.crawlResults);
                                Collections.sort(timeList.backStrokeResults);
                                Collections.sort(timeList.breastResults);
                                Collections.sort(timeList.butterflyResults);

                                print.hallOfFame(timeList.freeResults, timeList.crawlResults, timeList.butterflyResults,
                                        timeList.breastResults, timeList.backStrokeResults);

                                break;
                            case 2:
                                addCompetitiveResult();
                                break;
                            case 3:
                                trainingResultAdd();
                                break;
                            case 4:
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

            // printer selv ud fra input klassen
            print.askForBirthday();
            birthday = input.getDay();

            print.askMemberType();
            memberType = input.getMemberType();

            if (memberType.equals("Motionist")) {
                print.printString(name);
                print.printString(birthday);
                print.printString(memberType);

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
                    print.printSwimTypesDisplay();

                    SwimType newSwimType = input.getSwimType();

                    if (newSwimType == null) {
                        moreSwimTypes = false;
                    } else {
                        swimTypes.add(newSwimType);
                    }
                } while (moreSwimTypes);

                print.printSwimTypes(swimTypes);
                print.printString(name);
                print.printString(birthday);
                print.printString(memberType);

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
    public void addCompetitiveResult(){
        timeList.newCompetitiveResult(input.getInt("ID:"), input.getString("Navn:"),
                input.getDay("Dato:"),input.getInt("Tid:"),
                input.getSwimTypForResults(print.printSwimTypesDisplayForResult()),
                input.getString("Stævne navn:"), input.getInt("Placering:"));
        file.saveSwimResults(timeList.saveResultListToFile());
    }
    public void trainingResultAdd(){
        timeList.newTrainingResult(input.getInt("ID:"), input.getString("Navn:"),
                input.getDay("Dato:"),input.getInt("Tid:"),
                input.getSwimTypForResults(print.printSwimTypesDisplayForResult()));
        file.saveSwimResults(timeList.saveResultListToFile());
    }

    public void getTotalPayments(){
        ArrayList<Member> members = memberList.getMemberList();
        int totalPayments = 0;

        for (int i = 0; i < members.size(); i++){
        Member member = members.get(i);

        int age = date.howOldIsMember(member.getBirthday());
        boolean isActive = member.isActive();

        totalPayments += payment.calculatedPayment(age, isActive);
        }
        print.totalYearlyPayment(totalPayments);


    }

}

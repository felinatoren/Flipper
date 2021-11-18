public class Menu {

    Input input = new Input();
    Print print = new Print();
    Date date = new Date();

    FileHandler file = new FileHandler("Files/SwimResults", "Files/Member");
    MemberList memberList = new MemberList(file.loadMembers());

    public void run(){
        boolean running = true;
        int menuChoice;

        System.out.println("Read File");

        do {
            print.mainMenuDisplay(date.toString(date.today));
            menuChoice = input.getInt(print.chooseMenuPoint(), 1, 4);

            switch (menuChoice){
                case 1:
                    boolean memberMenuRunning = true;
                    do{
                    print.memberMenuDisplay();
                    menuChoice = input.getInt(print.chooseMenuPoint(), 1, 3);
                    switch(menuChoice){
                        case 1:
                            System.out.println("Registrer nyt medlem");
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
                    while(memberMenuRunning);
                    break;
                case 2:
                    boolean finansMenuRunning = true;
                    do{
                    print.financeMenuDisplay();
                    menuChoice = input.getInt(print.chooseMenuPoint(), 1, 3);
                    switch (menuChoice){
                        case 1:
                            System.out.println("se kontingent regnskab");
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
                    while(finansMenuRunning);
                    break;
                case 3:
                    boolean swimResultMenuRunning = true;
                    do{
                        print.swimResultsMenuDisplay();
                        menuChoice = input.getInt(print.chooseMenuPoint(), 1, 4);
                        switch (menuChoice){
                            case 1:
                                System.out.println("hall of fame");
                                break;
                            case 2:
                                System.out.println("indtast konkurrence-resultat");
                                break;
                            case 3:
                                System.out.println("trænings-resultat");
                                break;
                            case 4:
                                print.returnToMainMenu();
                                swimResultMenuRunning = false;
                                break;
                        }
                    }
                    while(swimResultMenuRunning);
                    break;
                case 4:
                    print.exitProgramMSG();
                    running = false;
                    break;
            }
        }
        while(running);
    }
}

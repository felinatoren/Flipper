public class Menu {

    Input input = new Input();
    Print print = new Print();

    public void run(){
        boolean running = true;
        int menuChoice;


        System.out.println("Read File");

        System.out.println("Ask for date");

        // print.printDate(input.getDay());

        do {
            print.mainMenuDisplay();
            menuChoice = input.getInt(print.chooseMenuPoint(), 1, 4);

            switch (menuChoice){
                case 1:
                    System.out.println("Medlems menu");
                    break;
                case 2:
                    System.out.println("Finans menu");
                    break;
                case 3:
                    System.out.println("Svømme resultat menu");
                    break;
                case 4:
                    System.out.println("Programmet lukker ned nu, tak for i dag.");
                    running = false;
                    break;
            }
        }
        while(running);
    }
}

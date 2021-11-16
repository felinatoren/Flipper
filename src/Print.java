public class Print {

    public void printDate(String date){
        System.out.println("I dag er den " + date);
    }

    public String chooseMenuPoint(){
        return "\nVælg menupunkt:";
    }

    public void mainMenuDisplay(){
        System.out.println("Svømmeklubben Flippers administrative Menu.\n");
        System.out.println("1 for Medlems menu.");
        System.out.println("2 for Finans menu.");
        System.out.println("3 for Svømme resultats menu.");
        System.out.println("4 for at lukke programmet.");
    }
}

public class Print {

    public void printToday(String date){
        System.out.println("I dag er den " + date);
    }
    public String chooseMenuPoint(){
        return "\nVælg menupunkt:";
    }
    public void exitProgramMSG(){
        System.out.println("Programmet lukker ned nu, tak for i dag.");
    }
    public void returnToMainMenu(){                             // muligt kan dropppes
        System.out.println("Returnerer til den administrative menu.\n");
    }
    public void mainMenuDisplay(){
        System.out.println("Svømmeklubben Flippers administrative Menu.\n");
        System.out.println("1 for Medlems menu.");
        System.out.println("2 for Finans menu.");
        System.out.println("3 for Svømme resultats menu.");
        System.out.println("4 for at lukke programmet.");
    }
    public void memberMenuDisplay(){
        System.out.println("\nMedlems menu.\n");
        System.out.println("1 for registrering af nyt medlem.");
        System.out.println("2 for redigering af eksisterende medlem.");
        System.out.println("3 retur til den administrative menu.");
    }
    public void financeMenuDisplay(){
        System.out.println("\nFinans menu.\n");
        System.out.println("1 for se årsregnskab over kontingenter.");
        System.out.println("2 for at se medlemmer i restance.");
        System.out.println("3 retur til den administrative menu.");
    }
    public void swimResultsMenuDisplay(){
        System.out.println("\nSvømme resultats menu.\n");
        System.out.println("1 for se top 5 svømme tider i alle discipliner.");
        System.out.println("2 for at indtaste konkurrence resultat.");
        System.out.println("3 for at indtaste trænings resultat.");
        System.out.println("4 retur til den administrative menu.");
    }
}

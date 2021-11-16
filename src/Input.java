import java.util.Scanner;
public class Input {

    Scanner scanner = new Scanner(System.in);





    public String getDay(){
        String fullDate;
        int date = 0;
        int month = 0;
        int year = 0;

        do{
            System.out.print("Dag: ");
            if (scanner.hasNextInt()){
                date = scanner.nextInt();
            }
            scanner.nextLine();
        }while(date <= 0 || date > 31);

        do{
            System.out.print("Måned: ");
            if (scanner.hasNextInt()){
                month = scanner.nextInt();
            }
            scanner.nextLine();
        }while(month <= 0 || date > 12);

        do{
            System.out.print("År: ");
            if (scanner.hasNextInt()){
                year = scanner.nextInt();
            }
            scanner.nextLine();
        }while(year <= 1900);


        fullDate = date + "/" + month + "/" + year;

      return fullDate;
    }

    public String getDay(String prompt){
        String fullDate;
        int date = 0;
        int month = 0;
        int year = 0;

        System.out.println(prompt);

        do{
            System.out.print("Dag: ");
            if (scanner.hasNextInt()){
                date = scanner.nextInt();
            }
            scanner.nextLine();
        }while(date <= 0 || date > 31);

        do{
            System.out.print("Måned: ");
            if (scanner.hasNextInt()){
                month = scanner.nextInt();
            }
            scanner.nextLine();
        }while(month <= 0 || date > 12);

        do{
            System.out.print("År: ");
            if (scanner.hasNextInt()){
                year = scanner.nextInt();
            }
            scanner.nextLine();
        }while(year <= 1900);


        fullDate = date + "/" + month + "/" + year;

        return fullDate;
    }








}

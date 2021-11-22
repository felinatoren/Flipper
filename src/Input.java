import java.util.Scanner;
public class Input {

    Scanner scanner = new Scanner(System.in);

    public int getInt(){
        int number = -1;
        do {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
            }
            scanner.nextLine();
        } while(number == -1);

        return number;

    }
    public int getInt(String prompt){
        int number = -1;
        do {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
            }
            scanner.nextLine();
        } while(number == -1);
        return number;
    }
    public int getInt(int betweenX, int andY){
        int number = -1;
        do {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
            }
            scanner.nextLine();
        } while(number < betweenX || number > andY);

        return number;

    }
    public int getInt(String prompt, int betweenX, int andY){
        int number = -1;
        do {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
            }
            scanner.nextLine();
        } while(number < betweenX || number > andY);

        return number;
    }
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

    public String getString(){
        return scanner.nextLine();
    }

    public String getMemberType(){
       int number = getInt(1,2);
       String memberType = "";


       if (number == 1){
           memberType = "casual";
       } else if (number == 2)
           memberType = "elite";


       return memberType;
    }

    public boolean getBoolean(){
        int number = getInt(1,2);
        boolean memberType = false;


        if (number == 1){
            memberType = true;
        } else if (number == 2)
            memberType = false;


        return memberType;
    }

    public SwimType getSwimType(){
            boolean correctInput = false;

        do {
            switch (getInt(1, 9)) {
                case 1:
                    return SwimType.CRAWL;
                case 2:
                    return SwimType.BACKSTROKE;
                case 3:
                    return SwimType.FREE;
                case 4:
                    return SwimType.BUTTERFLY;
                case 5:
                    return SwimType.BREAST;
                case 9:
                    return null;
                default:
                    correctInput = false;
            }

        } while (correctInput);

        return null;
    }


}

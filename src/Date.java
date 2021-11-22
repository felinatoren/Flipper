import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


public class Date {

    LocalDate today = LocalDate.now();


    public String toString(LocalDate date){
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();

        return day + "/" + month + "/" + year;
    }

    public boolean isSenior(String birthday){
        Scanner scanner = new Scanner(birthday);
        scanner.useDelimiter("/");

        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        LocalDate membersBirthday = LocalDate.of(year,month,day);

        long daysBetween = ChronoUnit.DAYS.between(membersBirthday, today);

        boolean isSenior;

        // You are 18, if you are 6574 days old.
        if (daysBetween > 6574){
            isSenior = true;
        } else
            isSenior = false;

        return isSenior;
    }
}

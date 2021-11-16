import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


public class Date {

    LocalDate today = LocalDate.now();

    public boolean isOver18(String birthday){
        Scanner scanner = new Scanner(birthday);
        scanner.useDelimiter("/");

        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        LocalDate membersBirthday = LocalDate.of(year,month,day);

        long daysBetween = ChronoUnit.DAYS.between(membersBirthday, today);

        boolean isOver18;

        // You are 18, if you are 6574 days old.
        if (daysBetween > 6574){
            isOver18 = true;
        } else
            isOver18 = false;

        return isOver18;
    }
}

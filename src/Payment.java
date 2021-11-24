import java.lang.reflect.Type;

public class Payment {
    public int calculatedPayment(int age, boolean isActive) {
        int payment;

        if (!isActive) {
            payment = 500;
        } else if (age < 18) {
            payment = 1000;
        } else if (age > 60) {
            payment = 1200;
        } else {
            payment = 1600;
        }
        return payment;
    }
}


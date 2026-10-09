import java.time.LocalDate;
import java.util.Scanner;

abstract class Subscription {
    protected String name;
    protected LocalDate startDate;

    public Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public abstract LocalDate getRenewalDate();
}

class BasicSubscription extends Subscription {
    public BasicSubscription(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardSubscription extends Subscription {
    public StandardSubscription(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumSubscription extends Subscription {
    public PremiumSubscription(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        Subscription[] subs = new Subscription[n];

        for (int i = 0; i < n; i++) {
            String planType = scanner.next();
            String name = scanner.next();
            LocalDate startDate = LocalDate.parse(scanner.next());

            switch (planType) {
                case "BASIC":
                    subs[i] = new BasicSubscription(name, startDate);
                    break;
                case "STANDARD":
                    subs[i] = new StandardSubscription(name, startDate);
                    break;
                case "PREMIUM":
                    subs[i] = new PremiumSubscription(name, startDate);
                    break;
            }
        }

        for (Subscription sub : subs) {
            System.out.printf("%s: %s\n", sub.getName(), sub.getRenewalDate());
        }

        scanner.close();
    }
}
public class q1 {
    private final String id;
    private double savings;

    public q1(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.savings += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.savings) {
            this.savings -= amount;
        } else {
            System.out.println("rejected, savings stays " + (int)this.savings);
        }
    }

    public double getSavings() {
        return this.savings;
    }

    public String getId() {
        return this.id;
    }

    public static void main(String[] args) {
        q1 pb = new q1("PB-1");
        pb.deposit(100);
        System.out.println("savings = " + (int)pb.getSavings());

        pb.withdraw(30);
        System.out.println("savings = " + (int)pb.getSavings());

        pb.withdraw(500);
    }
}
public class q5 {
    private final String id;
    private final double[] prices;
    private int count;

    public q5(String id, int maxItems) {
        this.id = id;
        this.prices = new double[maxItems];
        this.count = 0;
    }

    public void addItem(double price) {
        if (count < prices.length) {
            prices[count] = price;
            count++;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        q5 cart = new q5("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println((int) cart.getTotal());
        System.out.println(cart.getItemCount());
    }
}

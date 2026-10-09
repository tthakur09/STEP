public class q1 {

    private final int maxHealth;
    private int health;


    public q1(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            this.health = Math.max(0, this.health - amount);
        }
    }


    public void heal(int amount) {
        if (amount > 0) {
            this.health = Math.min(this.maxHealth, this.health + amount);
        }
    }


    public int getHealth() {
        return this.health;
    }


    public int getMaxHealth() {
        return this.maxHealth;
    }


    public static void main(String[] args) {
        q1 c = new q1(100);

        c.takeDamage(30);
        System.out.println("health = " + c.getHealth());

        c.heal(50);
        System.out.println("health = " + c.getHealth());
    }
}
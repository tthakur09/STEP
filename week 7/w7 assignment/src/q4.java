public class q4 {

    private final String id;
    private String color;


    public q4(String id) {
        this.id = id;
        this.color = "RED";
    }


    public void next() {
        if (this.color.equals("RED")) {
            this.color = "GREEN";
        } else if (this.color.equals("GREEN")) {
            this.color = "YELLOW";
        } else if (this.color.equals("YELLOW")) {
            this.color = "RED";
        }
    }

    public String getColor() {
        return this.color;
    }


    public String getId() {
        return this.id;
    }


    public static void main(String[] args) {
        q4 t = new q4("TL-9");
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());
    }
}
public class q3 {

    private final String firstName;
    private final char lastInitial;


    public q3(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastInitial = parts[1].charAt(0);
    }


    public String getNickname() {
        return firstName + " " + lastInitial + ".";
    }


    public static void main(String[] args) {
        q3 tag = new q3("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}

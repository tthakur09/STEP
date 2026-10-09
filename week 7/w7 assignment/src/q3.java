 public class q3 {

    private final String password;


    public q3(String password) {
        this.password = password;
    }


    public String getStrength() {
        int len = this.password.length();
        if (len < 6) {
            return "Weak";
        } else if (len <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }


    public static void main(String[] args) {
        q3 pc = new q3("abcd");
        System.out.println(pc.getStrength());

        q3 pc2 = new q3("abcdefghij");
        System.out.println(pc2.getStrength());
    }
}


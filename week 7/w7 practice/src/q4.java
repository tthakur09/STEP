public class q4 {

    private final int lockerNumber;
    private String code;


    public q4(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }


    public boolean changeCode(String oldCode, String newCode) {
        if (this.code.equals(oldCode)) {
            this.code = newCode;
            System.out.println("success");
            return true;
        } else {
            System.out.println("rejected, code is still unchanged");
            return false;
        }
    }


    public int getLockerNumber() {
        return this.lockerNumber;
    }


    public static void main(String[] args) {
        q4 l = new q4(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}

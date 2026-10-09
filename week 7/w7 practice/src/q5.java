public class q5 {
    private final String[] presentStudents;
    private int count;

    public q5(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.count = 0;
    }


    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }


    public void markPresent(String name) {

        if (!isPresent(name) && count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        }
    }


    public int getPresentCount() {
        return count;
    }


    public static void main(String[] args) {
        q5 sheet = new q5(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Is Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Is Chen present: " + sheet.isPresent("Chen"));
    }
}
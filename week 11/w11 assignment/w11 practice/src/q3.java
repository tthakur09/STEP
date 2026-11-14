
import java.util.HashSet;

public class q3 {

    static boolean hasDuplicate(String[] transactionIds) {
        HashSet<String> seen = new HashSet<>();

        for (String id : transactionIds) {
            if (seen.contains(id)) {
                return true;
            }
            seen.add(id);
        }

        return false;
    }

    public static void main(String[] args) {
        String[] a = {
                "TXN1001", "TXN1002", "TXN1003",
                "TXN1002", "TXN1004"
        };

        String[] b = {
                "TXN2001", "TXN2002", "TXN2003"
        };

        System.out.println(hasDuplicate(a));
        System.out.println(hasDuplicate(b));
    }
}

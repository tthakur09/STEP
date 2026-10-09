import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected static final LocalDate CURRENT_DATE = LocalDate.parse("2023-10-26");

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract LocalDate calculateDueDate();
}

class BookItem extends LibraryItem {
    public BookItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(14);
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(7);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(3);
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = Integer.parseInt(scanner.nextLine().trim());
        LibraryItem[] items = new LibraryItem[n];

        int count = 0;
        while (count < n && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            int firstSpace = line.indexOf(' ');
            String itemType = line.substring(0, firstSpace).trim();
            String titlePart = line.substring(firstSpace + 1).trim();

            if (titlePart.startsWith("\"") && titlePart.endsWith("\"") && titlePart.length() >= 2) {
                titlePart = titlePart.substring(1, titlePart.length() - 1);
            }

            switch (itemType) {
                case "BOOK":
                    items[count] = new BookItem(titlePart);
                    break;
                case "DVD":
                    items[count] = new DVDItem(titlePart);
                    break;
                case "MAGAZINE":
                    items[count] = new MagazineItem(titlePart);
                    break;
            }
            count++;
        }

        for (int i = 0; i < count; i++) {
            System.out.printf("%s: %s\n", items[i].getTitle(), items[i].calculateDueDate());
        }

        scanner.close();
    }
}

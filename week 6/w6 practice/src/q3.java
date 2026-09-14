import java.util.Scanner;

public class q3 {

    static class Course {
        String code;
        String title;
        int credits;
        int labCredits;


        public Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }


        public Course(String code, String title, int credits) {
            this(code, title, credits, 0);
        }


        public int totalCredits() {
            return this.credits + this.labCredits;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter Theory-Only Course Details:");
        System.out.print("Course Code: ");
        String theoryCode = scanner.nextLine().trim();

        System.out.print("Course Title: ");
        String theoryTitle = scanner.nextLine().trim();

        System.out.print("Credits: ");
        int theoryCredits = Integer.parseInt(scanner.nextLine().trim());


        System.out.println("\nEnter Lab-Integrated Course Details:");
        System.out.print("Course Code: ");
        String labCourseCode = scanner.nextLine().trim();

        System.out.print("Course Title: ");
        String labCourseTitle = scanner.nextLine().trim();

        System.out.print("Theory Credits: ");
        int courseCredits = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Lab Credits: ");
        int labCredits = Integer.parseInt(scanner.nextLine().trim());


        Course theoryCourse = new Course(theoryCode, theoryTitle, theoryCredits);
        Course labCourse = new Course(labCourseCode, labCourseTitle, courseCredits, labCredits);


        System.out.println("\n" + theoryCourse.code + " total credits: " + theoryCourse.totalCredits());
        System.out.println(labCourse.code + " total credits: " + labCourse.totalCredits());

        scanner.close();
    }
}
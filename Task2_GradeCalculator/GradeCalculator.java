
import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("     STUDENT GRADE CALCULATOR");
        System.out.println("==================================");

        int subjects;

        // Validate number of subjects
        while (true) {
            System.out.print("Enter the number of subjects: ");

            if (sc.hasNextInt()) {
                subjects = sc.nextInt();

                if (subjects > 0) {
                    break;
                } else {
                    System.out.println("Number of subjects must be positive.");
                }
            } else {
                System.out.println("Invalid input! Enter a whole number.");
                sc.next();
            }
        }

        int totalMarks = 0;
        int maxMarks = subjects * 100;

        // Input and validate marks for each subject
        for (int i = 1; i <= subjects; i++) {

            int marks;

            while (true) {
                System.out.print("Enter marks for Subject " + i + " (0-100): ");

                if (sc.hasNextInt()) {
                    marks = sc.nextInt();

                    if (marks >= 0 && marks <= 100) {
                        break;
                    } else {
                        System.out.println("Marks must be between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input! Enter whole-number marks.");
                    sc.next();
                }
            }

            totalMarks += marks;
        }

        // Calculate average percentage
        double percentage = (double) totalMarks / subjects;

        // Calculate grade
        String grade;

        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else if (percentage >= 40) {
            grade = "E";
        } else {
            grade = "F (Fail)";
        }

        // Display final result
        System.out.println("\n==================================");
        System.out.println("          RESULT SUMMARY");
        System.out.println("==================================");

        System.out.println("Total Subjects: " + subjects);
        System.out.println("Total Marks: " + totalMarks + " / " + maxMarks);
        System.out.printf("Average Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);

        if (percentage >= 40) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }

        System.out.println("==================================");

        sc.close();
    }
}

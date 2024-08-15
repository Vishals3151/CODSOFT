// TASK 2
import java.util.Scanner;
public class GradeCalculator {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        // Enter Number of Subject
        System.out.print("Enter Number of Subjects: ");
        int numSubjects = sc.nextInt();

        // Making Subject Array for storing Marks
        int marks[] = new int[numSubjects];

        // Taking Input of Subjects from user
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter your marks for Subject " + (i + 1) +" (out of 100) : ");
            marks[i] = sc.nextInt();
        }

        // Calculating Total Marks
        int totalMarks = 0;
        for (int i = 0; i < marks.length; i++) {
            totalMarks += marks[i];
        }

        // Calculating Percentage
        double Percentage = (double)totalMarks / numSubjects;

        // Calculating Grade
        String grade;
        if (Percentage >= 90) {
            grade = "A";
        }
        else if (Percentage >= 80) {
            grade = "B";
        }
        else if (Percentage >= 70) {
            grade = "C";
        }
        else if (Percentage >= 60) {
            grade = "D";
        }
        else if (Percentage >= 50) {
            grade = "E";
        }
        else{
            grade = "F";
        }

        // Display Results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Percentage: " + Percentage + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}

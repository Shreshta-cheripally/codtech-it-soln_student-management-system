import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int mathScore;
    private int englishScore;
    private int scienceScore;

    public Student(String name, int mathScore, int englishScore, int scienceScore) {
        this.name = name;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.scienceScore = scienceScore;
    }

    public String getName() {
        return name;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getScienceScore() {
        return scienceScore;
    }

    public double calculatePercentage() {
        return (mathScore + englishScore + scienceScore) / 3.0;
    }

    public String calculateGrade() {
        double percentage = calculatePercentage();
        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}

class StudentDatabase {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(String name, int mathScore, int englishScore, int scienceScore) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                student = new Student(name, mathScore, englishScore, scienceScore);
                break;
            }
        }
    }

    public void deleteStudent(String name) {
        students.removeIf(student -> student.getName().equals(name));
    }

    public void displayStudentDetails() {
        System.out.println("Student Details:");
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Math Score: " + student.getMathScore());
            System.out.println("English Score: " + student.getEnglishScore());
            System.out.println("Science Score: " + student.getScienceScore());
            System.out.println("Overall Percentage: " + student.calculatePercentage());
            System.out.println("Grade: " + student.calculateGrade());
            System.out.println("------------------------");
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDatabase studentDatabase = new StudentDatabase();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Student Details");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter math score: ");
                    int mathScore = scanner.nextInt();
                    System.out.print("Enter english score: ");
                    int englishScore = scanner.nextInt();
                    System.out.print("Enter science score: ");
                    int scienceScore = scanner.nextInt();

                    Student student = new Student(name, mathScore, englishScore, scienceScore);
                    studentDatabase.addStudent(student);
                    break;

                case 2:
                    System.out.print("Enter student name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new math score: ");
                    int updateMathScore = scanner.nextInt();
                    System.out.print("Enter new english score: ");
                    int updateEnglishScore = scanner.nextInt();
                    System.out.print("Enter new science score: ");
                    int updateScienceScore = scanner.nextInt();

                    studentDatabase.updateStudent(updateName, updateMathScore, updateEnglishScore, updateScienceScore);
                    break;

                case 3:
                    System.out.print("Enter student name to delete: ");
                    String deleteName = scanner.nextLine();
                    studentDatabase.deleteStudent(deleteName);
                    break;
            

                case 4:
                    studentDatabase.displayStudentDetails();
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

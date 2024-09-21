package student_ver2;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    private ArrayList<Student> studentList;
    private Scanner scanner;

    // Constructor
    public StudentList() {
        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Add a student
    public void addStudent() {
        // Add student
        System.out.print("Nhap ID: ");
        String id = scanner.nextLine();
        System.out.print("Nhap ten: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter Date Of Birth (yyyy-MM-dd): ");
        LocalDate dateOfBirth = null;
        while (dateOfBirth == null) {
            try {
                dateOfBirth = LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                System.out.print("Enter Date Of Birth (yyyy-MM-dd): ");
            }
        }

        float gpa = -1;
        while (gpa < 0) {
            System.out.print("Nhap GPA: ");
            gpa = scanner.nextFloat();
            if (gpa < 0) {
                System.out.println("GPA cannot be negative. Please enter a valid GPA.");
            }
        }
        scanner.nextLine(); // Clear the buffer

        System.out.print("Nhap nganh hoc: ");
        String major = scanner.nextLine();

        System.out.print("Has scholarship (true/false): ");
        boolean schoolship = scanner.nextBoolean();
        
        Student student = new Student(gpa, major, schoolship, id, fullName, dateOfBirth);
        studentList.add(student);
        System.out.println("Student added successfully.");
    }

    // Delete a student by ID
    public void deleteStudentById(String id) {
        if (studentList.removeIf(student -> student.getId().equals(id))) {
            System.out.println("Student with ID " + id + " deleted successfully.");
        } else {
            System.out.println("No student found with ID " + id + ".");
        }
    }

    // Find a student by ID
    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // Display all students
    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Student student : studentList) {
            student.displayInfo();
        }
    }

    // Find the student with the highest GPA
    public Student findTopStudent() {
        Student topStudent = null;
        for (Student student : studentList) {
            if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;
    }

    // Find students with scholarships
    public ArrayList<Student> findScholarshipStudents() {
        ArrayList<Student> scholarshipStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.hasSchoolship()) {
                scholarshipStudents.add(student);
            }
        }
        return scholarshipStudents;
    }

    // Calculate total tuition of all students
    public double calculateTuitionOfAllStudents() {
        double totalTuition = 0;
        for (Student student : studentList) {
            totalTuition += student.calculateTuition();
        }
        return totalTuition;
    }
}

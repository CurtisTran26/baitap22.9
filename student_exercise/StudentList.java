package student_exercise;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {

    private ArrayList<Student> studentList;
private Scanner scanner;
    public StudentList() {
        studentList = new ArrayList<>();
        scanner =new Scanner(System.in);
    }

    public void addStudent() {
        
        
        System.out.println("Enter student ID: ");
        String id = scanner.nextLine();

        System.out.println("Enter full name: ");
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
        System.out.println("Enter GPA: ");
        float gpa = scanner.nextFloat();
        scanner.nextLine();//consume newline
        System.out.println("Enter Major: ");
        String major = scanner.nextLine();
        Student student =new Student(gpa, major, id, fullName, dateOfBirth);
        studentList.add(student);
    }

    public void deleteStudentById(String ID) {
        studentList.removeIf(student -> student.getID().equals(ID));
    }

    public Student findStudentById(String ID) {
        for (Student student : studentList) {
            if (student.getID().equals(ID)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudent() {
        for (Student student : studentList) {
            student.displayInfo();
            System.out.println("-----------------");
        }
    }

    public Student findTopStudent() {
        if (studentList.isEmpty()) {
            return null;
        }
        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGPA() > topStudent.getGPA()) {
                topStudent = student;
            }
        }
        return topStudent;
    }
    public void updateStudent(){
    System.out.print("Enter student ID to update: ");
                    String updateId = scanner.nextLine();
                    Student studentToUpdate = findStudentById(updateId);
                    if (studentToUpdate != null) {
                        System.out.print("Enter new Full Name: ");
                        String newFullName = scanner.nextLine();

                        studentToUpdate.setFullName(newFullName);
                        System.out.print("Enter new Date Of Birth: ");
                        LocalDate newDateOfBirth = LocalDate.parse(scanner.nextLine());

                        studentToUpdate.setDateOfBirth(newDateOfBirth);
                        System.out.print("Enter new GPA: ");
                        float newGpa = scanner.nextFloat();
                        scanner.nextLine();  // consume newline
                        studentToUpdate.setGPA(newGpa);
                        System.out.println("Enter new major: ");
                        String newMajor = scanner.nextLine();
                        studentToUpdate.setMajor(newMajor);
                    } else {
                        System.out.println("Student not found!");
                    }
}
}

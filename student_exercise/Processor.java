package student_exercise;

import java.time.LocalDate;

import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Add a new student ");
            System.out.println("2.Update a student by id");
            System.out.println("3.Delete a student by id");
            System.out.println("4.Display all students");
            System.out.println("5.Find the student with the highest GPA");
            System.out.println("0.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();//conSume newLine
            switch (choice) {
                case 1:
                
                    
                    studentList.addStudent();
                    break;
                

                case 2:
                    studentList.updateStudent();
                    break;

                case 3:
                    System.out.println("Enter student ID to delete : ");
                    String deleteID = scanner.nextLine();
                    studentList.deleteStudentById(deleteID);
                    break;
                case 4:
                    
                    studentList.displayAllStudent();
                    break;
                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Top student : ");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No sudents found.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option, try again.");

            }
        }
    }
}

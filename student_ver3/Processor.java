package student_ver3;

import java.text.ParseException;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        PersonList personList = new PersonList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Update person");
            System.out.println("4. Delete person by ID");
            System.out.println("5. Find person by ID");
            System.out.println("6. Display all students and teachers");
            System.out.println("7. Find the student with the highest GPA");
            System.out.println("8. Find a teacher by department");
            System.out.println("9. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (option == 9) break;

            switch (option) {
                case 1:
                    personList.addStudent();
                    break;
                case 2:
                    personList.addTeacher();
                    break;
                case 3:
                    personList.updatePerson();
                    break;
                case 4:
                    personList.deletePersonById();
                    break;
                case 5:
                    personList.findPersonById();
                    break;
                case 6:
                    personList.displayEveryone();
                    break;
                case 7:
                    personList.findTopStudent();
                    break;
                case 8:
                    personList.findTeacherByDepartment();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}

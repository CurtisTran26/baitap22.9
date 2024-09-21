package student_ver3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

class PersonList {
    private ArrayList<Person> personList;
    private Scanner scanner;

    // Constructor
    public PersonList() {
        this.personList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter number of students to add: ");
        int num = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < num; i++) {
            System.out.println("Entering details for Student " + (i + 1) + ":");
            Student student = new Student();
            student.inputStudentDetails();
            personList.add(student);
        }
    }

    public void addTeacher() {
        Teacher teacher = new Teacher();
        teacher.inputTeacherDetails();
        personList.add(teacher);
    }

    public void updatePerson() {
        System.out.print("Enter person ID to update: ");
        String uId = scanner.nextLine();
        for (Person p : personList) {
            if (p.getId().equals(uId)) {
                System.out.print("Enter new name: ");
                p.setFullName(scanner.nextLine());
                System.out.print("Enter new DOB (dd/MM/yyyy): ");
                String uDOB = scanner.nextLine();
                try {
                    p.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(uDOB));
                } catch (Exception e) {
                    System.out.println("Wrong format.");
                }
                return;
            }
        }
        System.out.println("Person not found.");
    }

    public void deletePersonById() {
        System.out.print("Enter person ID to delete: ");
        String dId = scanner.nextLine();
        boolean removed = personList.removeIf(p -> p.getId().equals(dId));
        if (removed) {
            System.out.println("Person deleted.");
        } else {
            System.out.println("Person not found.");
        }
    }

    public void findPersonById() {
        System.out.print("Enter person ID: ");
        String fId = scanner.nextLine();
        for (Person p : personList) {
            if (p.getId().equals(fId)) {
                p.displayInfo();
                return;
            }
        }
        System.out.println("Person not found.");
    }

    public void displayEveryone() {
        for (Person p : personList) {
            p.displayInfo();
        }
    }

    public void findTopStudent() {
        Student topStudent = null;
        for (Person p : personList) {
            if (p instanceof Student) {
                Student s = (Student) p;
                if (topStudent == null || s.getGpa() > topStudent.getGpa()) {
                    topStudent = s;
                }
            }
        }
        if (topStudent != null) {
            topStudent.displayInfo();
        } else {
            System.out.println("No students found.");
        }
    }

    public void findTeacherByDepartment() {
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        boolean found = false;
        for (Person p : personList) {
            if (p instanceof Teacher) {
                Teacher t = (Teacher) p;
                if (t.getDepartment().equals(department)) {
                    t.displayInfo();
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No teacher found in the specified department.");
        }
    }
}

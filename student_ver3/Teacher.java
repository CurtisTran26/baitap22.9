package student_ver3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Teacher extends Person {
    private String department;
    private String teachingSubject;

    // Constructors
    public Teacher(String department, String teachingSubject, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    public Teacher() {
    }

    // Getters and setters
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

    public void inputTeacherDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter teacher ID: ");
        setId(scanner.nextLine());
        System.out.print("Enter teacher name: ");
        setFullName(scanner.nextLine());
        System.out.print("Enter teacher DOB (dd/MM/yyyy): ");
        
        String dateOfBirthString = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            setDateOfBirth(sdf.parse(dateOfBirthString));
        } catch (Exception e) {
            System.out.println("Wrong format, setting DOB to null.");
            setDateOfBirth(null);
        }
        
        System.out.print("Enter department: ");
        setDepartment(scanner.nextLine());
        System.out.print("Enter teaching subject: ");
        setTeachingSubject(scanner.nextLine());
    }

    @Override
    public void displayInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Teacher ID: " + getId() + ", Name: " + getFullName() +
                ", DOB: " + (getDateOfBirth() != null ? sdf.format(getDateOfBirth()) : "N/A") +
                ", Department: " + department + ", Subject: " + teachingSubject);
    }
}

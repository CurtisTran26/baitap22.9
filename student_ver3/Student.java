package student_ver3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Student extends Person {
    private float gpa;
    private String major;

    // Constructors
    public Student(float gpa, String major, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

    public Student() {
    }

    // Getters and setters
    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // Add student information
    public void inputStudentDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        setId(scanner.nextLine());
        System.out.print("Enter student name: ");
        setFullName(scanner.nextLine());
        System.out.print("Enter student DOB (dd/MM/yyyy): ");
        
        String dateOfBirthString = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            setDateOfBirth(sdf.parse(dateOfBirthString));
        } catch (Exception e) {
            System.out.println("Wrong format, setting DOB to null.");
            setDateOfBirth(null);
        }
        
        System.out.print("Enter GPA: ");
        setGpa(scanner.nextFloat());
        scanner.nextLine(); // consume newline
        System.out.print("Enter major: ");
        setMajor(scanner.nextLine());
    }

    @Override
    public void displayInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Student ID: " + getId() + ", Name: " + getFullName() +
                ", GPA: " + gpa + ", Major: " + major +
                ", DOB: " + (getDateOfBirth() != null ? sdf.format(getDateOfBirth()) : "N/A"));
    }
}

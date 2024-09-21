package student_ver2;

import java.time.LocalDate;

public class Student extends Person {
    private float gpa;
    private String major;
    private double tuition = 10000000;
    private boolean schoolship;

    public Student(float gpa, String major, boolean schoolship, String id, String fullName, LocalDate dateOfBirth) {
        super(id, fullName, dateOfBirth);
        if (gpa < 0 || major == null || major.isEmpty()) {
            throw new IllegalArgumentException("Invalid GPA or Major");
        }
        this.gpa = gpa;
        this.major = major;
        this.schoolship = schoolship;
    }

    public Student() {
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        if (gpa < 0) {
            throw new IllegalArgumentException("GPA cannot be negative");
        }
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if (major == null || major.isEmpty()) {
            throw new IllegalArgumentException("Major cannot be null or empty");
        }
        this.major = major;
    }

    public double getTuition() {
        return tuition;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public boolean hasSchoolship() {
        return schoolship;
    }

    public double calculateTuition() {
        return schoolship ? tuition * 0.5 : tuition;
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date Of Birth: " + getDateOfBirth());
        System.out.println("GPA: " + getGpa());
        System.out.println("Major: " + getMajor());
        System.out.printf("Tuition: %.2f%n", calculateTuition());
        System.out.println("Scholarship: " + (schoolship ? "Yes" : "No"));
    }
}

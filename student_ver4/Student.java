package student_ver4;

import java.util.Date;

public class Student extends Person {
    private float gpa;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

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

    @Override
    public void displayInfo() {
        System.out.println("ID: "+getId()+", Student Info: " + getFullName() + ", Date of Birth: " + getFormattedDateOfBirth() + ", Major: " + major + ", GPA: " + gpa);
    }
}

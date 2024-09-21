package student_exercise;

import java.time.LocalDate;
import java.util.Date;

public class Student extends Person {

    private float GPA;
    private String major;

    public Student(float GPA, String major, String ID, String FullName, LocalDate DateOfBirth) {
        super(ID, FullName, DateOfBirth);
        this.GPA = GPA;
        this.major = major;
    }

    

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + getID());
        System.out.println("Name: " + getFullName());
        System.out.println("Date OF Birth: " + getDateOfBirth());
        System.out.println("GPA: " + getGPA());
        System.out.println("Major: " + getMajor());
    }
}

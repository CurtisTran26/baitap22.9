package student_ver2;

import java.time.LocalDate;

/**
 *
 * @author Trần Đặng Quang Duy
 */
public abstract class Person implements IPerson {
    private String id;
    private String fullName;
    private LocalDate dateOfBirth;

    public Person(String id, String fullName, LocalDate dateOfBirth) {
        if (id == null || fullName == null || dateOfBirth == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public abstract void displayInfo();

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + fullName + ", Date of Birth: " + dateOfBirth;
    }
}

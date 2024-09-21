package student_exercise;

import java.time.LocalDate;
import java.util.Date;

public abstract class Person implements IPerson {

    private String ID;
    private String FullName;
    private LocalDate DateOfBirth;

    public Person(String ID, String FullName, LocalDate DateOfBirth) {
        this.ID = ID;
        this.FullName = FullName;
        this.DateOfBirth = DateOfBirth;
    }

    public Person() {
    }
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    @Override
    public abstract void
            displayInfo();

}

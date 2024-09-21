
package student_ver3;
import java.util.Date;





// Abstract class Person
public abstract class Person implements IPerson {
    private String id;
    private String fullName;
    Date dateOfBirth;
   

    // Constructor

    public Person(String id, String fullName, Date dateOfBirth) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    // Getters and setters
    public void setDateOfBirth(Date dateOfBirth) {    
        this.dateOfBirth = dateOfBirth;
    }

    // Abstract method displayInfo (to be implemented by subclasses)
    @Override
    public abstract void displayInfo();
}

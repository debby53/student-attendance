package STUDENT_ATTENDANCE;
import java.util.regex.Pattern;
class InvalidAttendanceException extends Exception{
    public InvalidAttendanceException(String message){
        super(message);
    }
}

public class Person {
    private String name;
    private  int id;
    private String email;

    public Person(String name, int id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(String.valueOf(id).length()==6) {
            this.id = id;
        }else{
            throw new IllegalArgumentException("ID must be a 6-digit number.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String emailRegex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        if(Pattern.matches(emailRegex,email)) {

            this.email = email;
        }else {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }
}

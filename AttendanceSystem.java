package STUDENT_ATTENDANCE;
import java.util.HashMap;
import java.util.Map;
class InvalidStudentIdException extends Exception{
    public InvalidStudentIdException(String message){
        super(message);
    }
}


public class AttendanceSystem  implements IAttendanceManager{
    private Map<Integer,Student>studentMap;

    public AttendanceSystem(){
        this. studentMap=new HashMap<>();

    }
    public void addStudent(Student student) {
        studentMap.put(student.getId(),student);
    }
    @Override
    public void markAttendance(int studentId, Boolean isPresent)throws InvalidStudentIdException {
        Student student=studentMap.get(studentId);
        if(student==null){
            throw new InvalidStudentIdException("student "+studentId + "does not exist");
        }try{
            student.updateAttendance(isPresent? 1:0,1);
        }catch (InvalidAttendanceException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void getAttendance(int studentId) throws InvalidStudentIdException {
        Student student=studentMap.get(studentId);
        if(student==null){
            throw new InvalidStudentIdException("student id "+ studentId + "does not exist");

        }
        System.out.println(student.getAttendancePercentage());


    }

    @Override
    public void generateAttendanceReport() {
        System.out.println("\nAttendance Report:");
        for(Student student : studentMap.values()){
            System.out.println("student id is "+student.getId());
            System.out.println("name is "+student.getName());
            System.out.println("attendance is "+student.getAttendancePercentage());

        }

    }
}

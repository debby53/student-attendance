package STUDENT_ATTENDANCE;

public class Student extends Person{
    private double grade;
    private double  attendancePercentage;
    private String  section;
    private int daysPresent;
    private int totalDays;

    public Student(String name, int id, String email, int totalDays, int daysPresent) {
        super(name, id, email);
        this.totalDays = 0;
        this.daysPresent = 0;
    }

    public Student(String name, int id, String email, double grade, double attendancePercentage, String section) {
        super(name, id, email);
        this.grade = grade;
        this.attendancePercentage = 0.0;
        this.section = section;

    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getAttendancePercentage() {
        return attendancePercentage;
    }

    public void setAttendancePercentage(double attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
    public void updateAttendance(int daysPresent, int totalDays)throws InvalidAttendanceException{
        if(daysPresent<0 || totalDays<0 || daysPresent>totalDays){
            throw new InvalidAttendanceException("invalid attendance data: dayspresent and totaldays must greater than 0 and dayspresent<=totaldays");
        }
        this.daysPresent+=daysPresent;
        this.totalDays+=totalDays;
        this.attendancePercentage=((double)this.daysPresent/this.totalDays)*100;


    }
}

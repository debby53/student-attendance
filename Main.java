package STUDENT_ATTENDANCE;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AttendanceSystem system = new AttendanceSystem();
        for (int j = 0; j< 3; j++) {
            System.out.println("enter student details for student "+(j+1));
            String name;
            int id;
            String email;
            double grade;
            String section;
            double perc;
            while (true) {
                System.out.println("enter your id");
                try {
                    id = Integer.parseInt(sc.nextLine());
                    if (String.valueOf(id).length() == 6) {
                        break;
                    } else {
                        System.out.println("plz try again");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. ID must be numeric. Try again.");
                }
            }
            while (true) {
                System.out.println("enter email");



                email = sc.nextLine();
                String emailRegex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
                if (Pattern.matches(emailRegex, email)) {
                    break;
                } else {
                    System.out.println("Invalid email format. Try again.");
                }

            }
            System.out.print("Enter your name: ");
            name = sc.nextLine();
            System.out.print("Enter your grade: ");
            grade = Double.parseDouble(sc.nextLine()); // Consume newline safely
            System.out.print("Enter your section: ");
            section = sc.nextLine();
            System.out.println("Enter attendance percentage (0.0 for new student): ");
            perc = Double.parseDouble(sc.nextLine());

            Student student = new Student(name, id, email,grade,perc,section);
            system.addStudent(student);
            for(int i=0; i<5; i++){
                System.out.println("Mark Attendance for Day "+(i+1));
                int studentId;
                boolean isPresent;
                while (true){
                    try {
                        System.out.print("Enter Student ID: ");
                        studentId = Integer.parseInt(sc.nextLine());
                        System.out.print("Is Present (true/false): ");
                        isPresent=Boolean.parseBoolean(sc.nextLine());
                        system.markAttendance(studentId, isPresent);
                        system.getAttendance(id);
                        break;
                    } catch (InvalidStudentIdException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Invalid input. Try again.");
                    }


                }
            }
            system.generateAttendanceReport();
        }
    }
}

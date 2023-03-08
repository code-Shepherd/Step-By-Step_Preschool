import java.util.Scanner;


public class RegisterStudentUI extends DecoratorUI {

    private StudentController reg;
    private final String name = "Parents Options";
    
    public RegisterStudentUI(){
        reg = new StudentController();
        Scanner scanner = new Scanner(System.in);

        clrscr();
        decorateLine(20);
        System.out.println(name);
        decorateLine(20);
        System.out.println("1.Register Student");
        System.out.println("2.Exit");
        newLine(3);
        System.out.print("Enter option: ");
        int opt1 = scanner.nextInt();
        if(opt1 == 1){
            Student student = enterStudentInfo();
            clrscr();
            // Print the student information
            System.out.println("\nStudent information:");
            System.out.println(student);
            newLine(2);
            System.out.println("Press 1 to submit or 0 to exit");
            int opt2 = scanner.nextInt();
                if (opt2==1){
                    if(reg.registerStudent(student))
                        System.out.println("Student successfully registered");
                    else
                        System.out.println("Student unsuccessfully registered");
                }
                else
                    exit(2);
        }
        else if (opt1 ==2){
            System.out.println("System exiting ...");
            exit(2);
        }
        else
            System.out.println("Invalid Input");  
    }


    private Student enterStudentInfo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the student registration form!");
        newLine(1);
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        scanner.nextLine(); // consume newline left-over

        System.out.print("Enter date of birth (yyyy-mm-dd): ");
        String dob = scanner.nextLine();

        System.out.print("Enter gender (MALE/FEMALE): ");
        Gender gender = Gender.MALE;
        try{
            String genderStr = scanner.nextLine().toUpperCase();
            gender = Gender.valueOf(genderStr);
        }
        catch(IllegalArgumentException e){}

        newLine(2);
        System.out.println("Enter Parent 1 Information");
        Guardian parent1 = readGuardian(scanner);

        newLine(2);
        System.out.println("Enter Parent 2 Information (Enter 'skip' to skip)");
        Guardian parent2 = null;
        String skip = scanner.nextLine();
        if (!skip.equalsIgnoreCase("skip")) {
            parent2 = readGuardian(scanner);
        }

        System.out.println("Enter Emergency Contact Information");
        Guardian emerContact = readGuardian(scanner);

        //systempause
        clrscr();
        /*int id = 0; // default value
        System.out.print("Enter ID (optional): ");
        String idStr = scanner.nextLine();
        if (!idStr.isEmpty()) {
            id = Integer.parseInt(idStr);
        }*/

        // Create a new student object
        Student student = new Student(firstName, lastName, address, gender, age, dob, parent1, parent2, emerContact);
        return student;
        /*if (id != 0) {
            student.setId(id);
        }*/
    }

    private static Guardian readGuardian(Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter address: ");
        String addr = scanner.nextLine();

        System.out.print("Enter relation: ");
        String relation = scanner.nextLine();

        return new Guardian(firstName, lastName, phone,addr, relation);
    }
}

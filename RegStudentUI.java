import java.util.Scanner;


public class RegStudentUI extends DecoratorUI {

    private RegStudentController reg;
    
    public RegStudentUI(){
        reg = new RegStudentController();
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
        
        /*if (id != 0) {
            student.setId(id);
        }*/

        // Print the student information
        clrscr();
        System.out.println("\nStudent information:");
        System.out.println(student);
        newLine(2);
        System.out.println("Press 1 to submit and 0 to exit");
        int opt = scanner.nextInt();
        if (opt==1)
            if(reg.createStudent(student))
                System.out.println("Student Successfully created");
            else
                System.out.println("Student unsuccessfully created");
        else
            exit(2);
        
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

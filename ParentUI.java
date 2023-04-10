import java.util.InputMismatchException;
import java.util.Scanner;


public class ParentUI extends DecoratorUI {

    private StudentController reg;
    private final String name = "Parents Options";
    
    public ParentUI(StudentController stcon){
        reg = stcon;
        Scanner scan = new Scanner(System.in);
        int menu = 1;
        while (menu!=0)
        {
            try{
                clrscr();
                String menuOptions = "=======";
                menuOptions += name;
                menuOptions+= "=======\n";
                menuOptions+="1.Register Student\n";
                menuOptions+="2.View Student Record\n";
                menuOptions+="3.View Student Report\n";
                menuOptions+="0.Exit\n";
                menuOptions+="====================================\n";
                System.out.println(menuOptions); 
                newLine(1); 
                System.out.println("Enter Option: ");     
                menu = scan.nextInt();
                switch(menu){
                    case 1:{
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        Student student = enterStudentInfo();
                        clrscr();
                        // Print the student information
                        System.out.println("\nStudent information:");
                        System.out.println(student);
                        newLine(2);
                        System.out.println("Press 1 to submit or 0 to exit");
                        int opt2 = scan.nextInt();
                        if (opt2==1){
                            reg.registerStudent(student);
                            System.out.println("Student successfully registered");       
                        }
                        else
                            exit(2);
                        break;
                    }
                    case 2:{
                        String stName = enterName();
                        String pName = enterParentName();
                        Student st = reg.findStudent(stName);
                        if (reg.studentExist(st)){
                            if (reg.verifyDetails(stName, pName)){
                                System.out.println(st);
                            }
                            else
                                System.out.println("Parent does not belong to child");  
                        }
                        else
                            System.out.println(name+" does not exist in database"); 
                        break;
                    }
                    case 3:{
                        String stName = enterName();
                        String pName = enterParentName();
                        Student st = reg.findStudent(stName);
                        if (reg.studentExist(st)){
                            if (reg.verifyDetails(stName, pName)){
                                new ReportForm(st);
                            }
                            else
                                System.out.println("Parent does not belong to child");  
                        }
                        else
                            System.out.println(name+" does not exist in database"); 
                        break;
                    }  
                }              
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Option");
            }   
        }
    }


    Student enterStudentInfo(){
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

        newLine(2);
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

    String enterParentName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter parent full name: ");
        String pName = scan.nextLine();
        return pName;
           
    }
    private String enterName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter student full name: ");
        String name = scan.nextLine();
        return name;    
    }
}



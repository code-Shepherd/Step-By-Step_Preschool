import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AdminUI{
    private final String name = "Admin Options";
    private StudentController sc;
    DecoratorUI dui = new DecoratorUI();

    public AdminUI(StudentController stCon){
        Scanner scanner = new Scanner(System.in);
        AdminUI thisForm = this;
        sc = stCon;
        int menu = 1;
        while (menu!=0)
        {
            try{
                dui.clrscr();
                String menuOptions = "=======";
                menuOptions += name;
                menuOptions+= "=======\n";
                menuOptions+="1.Register Student\n";
                menuOptions+="2.Assign Student to Class\n";
                menuOptions+="3.View Student Record\n";
                menuOptions+="4.Modify Student Record\n";
                menuOptions+="5.Enter Student Grades\n";
                menuOptions+="6.Generate Report\n";
                menuOptions+="7.View Student Report\n";
                menuOptions+="8.View Class\n";
                menuOptions+="9.Enter Employee Information\n";
                menuOptions+="0.Exit\n";
                menuOptions+="====================================\n";
                System.out.println(menuOptions); 
                dui.newLine(1); 
                System.out.print("Enter option: ");     
                menu = scanner.nextInt();
                switch(menu){
                    case 1:{
                        dui.clrscr();
                        Student student = enterStudentInfo();
                        dui.clrscr();
                        //Print the student information
                        System.out.println("\nStudent information:");
                        System.out.println(student);
                        dui.newLine(2);
                        System.out.println("Press 1 to submit or 0 to exit");
                        int opt2 = scanner.nextInt();
                        if (opt2==1){
                            sc.registerStudent(student);
                            System.out.println("Student successfully registered");
                            dui.pause(3);       
                        }
                        else
                            dui.exit(2);
                        break;
                    }
                    case 2:{
                        dui.clrscr();
                        if (sc.getUnassignSt().size()<1){
                            System.out.println("There is no unassign students");
                            dui.pause(3);   
                        }
                        else{
                            sc.assignSt();
                        }
                        break;
                    }
                    case 3:{
                        String stName = enterName();
                        Student st = sc.findStudent(stName);
                        //System.out.println(st);
                        if (sc.studentExist(st)){
                            System.out.println(st);
                            dui.pause(12);
                            String y = scanner.nextLine();
                        }
                        else
                            System.out.println(name+" does not exist in database");    
                        break;
                    }
                    case 4:{ break;}
                        //modify student record
                    case 5:{
                        String name = enterName();
                        dui.clrscr();
                        Student student = sc.findStudent(name);
                        if (sc.studentExist(student))
                            new EnterGradesUI(student,thisForm);
                        else
                            System.out.println(name+" does not exist in the database"); 
                            dui.pause(3);
                        break;
                    }
                    case 6:{
                        String name = enterName();
                        dui.clrscr();
                        Student student = sc.findStudent(name);
                        if (sc.studentExist(student)){
                            enterReportInfo(student);
                            System.out.println(" Student report successfully generated");
                            dui.pause(3);
                        }
                        else
                            System.out.println(name+" does not exist in the database");
                            dui.pause(3);
                        break;
                    }
                    case 7:{
                        String name = enterName();
                        dui.clrscr();
                        Student student = sc.findStudent(name);
                        if (sc.studentExist(student)){
                            new ReportForm(student);
                        }
                        else
                            System.out.println(name+" does not exist in the database");
                            dui.pause(3);
                        break;
                    }
                    case 8:{
                        dui.clrscr();
                        displayClasses();
                        dui.newLine(1);
                        int cl = enterClass();
                        dui.clrscr();
                        String clas = sc.getClasses().get(cl-1);
                        displayStOfClass(clas);
                        break;
                    }
                    case 9:
                    //enter employee info
                }              
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Option");
            }
        }   }


    public void saveExit(Student student, Grade grades){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to Save and Exit or 0 to Exit Only");
        int opt = scanner.nextInt();
        if (opt == 1){
            sc.addGrade(student, grades);
        }
        dui.newLine(2);

    }

    private void enterReportInfo(Student student) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter current term: ");
        int term = scan.nextInt();
        System.out.print("Enter sessions absent: ");
        int absent = scan.nextInt();
        System.out.print("Enter sessions present: ");
        int present = scan.nextInt();
        sc.createReport(student,absent,present,term);   
    }

    private String enterName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter student full name: ");
        String name = scan.nextLine();
        return name;    
    }

    private int enterClass() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter class number: ");
        int cl = scan.nextInt();
        return cl;    
    }

    public void displayClasses(){
        String str;
        System.out.print("Class\n");
        ArrayList<String> classes = sc.getClasses();
        for(int i=0; i<classes.size();i++){
            str=(i+1)+". ";
            System.out.print(str+classes.get(i)+"\n");
        }
    }

    public void displayStOfClass(String cl) {
        ArrayList<Student> slst = sc.getStOfClass(cl);
        for (int i=0;i<slst.size();i++){
            Student st = slst.get(i);
            System.out.println(st.getName());
        }      
    }

    public Student enterStudentInfo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the student registration form!");
        dui.newLine(1);
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

        dui.newLine(2);
        System.out.println("Enter Parent 1 Information");
        Guardian parent1 = readGuardian(scanner);

        dui.newLine(2);
        System.out.println("Enter Parent 2 Information (Enter 'skip' to skip)");
        Guardian parent2 = null;
        String skip = scanner.nextLine();
        if (!skip.equalsIgnoreCase("skip")) {
            parent2 = readGuardian(scanner);
        }

        dui.newLine(2);
        System.out.println("Enter Emergency Contact Information");
        Guardian emerContact = readGuardian(scanner);

        //systempause
        dui.clrscr();
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

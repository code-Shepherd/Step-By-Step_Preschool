import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminUI extends DecoratorUI {
    private final String name = "Admin Options";
    private StudentController sc;
    private ParentUI ui = new ParentUI(sc);

    public AdminUI(StudentController stCon){
        Scanner scanner = new Scanner(System.in);
        AdminUI thisForm = this;
        sc = stCon;
        int menu = 1;
        while (menu!=0)
        {
            try{
                clrscr();
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
                newLine(1); 
                System.out.print("Enter option: ")      
                menu = scanner.nextInt();
                switch(menu){
                    case 1:{
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        Student student = ui.enterStudentInfo();
                        clrscr();
                        // Print the student information
                        System.out.println("\nStudent information:");
                        System.out.println(student);
                        newLine(2);
                        System.out.println("Press 1 to submit or 0 to exit");
                        int opt2 = scanner.nextInt();
                        if (opt2==1){
                            sc.registerStudent(student);
                            System.out.println("Student successfully registered");       
                        }
                        else
                            exit(2);
                        break;
                    }
                    case 2:{
                        clrscr();
                        sc.assignSt();
                        break;
                    }
                    case 3:{
                        String stName = enterName();
                        Student st = sc.findStudent(stName);
                        if (sc.studentExist(st))
                            System.out.println(st);
                        else
                            System.out.println(name+" does not exist in database");    
                        break;
                    }
                    case 4:
                        //modify student record
                    case 5:{
                        String name = enterName();
                        clrscr();
                        Student student = sc.findStudent(name);
                        if (sc.studentExist(student))
                            new EnterGradesUI(student,thisForm);
                        else
                            System.out.println(name+" does not exist in the database"); 
                        break;
                    }
                    case 6:{
                        String name = enterName();
                        clrscr();
                        Student student = sc.findStudent(name);
                        if (sc.studentExist(student)){
                            enterReportInfo(student);
                            System.out.println(" Student report successfully generated");
                        }
                        else
                            System.out.println(name+" does not exist in the database");
                        break;
                    }
                    case 7:{
                        String name = enterName();
                        clrscr();
                        Student student = sc.findStudent(name);
                        if (sc.studentExist(student)){
                            new ReportForm(student);
                        }
                        else
                            System.out.println(name+" does not exist in the database");
                        break;
                    }
                    case 8:{
                        clrscr();
                        displayClasses();
                        int cl = enterClass();
                        clrscr();
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
        }
    }


    public void saveExit(Student student, Grade grades){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to Save and Exit or 0 to Exit Only");
        int opt = scanner.nextInt();
        if (opt == 1){
            sc.addGrade(student, grades);
        }
        newLine(2);

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

}

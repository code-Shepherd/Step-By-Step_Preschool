import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminUI extends DecoratorUI {
    private final String name = "Admin Options";
    private StudentController sc;

    public AdminUI(StudentController stCon){
        Scanner scanner = new Scanner(System.in);
        AdminUI thisForm = this;
        sc = stCon;
        int menu = 1;
        while (menu!=0)
        {
            try{
                String menuOptions = "=======";
                menuOptions += name;
                menuOptions+= "=======\n";
                menuOptions+="1.Assign Student to Class\n";
                menuOptions+="2.Enter Student Grades\n";
                menuOptions+="3.Generate Report\n";
                menuOptions+="4.View Student Report\n";
                menuOptions+="0.Exit\n";
                menuOptions+="====================================\n";
                System.out.println(menuOptions); 
                newLine(3);       
                menu = scanner.nextInt();
                switch(menu){
                    case 1:{
                        clrscr();
                        //db.getUnassignSt();
                        //to be implemented
                            break;
                    }
                    case 2:{
                        String name = enterName();
                        clrscr();
                        System.out.println(name);
                        Student student = sc.findStudent(name);
                        System.out.println(student);
                        if (sc.studentExist(student))
                            new EnterGradesUI(student,thisForm);
                        else
                            System.out.println(name+" does not exist in the database"); 
                        break;
                    }
                    case 3:{
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
                    case 4:{
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

}

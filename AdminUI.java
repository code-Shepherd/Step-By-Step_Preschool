import java.util.ArrayList;
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
                        displayUnassign(sc.getUnassignSt());
                        break;
                    }
                    case 2:{
                        String name = enterName();
                        clrscr();
                        Student student = sc.findStudent(name);
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

    private void displayUnassign(ArrayList<Student> unassignSt) {
        if (unassignSt.size()<1){
            System.out.println("There is no unassign students");
        }
        else{
            for(int i =0;i<unassignSt.size();i++){
                Scanner scan = new Scanner(System.in);
                Student st = unassignSt.get(i); 
                String str = "Name: "+unassignSt.get(i).getName()+ "\tDate of Birth: "+st.getDob()+ "\tAge: "+st.getAge();
                System.out.println(str);
                ArrayList<String> classes = new  ArrayList<String>();
                classes.add("Nursery 1");
                classes.add("Nursery 2");
                classes.add("Nursery 3");
                classes.add("Nursery 4");
                classes.add("Nursery 5");
                classes.add("Kindergarten 1");
                classes.add("Kindergarten 2");
                classes.add("Kindergarten +");
                String str1 = "\n1.Nursery 1\t2.Nursery 2\t3.Nursery 3\t4.Nursery 4\t5.Nursery 5";
                str1+= "\t6.Kindergarten 1\t7.Kindergarten 2\t8.Kindergarten +";
                System.out.println(str1);
                System.out.println("\nEnter Option");
                int opt = scan.nextInt();
                String cl = classes.get(opt-1);
                st.setGradeClass(cl);  
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

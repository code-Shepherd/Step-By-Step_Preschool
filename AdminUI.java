import java.util.Scanner;

public class AdminUI extends DecoratorUI {
    private final String name = "Admin Options";
    private StudentDBController db;
    private EnterGradesUI egui;

    public AdminUI(){
        Scanner scanner = new Scanner(System.in);
        db = new StudentDBController();
        egui = new EnterGradesUI();
        clrscr();
        decorateLine(20);
        System.out.println(name);
        decorateLine(20);
        System.out.println("1.Assign Student to Class");
        System.out.println("2.Enter Student Grades");
        System.out.println("3.Exit");
        newLine(2);
        System.out.print("Enter option: ");
        int opt = scanner.nextInt();
        if(opt == 1){
            clrscr();
            //to be implemented
        }
        else if(opt == 2){
            String name = enterName();
            clrscr();
            if (db.studentExist(name)){
                egui.displayGradeForm(name);
            }
            else{
                newLine(2);
                System.out.print(name); 
                System.out.print(" does not exist in database");
                newLine(2); 
            }
        }
        else if (opt ==3 ){
            System.out.println("System exiting ...");
            exit(2);
        }
        else
            System.out.println("Invalid Input");
    }

    private String enterName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter student full name: ");
        String name = scan.nextLine();
        return name;
        
    }

}

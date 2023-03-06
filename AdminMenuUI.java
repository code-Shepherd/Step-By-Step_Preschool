import java.util.Scanner;

public class AdminMenuUI extends DecoratorUI {
    private final String name = "Admin Options";

    public AdminMenuUI(){
        Scanner scanner = new Scanner(System.in);

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
            new AssignStController();}
        if(opt == 2){
            clrscr();
            new EnterStGradesUI();}
        else if (opt ==3 ){
            System.out.println("System exiting ...");
            exit(2);}
        else
            System.out.println("Invalid Input");
    }


}

import java.util.Scanner;

public class ParentMenuUI extends DecoratorUI{
    private final String name = "Parents Options";
    
    public ParentMenuUI(){
        Scanner scanner = new Scanner(System.in);

        clrscr();
        decorateLine(20);
        System.out.println(name);
        decorateLine(20);
        System.out.println("1.Register Student");
        System.out.println("2.Exit");
        newLine(3);
        System.out.print("Enter option: ");
        int opt = scanner.nextInt();
        if(opt == 1){
            clrscr();
            new RegStudentUI();}
        else if (opt ==0 )
            System.out.println("System exiting ...");
        else
            System.out.println("Invalid Input");  
    }

}

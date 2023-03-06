import java.util.Scanner;

public class EnterStGradesUI extends DecoratorUI {

    EnterStGradesController obj;
    
    public EnterStGradesUI(){
        Scanner scanner = new Scanner(System.in);
        obj = new EnterStGradesController();
        clrscr();
        System.out.println("Enter full student name");
        String name = scanner.nextLine();
        if (obj.studentExist(name)){
            clrscr();
            new GradeFormUI(name);}
        else{
            newLine(2);
            System.out.print(name); 
            System.out.print(" does not exist in database");
            newLine(2); }

    }
}

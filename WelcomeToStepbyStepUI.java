import java.util.InputMismatchException;
import java.util.Scanner;

public class WelcomeToStepbyStepUI extends DecoratorUI{
    private final String name = "Welcome to Step-by-Step PreSchool Online Platform";
    
    public WelcomeToStepbyStepUI(){
        clrscr();
        decorateLine(50);
        System.out.println(name);
        decorateLine(50);
        newLine(2);
        getInfo();   
    }

    public void getInfo(){
        int t=0;
        while (t<3){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter 1 to continue as parent or 2 to continue as administrator. Press 0 to exit");
            try{
                int opt = scanner.nextInt();
                if (opt ==1)
                    new RegisterStudentUI();
                else if (opt ==2)
                    new AdminUI();
                else if(opt ==0) {   
                    System.out.println("System exitting.....");
                    System.exit(2);}
                else
                    System.out.println("Invalid Option");
                }
            catch(InputMismatchException e){
                System.out.println("Invalid Option");
            }
            t+=1;

        }
        System.out.println("System exitting.....");
    }
}
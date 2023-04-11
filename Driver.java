import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    
    public Driver(){}
    public static void main(String[] args) {
        StudentController stCon = new StudentController();
        String title = "Welcome to Step-Step Online Platform";
        DecoratorUI dui = new DecoratorUI();

        stCon.registerStudent(new Student("Daneel", "Downer", "9 Miles Bull Bay Beach Road", Gender.FEMALE, 2,"2002-03-10", new Guardian("Celia", "Fearon", "3453245", null, "mother"), null, null));

        Scanner scan = new Scanner(System.in);
        int t=1;
        while (t!=0)
        {
            try{
                dui.clrscr();
                System.out.println(title);
                dui.decorateLine(36);
                dui.newLine(2);
                String menuOptions = "=======";
                menuOptions += "User";
                menuOptions+= "=======\n";
                menuOptions+="1.Parent\n";
                menuOptions+="2.Admin\n";
                menuOptions+="0.Exit\n";
                menuOptions+="====================================\n";
                System.out.println(menuOptions);
                System.out.println("Enter option #: ");       
                int menu = scan.nextInt();
                t=menu;
                switch(menu){
                    case 1:{
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            new ParentUI(stCon);
                            break;
                        }
                    case 2:{
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            new AdminUI(stCon);
                            break;
                        }  
                }
                           
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Option");
            }   
        }
        System.out.println("System exitting.....");
        System.exit(2);
    }

}


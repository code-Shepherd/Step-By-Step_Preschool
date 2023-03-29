import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    
    public Driver(){}
    public static void main(String[] args) {
        StudentController stCon = new StudentController();

        Scanner scan = new Scanner(System.in);
        int menu = 1;
        while (menu!=0)
        {
            try{
                System.out.print("\033[H\033[2J");
                System.out.flush();
                String menuOptions = "=======";
                menuOptions += "User";
                menuOptions+= "=======\n";
                menuOptions+="1.Parent\n";
                menuOptions+="2.Admin\n";
                menuOptions+="0.Exit\n";
                menuOptions+="====================================\n";
                System.out.println(menuOptions);        
                menu = scan.nextInt();
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


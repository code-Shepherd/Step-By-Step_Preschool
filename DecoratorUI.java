import java.util.concurrent.TimeUnit;

public class DecoratorUI {
    private final String a = "#";

    public DecoratorUI(){}

    public void clrscr() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void decorateLine(int n){
        for (int i=0;i<n;i++){
            System.out.print(a);
        }
        System.out.println();
    }

    public void pause(int n){
        System.out.println("\nScreen pause for"+n+"seconds...");
        try {
            TimeUnit.SECONDS.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void newLine(int n) {
        for (int i=0;i<n;i++){
            System.out.println("");
        }
    }

    public void exit(int n) {
        System.exit(n);
    }

}

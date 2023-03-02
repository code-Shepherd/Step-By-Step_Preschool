public abstract class Decorator {
    private final String a = "#";

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

    public void newLine(int n) {
        for (int i=0;i<n;i++){
            System.out.println("");
        }
    }

    public void exit(int n) {
        System.exit(n);
    }

}

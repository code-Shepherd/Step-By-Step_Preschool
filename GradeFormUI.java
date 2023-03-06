import java.util.Scanner;

public class GradeFormUI extends DecoratorUI{

    private EnterStGradesController obj;

    public GradeFormUI(String name){
        obj = new EnterStGradesController();
        Scanner scanner = new Scanner(System.in);
        Grade grades = new Grade();
        String title = "Grade Report of "+name;
        System.out.println(title);
        decorateLine(30);
        key();
        newLine(1);
        emotional(scanner, grades);

        System.out.println("Press 1 to Save or 0 to Exit");
        int opt = scanner.nextInt();
        if (opt == 1){
            obj.addGrade(name, grades);
        }

        newLine(2);
    }

    private void key(){
        String str = "Key:I - Independently Consistent, B - Beginning,  N - Not Observed, S - Developing Satisfactorily";
        System.out.println(str);
    }
    private Boolean con(Scanner scanner){
        System.out.println("Do you wish to contue? Yes(Y) No(N)");
        String opt = scanner.nextLine().toUpperCase();
        if (opt=="Y")
            return true;
        else
            return false;
    }

    private void emotional(Scanner scanner, Grade grades){
        System.out.println("#Emotional/Social Development#");
        newLine(1);
        String str;
        str = "Separates from parent without difficulty";
        doOver(str,scanner, grades);
        str = "Curious about environment";
        doOver(str,scanner, grades);
        str = "Demonstrates self confidence and risk taking";
        doOver(str,scanner, grades);
        str = "Displays individuality and independence";
        doOver(str,scanner, grades);
        str = "Enjoys pretend play";
        doOver(str,scanner, grades);
        str = "Shares and cooperates with others";
        doOver(str,scanner, grades);
        str = "Respects rights and feeling of others";
        doOver(str,scanner, grades);
        str = "Expresses feelings verbally in an appropriate manner";
        doOver(str,scanner, grades);
        str = "Make preferences or choices known to reflect sense of self";
        doOver(str,scanner, grades);
        str = "Awareness of consequences of own actions";
        doOver(str,scanner, grades);
    }

    private void selfHelp(Scanner scanner, Grade grades){
        System.out.println("#SELF HELP SKILLS#");
        newLine(1);
        String str;
        str = "Cares for bathroom needs independently";
        doOver(str,scanner, grades);
        str = "Ability to dress and undress";
        doOver(str,scanner, grades);        
        str = "Makes activity choices without teacher's help";
        doOver(str,scanner, grades);
    }
    
    private void playHabits(Scanner scanner, Grade grades){     
        System.out.println("PLAY HABITS");
        newLine(1);
        String str;
        str = "Cooperates in classroom clean up activities";
        doOver(str,scanner, grades);
        str = "Displays enthusiam about accomplishments";
        doOver(str,scanner, grades);
    }

    private void lanugage(Scanner scanner, Grade grades){
        System.out.println("LANGUAGE DEVELOPMENT");
        newLine(1);
        String str;   
        str = "Speaks clearly enough for adults to understand";
        doOver(str,scanner, grades);
        str = "Speaks in complete sentences and in proper order";
        doOver(str,scanner, grades);
        str = "Follows simple instructions";
        doOver(str,scanner, grades);
        str = "Ability to converse using comparatives, plurals and past tenses";
        doOver(str,scanner, grades);
        str = "Demonstrate left to right orientation";
        doOver(str,scanner, grades);
        str = "Imitates actions during circle time / dance activites";
        doOver(str,scanner, grades);
        str = "Able to identify objects by name";
        doOver(str,scanner, grades);
        str = "Attentive during circle time / story time";
        doOver(str,scanner, grades);
        str = "Repeat simple rhymes";
        doOver(str,scanner, grades);
    }
    

    private void cognitive(Scanner scanner, Grade grades){       
        System.out.println("#COGNITIVE DEVELOPMENT#");
        newLine(1);
        String str;
        str = "Recognize basic geometric shapes";
        doOver(str,scanner, grades);
        str = "Sort objects by size, colours or shape";
        doOver(str,scanner, grades);
        str = "Recognize colours";
        doOver(str,scanner, grades);
        str = "Understand time concepts (soon, now, later etc.)";
        doOver(str,scanner, grades);
        str = "Make comparison among objects, pictures and symbols";
        doOver(str,scanner, grades);
        str = "Enjoys pretend play activities (dress up and imaginative play)";
        doOver(str,scanner, grades);
        str = "Identify letters of the alphabet";
        doOver(str,scanner, grades);
        str = "Identify numerals 1 to 20";
        doOver(str,scanner, grades);
        str = "Ability to quantify objects in a set (1-10 at least)";
        doOver(str,scanner, grades);
        str = "Display an understanding of sequences and patterns";
        doOver(str,scanner, grades);
        str = "Identify the letters in their name";
        doOver(str,scanner, grades);
    }

    private void grossMotor(Scanner scanner, Grade grades){
        System.out.println("GROSS MOTOR DEVELOPMENT");
        newLine(1);
        String str;
        str = "Can hop, jump, climb, run, throw and catch a ball";
        doOver(str,scanner, grades);
        str = "Shows good balance";
        doOver(str,scanner, grades);
        str = "Ability to dress and undress self";
        doOver(str,scanner, grades);
        str = "Demonstrates a good understanding of positions and spatial awareness";
        doOver(str,scanner, grades);
        str = "Follows simple movement sequences";
        doOver(str,scanner, grades);
    }

    private void fineMotor(Scanner scanner, Grade grades){
        System.out.println("FINE MOTOR DEVELOPMENT");
        newLine(1); 
        String str;     
        str = "Use writing tool to trace and write letters and numbers.";
        doOver(str,scanner, grades);
        str = "Colour within the lines";
        doOver(str,scanner, grades);
        str = "Can manipulate objects with ease e.g. opening, closing, screwing, zipping etc.";
        doOver(str,scanner, grades);
        str = "Enjoys creative activites (drawing, painting and building)";
        doOver(str,scanner, grades);
        str = "Shows control with lacing, playdough, cutting and pasting ";
        doOver(str,scanner, grades);
    }

    private void doOver(String str, Scanner scanner, Grade grades){
        System.out.print(str+": ");
        String opt = scanner.next().toUpperCase();
        grades.addSubGrade(str, opt);
    }

}

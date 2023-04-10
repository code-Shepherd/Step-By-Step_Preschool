import java.util.ArrayList;
import java.util.Scanner;

public class StudentController{
    private ArrayList<Student> sList;
    ArrayList<String> classes = new  ArrayList<String>();


    public StudentController(){
        sList = new ArrayList<Student>(); 
        classes.add("Nursery 1");
        classes.add("Nursery 2");
        classes.add("Nursery 3");
        classes.add("Nursery 4");
        classes.add("Nursery 5");
        classes.add("Kindergarten 1");
        classes.add("Kindergarten 2");
        classes.add("Kindergarten +");
    }

    public void registerStudent(Student st){ 
        sList.add(st);
        //db.addStudent(st);  
    }

    public ArrayList<String> getClasses(){
        return classes;
    }

    public void addGrade(Student student, Grade grades) {
        student.setGrade(grades);
        //db.addGrades(student,grades);
    }

    public boolean studentExist(Student st) {
        if (st==null)
            return false;
        else
            return true;     
    }

    public Student findStudent(String name) {
        for(int i=0;i<sList.size();i++){
            Student st = sList.get(i);
            if (st.getName().equals(name)) 
                return st;
        }
        return null;       
    }

    public void createReport(Student st, int absent, int present, int term) {
        Report report = new Report(st.getGrade(),absent,present,term,st.getGradeClass());
        st.addReport(report);
        //db.addReport(report);
    }

    public Boolean verifyDetails(String stName, String pName) {
        
            Student st = findStudent(stName);
            if(st.getParent1()!=null && st.getParent2()!=null ){
                return st.getParent1().getName().equals(pName) || st.getParent2().getName().equals(pName);
            }
            else if(st.getParent1()!=null){
                return st.getParent1().getName().equals(pName);
            }
            else return false;
    }

    public ArrayList<Student> getUnassignSt(){
        ArrayList<Student> lst = new ArrayList<Student>();
        for(int i=0;i<sList.size();i++){
            Student st = sList.get(i);
            if (st.getGradeClass().equals("")) 
                lst.add(st);
        }
        return lst; 
    }

	public void assignSt() {
        Scanner scan = new Scanner(System.in);
        
        
        ArrayList<Student> unassignSt = getUnassignSt();
        if (unassignSt.size()<1){
            System.out.println("There is no unassign students");
        }
        else{
            for(int i=0;i<unassignSt.size();i++){
                Student st = unassignSt.get(i); 
                String str = "Name: "+unassignSt.get(i).getName()+ "\tDate of Birth: "+st.getDob()+ "\tAge: "+st.getAge();
                System.out.println(str);
                String str1 = "\n1.Nursery 1\t2.Nursery 2\t3.Nursery 3\t4.Nursery 4\t5.Nursery 5";
                str1+= "\t6.Kindergarten 1\t7.Kindergarten 2\t8.Kindergarten +";
                System.out.println(str1);
                System.out.println("\nEnter Option");
                int opt = scan.nextInt();
                String cl = classes.get(opt-1);
                st.setGradeClass(cl);
                //db.setClass(st,cl);
            }
	    }
    }
    public boolean classExist(String cl) {
        for (int i=0;i<classes.size();i++){
            if(classes.get(i).equals(cl))
                return true;
        }
        return false;
    }

    public ArrayList<Student> viewClass(String cl) {
        ArrayList<Student> slst = new ArrayList<Student>();
        for (int i=0;i<sList.size();i++){
            Student st = sList.get(i);
            if(st.getGradeClass().equals(cl))
                slst.add(st);
        }
        return slst;
         
    }

    public ArrayList<Student> getStOfClass(String cl) {
        return null;
    }
}
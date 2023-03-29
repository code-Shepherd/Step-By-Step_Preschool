import java.util.ArrayList;
import java.util.Calendar;

public class StudentController{

    private StudentDBController db;
    private ArrayList<Student> sList;

    public StudentController(){
        db = new StudentDBController();
        sList = new ArrayList<Student>(); 

    }

    public void registerStudent(Student st){ 
        sList.add(st);
        db.addStudent(st);  
    }

    public void addGrade(Student student, Grade grades) {
        student.setGrade(grades);
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
    }

    public Boolean verifyDetails(String stName, String pName) {
        Student st = findStudent(stName);
        if(st.getParent1().getName() == pName || st.getParent2().getName() == pName)
            return true;
        else
            return false;

    }
}
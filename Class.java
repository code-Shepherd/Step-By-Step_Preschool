import java.util.ArrayList;

public class Class{
    private final String className;
    private String teacher;
    private ArrayList<Student> students;

    public Class(String className, String teacher){
        this.className=className;
        this.teacher = teacher;
    }

    public String getClassName(){
        return className;
    }

    public String getTeacher(){
        return teacher;
    }

    public ArrayList<Student> getStudents(){
        return students;
    }

    public void setTeacher(String teacher){
        this.teacher = teacher;
    }

    public void addStudentToClass(Student st){
        students.add(st);
    }

}
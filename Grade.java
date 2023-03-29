import java.util.*;

public class Grade{

    // variables
    private  HashMap<String, String> grades;
    /**
     * This method constructs and initialises a Grade
     * @param grades Represents the grade of a student
     */
    public Grade(){
        grades = new HashMap<>(); 
    }

    /**
     * This method returns the grade for a specific subject
     * @param subject Represents the subject of a student 
     * @return Returns the grade for a specific subject
     */
    public String getGrade(String subject){
        return this.grades.get(subject);
    }

    /**
     * This method sets the grade of a student for a particular subject 
     * @param subject Represensts the subject of a student
     * @param mark Represents the subject of a students
     */
    public void setGrade(String subject,String mark){
        this.grades.replace(subject,mark);
    }


    /**
    * @return Returns all grades of a student
    */
    public HashMap<String, String> getGrades(){
        return grades;
    }

    public void addSubGrade(String subject, String grade){
        grades.put(subject,grade);
    }

}


import java.util.Calendar;

public class Report {
    
    private Grade grade;
    private int absent;
    private int present;
    private int term;
    private int year;
    private String gradeClass;

    public Report(Grade grade, int absent, int present, int term2, String gradeClass){
        this.grade = grade;
        this.absent = absent;
        this.present = present;
        this.term = term2;
        Calendar cal = Calendar.getInstance();
        this.year = cal.get(Calendar.YEAR);
        this.gradeClass = gradeClass;
    }

    public Grade getGrade(){
        return grade;
    }

    public int getPresent(){
        return present;
    }

    public int getAbsent(){
        return absent;
    }

    public int getTerm(){
        return term;
    }

    public int getYear(){
        return year;
    }

    public String getGradeClass(){
        return gradeClass;
    }

    public String toString(){
        String str = "Year: "+year+"/tTerm: "+term+"/nSessions absent: "+absent+"Session Present"+present;
        return str;
    }
    
}

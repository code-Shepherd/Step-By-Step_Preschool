import java.util.ArrayList;

public class Student{

    //Attributes

    private String fname;
    private String lname;
    private String address;
    private int id;
    private int age;
    private String dob;
    private Gender gender;
    private Guardian parent1;
    private Guardian parent2;
    private Guardian emerContact;
    private Grade grade;
    private ArrayList<Report> reports = new ArrayList<Report>();
    private String gradeClass= "";

    private static int count =0;

    public Student(String fname, String lname, String address, Gender gender, int age, String dob, Guardian parent1, Guardian parent2, Guardian emerContact){
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.dob  = dob;
        this.parent1 =parent1;
        this.parent2 = parent2;
        this.emerContact = emerContact;
        this.id = count;
        countId();   
    }

    public String getName(){
        return fname+" "+lname;
    }

    public String getAddress(){
        return address;
    }

    public int getId(){
        return id;
    }

    public int getAge(){
        return age;
    }

    public String getDob(){
        return dob;
    }

    public Gender getGender(){
        return gender;
    }

    public Guardian getParent1(){
        return parent1;
    }

    public Guardian getParent2(){
        return parent2;
    }

    public Guardian getEmerContact(){
        return emerContact;
    }

    public Grade getGrade(){
        return grade;
    }

    public void setGrade(Grade grade){
        this.grade = grade;  
    }

    private static void countId(){
        count++;
    }

    public void addReport(Report report){
        reports.add(report);
    }

    public Report getReport(int year){
        int len = reports.size();
        for(int i=0;i<len;i++){
            Report report = reports.get(i);
            if (year == report.getYear())
                return report;
        }
        return null;
    }

    public String getGradeClass(){
        return gradeClass;
    }

    public void setGradeClass(String gradeClass){
        this.gradeClass = gradeClass;
    }

    public String toString(){
        String str = "Personal Details"+"\nName: "+getName()+"\nAddress: "+getAddress()+"\nAge: "+getAge()+"\nDOB: "+getDob()+"\nGender: "+getGender();
        str+= "\n\nParent1 Details"+parent1+"\n\nParent2 Details"+parent2+"\n\nEmergency Contact Details"+emerContact;
        return str;
    }

}
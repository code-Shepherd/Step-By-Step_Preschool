public class RegStudentController{

    private StudentDBController obj;

    public RegStudentController(){
        obj = new StudentDBController();
    }

    public boolean createStudent(Student student) {
        if (verifyStudent(student.getDob(), student.getAge())){
            obj.addStudent(student);
            return true;}
        else
            return false;
    }
    
    public static boolean verifyStudent(String dob, int age){
        /*Checks the age and dob */
        return true;
    }

}
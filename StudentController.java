import java.util.Calendar;
import java.util.GregorianCalendar;

public class StudentController{

    private StudentDBController db;

    public StudentController(){
        db = new StudentDBController();
    }

    public boolean registerStudent(Student student) {
        if (verifyStudent(student.getDob(), student.getAge())){
            db.addStudent(student);
            return true;
        }
        else
            return false;
    }
    
    public boolean verifyStudent(String dob, int age){
        String [] dobb = dob.split("-");
		/*Calendar calDOB = new GregorianCalendar((int)dobb[0], dobb[1], dobb[2]);

		// Get the current date
		Calendar currDate = new GregorianCalendar();

		// Find the age of the user
		int currAge = currDate.get(Calendar.YEAR) - calDOB.get(Calendar.YEAR);

		// Check and confirm current age
		if ((calDOB.get(Calendar.MONTH) > currDate.get(Calendar.MONTH))
				|| (calDOB.get(Calendar.MONTH) == currDate.get(Calendar.MONTH)
						&& calDOB.get(Calendar.DAY_OF_MONTH) > currDate.get(Calendar.DAY_OF_MONTH))) {
			// decrease age by 1
			currAge--;
		}
		// Display the age of the given user
		System.out.println("Your age is " + currAge + " years");*/
        return true;
    }

}
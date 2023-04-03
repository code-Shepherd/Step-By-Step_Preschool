import java.util.Calendar;

public class ReportForm{

    DecoratorUI dec = new DecoratorUI();
    private String heading = "\n31 Barbican Road, Kingston 6, Jamaica. W.I. \n Tele: 876-665-6298 Email: stepbystep2007@hotmail.com ";

    public ReportForm(Student st) {
        dec.clrscr();
        Report report = st.getReport(Calendar.getInstance().get(Calendar.YEAR));
        String str = "Name: "+st.getName()+"\t\tTeacher: Ms Holms"+"\nAge: "+st.getAge()+"\t\tDate of Birth: "+st.getDob();
        str+="\n"+report+"\n";
        System.out.println(str);
    }

}

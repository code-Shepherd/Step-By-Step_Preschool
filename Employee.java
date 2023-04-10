public class Employee{
    private EType type;

    private String fname; 
    private String lname;  
    private Gender gender;
    private String dob;
    private String contact;
    private String email;
    private String address;
    private String trn;
    private String nis;
    private String status;
    private String hireDate;
    private Guardian emerCon;
    private String payRate;
    private String payType;

    private String clas;

    public Employee(String fname, String lname, String hireDate, String dob, Gender gender, String trn, String nis, String clas, String status, String addr, String email, String contact,EType type, Guardian emer, String payRate, String payType){
        this.fname = fname;
        this.lname = lname;
        this.hireDate = hireDate;
        this.dob=dob;
        this.gender = gender;
        this.trn = trn;
        this.nis = nis;
        this.clas = clas;
        this.status = status;
        this.address = addr;
        this.emerCon = emer;
        this.contact = contact;
        this.email = email;
        this.payRate = payRate;
        this.payType = payType;
        this.type=type;
    }

    public String getName(){
        return lname+" "+fname;
    }

    public String getAddr(){
        return address;
    }

    public Gender getGender(){
        return gender;
    }
    
    public EType getType(){
        return type;
    }

    public String getDOB(){
        return dob;
    }

    public void setAddr(String newAddr){
        this.address = newAddr;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String new_Email){
        this.email=new_Email;
    }

    public String getContact(){
        return contact;
    }

    public void setContact(String contact){
        this.contact=contact;
    }

    public String getTRN(){
        return trn;
    }
    public String getNIS(){
        return nis;
    }
    public String getStatus(){
        return status;
    }
    public Guardian getEmer(){
        return emerCon;
    }
    public String getClas(){
        return clas;
    }

    public String getHireDate(){
        return hireDate;
    }

    public String getPatRate(){
        return payRate;
    }

    public String getPayType(){
        return payType;
    }
}


public class Student extends Person{

    //Attributes

    private int id;
    private int age;
    private String dob;
    private Gender gender;
    private Guardian parent1;
    private Guardian parent2;
    private Guardian emerContact;

    private static int count =0;

    public Student(String fname, String lname, String address, Gender gender, int age, String dob, Guardian parent1, Guardian parent2, Guardian emerContact){
        super(fname, lname, address);
        this.age = age;
        this.gender = gender;
        this.dob  = dob;
        this.parent1 =parent1;
        this.parent2 = parent2;
        this.emerContact = emerContact;
        this.id = count;
        countId();   
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

    private static void countId(){
        count++;
    }

    public String toString(){
        String str = "Personal Details"+"\nName: "+getName()+"\nAddress: "+getAddress()+"\nAge: "+getAge()+"\nDOB: "+getDob()+"\nGender: "+getGender();
        str+= "\n\nParent1 Details"+parent1+"\n\nParent2 Details"+parent2+"\n\nEmergency Contact Details"+emerContact;
        return str;
    }

}
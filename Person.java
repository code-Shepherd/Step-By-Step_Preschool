public abstract class Person{
    
    //Attributes
    private String fname;
    private String lname;
    private String address;

    public Person(String fname, String lname, String address){
        this.fname = fname;
        this.lname = lname;
        this.address = address;
    }

    public String getName(){
        return fname + " " + lname;
    }

    public String getAddress(){
        return address;
    }

    public String toString(){
        return " ";
    }
    
}

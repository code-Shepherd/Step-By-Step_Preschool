public class Guardian{
    
    //Attributes
    private String fname;
    private String lname;
    private String occupation;
    private String contact;
    private String relation;

    public Guardian(String fname, String lname, String contact, String occupation, String relation){
       this.fname = fname;
       this.lname = lname;
       this.occupation =  occupation;
        this.contact = contact;
        this.relation = relation;
    }

    public String getName(){
        return fname+" "+lname;
    }

    public String getOccupation(){
        return occupation;
    }

    public String getContact(){
        return contact;
    }

    public String getRelation(){
        return relation;
    }

    public String toString(){
        String str = "\nName: "+getName()+"\nOccupation: "+getOccupation()+"\nContact: "+getContact()+"\nRelation: "+getRelation();
        return str;
    }
    
}

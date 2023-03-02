public class Guardian extends Person {
    
    //Attributes
    private String contact;
    private String relation;

    public Guardian(String fname, String lname, String contact, String address, String relation){
        super(fname, lname, address);
        this.contact = contact;
        this.relation = relation;
    }

    public String getContact(){
        return contact;
    }

    public String getRelation(){
        return relation;
    }

    public String toString(){
        String str = "\nName: "+getName()+"\nAddress: "+getAddress()+"\nContact: "+getContact()+"\nRelation: "+getRelation();
        return str;
    }
    
}

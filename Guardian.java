public class Guardian{
    
    //Attributes
    private String contact;
    private String relation;
    private PersonalDetails pd;

    public Guardian(String fname, String lname, String contact, String address, String relation){
        pd = new PersonalDetails(fname, lname, address);
        this.contact = contact;
        this.relation = relation;
    }

    public String getName(){
        return pd.getName();
    }

    public String getAddress(){
        return pd.getAddress();
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

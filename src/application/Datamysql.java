package application;

import java.util.Date;

public class Datamysql
{
    int no,type  ;
    Double amount;
    String name,phno,comment ;
    Date deadline ;

    public Datamysql(int no1, String name1,  String phno1 , Double amount1 ,String comment1 , int type1  ,Date deadline1) {
        this.no = no1;
        this.name = name1;
        this.phno = phno1;
        this.amount = amount1;
        this.comment = comment1;
        this.type = type1;
        this.deadline =  deadline1;
    
    }

    

	public int getNo() {
        return no;
    }

    public void setNo(int no1) {
        this.no = no1;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name1) {
        this.name = name1;
    }

   

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno1)
    {
    	this.phno = phno1;
    }

    
    
    public double getAmount()
    {
    	return amount;
    }
    public void setAmount(Double amount1)
    {
    	this.amount = amount1;
    	
    }
    
    
    
    public String getComment()
    {
    	return comment;
    }
    public void setComment(String comment1) {
        this.comment = comment1;
    }
    
    
    
    
    public int getType() {
        return type;
    }

    public void setType(int type1) {
        this.type = type1;
    }

    
    
    public Date getDEADLINE() {
        return deadline;
    }

    public void setDEADLINE(Date deadline1) {
        this.deadline = deadline1;
    }

}

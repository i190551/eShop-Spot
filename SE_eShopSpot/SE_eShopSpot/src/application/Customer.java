package application;

import java.util.ArrayList;

public class Customer {
	
	protected String cid;
	protected String name;
	protected String phoneNo;
	protected String email;
	protected String dob;
	protected String password;
	protected String isMember;
	protected ArrayList<Cart> cart = new ArrayList<Cart>();
	
	public int checkCredentials(String ephno, String p)
	{
		if ((ephno.equals(phoneNo) || ephno.equals(email)) && p.equals(password))
			return 1;
		return 0;
	}
	public void displayInfo()
	{
		System.out.println("\ncid = " + cid +
				"\nName = " + name + "\nPhoneNo = " + phoneNo + "\nEmail = " + email + 
				"\nDOB = " + dob + "\nPassword = " + password + "\nisMember = " + isMember);
		
		for (int i=0; i<cart.size(); i++)
		{
			cart.get(i).displayInfo();
		}
	}
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsMember() {
		return isMember;
	}
	public void setIsMember(String isMember) {
		this.isMember = isMember;
	}
	public ArrayList<Cart> getCart() {
		return cart;
	}
	public void setCart(ArrayList<Cart> cart) {
		this.cart = cart;
	}
}

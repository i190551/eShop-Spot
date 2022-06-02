package application;

/* Member could be done in two ways : Either inherit it from Customer (OR) Create an object of Customer in it.
 * We have chosen the later beacuse if we inherit it then every attribute needs to be set based on its cid.
 * In the other method we just have to set the object and all the attributes are set automatically*/
public class Member{

	private String mid;
	private Customer ccid;
	private String cid;
	private String preferences;
	private String address;
	private double wallet;
	private double card;
	private String bankaccount;

	public void displayInfo()
	{
		ccid.displayInfo();
		
		System.out.println("\nmid = " + mid + "\ncid = " + cid + "\npreferences = " + preferences + 
				"\naddress = " + address + "\nwallet = " + wallet + "\ncard = " + card + "\nbank = " + bankaccount);
	}
	
	public String getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Customer getCcid() {
		return ccid;
	}
	public void setCcid(Customer ccid) {
		this.ccid = ccid;
	}
	public String getPreferences() {
		return preferences;
	}
	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	public double getCard() {
		return card;
	}
	public void setCard(double card) {
		this.card = card;
	}
}

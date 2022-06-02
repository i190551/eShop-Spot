package application;

public class Cart {

	private String citem;
	private String pid;
	private Products ppid;
	private String cid;
	private int qtn;
	
	public void displayInfo()
	{
		System.out.println("\nCart Items");
		System.out.println("citem = " + citem + "\npid = " + pid + "\ncid = " + cid + "\nqtn = " + qtn);
		ppid.displayInfo();
	}
	
	public Products getPpid() {
		return ppid;
	}
	public void setPpid(Products ppid) {
		this.ppid = ppid;
	}
	public String getCitem() {
		return citem;
	}
	public void setCitem(String citem) {
		this.citem = citem;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public int getQtn() {
		return qtn;
	}
	public void setQtn(int qtn) {
		this.qtn += qtn;
	}
}

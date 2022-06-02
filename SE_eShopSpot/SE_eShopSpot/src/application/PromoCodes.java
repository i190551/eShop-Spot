package application;

public class PromoCodes {

	private String pcid;
	private int pcNum;
	private int pcOff; // How much percent is off
	
	public String getPcid() {
		return pcid;
	}
	public void setPcid(String pcid) {
		this.pcid = pcid;
	}
	public int getPcNum() {
		return pcNum;
	}
	public void setPcNum(int pcNum) {
		this.pcNum = pcNum;
	}
	public int getPcOff() {
		return pcOff;
	}
	public void setPcOff(int pcOff) {
		this.pcOff = pcOff;
	}
}

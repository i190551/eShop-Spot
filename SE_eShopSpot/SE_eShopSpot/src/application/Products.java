package application;

import java.sql.Blob;

public class Products {

	private String pid;
	private String image_path;
	private String name;
	private int qtn;
	private int sold;
	private int remaining;
	private String type;
	private String description;
	private double price;
	private Blob image;
	
	public void displayInfo()
	{
		System.out.println("pid = " + pid + ", image path = " + image_path + ", name = " + name 
				+ ", qtn = " + qtn + ", sold = " + sold + ", remaining = "
				+ remaining + ", type = " + type + ", description = " + description + ", price = " + price
				+ ", image = " + image);
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQtn() {
		return qtn;
	}
	public void setQtn(int qtn) {
		this.qtn = qtn;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public int getRemaining() {
		return remaining;
	}
	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
}

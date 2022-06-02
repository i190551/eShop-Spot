package application;

import java.sql.SQLException;
import java.util.ArrayList;

public class EShopSpotController {

	private static final ArrayList<Products> products = new ArrayList<Products>();
	private static final ArrayList<Products> trendingproducts = new ArrayList<Products>();
	private static final ArrayList<PromoCodes> promocodes = new ArrayList<PromoCodes>();
	private static final ArrayList<Customer> customers = new ArrayList<Customer>();
	private static final ArrayList<Member> members = new ArrayList<Member>();
	private static final ArrayList<Cart> cart = new ArrayList<Cart>();
	private static final ArrayList<Order> orders = new ArrayList<Order>();
	private static String typeProducts; // category 
	private static String loggedIn = "No"; // logged in or not
	private static ArrayList<String> responsesFaq = new ArrayList<String>();
	private static int currentUser;
    private static String orderNo = "100000000"; 
	
	public static String getOrderNo() {
		return orderNo;
	}

	public static void setOrderNo(String orderNo) {
		EShopSpotController.orderNo = orderNo;
	}

	public int searchProducts(int index)
	{
		int val = 0;
		
		for (int i=0; i<customers.get(currentUser).getCart().size(); i++)
		{
			if (products.get(index).getPid().equals(customers.get(currentUser).getCart().get(i).getPid()))
				val = i;
		}
		return val;
	}
	
	public void buyingProduct(int index, String type) throws ClassNotFoundException, SQLException
	{
		Database db = new Database();
		if (type.equals("increment"))
		{
			int val = searchProducts(index);
			customers.get(currentUser).getCart().get(val).setQtn(1);
			
			// db cart update qtn
			db.updateCartQtn(customers.get(currentUser).getCart().get(val).getPid());
		}
		else if (type.equals("add"))
		{
			Cart ct = new Cart();
			String fixed = "ct";
			String ctno = Integer.toString((cart.size()+1));
			String citem = fixed.concat(ctno);
			ct.setCitem(citem);
			
			ct.setPid(products.get(index).getPid());
			ct.setPpid(products.get(index));
			ct.setCid(customers.get(currentUser).getCid());
			ct.setQtn(1);
			
			cart.add(ct);
			customers.get(currentUser).getCart().add(ct);
			
			// db cart add item
			db.addItem(ct);
		}
		int qtn = products.get(index).getQtn();
		int updt = qtn - 1;
		products.get(index).setQtn(updt);
		System.out.println(products.get(index).getQtn());
		
		// db product update qtn
		db.updateProductQtn(products.get(index).getPid());
	}
	
	public boolean walletAmount(int mem, double newAmount) throws SQLException, ClassNotFoundException
	{
		String mid = members.get(mem).getMid();
		
		double current = EShopSpotController.getMembers().get(mem).getWallet();
		double updated = current + newAmount;
		EShopSpotController.getMembers().get(mem).setWallet(updated);
		
		Database db = new Database();
		db.updateWallet(mid, updated);
		return true;
	}
	
	public boolean searchCustomer(String em, String ph)
	{
		for (int i=0; i<customers.size(); i++)
		{
			if (customers.get(i).getPhoneNo().equals(ph) || customers.get(i).getEmail().equals(em))
				return true;
		}
		return false;
	}
	
	public boolean searchMember(int currUser)
	{
		if (customers.get(currUser).getIsMember().equals("Yes"))
			return true;
		else 
			return false;
	}
	
	
	public boolean addMember(String address, String bankno, String preferences) throws ClassNotFoundException, SQLException
	{
		boolean searchMember = searchMember(currentUser); 
		if (searchMember == true)
		{
			return false;
		}
		else if (searchMember == false)
		{
			Member m = new Member();
			
			/* Setting mid */
			String fixed = "m";
			String mno = Integer.toString((members.size()+1));
			String mid = fixed.concat(mno);
			m.setMid(mid);
			
			/* Setting Customer */
			m.setCid(customers.get(currentUser).getCid());
			Customer c = new Customer();
			c = customers.get(currentUser);
			m.setCcid(c);
			m.getCcid().setIsMember("Yes");
			
			m.setAddress(address);
			m.setPreferences(preferences);
			m.setWallet(0.0);
			m.setCard(0.0);
			m.setBankaccount(bankno);
			
			Database db = new Database();
			db.insertMember(m);
			members.add(m);
			db.updateIsMember(m.getCid());
			return true;
		}
		return false;
	}
	
	public boolean addCustomer(String n, String ph, String dob, String em, String p) throws SQLException, ClassNotFoundException
	{
		/* If the customer with this email and phone No already exists then new account will not be created.*/
		boolean search = searchCustomer(em,ph);
		
		if (search == false)
		{
			Customer c = new Customer();

			/* Setting Cid */
			String fixed = "c";
			String cno = Integer.toString((customers.size()+1));
			String cid = fixed.concat(cno);
			c.setCid(cid);
			
			/* Setting rest of the attributes */
			c.setName(n);
			c.setPhoneNo(ph);
			c.setDob(dob);
			c.setEmail(em);
			c.setPassword(p);
			c.setIsMember("No");
			
			/* Setting cart which has a list of items */
			ArrayList<Cart> ct = new ArrayList<Cart>();
			c.setCart(ct);
			
			Database db = new Database();
			db.insertCustomer(c);
			customers.add(c);
			return true;
		}
		else if (search == true)
			return false;
		
		return false;
	}
	
	public int login(String ephno, String p)
	{
		for (int i=0; i<customers.size(); i++)
		{
			int check = customers.get(i).checkCredentials(ephno, p);
			if (check == 1)
				return i;
		}
		return -1;
	}
	
	public static ArrayList<Order> getOrders() {
		return orders;
	}

	public static int getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(int currentUser) {
		EShopSpotController.currentUser = currentUser;
	}

	public static ArrayList<Customer> getCustomers() {
		return customers;
	}

	public static ArrayList<Member> getMembers() {
		return members;
	}

	public static ArrayList<Cart> getCart() {
		return cart;
	}

	public static ArrayList<PromoCodes> getPromocodes() {
		return promocodes;
	}
	
	public static ArrayList<String> getResponsesFaq() {
		return responsesFaq;
	}

	public static void setResponsesFaq(ArrayList<String> responsesFaq) {
		EShopSpotController.responsesFaq = responsesFaq;
	}

	public static ArrayList<Products> getTrendingproducts() {
		return trendingproducts;
	}

	public static String getLoggedIn() {
		return loggedIn;
	}

	public static void setLoggedIn(String loggedIn) {
		EShopSpotController.loggedIn = loggedIn;
	}

	public static String getTypeProducts() {
		return typeProducts;
	}

	public static void setTypeProducts(String typeProducts) {
		EShopSpotController.typeProducts = typeProducts;
	}

	public static ArrayList<Products> getProducts() {
		return products;
	}

	public void displayCustomers()
	{
		System.out.println("\nDisplaying Customer Details");
		for (int i=0; i<customers.size(); i++)
		{
			customers.get(i).displayInfo();
		}
	}
	
	public void displayMembers()
	{
		System.out.println("\nDisplaying Member Details");
		for (int i=0; i<members.size(); i++)
		{
			members.get(i).displayInfo();
		}
	}
	
	public void displayProducts()
	{
		System.out.println("\nDisplaying Product Details");
		for (int i=0; i<products.size(); i++)
		{
			products.get(i).displayInfo();
		}
	}
}

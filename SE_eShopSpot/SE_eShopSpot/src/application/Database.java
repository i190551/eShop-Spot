package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private Connection con;
	private static Connection connect;
	
	public void createConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("\nDriver Loaded Successfully!");
			setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/ess","root","root")); 
			System.out.println("Connection Established!");			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("\nDriver Loaded Successfully!");
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ess","root","root"); 
		System.out.println("Connection Established!");	
		return connect;
	}

	public void deleteOrder(String orderNo) throws SQLException
	{
		createConnection();
		String sql = "DELETE from orders WHERE orderNo = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setString(1,orderNo);
		
		int rowsInserted = statement.executeUpdate();
		
		if (rowsInserted > 0)
		{
			System.out.println("\nOrder Removed Successfully !!!");
		}

	}
	
	public void retreiveProducts() throws SQLException
	{
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from Products");
		
		while(rs.next())
		{
			Products p = new Products();
	        p.setPid(rs.getString(1));
	        p.setImage_path(rs.getString(2));
			p.setName(rs.getString(3));
			p.setQtn(rs.getInt(4));
			p.setSold(rs.getInt(5));
			p.setRemaining(rs.getInt(6));
			p.setType(rs.getString(7));
			p.setDescription(rs.getString(8));
			p.setPrice(rs.getInt(9));
		    p.setImage(rs.getBlob(10));
			
			//System.out.println(rs.getString(1) + "  " + rs.getString(2)+ "  " + rs.getString(3) + "  " + rs.getInt(4) + "  " + rs.getInt(5) + "  " + rs.getInt(6) + "  " + rs.getString(7)
			//+ "  " + rs.getString(8)+ "  " + rs.getInt(9) + "  " + rs.getBlob(10));
			EShopSpotController.getProducts().add(p);
		}
	}
	
	public void retreiveOrders() throws SQLException
	{
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from orders");
		
		while(rs.next())
		{
			Order od = new Order();
	        od.setOrderNo(rs.getString(1));
	        od.setId(rs.getString(2));
			od.setPaymentType(rs.getString(3));
			
			//System.out.println(rs.getString(1) + "  " + rs.getString(2)+ "  " + rs.getString(3) + "  " + rs.getInt(4) + "  " + rs.getInt(5) + "  " + rs.getInt(6) + "  " + rs.getString(7)
			//+ "  " + rs.getString(8)+ "  " + rs.getInt(9) + "  " + rs.getBlob(10));
			EShopSpotController.getOrders().add(od);
		}
	}
	
	public void retreiveTrendingProducts() throws SQLException
	{
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from trendingproducts");
		
		while(rs.next())
		{
			TrendingProducts tp = new TrendingProducts();
	        tp.setTdid(rs.getString(1));
	        tp.setImage_path(rs.getString(2));
			tp.setName(rs.getString(3));
			tp.setQtn(rs.getInt(4));
			tp.setSold(rs.getInt(5));
			tp.setRemaining(rs.getInt(6));
			tp.setType(rs.getString(7));
			tp.setDescription(rs.getString(8));
			tp.setPrice(rs.getInt(9));
		    tp.setImage(rs.getBlob(10));
		    tp.setPid(rs.getString(11));
			
			//System.out.println(rs.getString(1) + "  " + rs.getString(2)+ "  " + rs.getString(3) + "  " + rs.getInt(4) + "  " + rs.getInt(5) + "  " + rs.getInt(6) + "  " + rs.getString(7)
			//+ "  " + rs.getString(8)+ "  " + rs.getInt(9) + "  " + rs.getBlob(10) + "  " + rs.getString(11));
			EShopSpotController.getTrendingproducts().add(tp);
		}
	}
	
	public void retreivePromoCodes() throws SQLException
	{
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from promocodes");
		
		while(rs.next())
		{
			PromoCodes pc = new PromoCodes();
	        pc.setPcid(rs.getString(1));
	        pc.setPcNum(rs.getInt(2));
			pc.setPcOff(rs.getInt(3));
			
			//System.out.println(rs.getString(1) + "  " + rs.getInt(2)+ "  " + rs.getInt(3));
			EShopSpotController.getPromocodes().add(pc);
		}
	}
	
	public void retreiveCustomers() throws SQLException
	{
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from customers");
		
		while(rs.next())
		{
			Customer ct = new Customer();
	        ct.setCid(rs.getString(1));
	        ct.setName(rs.getString(2));
	        ct.setPhoneNo(rs.getString(3));
	        ct.setEmail(rs.getString(4));
	        ct.setDob(rs.getString(5));
	        ct.setPassword(rs.getString(6));
	        ct.setIsMember(rs.getString(7));
			EShopSpotController.getCustomers().add(ct);
		}
	}
	
	public void retreiveCart() throws SQLException
	{
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from cart");
		
		while(rs.next())
		{
			Cart cart = new Cart();
	        cart.setCitem(rs.getString(1));
	        cart.setPid(rs.getString(2));
	        cart.setCid(rs.getString(3));
	        cart.setQtn(rs.getInt(4));
			EShopSpotController.getCart().add(cart);
		}
	}
	
	public void retreiveMembers() throws SQLException
	{
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from member");
		
		while(rs.next())
		{
			Member mem = new Member();
	        mem.setMid(rs.getString(1));
	        mem.setCid(rs.getString(2));
	        mem.setPreferences(rs.getString(3));
	        mem.setAddress(rs.getString(4));
	        mem.setWallet(rs.getDouble(5));
	        mem.setCard(rs.getDouble(6));
	        mem.setBankaccount(rs.getString(7));
	        EShopSpotController.getMembers().add(mem);
		}
	}
	
	public void setProductsinCart()
	{
		for (int k = 0; k<EShopSpotController.getCart().size(); k++)
		{
			for (int m = 0; m<EShopSpotController.getProducts().size(); m++)
			{
				if (EShopSpotController.getProducts().get(m).getPid().equals(EShopSpotController.getCart().get(k).getPid()))
				{
					EShopSpotController.getCart().get(k).setPpid(EShopSpotController.getProducts().get(m));
				}
			}
		}
	}
	
	public void setCartinCustomer()
	{
		for (int k = 0; k<EShopSpotController.getCustomers().size(); k++)
		{
			for (int m = 0; m<EShopSpotController.getCart().size(); m++)
			{
				if (EShopSpotController.getCart().get(m).getCid().equals(EShopSpotController.getCustomers().get(k).getCid()))
				{
					EShopSpotController.getCustomers().get(k).getCart().add(EShopSpotController.getCart().get(m));
				}
			}
		}
	}
	
	public void setCustomerinMember()
	{
		for (int k = 0; k<EShopSpotController.getMembers().size(); k++)
		{
			for (int m = 0; m<EShopSpotController.getCustomers().size(); m++)
			{
				if (EShopSpotController.getCustomers().get(m).getCid().equals(EShopSpotController.getMembers().get(k).getCid()))
				{
					EShopSpotController.getMembers().get(k).setCcid(EShopSpotController.getCustomers().get(m));
				}
			}
		}
	}
	
	public void insertCustomer(Customer c) throws SQLException, ClassNotFoundException
	{
		con = getConnection();
		String sql = "INSERT into customers (cid,name,phoneNo,email,dob,password,isMember) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setString(1,c.getCid());
		statement.setString(2,c.getName());
		statement.setString(3,c.getPhoneNo());
		statement.setString(4,c.getEmail());
		statement.setString(5,c.getDob());
		statement.setString(6,c.getPassword());
		statement.setString(7,c.getIsMember());
		
		int rowsInserted = statement.executeUpdate();
		
		if (rowsInserted > 0)
		{
			System.out.println("\nCustomer Inserted Successfully !!!");
		}
	}
	
	public void insertOrder(Order o) throws SQLException, ClassNotFoundException
	{
		con = getConnection();
		String sql = "INSERT into orders (orderNo,id,paymentType) VALUES (?, ?, ?)";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setString(1,o.getOrderNo());
		statement.setString(2,o.getId());
		statement.setString(3,o.getPaymentType());
		
		int rowsInserted = statement.executeUpdate();
		
		if (rowsInserted > 0)
		{
			System.out.println("\nOrder Inserted Successfully !!!");
		}
	}
	
	public void insertMember(Member m) throws SQLException, ClassNotFoundException
	{
		con = getConnection();
		String sql = "INSERT into member (mid,cid,preferences,address,wallet,card,bankaccount) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setString(1,m.getMid());
		statement.setString(2,m.getCid());
		statement.setString(3,m.getPreferences());
		statement.setString(4,m.getAddress());
		statement.setDouble(5,m.getWallet());
		statement.setDouble(6,m.getCard());
		statement.setString(7,m.getBankaccount());
		
		int rowsInserted = statement.executeUpdate();
		
		if (rowsInserted > 0)
		{
			System.out.println("\nMember Inserted Successfully !!!");
		}
	}
	
	public void addItem(Cart ct) throws SQLException, ClassNotFoundException
	{
		con = getConnection();
		String sql = "INSERT into cart (citem,pid,cid,qtn) VALUES (?, ?, ?, ?)";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setString(1,ct.getCitem());
		statement.setString(2,ct.getPid());
		statement.setString(3,ct.getCid());
		statement.setInt(4,ct.getQtn());
		
		int rowsInserted = statement.executeUpdate();
		
		if (rowsInserted > 0)
		{
			System.out.println("\nItem Inserted Successfully !!!");
		}
	}
	
	public void updateIsMember(String cid) throws SQLException
	{
		createConnection();
		
		String sql = "UPDATE customers SET isMember = 'Yes' WHERE cid = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1,cid);
		
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0)
		{
			System.out.println("\nIsMember updated successfully!");
		}
	}
	
	public void updateProductQtn(String pid) throws SQLException
	{
		createConnection();
		
		String sql = "UPDATE Products SET qtn = qtn - 1 WHERE pid = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1,pid);
		
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0)
		{
			System.out.println("\nQuantity (Products) updated successfully!");
		}
	}
	
	public void updateCartQtn(String pid) throws SQLException
	{
		createConnection();
		
		String sql = "UPDATE cart SET qtn = qtn + 1 WHERE pid = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1,pid);
		
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0)
		{
			System.out.println("\nQuantity (Cart) updated successfully!");
		}
	}
	
	public void updateWallet(String mid, double updated) throws SQLException, ClassNotFoundException
	{
		con = getConnection();
		String sql3 = "UPDATE member SET wallet = ? WHERE mid = ?";
		PreparedStatement statement3 = con.prepareStatement(sql3);
		
		statement3.setDouble(1,updated);
		statement3.setString(2,mid);
		
		int rowsInserted3 = statement3.executeUpdate();
		
		if (rowsInserted3 > 0)
		{
			System.out.println("\nWallet Updated Successfully !!!");
		}
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}

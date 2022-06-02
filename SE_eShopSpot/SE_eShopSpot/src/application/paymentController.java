package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class paymentController implements Initializable {

    @FXML
    private Button CancelOrder;

    @FXML
    private TextField amountPaid;

    @FXML
    private TextField bankAccNum;
    
    @FXML
    private CheckBox cod;
    
    @FXML
    private Button pay;
    
    @FXML
    private TextField totalbill;

    @FXML
    private CheckBox wallet;
    
    @FXML
    private Button beauty1;

    @FXML
    private Button becomeMember;

    @FXML
    private ImageView cardBtn;

    @FXML
    private Button customerCare;

    @FXML
    private Button discover;

    @FXML
    private Button electronics1;

    @FXML
    private Button faq;

    @FXML
    private Button gadgets1;

    @FXML
    private Button health1;

    @FXML
    private Button home;

    @FXML
    private Button kidClothing1;

    @FXML
    private Label loggedinname;

    @FXML
    private Button login;

    @FXML
    private Button logout;

    @FXML
    private Button menClothing1;

    @FXML
    private Button signup;

    @FXML
    private ImageView walletIcon;

    @FXML
    private Button womenCLothing1;

    double bill = 0.0;
    
    int mem = -1;
    
    private void AlertMessage (String title, String content)
    {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
        alert.showAndWait();
    }
    
    public boolean checkAccount(String acc)
    {
    	int count = 0;
    	if (acc.length() < 9)
    		return false;
    	for (int i = 0; i < acc.length(); i++)
    	{
    		if (acc.charAt(i) >= 48 && acc.charAt(i) <= 57)
    		{
    			count++;
    		}
    	}
    	if (count == acc.length())
    	{
    		return true;
    	}
    	return false;
    }
    
    public boolean checkAccountNumber(String acc)
    {
    	if (EShopSpotController.getMembers().get(mem).getBankaccount().equals(acc))
    		return true;
    	return false;
    }
    
    @FXML
    void payBtn(ActionEvent event) throws ClassNotFoundException, SQLException {

    	Database db = new Database();
    	int selected = 0;
    	if (!bankAccNum.getText().isEmpty())
    	{
    		selected += 1;
    	}
    	if (wallet.isSelected())
    	{
    		selected += 1;
    	}
    	if (cod.isSelected())
    	{
    		selected += 1;
    	}
    	if (selected == 2 || selected == 3)
    	{
    		String title = "Payment Method";
    		String content = "Select only one Payment Method.";
    		AlertMessage(title, content);
    	}
    	else if (bankAccNum.getText().isEmpty() && selected == 0)
    	{
    		String title = "Payment Method";
    		String content = "Kindly enter Account Number if you are trying to pay through bank account.";
    		AlertMessage(title, content);
    	}
    	else if (!bankAccNum.getText().isEmpty() && selected == 1)
    	{
    		if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).isMember.equals("Yes"))
    		{
    			if (checkAccountNumber(bankAccNum.getText()) && checkAccount(bankAccNum.getText()))
    			{
    				String title = "Payment Method";
    	    		String content = "Paid through Bank.";
    	    		AlertMessage(title, content);
    	    		
    	    		amountPaid.setText(Double.toString(bill));
    	    		Order od = new Order();
    	    		
    	    		Random rand = new Random();
    	    		long random_long = rand.nextLong(999999999-100000000) + 100000000;
    	    		String o = Long.toString(random_long);
    	    		
    	    		od.setOrderNo(o);
    	    		od.setId(EShopSpotController.getMembers().get(mem).getMid());
    	    		od.setPaymentType("Bank");
    	    		db.insertOrder(od);
    	    		EShopSpotController.getOrders().add(od);
    			}
    			else
    			{
    				String title = "Payment Method";
    	    		String content = "You have entered wrong Account Number. Kindly check again";
    	    		AlertMessage(title, content);
    			}
    		}
    		else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).isMember.equals("No"))
    		{
    			if (checkAccount(bankAccNum.getText()))
    			{
    				String title = "Payment Method";
    	    		String content = "Paid through Bank.";
    	    		AlertMessage(title, content);
    	    		
    	    		amountPaid.setText(Double.toString(bill));
    	    		
    	    		Order od = new Order();
    	    		Random rand = new Random();
    	    		long random_long = rand.nextLong(999999999-100000000) + 100000000;
    	    		String o = Long.toString(random_long);
    	    		
    	    		od.setOrderNo(o);
    	    		od.setId(EShopSpotController.getMembers().get(EShopSpotController.getCurrentUser()).getCid());
    	    		od.setPaymentType("Bank");
    	    		db.insertOrder(od);
    	    		EShopSpotController.getOrders().add(od);
    			}
    			else
    			{
    				String title = "Payment Method";
    	    		String content = "You have entered wrong Account Number. Kindly check again";
    	    		AlertMessage(title, content);
    			}
    		}
    	}
    	else if (wallet.isSelected() && selected == 1)
    	{
    		if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).isMember.equals("Yes"))
    		{
    			if (EShopSpotController.getMembers().get(mem).getWallet() >= bill)
				{
    				double current = EShopSpotController.getMembers().get(mem).getWallet();
    				double left = current - bill;
    				EShopSpotController.getMembers().get(mem).setWallet(left);
    				
    				System.out.println(left);
    				
    				// update db
    				db.updateWallet(EShopSpotController.getMembers().get(mem).getMid(), left);
    				
    				String title = "Payment Method";
            		String content = "Paid through Wallet.";
            		AlertMessage(title, content);
            		
            		amountPaid.setText(Double.toString(bill));
            		
    	    		Order od = new Order();
    	    		Random rand = new Random();
    	    		long random_long = rand.nextLong(999999999-100000000) + 100000000;
    	    		String o = Long.toString(random_long);
    	    		
    	    		od.setOrderNo(o);
    	    		od.setId(EShopSpotController.getMembers().get(mem).getMid());
    	    		od.setPaymentType("Wallet");
    	    		db.insertOrder(od);
    	    		EShopSpotController.getOrders().add(od);
				}
    		}
    		else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).isMember.equals("No"))
    		{
    			String title = "Payment Method";
        		String content = "You are not a member so you cannot pay through wallet.";
        		AlertMessage(title, content);
    		}
    	}
    	else if (cod.isSelected() && selected == 1)
    	{
    		String title = "Payment Method";
    		String content = "Payment will be paid on delivery.";
    		AlertMessage(title, content);
    		
    		Order od = new Order();
    		Random rand = new Random();
    		long random_long = rand.nextLong(999999999-100000000) + 100000000;
    		String o = Long.toString(random_long);
    		
    		od.setOrderNo(o);
    		od.setId(EShopSpotController.getMembers().get(EShopSpotController.getCurrentUser()).getCid());
    		od.setPaymentType("COD");
    		db.insertOrder(od);
    		EShopSpotController.getOrders().add(od);
    	}
    }

    @FXML
    void CancelorderBttn(ActionEvent event) throws IOException {
    	
    	if (EShopSpotController.getLoggedIn().equals("No"))
    	{
    		String title = "Cancel Order";
    		String content = "You must log in first to cancel order."
    				+ "\nIf you do not have an account. Sign-up now and have access to many features.";
    		AlertMessage(title, content);
    	}
    	else if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		Main m = new Main();
        	m.screen("/Controller_FXMLs/orderCancellation.fxml", "Order Cancellation");
    	}
    }

    @FXML
    void CartViewBtn(MouseEvent event) throws IOException {
    	
    	if (EShopSpotController.getLoggedIn().equals("No"))
    	{
    		String title = "Cart";
    		String content = "You must log in first to view your cart."
    				+ "\nIf you do not have an account. Sign-up now and have access to many features.";
    		AlertMessage(title, content);
    	}
    	else if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		Main m = new Main();
        	m.screen("/Controller_FXMLs/cart.fxml","Cart");
    	}
    }

    @FXML
    void beautyBttn(ActionEvent event) throws IOException {
    	EShopSpotController.setTypeProducts("Beauty");
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/Products.fxml", "Products");
    }

    @FXML
    void becomeMemberBttn(ActionEvent event) throws IOException {
    	
    	if (EShopSpotController.getLoggedIn().equals("No"))
    	{
    		String title = "Member";
    		String content = "You must log in first to register yourself as a member."
    				+ "\nIf you do not have an account. Sign-up now and have access to many features.";
    		AlertMessage(title, content);
    	}
    	else if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		Main m = new Main();
        	m.screen("/Controller_FXMLs/becomeMember.fxml", "Member");
    	}
    }

    @FXML
    void clickWalletBttn(MouseEvent event) throws IOException {

    	if (EShopSpotController.getLoggedIn().equals("No"))
    	{
    		String title = "Wallet";
    		String content = "You must log in first to view your wallet.";
    		AlertMessage(title, content);
    	}
    	else if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getIsMember().equals("Yes"))
    		{
    			Main m = new Main();
            	m.screen("/Controller_FXMLs/wallet.fxml", "Wallet");
    		}
    		else
    		{
    			String title = "Wallet";
        		String content = "You must be registered as a Member to view your wallet.";
        		AlertMessage(title, content);
    		}
    	}
    }

    @FXML
    void customerCareBttn(ActionEvent event) {
    	System.out.println("Show nothing");
    }

    @FXML
    void discoverBttn(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/Discover.fxml", "Discover");
    }

    @FXML
    void electronicsBttn(ActionEvent event) throws IOException {
    	EShopSpotController.setTypeProducts("Electronics");
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/Products.fxml", "Products");
    }

    @FXML
    void faqBttn(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/faq.fxml", "Faqs");
    }

    @FXML
    void gadgetsBttn(ActionEvent event) throws IOException {
    	EShopSpotController.setTypeProducts("Gadgets");
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/Products.fxml", "Products");
    }

    @FXML
    void healthBttn(ActionEvent event) throws IOException {
    	EShopSpotController.setTypeProducts("Health");
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/Products.fxml", "Products");
    }

    @FXML
    void homePageBtn(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/mainPage.fxml","eShopSpot");
    }

    @FXML
    void kidsClothingBttn(ActionEvent event) throws IOException {
    	EShopSpotController.setTypeProducts("Kids Clothing");
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/Products.fxml", "Products");
    }

    @FXML
    void loginBttn(ActionEvent event) throws IOException {
    	
    	if (EShopSpotController.getLoggedIn().equals("No"))
    	{
    		Main m = new Main();
        	m.screen("/Controller_FXMLs/login.fxml", "Login");
    	}
    	else if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		String title = "Logged in";
    		String content = "You are already logged in."
    				+ "\nIf you want to switch accounts, please logout first.";
    		AlertMessage(title, content);
    	}

    }

    @FXML
    void logoutbtn(ActionEvent event) throws IOException {
    	
    	if (EShopSpotController.getLoggedIn().equals("No"))
    	{
    		String title = "Logout";
    		String content = "You must log in first to logout."
    				+ "\nIf you do not have an account. Sign-up now and have access to many features.";
    		AlertMessage(title, content);
    	}
    	else if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		EShopSpotController.setCurrentUser(-1);
    		EShopSpotController.setLoggedIn("No");
    		String title = "Logout";
    		String content = "You have successfully logged out.";
    		AlertMessage(title, content);
    		Main m = new Main();
        	m.screen("/Controller_FXMLs/login.fxml", "Products");
    	}
    }

    @FXML
    void menClothingBttn(ActionEvent event) throws IOException {
    	EShopSpotController.setTypeProducts("Men Clothing");
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/Products.fxml", "Products");
    }

    @FXML
    void signUpBttn(ActionEvent event) throws IOException {

    	if (EShopSpotController.getLoggedIn().equals("No"))
    	{
    		Main m = new Main();
        	m.screen("/Controller_FXMLs/signup.fxml", "Sign-up");
    	}
    	else if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		String title = "Logged in";
    		String content = "You are already logged in."
    				+ "\nIf you want to create a new account, please logout first.";
    		AlertMessage(title, content);
    	}
    }

    @FXML
    void womenClothingBttn(ActionEvent event) throws IOException {
    	EShopSpotController.setTypeProducts("Women Clothing");
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/Products.fxml", "Products");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		for (int i=0; i<EShopSpotController.getMembers().size(); i++)
    	{
    		if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCid().equals(EShopSpotController.getMembers().get(i).getCid()))
    			mem = i;
    	}
		
		if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		loggedinname.setText(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getName());
    	}
		
		for (int i=0; i<EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size(); i++)
		{
			bill += EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(i).getPpid().getPrice();
		}
		totalbill.setText(Double.toString(bill));
	}
}

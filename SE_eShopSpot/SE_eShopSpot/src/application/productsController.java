package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class productsController implements Initializable{

	Image myImage1;
	Image myImage2;
	Image myImage3;
	Image myImage4;
	Image myImage5;
	Image myImage6;
	
	Label l1 = new Label();
	Label l2 = new Label();
	Label l3 = new Label();
	Label l4 = new Label();
	Label l5 = new Label();
	Label l6 = new Label();
	
	@FXML
    private Button buy1;

    @FXML
    private Button buy2;

    @FXML
    private Button buy3;

    @FXML
    private Button buy4;

    @FXML
    private Button buy5;

    @FXML
    private Button buy6;
    
	@FXML
    private Label pr1;

    @FXML
    private Label pr2;

    @FXML
    private Label pr3;

    @FXML
    private Label pr4;

    @FXML
    private Label pr5;

    @FXML
    private Label pr6;

	@FXML
    private Label loggedinname;
	
	@FXML
    private Button CancelOrder;
	
	@FXML
    private Button logout;
	
	@FXML
    private Button home;
	
	@FXML
    private ImageView Picture1;

    @FXML
    private ImageView Picture2;

    @FXML
    private ImageView Picture3;

    @FXML
    private ImageView Picture4;

    @FXML
    private ImageView Picture5;

    @FXML
    private ImageView Picture6;
    
    @FXML
    private Button beauty;

    @FXML
    private Button becomeMember;

    @FXML
    private ImageView cardBtn;

    @FXML
    private Button customerCare;

    @FXML
    private Button discover;

    @FXML
    private Button electronics;

    @FXML
    private Button faq;

    @FXML
    private Button gadgets;

    @FXML
    private Button health;

    @FXML
    private Button kidClothing;

    @FXML
    private Button login;

    @FXML
    private Button menClothing;

    @FXML
    private Button signup;

    @FXML
    private Button womenCLothing;

    @FXML
    void buy1Btn(ActionEvent event) throws ClassNotFoundException, SQLException {

    	if (EShopSpotController.getLoggedIn().equals("No"))
    	{
    		String title = "Buying Products";
    		String content = "You must log in first to buy any product.";
    		AlertMessage(title, content);
    	}
    	else if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		int p = 0;
        	int index = -1;
        	for (int i=0; i<EShopSpotController.getProducts().size(); i++)
        	{
        		if (EShopSpotController.getTypeProducts().equals(EShopSpotController.getProducts().get(i).getType()))
        		{
        			p++;
        			if (p == 1)
        			{
        				index = i;
        				break;
        			}
        		}
        	}
        	int checkProduct = 0;
        	for (int i=0; i<EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size(); i++)
        	{
        		if (EShopSpotController.getProducts().get(index).getPid().equals(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(i).getPid()))
        		{
        			System.out.println("Product already present");
        			checkProduct = 1;
        		}
        	}
        	if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() == 4 && checkProduct == 1)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "increment");
        		
        		String title = "Buying Products";
        		String content = "Your Cart is Full, but the item exists, so we will increase the quantity.";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() == 4 && checkProduct == 0)
        	{
        		String title = "Buying Products";
        		String content = "Your Cart is Full (Cart has a limit of adding 4 items).";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() < 4 && checkProduct == 0)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "add");
        		
        		String title = "Buying Products";
        		String content = "Your Cart still has space. The item has been added.";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() < 4 && checkProduct == 1)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "increment");
        		
        		String title = "Buying Products";
        		String content = "Your Cart still has some space, but the item exists, so we will increase the quantity.";
        		AlertMessage(title, content);
        	}
        	System.out.println(EShopSpotController.getProducts().get(index).getName());
    	}
    }

    @FXML
    void buy2Btn(ActionEvent event) throws ClassNotFoundException, SQLException {

    	if (EShopSpotController.getLoggedIn().equals("No"))
    	{
    		String title = "Buying Products";
    		String content = "You must log in first to buy any product.";
    		AlertMessage(title, content);
    	}
    	else if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		int p = 0;
        	int index = -1;
        	for (int i=0; i<EShopSpotController.getProducts().size(); i++)
        	{
        		if (EShopSpotController.getTypeProducts().equals(EShopSpotController.getProducts().get(i).getType()))
        		{
        			p++;
        			if (p == 2)
        			{
        				index = i;
        				break;
        			}
        		}
        	}
        	int checkProduct = 0;
        	for (int i=0; i<EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size(); i++)
        	{
        		if (EShopSpotController.getProducts().get(index).getPid().equals(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(i).getPid()))
        		{
        			System.out.println("Product already present");
        			checkProduct = 1;
        		}
        	}
        	if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() == 4 && checkProduct == 1)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "increment");
        		
        		String title = "Buying Products";
        		String content = "Your Cart is Full, but the item exists, so we will increase the quantity.";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() == 4 && checkProduct == 0)
        	{
        		String title = "Buying Products";
        		String content = "Your Cart is Full (Cart has a limit of adding 4 items).";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() < 4 && checkProduct == 0)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "add");
        		
        		String title = "Buying Products";
        		String content = "Your Cart still has space. The item has been added.";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() < 4 && checkProduct == 1)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "increment");
        		
        		String title = "Buying Products";
        		String content = "Your Cart still has some space, but the item exists, so we will increase the quantity.";
        		AlertMessage(title, content);
        	}
        	System.out.println(EShopSpotController.getProducts().get(index).getName());
    	}
    }

    @FXML
    void buy3Btn(ActionEvent event) throws ClassNotFoundException, SQLException {

    	if (EShopSpotController.getLoggedIn().equals("No"))
    	{
    		String title = "Buying Products";
    		String content = "You must log in first to buy any product.";
    		AlertMessage(title, content);
    	}
    	else if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		int p = 0;
        	int index = -1;
        	for (int i=0; i<EShopSpotController.getProducts().size(); i++)
        	{
        		if (EShopSpotController.getTypeProducts().equals(EShopSpotController.getProducts().get(i).getType()))
        		{
        			p++;
        			if (p == 3)
        			{
        				index = i;
        				break;
        			}
        		}
        	}
        	int checkProduct = 0;
        	for (int i=0; i<EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size(); i++)
        	{
        		if (EShopSpotController.getProducts().get(index).getPid().equals(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(i).getPid()))
        		{
        			System.out.println("Product already present");
        			checkProduct = 1;
        		}
        	}
        	if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() == 4 && checkProduct == 1)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "increment");
        		
        		String title = "Buying Products";
        		String content = "Your Cart is Full, but the item exists, so we will increase the quantity.";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() == 4 && checkProduct == 0)
        	{
        		String title = "Buying Products";
        		String content = "Your Cart is Full (Cart has a limit of adding 4 items).";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() < 4 && checkProduct == 0)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "add");
        		
        		String title = "Buying Products";
        		String content = "Your Cart still has space. The item has been added.";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() < 4 && checkProduct == 1)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "increment");
        		
        		String title = "Buying Products";
        		String content = "Your Cart still has some space, but the item exists, so we will increase the quantity.";
        		AlertMessage(title, content);
        	}
        	System.out.println(EShopSpotController.getProducts().get(index).getName());
    	}
    }

    @FXML
    void buy4Btn(ActionEvent event) throws ClassNotFoundException, SQLException {

    	if (EShopSpotController.getLoggedIn().equals("No"))
    	{
    		String title = "Buying Products";
    		String content = "You must log in first to buy any product.";
    		AlertMessage(title, content);
    	}
    	else if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		int p = 0;
        	int index = -1;
        	for (int i=0; i<EShopSpotController.getProducts().size(); i++)
        	{
        		if (EShopSpotController.getTypeProducts().equals(EShopSpotController.getProducts().get(i).getType()))
        		{
        			p++;
        			if (p == 4)
        			{
        				index = i;
        				break;
        			}
        		}
        	}
        	int checkProduct = 0;
        	for (int i=0; i<EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size(); i++)
        	{
        		if (EShopSpotController.getProducts().get(index).getPid().equals(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(i).getPid()))
        		{
        			System.out.println("Product already present");
        			checkProduct = 1;
        		}
        	}
        	if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() == 4 && checkProduct == 1)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "increment");
        		
        		String title = "Buying Products";
        		String content = "Your Cart is Full, but the item exists, so we will increase the quantity.";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() == 4 && checkProduct == 0)
        	{
        		String title = "Buying Products";
        		String content = "Your Cart is Full (Cart has a limit of adding 4 items).";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() < 4 && checkProduct == 0)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "add");
        		
        		String title = "Buying Products";
        		String content = "Your Cart still has space. The item has been added.";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() < 4 && checkProduct == 1)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "increment");
        		
        		String title = "Buying Products";
        		String content = "Your Cart still has some space, but the item exists, so we will increase the quantity.";
        		AlertMessage(title, content);
        	}
        	System.out.println(EShopSpotController.getProducts().get(index).getName());
    	}
    }

    @FXML
    void buy5Btn(ActionEvent event) throws ClassNotFoundException, SQLException {
    	
    	if (EShopSpotController.getLoggedIn().equals("No"))
    	{
    		String title = "Buying Products";
    		String content = "You must log in first to buy any product.";
    		AlertMessage(title, content);
    	}
    	else if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		int p = 0;
        	int index = -1;
        	for (int i=0; i<EShopSpotController.getProducts().size(); i++)
        	{
        		if (EShopSpotController.getTypeProducts().equals(EShopSpotController.getProducts().get(i).getType()))
        		{
        			p++;
        			if (p == 5)
        			{
        				index = i;
        				break;
        			}
        		}
        	}
        	int checkProduct = 0;
        	for (int i=0; i<EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size(); i++)
        	{
        		if (EShopSpotController.getProducts().get(index).getPid().equals(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(i).getPid()))
        		{
        			System.out.println("Product already present");
        			checkProduct = 1;
        		}
        	}
        	if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() == 4 && checkProduct == 1)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "increment");
        		
        		String title = "Buying Products";
        		String content = "Your Cart is Full, but the item exists, so we will increase the quantity.";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() == 4 && checkProduct == 0)
        	{
        		String title = "Buying Products";
        		String content = "Your Cart is Full (Cart has a limit of adding 4 items).";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() < 4 && checkProduct == 0)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "add");
        		
        		String title = "Buying Products";
        		String content = "Your Cart still has space. The item has been added.";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() < 4 && checkProduct == 1)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "increment");
        		
        		String title = "Buying Products";
        		String content = "Your Cart still has some space, but the item exists, so we will increase the quantity.";
        		AlertMessage(title, content);
        	}
        	System.out.println(EShopSpotController.getProducts().get(index).getName());
    	}
    }

    @FXML
    void buy6Btn(ActionEvent event) throws ClassNotFoundException, SQLException {

    	if (EShopSpotController.getLoggedIn().equals("No"))
    	{
    		String title = "Buying Products";
    		String content = "You must log in first to buy any product.";
    		AlertMessage(title, content);
    	}
    	else if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		int p = 0;
        	int index = -1;
        	for (int i=0; i<EShopSpotController.getProducts().size(); i++)
        	{
        		if (EShopSpotController.getTypeProducts().equals(EShopSpotController.getProducts().get(i).getType()))
        		{
        			p++;
        			if (p == 6)
        			{
        				index = i;
        				break;
        			}
        		}
        	}
        	int checkProduct = 0;
        	for (int i=0; i<EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size(); i++)
        	{
        		if (EShopSpotController.getProducts().get(index).getPid().equals(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(i).getPid()))
        		{
        			System.out.println("Product already present");
        			checkProduct = 1;
        		}
        	}
        	if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() == 4 && checkProduct == 1)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "increment");
        		
        		String title = "Buying Products";
        		String content = "Your Cart is Full, but the item exists, so we will increase the quantity.";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() == 4 && checkProduct == 0)
        	{
        		String title = "Buying Products";
        		String content = "Your Cart is Full (Cart has a limit of adding 4 items).";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() < 4 && checkProduct == 0)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "add");
        		
        		String title = "Buying Products";
        		String content = "Your Cart still has space. The item has been added.";
        		AlertMessage(title, content);
        	}
        	else if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size() < 4 && checkProduct == 1)
        	{
        		EShopSpotController ess = new EShopSpotController();
        		ess.buyingProduct(index, "increment");
        		
        		String title = "Buying Products";
        		String content = "Your Cart still has some space, but the item exists, so we will increase the quantity.";
        		AlertMessage(title, content);
        	}
        	System.out.println(EShopSpotController.getProducts().get(index).getName());
    	}
    }
    
    private void AlertMessage (String title, String content)
    {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
        alert.showAndWait();
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
    void homePageBtn(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/mainPage.fxml","eShopSpot");
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

    @FXML
    void changep1(MouseEvent event) {
    	pr1.setText(l1.getText());
    }

    @FXML
    void changep2(MouseEvent event) {
    	pr2.setText(l2.getText());
    }

    @FXML
    void changep3(MouseEvent event) {
    	pr3.setText(l3.getText());
    }

    @FXML
    void changep4(MouseEvent event) {
    	pr4.setText(l4.getText());
    }

    @FXML
    void changep5(MouseEvent event) {
    	pr5.setText(l5.getText());
    }

    @FXML
    void changep6(MouseEvent event) {
    	pr6.setText(l6.getText());
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		loggedinname.setText(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getName());
    	}
		
		int prev = 0;
		for (int i=0; i<EShopSpotController.getProducts().size(); i++)
		{
			if (EShopSpotController.getProducts().get(i).getType().equals(EShopSpotController.getTypeProducts()))
			{
				if (prev == 0)
				{
					myImage1 = new Image(getClass().getResourceAsStream(EShopSpotController.getProducts().get(i).getImage_path()));
					l1.setText((Double.toString(EShopSpotController.getProducts().get(i).getPrice())));
				}
				if (prev == 1)
				{
					myImage2 = new Image(getClass().getResourceAsStream(EShopSpotController.getProducts().get(i).getImage_path()));
					l2.setText((Double.toString(EShopSpotController.getProducts().get(i).getPrice())));}
				if (prev == 2)
				{
					myImage3 = new Image(getClass().getResourceAsStream(EShopSpotController.getProducts().get(i).getImage_path()));
					l3.setText((Double.toString(EShopSpotController.getProducts().get(i).getPrice())));
					}
				if (prev == 3)
				{	
					myImage4 = new Image(getClass().getResourceAsStream(EShopSpotController.getProducts().get(i).getImage_path()));
					l4.setText((Double.toString(EShopSpotController.getProducts().get(i).getPrice())));
				}
				if (prev == 4)
				{	
					myImage5 = new Image(getClass().getResourceAsStream(EShopSpotController.getProducts().get(i).getImage_path()));
					l5.setText((Double.toString(EShopSpotController.getProducts().get(i).getPrice())));
				}
				if (prev == 5)
				{
					myImage6 = new Image(getClass().getResourceAsStream(EShopSpotController.getProducts().get(i).getImage_path()));
					l6.setText((Double.toString(EShopSpotController.getProducts().get(i).getPrice())));
				}
				prev++;
			}
		}
		
		Picture1.setImage(myImage1);
		Picture2.setImage(myImage2);
		Picture3.setImage(myImage3);
		Picture4.setImage(myImage4);
		Picture5.setImage(myImage5);
		Picture6.setImage(myImage6);
	}
}

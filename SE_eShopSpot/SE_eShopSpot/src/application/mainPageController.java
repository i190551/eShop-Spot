package application;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class mainPageController implements Initializable{

	// For Advertisements
	Image myImage1 = new Image(getClass().getResourceAsStream("/Images/ad.png"));
	Image myImage2 = new Image(getClass().getResourceAsStream("/Images/apparel.jpg"));
	Image myImage3 = new Image(getClass().getResourceAsStream("/Images/ad4.jpeg"));
	Image myImage4 = new Image(getClass().getResourceAsStream("/Images/sunglasses.jpg"));
	Image myImage5 = new Image(getClass().getResourceAsStream("/Images/hat.jpg"));
		
	// For Trending Products
	Image myImaget2;
	Image myImaget3;
	Image myImaget4;
	Image myImaget5;
	Image myImaget6;
	
	@FXML
    private ImageView walletIcon;

	@FXML
    private Label loggedinname;
	
	@FXML
    private Button CancelOrder;
	
	@FXML
    private Button logout;
	
	@FXML
    private ImageView Advertisement;

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
    private Circle dot1;

    @FXML
    private Circle dot2;

    @FXML
    private Circle dot3;
    
    @FXML
    private Circle dot4;

    @FXML
    private Circle dot5;
    
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
    
    /* For changing advertisements */
    @FXML
    void dot1clicked(MouseEvent event) {
    	dot2.setFill(Color.GRAY);
    	dot1.setFill(Color.VIOLET);
    	dot3.setFill(Color.GRAY);
    	dot4.setFill(Color.GRAY);
    	dot5.setFill(Color.GRAY);
    	Advertisement.setImage(myImage1);
    }

    @FXML
    void dot2clicked(MouseEvent event) {
    	dot2.setFill(Color.VIOLET);
    	dot1.setFill(Color.GRAY);
    	dot3.setFill(Color.GRAY);
    	dot4.setFill(Color.GRAY);
    	dot5.setFill(Color.GRAY);
    	Advertisement.setImage(myImage2);
    }

    @FXML
    void dot3clicked(MouseEvent event) {
    	dot3.setFill(Color.VIOLET);
    	dot2.setFill(Color.GRAY);
    	dot1.setFill(Color.GRAY);
    	dot4.setFill(Color.GRAY);
    	dot5.setFill(Color.GRAY);
    	Advertisement.setImage(myImage3);
    }
    
    @FXML
    void dot4clicked(MouseEvent event) {
    	dot4.setFill(Color.VIOLET);
    	dot2.setFill(Color.GRAY);
    	dot1.setFill(Color.GRAY);
    	dot3.setFill(Color.GRAY);
    	dot5.setFill(Color.GRAY);
    	Advertisement.setImage(myImage4);
    }

    @FXML
    void dot5clicked(MouseEvent event) {
    	dot5.setFill(Color.VIOLET);
    	dot2.setFill(Color.GRAY);
    	dot1.setFill(Color.GRAY);
    	dot3.setFill(Color.GRAY);
    	dot4.setFill(Color.GRAY);
    	Advertisement.setImage(myImage5);
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

    /* For Trending Products */
    @FXML
    private ImageView pt2;

    @FXML
    private ImageView pt3;

    @FXML
    private ImageView pt4;

    @FXML
    private ImageView pt5;

    @FXML
    private ImageView pt6;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
    	if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		loggedinname.setText(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getName());
    	}
		int prev = 0;
		for (int i=0; i<EShopSpotController.getProducts().size(); i++)
		{
			if (prev == 0)
				myImaget2 = new Image(getClass().getResourceAsStream(EShopSpotController.getTrendingproducts().get(i).getImage_path()));
			if (prev == 1)
				myImaget3 = new Image(getClass().getResourceAsStream(EShopSpotController.getTrendingproducts().get(i).getImage_path()));
			if (prev == 2)
				myImaget4 = new Image(getClass().getResourceAsStream(EShopSpotController.getTrendingproducts().get(i).getImage_path()));
			if (prev == 3)
				myImaget5 = new Image(getClass().getResourceAsStream(EShopSpotController.getTrendingproducts().get(i).getImage_path()));
			if (prev == 4)
				myImaget6 = new Image(getClass().getResourceAsStream(EShopSpotController.getTrendingproducts().get(i).getImage_path()));
			prev++;
		}
		
		pt2.setImage(myImaget2);
		pt3.setImage(myImaget3);
		pt4.setImage(myImaget4);
		pt5.setImage(myImaget5);
		pt6.setImage(myImaget6);
	}
}

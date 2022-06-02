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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class cartController implements Initializable {

	Image myImage1;
	Image myImage2;
	Image myImage3;
	Image myImage4;
	
    @FXML
    private Button CancelOrder;

    @FXML
    private ImageView Picture1;

    @FXML
    private ImageView Picture2;

    @FXML
    private ImageView Picture3;

    @FXML
    private ImageView Picture4;

    @FXML
    private Button beauty;

    @FXML
    private Button becomeMember;

    @FXML
    private ImageView cardBtn;

    @FXML
    private Button customerCare;

    @FXML
    private Label d1;

    @FXML
    private Label d2;

    @FXML
    private Label d3;

    @FXML
    private Label d4;

    @FXML
    private Button details1;

    @FXML
    private Button details2;

    @FXML
    private Button details3;

    @FXML
    private Button details4;

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
    private Button home;

    @FXML
    private Button kidClothing;

    @FXML
    private Button login;

    @FXML
    private Button logout;

    @FXML
    private Label loggedinname;
    
    @FXML
    private Button menClothing;

    @FXML
    private Label n1;

    @FXML
    private Label n2;

    @FXML
    private Label n3;

    @FXML
    private Label n4;

    @FXML
    private Label p1;

    @FXML
    private Label p2;
    
    @FXML
    private Label p3;

    @FXML
    private Label p4;

    @FXML
    private TextField QtnProducts;
    
    @FXML
    private Label totalProducts;
    
    @FXML
    private Button payment;

    @FXML
    private Label q1;

    @FXML
    private Label q2;

    @FXML
    private Label q3;

    @FXML
    private Label q4;

    @FXML
    private Button signup;

    @FXML
    private Button womenCLothing;

    @FXML
    void totalProductsClick(MouseEvent event) {
    	QtnProducts.setText(Integer.toString(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size()));
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
    	// Nothing
    }

    @FXML
    void details1Btn(ActionEvent event) {

    	n1.setText(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(0).getPpid().getName());
    	q1.setText(Integer.toString(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(0).getQtn()));
    	p1.setText(Double.toString(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(0).getPpid().getPrice()));
    	d1.setText(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(0).getPpid().getDescription());
    }

    @FXML
    void details2Btn(ActionEvent event) {

    	n2.setText(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(1).getPpid().getName());
    	q2.setText(Integer.toString(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(1).getQtn()));
    	p2.setText(Double.toString(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(1).getPpid().getPrice()));
    	d2.setText(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(1).getPpid().getDescription());
    }

    @FXML
    void details3Btn(ActionEvent event) {

    	n3.setText(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(2).getPpid().getName());
    	q3.setText(Integer.toString(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(2).getQtn()));
    	p3.setText(Double.toString(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(2).getPpid().getPrice()));
    	d3.setText(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(2).getPpid().getDescription());
    }

    @FXML
    void details4Btn(ActionEvent event) {
    	
    	n4.setText(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(3).getPpid().getName());
    	q4.setText(Integer.toString(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(3).getQtn()));
    	p4.setText(Double.toString(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(3).getPpid().getPrice()));
    	d4.setText(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(3).getPpid().getDescription());
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
    void paymentBtn(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.screen("/Controller_FXMLs/payment.fxml","eShopSpot Payment");
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
		
		if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		loggedinname.setText(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getName());
    	}
		
		int prev = 0;
		for (int i=0; i<EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size(); i++)
		{
			if (prev == 0)
			{
				myImage1 = new Image(getClass().getResourceAsStream(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(i).getPpid().getImage_path()));
			}
			if (prev == 1)
			{
				myImage2 = new Image(getClass().getResourceAsStream(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(i).getPpid().getImage_path()));
			}
			if (prev == 2)
			{
				myImage3 = new Image(getClass().getResourceAsStream(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(i).getPpid().getImage_path()));
			}
			if (prev == 3)
			{	
				myImage4 = new Image(getClass().getResourceAsStream(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().get(i).getPpid().getImage_path()));
			}
			prev++;
		}	
		Picture1.setImage(myImage1);
		Picture2.setImage(myImage2);
		Picture3.setImage(myImage3);
		Picture4.setImage(myImage4);
		
		QtnProducts.setText(Integer.toString(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCart().size()));
	}

}

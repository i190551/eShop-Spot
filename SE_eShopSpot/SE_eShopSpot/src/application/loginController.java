package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class loginController {

    @FXML
    private Button CancelOrder;

    @FXML
    private Button beauty1;

    @FXML
    private Button becomeMember;

    @FXML
    private Button customerCare;

    @FXML
    private Button discover1;

    @FXML
    private Button electronics1;

    @FXML
    private Button faq;

    @FXML
    private Button forgotPass;

    @FXML
    private Button gadgets1;

    @FXML
    private Button health1;

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
    private Button register;

    @FXML
    private Button signup;

    @FXML
    private Button submit;

    @FXML
    private Button womenCLothing1;
    
    @FXML
    private TextField numberOrEmail;

    @FXML
    private PasswordField pass;
    
    @FXML
    private Button home;
    
    @FXML
    private ImageView cardBtn;

    @FXML
    void homePageBtn(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/mainPage.fxml","eShopSpot");
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
    void forgotPassBttn(ActionEvent event) {

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
        	m.screen("/Controller_FXMLs/login.fxml", "Products");
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
    void registerBttn(ActionEvent event) {

    	if (EShopSpotController.getLoggedIn().equals("No"))
    	{
    		
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

    private void AlertMessage (String title, String content)
    {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
        alert.showAndWait();
    }
    
    @FXML
    void submitBttn(ActionEvent event) {

    	if (EShopSpotController.getLoggedIn().equals("Yes"))
		{
			String title = "Logged in";
			String content = "Already logged in. Logout first to login to another account";
        	AlertMessage(title,content);
		}
    	else if (numberOrEmail.getText().isEmpty() && pass.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter the required information.";
        	AlertMessage(title,content);	
		}
		else if (numberOrEmail.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter login email or phoneNo.";
        	AlertMessage(title,content);
        }
		else if (pass.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter password.";
        	AlertMessage(title,content);
        }
		else if (!numberOrEmail.getText().isEmpty() && !pass.getText().isEmpty())
		{
			EShopSpotController ess = new EShopSpotController();
			int ans = ess.login(numberOrEmail.getText(), pass.getText());
			
			if (ans == -1)
			{
				String title = "Login Failed";
				String content = "Either you do not have an account or you are entering wrong credentials.";
	        	AlertMessage(title,content);
			}
			else if (ans >= 0)
			{
				EShopSpotController.setLoggedIn("Yes");
				EShopSpotController.setCurrentUser(ans);
				loggedinname.setText(EShopSpotController.getCustomers().get(ans).getName());
				
				String title = "Login Successful";
				String content = "You have successfully logged into your account.";
	        	AlertMessage(title,content);
			}
		}
    }

    @FXML
    void womenClothingBttn(ActionEvent event) throws IOException {
    	EShopSpotController.setTypeProducts("Women Clothing");
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/Products.fxml", "Products");
    }
}

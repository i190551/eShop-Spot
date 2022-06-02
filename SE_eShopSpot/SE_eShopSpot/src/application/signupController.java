package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class signupController implements Initializable {

    @FXML
    private Button CancelOrder;

    public String dateDOB = "nodate";
    
    @FXML
    private DatePicker DOB;

    @FXML
    private Button beauty;

    @FXML
    private Button becomeMember;

    @FXML
    private ImageView cardBtn;

    @FXML
    private CheckBox checkBoxSignup;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private Button customerCare;

    @FXML
    private Button discover1;

    @FXML
    private Button electronics;

    @FXML
    private TextField email;

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
    private Label loggedinname;

    @FXML
    private Button login;

    @FXML
    private Button login1;

    @FXML
    private Button logout;

    @FXML
    private Button menClothing;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Button signup;

    @FXML
    private Button submitSignUp;

    @FXML
    private Button womenCLothing;

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

    private void AlertMessage (String title, String content)
    {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
        alert.showAndWait();
    }
    
    @FXML
    void DateSet(ActionEvent event) {
    	LocalDate myDate = DOB.getValue();
    	dateDOB = myDate.format(DateTimeFormatter.ofPattern("MM-DD-YYYY"));
    }

    public boolean checkPhoneNo(String phoneNo)
    {
    	int count = 0;
    	if (phoneNo.length() < 11)
    		return false;
    	for (int i = 0; i < phoneNo.length(); i++)
    	{
    		if (phoneNo.charAt(i) >= 48 && phoneNo.charAt(i) <= 57)
    		{
    			count++;
    		}
    	}
    	if (count == phoneNo.length())
    	{
    		return true;
    	}
    	return false;
    }
    
    @FXML
    void submitSignUpBttn(ActionEvent event) throws SQLException, ClassNotFoundException {

    	if (name.getText().isEmpty() && phoneNumber.getText().isEmpty() && email.getText().isEmpty() 
    			&& password.getText().isEmpty() && confirmPassword.getText().isEmpty() && dateDOB.equals("nodate"))
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter the required information.";
        	AlertMessage(title,content);	
		}
		else if (name.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter name and any other remaining information.";
        	AlertMessage(title,content);
        }
		else if (phoneNumber.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter phone Number and any other remaining information.";
        	AlertMessage(title,content);
        }
		else if (email.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter email and any other remaining information.";
        	AlertMessage(title,content);
        }
		else if (password.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter password and any other remaining information.";
        	AlertMessage(title,content);
        }
		else if (confirmPassword.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter password again to confirm it and any other remaining information.";
        	AlertMessage(title,content);
        }
		else if (dateDOB.equals("nodate"))
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter DOB and any other remaining information.";
        	AlertMessage(title,content);
        }
		else if (!name.getText().isEmpty() && !phoneNumber.getText().isEmpty() && !email.getText().isEmpty() 
    			&& !password.getText().isEmpty() && !confirmPassword.getText().isEmpty() && !dateDOB.equals("nodate"))
		{
			int allFields = 1;
			/* Check Phone Number */
			if (!checkPhoneNo(phoneNumber.getText()) || !phoneNumber.getText().startsWith("03"))
			{
				allFields = 0;
				String title = "Incomplete Credentials";
				String content = "Kindly enter correct phone No. The first digit must be 0 and second digit must be 3."
						+ "\nThe No. should be 11 digits.";
	        	AlertMessage(title,content);
			}
			/* Check email */
			if (!email.getText().contains("@gmail.com"))
			{
				allFields = 0;
				String title = "Incomplete Credentials";
				String content = "The email should have @gmail.com.";
	        	AlertMessage(title,content);
			}
			/* Check Password */
			if (!password.getText().equals(confirmPassword.getText()))
			{
				allFields = 0;
				String title = "Incomplete Credentials";
				String content = "The password in both fields must be same.";
	        	AlertMessage(title,content);
			}
			/* Checking the checkbox */
			if (!checkBoxSignup.isSelected())
			{
				allFields = 0;
				String title = "Incomplete Credentials";
				String content = "Kindly select the Check Box to continue with Sign-up.";
	        	AlertMessage(title,content);
			}
			if (allFields == 1)
			{
				EShopSpotController ess = new EShopSpotController();
				if (ess.addCustomer(name.getText(), phoneNumber.getText(), dateDOB, email.getText(), password.getText()))
				{
					String title = "Sign-up Successful";
					String content = "You have been successfully registered."
							+ "\nYou can now use your new credentials to login and explore new features.";
		        	AlertMessage(title,content);
				}
				else
				{
					String title = "Sign-up not Successful";
					String content = "An account with the entered email or phone No. has already been created.";
		        	AlertMessage(title,content);
				}
			}
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
	}

}

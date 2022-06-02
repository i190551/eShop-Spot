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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class becomeMemberController implements Initializable {

    @FXML
    private Button CancelOrder;

    @FXML
    private TextField address;

    @FXML
    private TextField bankaccount;

    @FXML
    private Button beauty;

    @FXML
    private CheckBox beautybox;

    @FXML
    private Button becomeMember;

    @FXML
    private ImageView cardBtn;

    @FXML
    private CheckBox checkBoxMember;

    @FXML
    private CheckBox clothingbox;

    @FXML
    private Button customerCare;

    @FXML
    private Button discover1;

    @FXML
    private Button electronics;

    @FXML
    private CheckBox electronicsbox;

    @FXML
    private Button faq;

    @FXML
    private Button gadgets;

    @FXML
    private CheckBox gadgetsbox;

    @FXML
    private Button health;

    @FXML
    private CheckBox healthbox;

    @FXML
    private Button home;

    @FXML
    private Button kidClothing;

    @FXML
    private Label loggedinname;

    @FXML
    private Button login1;

    @FXML
    private Button logout;

    @FXML
    private Button menClothing;

    @FXML
    private Button signup;

    @FXML
    private Button submitMember;

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
    void signUpBttn(ActionEvent event) {

    }

    private void AlertMessage (String title, String content)
    {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
        alert.showAndWait();
    }
    
    public boolean checkBankNo(String bankNo)
    {
    	int count = 0;
    	if (bankNo.length() < 9)
    		return false;
    	for (int i = 0; i < bankNo.length(); i++)
    	{
    		if (bankNo.charAt(i) >= 48 && bankNo.charAt(i) <= 57)
    		{
    			count++;
    		}
    	}
    	if (count == bankNo.length())
    	{
    		return true;
    	}
    	return false;
    }
    
    @FXML
    void submitMemberBttn(ActionEvent event) throws ClassNotFoundException, SQLException {

    	int preferences = 0;
    	String pref = " ";
    	StringBuilder sb = new StringBuilder(pref);
    	
    	if (address.getText().isEmpty() && bankaccount.getText().isEmpty() && !healthbox.isSelected()
    			&& !clothingbox.isSelected() && !gadgetsbox.isSelected() && !electronicsbox.isSelected() 
    			&& !beautybox.isSelected())
		{
			String title = "Incomplete Info";
			String content = "Kindly enter the required information.";
        	AlertMessage(title,content);	
		}
		else if (address.getText().isEmpty())
		{
			String title = "Incomplete Info";
			String content = "Kindly enter address and any other remaining information.";
        	AlertMessage(title,content);
        }
		else if (bankaccount.getText().isEmpty())
		{
			String title = "Incomplete Info";
			String content = "Kindly enter bank account number and any other remaining information.";
        	AlertMessage(title,content);
        }
		else if (!healthbox.isSelected() && !clothingbox.isSelected() && !gadgetsbox.isSelected() && !electronicsbox.isSelected() 
    			&& !beautybox.isSelected()) 
        {
			String title = "Incomplete Info";
			String content = "Kindly select at least one preference and fill any other remaining information.";
        	AlertMessage(title,content);
        }
		if (healthbox.isSelected() || clothingbox.isSelected() || gadgetsbox.isSelected() || electronicsbox.isSelected() 
    			|| beautybox.isSelected())
		{
			if (healthbox.isSelected())
			{
				preferences++;
				sb.append("Health");
				sb.append(",");
			}
			if (beautybox.isSelected())
			{
				preferences++;
				sb.append("Beauty");
				sb.append(",");
			}
			if (electronicsbox.isSelected())
			{
				preferences++;
				sb.append("Electronics");
				sb.append(",");
			}
			if (gadgetsbox.isSelected())
			{
				preferences++;
				sb.append("Gadgets");
				sb.append(",");
			}
			if (clothingbox.isSelected())
			{
				preferences++;
				sb.append("Clothing");
			}
		} 
		if (!address.getText().isEmpty() && !bankaccount.getText().isEmpty() && preferences >= 1)
		{
			int allFields = 1;
			/* Check Bank Number */
			if (!checkBankNo(bankaccount.getText()))
			{
				allFields = 0;
				String title = "Incomplete Info";
				String content = "Kindly enter correct bank No."
						+ "\nThe No. should be 9 digits.";
	        	AlertMessage(title,content);
			}
			if (!checkBoxMember.isSelected())
			{
				allFields = 0;
				String title = "Incomplete Credentials";
				String content = "Kindly select the Check Box to continue with Becoming a Member.";
	        	AlertMessage(title,content);
			}
			if (allFields == 1)
			{
				EShopSpotController ess = new EShopSpotController();
				pref = sb.toString();
				if (ess.addMember(address.getText(), bankaccount.getText(), pref))
				{
					String title = "Member Registration Successful";
					String content = "You have been successfully registered as a Member."
							+ "\nYou can now use your newly assigned features.";
		        	AlertMessage(title,content);
				}
				else
				{
					String title = "Member Registration not Successful";
					String content = "You are already registered as a Member.";
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

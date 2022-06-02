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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class walletController implements Initializable {

    @FXML
    private Button CancelOrder;

    @FXML
    private TextField accNum;

    @FXML
    private TextField amount;

    @FXML
    private TextField amountEnt;

    @FXML
    private Button beauty;

    @FXML
    private Button becomeMember;

    @FXML
    private ImageView cardBtn;

    @FXML
    private Button customerCare;

    @FXML
    private Button discover1;

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
    private Label loggedinname;

    @FXML
    private Button login;

    @FXML
    private Button logout;

    @FXML
    private Button menClothing;

    @FXML
    private Button signup;

    @FXML
    private Button transfer;

    @FXML
    private TextField wallentcurrentamount;

    @FXML
    private Button womenCLothing;

    int mem = -1;
    
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
    void amountDisplay(ActionEvent event) {

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
    
    public boolean checkAmount(String amount)
    {
    	int count = 0;
    	for (int i = 0; i < amount.length(); i++)
    	{
    		if (amount.charAt(i) >= 48 && amount.charAt(i) <= 57)
    		{
    			count++;
    		}
    	}
    	if (count == amount.length())
    	{
    		return true;
    	}
    	return false;
    }
    
    public boolean checkAccount(String acc)
    {
    	if (EShopSpotController.getMembers().get(mem).getBankaccount().equals(acc))
    		return true;
    	return false;
    }
    
    @FXML
    void transferBttn(ActionEvent event) throws SQLException, ClassNotFoundException {
    	
    	if (accNum.getText().isEmpty() && amountEnt.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter the required information.";
        	AlertMessage(title,content);	
		}
		else if (accNum.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter Account Number.";
        	AlertMessage(title,content);
        }
		else if (amountEnt.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly specify the amount to transfer.";
        	AlertMessage(title,content);
        }
		else if (!accNum.getText().isEmpty() && !amountEnt.getText().isEmpty())
		{
			if (!checkAccount(accNum.getText()))
			{
				String title = "Transaction Failed";
				String content = "The correct account number associated with your account has not been entered.";
	        	AlertMessage(title,content);
			}
			if (!checkAmount(amountEnt.getText()))
			{
				String title = "Transaction Failed";
				String content = "The correct amount has not been entered.";
	        	AlertMessage(title,content);
			}
			if (checkAccount(accNum.getText()) && checkAmount(amountEnt.getText()))
			{
				double newAmount = Double.parseDouble(amountEnt.getText());
				
				EShopSpotController ess = new EShopSpotController();
				if (ess.walletAmount(mem, newAmount))
				{
					String title = "Transaction Successful";
					String content = "The amount has been transferred.";
		        	AlertMessage(title,content);
					amount.setText(amountEnt.getText());
				}
				else
				{
					String title = "Transaction Failed";
					String content = "The amount has not been transferred.";
		        	AlertMessage(title,content);
				}
			}
		}
    }

    @FXML
    void wallentcurrentamountDisplay(MouseEvent event) {
    	
    	wallentcurrentamount.setText(Double.toString(EShopSpotController.getMembers().get(mem).getWallet()));
    }
    
    @FXML
    void womenClothingBttn(ActionEvent event) throws IOException {
    	EShopSpotController.setTypeProducts("Women Clothing");
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/Products.fxml", "Products");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		for (int i=0; i<EShopSpotController.getMembers().size(); i++)
    	{
    		if (EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getCid().equals(EShopSpotController.getMembers().get(i).getCid()))
    			mem = i;
    	}
		if (EShopSpotController.getLoggedIn().equals("Yes"))
    	{
    		loggedinname.setText(EShopSpotController.getCustomers().get(EShopSpotController.getCurrentUser()).getName());
    	}
	}

}

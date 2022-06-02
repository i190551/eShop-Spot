package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class faqController {

	private void AlertMessage (String title, String content)
    {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
        alert.showAndWait();
    }
	
    @FXML
    private Button becomeMember1;

    @FXML
    private ToggleGroup answer;
    
    @FXML
    private Button CancelOrder;
    
    @FXML
    private Button customerCare1;

    @FXML
    private Button logout;
    
    @FXML
    private Button faq1;

    @FXML
    private Button homepage;

    @FXML
    private Button login1;

    @FXML
    private RadioButton no;

    @FXML
    private Button q1;

    @FXML
    private Button q2;

    @FXML
    private Button q3;

    @FXML
    private Button q4;

    @FXML
    private Button q5;

    @FXML
    private Button q6;

    @FXML
    private Button q7;

    @FXML
    private Button q8;

    @FXML
    private Button signup1;

    @FXML
    private RadioButton yes;

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
    void faqBttn(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/faq.fxml", "Faqs");;
    }

    @FXML
    void homepageBttn(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.screen("/Controller_FXMLs/mainPage.fxml","eShopSpot");
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
    void response(ActionEvent event) {

    	if (no.isSelected())
    	{
    		EShopSpotController.getResponsesFaq().add("NO");
    		System.out.println(EShopSpotController.getResponsesFaq().get(EShopSpotController.getResponsesFaq().size()-1));
    	}
    	else if (yes.isSelected())
    	{
    		EShopSpotController.getResponsesFaq().add("YES");
    		System.out.println(EShopSpotController.getResponsesFaq().get(EShopSpotController.getResponsesFaq().size()-1));
    	}
    }
    
    @FXML
    void q1ans(ActionEvent event) {
    	String title = "Account Management -> My Account";
		String content = "Can I access eShopSpot account from multiple devices?"
				+ "\r\n"+"Yes, you can access the eShopSpot app from multiple devices.";
    	AlertMessage(title,content);
    }

    @FXML
    void q2ans(ActionEvent event) {
    	String title = "Account Management -> My Account";
		String content = "  How to subscribe eShopSpot Newsletters?"+"\r\n"+"To Subscribe to the Newsletter of eShopSpot, you need to follow the below simple steps on the eShopSpot Website:\r\n"
				+ "\r\n"
				+ "Log in to your Account\r\n"
				+ "\r\n"
				+ "Tap your name at the top right corner\r\n"
				+ "\r\n"
				+ "Click Manage My Account\r\n"
				+ "\r\n"
				+ "Click Subscribe from our Newsletter under the Personal Profile section\r\n"
				+ "\r\n"
				+ "Read eShopSpot Privacy Policy\r\n"
				+ "\r\n"
				+ "If you agree to the policy, click Subscribe";
    	AlertMessage(title,content);
    }

    @FXML
    void q3ans(ActionEvent event) {
    	String title = "Account Management -> My Account";
		String content = " What should I do if my phone number is already registered with another account?"+"\r\n"+"Only 1 phone number can be registered under each eShopSpot account.\r\n"
				+ "\r\n"
				+ "You have an existing account with the same phone number, in this case, you can log in to your existing account and continue to use it.\r\n"
				+ "\r\n"
				+ "If you have forgotten your password, simply reset your password on the login page. Once you set a new password then you can continue with your existing account.\r\n"
				+ "\r\n"
				+ "If you are unable to create an account or change to your new phone number, you can: Please try again using a new phone number (which is not linked with any other account on eShopSpot).\r\n"
				+ "\r\n"
				+ "If you still find any issue you can contact our Care Champ (Live Chat) for further assistance.";
    	AlertMessage(title,content);
    }

    @FXML
    void q4ans(ActionEvent event) {
    	String title = "Account Management -> Privacy & Security ";
		String content = " How does eShopSpot protect the customer's data??"+"\r\n"+"The Privacy Policy at eShopSpot can help you with the following concerns:\r\n"
				+ "\r\n"
				+ "How we collect, use, and (under certain conditions) disclose your personal information\r\n"
				+ "\r\n"
				+ "The steps we have taken to secure your personal information\r\n"
				+ "\r\n"
				+ "The Privacy Policy explains your options regarding the collection, use, and disclosure of your personal information.\r\n"
				+ "\r\n"
				+ "Please visit the Privacy & Confidentiality to learn more";
    	AlertMessage(title,content);
    }

    @FXML
    void q5ans(ActionEvent event) {
    	String title = "Account Management -> Privacy & Security";
		String content = "What safety measures can I take on eShopSpot to avoid being hacked or scammed?\r\n"
				+ "We are focused on ensuring that no incidents of fraud and scams take place. Please reach out to us via live chat if you come across any suspicious activity related to eShopSpot.\r\n"
				+ "\r\n"
				+ "Fraudulent activities can include:\r\n"
				+ "\r\n"
				+ "1. Messages received on WhatsApp from sellers claiming to be a part of our eShopSpot seller community"
				+"\r\n"
				+ "2. Facebook pages that claim to be associated with our platform and selling eShopSpot products"
				+"\r\n"
				+"3. Orders not packed in the packaging of eShopSpot\r\n"
				+"\r\n"
				+ "4. Delivery agents acting to be DEX Heroes\r\n"
				+"\r\n"
				+ "5. Individuals representing eShopSpot Customer Service Agents and asking for bank account details.\r\n"
				+"\r\n"
				+ "6. Other websites that are similar in name to eShopSpot.pk"
				+"\r\n";
    	AlertMessage(title,content);
    }

    @FXML
    void q6ans(ActionEvent event) {
    	String title = "Orders -> Vouchers";
		String content = "What is the validity of vouchers?\r\n"
				+ "You can check the validity of the voucher by login into your eShopSpot account > Click on your name top right side > Manage My Account > Vouchers.";
				
    	AlertMessage(title,content);
    }

    @FXML
    void q7ans(ActionEvent event) {
    	String title = "Orders -> Vouchers";
		String content = "Where can I check my vouchers?\r\n"
				+ "What is the validity of vouchers?\r\n"
				+ "You can check the validity of the voucher by login into your eShopSpot account > Click on your name top right side > Manage My Account > Vouchers.";
    	AlertMessage(title,content);
    }
    
    @FXML
    void q8ans(ActionEvent event) {
    	String title = "Payments -> Payment Method";
		String content ="I am unable to pay through EasyPaisa Direct, what should I do?\r\n"+
				"If you did not receive the OTP while paying from EasyPaisa, refer to the scenarios below:\r\n"
				+ "\r\n"
				+ "If you�re a Telenor user: Input your 5-digit M-PIN into the USSD prompt.\r\n"
				+ "\r\n"
				+ "If you're a non-Telenor user; Login in your Easypaisa app > Tap on the top-left Menu to approve the payment in \"My approvals\"";
    	AlertMessage(title,content);
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
}

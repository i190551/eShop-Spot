package application;
	
import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private static Stage st;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/Controller_FXMLs/mainPage.fxml"));
			Scene scene = new Scene(root,1300,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			st=primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("eShopSpot");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void screen(String sc, String t) throws IOException {
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource(sc));
		Scene scene = new Scene(root,1300,700);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		st.setTitle(t);
	    st.setScene(scene);
	    st.show();
	}
	
	public static void main(String[] args) throws SQLException {
		Database db = new Database();
		db.createConnection();
		db.retreiveProducts();
		db.retreiveTrendingProducts();
		db.retreivePromoCodes();
		db.retreiveCustomers();
		db.retreiveCart();
		db.retreiveMembers();
		db.setProductsinCart();
		db.setCartinCustomer();
		db.setCustomerinMember();
		db.retreiveOrders();
		
		/* For Display and checking the database purposes */
		//EShopSpotController ess = new EShopSpotController();
		//ess.displayCustomers();
		//ess.displayMembers();
		
		launch(args);
	}
}

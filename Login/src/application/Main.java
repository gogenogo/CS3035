package application;
	
import application.InteractionModel.Displayed;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	public static final Color forText = Color.rgb(13, 140, 255);

	public static final Model model = new Model();
	public static final View view = new View();
	public static final Controller controller = new Controller();
	public static final InteractionModel iModel = new InteractionModel();
	public static final ToolbarView tbView = new ToolbarView();
	public static final ToolbarController tbController = new ToolbarController(tbView);
	

	public static final DashboardView dashview = new DashboardView();
	public static final NewExpenseView expenseview = new NewExpenseView();
	public static final DashboardController dashcontroller = new DashboardController();

	
	@Override
	public void start(Stage primaryStage) {
		try {
			//Main.dashcontroller.showView();
			VBox root = new VBox();
			root.getChildren().addAll(tbView, view);
			Scene scene = new Scene(root,400,600, Color.rgb(217, 228, 255));
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			final Stage newStage = new Stage();
			newStage.initStyle(StageStyle.TRANSPARENT);
			VBox textBoxs = new VBox(3);
			
			Text title = new Text("Sharkt");
			title.setFont(Font.font("Open Sans", 80));
			title.setStroke(Main.forText);
			title.setFill(Main.forText);
			
			Text subTitle = new Text("Here to help you save money!");
			subTitle.setFont(Font.font("Open Sans", 30));
			subTitle.setStroke(Main.forText);
			subTitle.setFill(Main.forText);
			
			Text body = new Text("Please wait while we set things up for you...");
			body.setFont(Font.font("Open Sans", 15));
			body.setStroke(Main.forText);
			body.setFill(Main.forText);
			
			textBoxs.getChildren().addAll(title, subTitle, body);
			textBoxs.setAlignment(Pos.CENTER);
			VBox inner = new VBox(20);
			ImageView logo = new ImageView("SharktLogo.png");
			inner.getChildren().addAll(textBoxs, logo);
			inner.setAlignment(Pos.CENTER);
			Scene newScene = new Scene(inner, 800, 450); 
			inner.setBackground(new Background(new BackgroundFill(Color.rgb(217, 228, 255), CornerRadii.EMPTY, null)));
			newStage.setScene(newScene);
			iModel.setDisplayed(Displayed.OPEN);
			newStage.show();
			PauseTransition delay = new PauseTransition(Duration.seconds(3));
			delay.setOnFinished(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					newStage.close();
					primaryStage.show();

					
				}
				
			});
			delay.play();

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

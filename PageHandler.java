import javafx.application.Application;
import javafx.stage.Stage;

public class PageHandler extends Application {
    LoginPage lp;
    
    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage primaryStage) {
        lp = new LoginPage();
        primaryStage.setTitle(lp.getString());
        primaryStage.setScene(lp.getScene());
        primaryStage.show();
    }
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PageHandler extends Application {
    private static Stage primaryStage;
    private LoginPage lp;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        lp = new LoginPage();
        primaryStage.setTitle(lp.getString());
        primaryStage.setScene(lp.getScene());
        primaryStage.show();
    }

    public static void updatePage(Scene sc) {primaryStage.setScene(sc);}
}

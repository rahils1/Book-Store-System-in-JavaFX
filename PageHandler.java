import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PageHandler extends Application {
    private static Stage primaryStage;

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        new AccountOverview(new User("1", "2", "3", "4", "5"));
        primaryStage.show();
    }

    public static void updateStage(String s, Scene sc) {
        primaryStage.setTitle(s);
        primaryStage.setScene(sc);
    }
}

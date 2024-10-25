import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BookSearch extends Application {
    BorderPane root = new BorderPane();

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Book Search");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
}

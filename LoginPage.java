import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginPage {
    private VBox loginPage, loginBox;
    private Scene sc;
    private Color maroon = Color.web("#8C1D40");

    public LoginPage() {
        loginPage = new VBox();
        loginPage.setAlignment(Pos.CENTER);
        loginPage.setPadding(new Insets(20));
        loginPage.setStyle("-fx-background-color: #FFC627;");

        // Logo and title
        Label titleLabel = new Label("Sparky Book Service");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        titleLabel.setTextFill(Color.web("#8C1D40"));

        // Login form container
        loginBox = new VBox(10);
        loginBox.setAlignment(Pos.CENTER);
        loginBox.setPadding(new Insets(20));
        loginBox.setStyle("-fx-background-color: #F1C27D; -fx-background-radius: 10;");

        // Username field
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setStyle("-fx-background-radius: 20; -fx-padding: 5 20 5 20;");

        // Password field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setStyle("-fx-background-radius: 20; -fx-padding: 5 20 5 20;");

        // Login button
        Button loginButton = new Button("Login");
        loginButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        loginButton.setStyle("-fx-background-color: #001239; -fx-background-radius: 20;");
        loginButton.setTextFill(maroon);
        loginButton.setPrefWidth(200);

        // Links
        Hyperlink forgotPasswordLink = new Hyperlink("Forgot Password?");
        forgotPasswordLink.setTextFill(maroon);
        forgotPasswordLink.setUnderline(false);

        Hyperlink registerLink = new Hyperlink("Register");
        registerLink.setTextFill(maroon);
        registerLink.setUnderline(false);

        // Adding components to login container
        loginBox.getChildren().addAll(usernameField, passwordField, loginButton, forgotPasswordLink, registerLink);

        // Adding all components to main container
        loginPage.getChildren().addAll(titleLabel, loginBox);

        // Setting up the scene and stage
        sc = new Scene(loginPage, 500, 400);

    }

    public Scene getScene() {return sc;}

    public String getString() {return "Login Page";}
}

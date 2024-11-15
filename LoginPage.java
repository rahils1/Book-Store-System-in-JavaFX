import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Alert.AlertType;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LoginPage {
    private VBox loginPage, loginBox;
    private Scene sc;
    private Color maroon = Color.web("#8C1D40");
    private ArrayList<User> users;
    private TextField usernameField;
    private PasswordField passwordField;

    public LoginPage() {
        users = new ArrayList<User>();
        loginPage = new VBox();
        loginPage.setAlignment(Pos.CENTER);
        loginPage.setPadding(new Insets(20));
        loginPage.setStyle("-fx-background-color: #FFC627;");

        Label titleLabel = new Label("Sparky Book Service");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        titleLabel.setTextFill(maroon);

        loginBox = new VBox(10);
        loginBox.setAlignment(Pos.CENTER);
        loginBox.setPadding(new Insets(20));
        loginBox.setStyle("-fx-background-color: #F1C27D; -fx-background-radius: 10;");

        usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setPadding(new Insets(5,20,5,20));
        usernameField.setStyle("-fx-background-radius: 20;");

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setPadding(new Insets(5,20,5,20));
        passwordField.setStyle("-fx-background-radius: 20;");

        Button loginButton = new Button("Login");
        loginButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        loginButton.setStyle("-fx-background-color: #001239; -fx-background-radius: 20;");
        loginButton.setTextFill(maroon);
        loginButton.setPrefWidth(200);
        loginButton.setOnAction(e->onLoginAttempt());

        Hyperlink forgotPasswordLink = new Hyperlink("Forgot Password?");
        forgotPasswordLink.setTextFill(maroon);
        forgotPasswordLink.setUnderline(false);

        Hyperlink registerLink = new Hyperlink("Register");
        registerLink.setOnAction(e->CreateAccount());
        registerLink.setTextFill(maroon);
        registerLink.setUnderline(false);

        loginBox.getChildren().addAll(usernameField, passwordField, loginButton, forgotPasswordLink, registerLink);

        loginPage.getChildren().addAll(titleLabel, loginBox);

        sc = new Scene(loginPage, 500, 400);
        PageHandler.updateStage("Login Page", sc);
    }

    private void onLoginAttempt() {
        String file = usernameField.getText() + ".ser";
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            User deserializedUser = new User();
            deserializedUser.readExternal(in);
            boolean v = deserializedUser.validateUser(deserializedUser.getUname(), passwordField.getText());
            if(!v) {showAlert("Wrong username or password."); return;}
            new BookSearch(deserializedUser);
        } catch (IOException | ClassNotFoundException e) {showAlert("Wrong username or password.");}
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.ERROR, message);
        alert.showAndWait();
    }

    private void CreateAccount() {}
}

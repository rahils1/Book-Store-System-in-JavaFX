import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AccountOverview {
    User curr;
    public AccountOverview(User u) {
        curr = u;
        final Color MAROON = Color.web("#8C1D40");
        final Color GOLD = Color.web("FFC627");

        GridPane myAccount = new GridPane();

        Button backButton = new Button("Back");
        backButton.setFont(Font.font("Arial", 12));
        backButton.setStyle("-fx-background-color: #FFC627");
        backButton.setTextFill(MAROON);
        backButton.setPrefHeight(20);
        backButton.setOnAction(e-> {});

        Button logoutButton = new Button("Logout");
        logoutButton.setFont(Font.font("Arial", 12));
        logoutButton.setStyle("-fx-background-color: #FFC627");
        logoutButton.setTextFill(MAROON);
        logoutButton.setPrefHeight(20);
        logoutButton.setOnAction(e->{});

        HBox topBanner = new HBox(350, backButton, logoutButton);
        topBanner.setStyle("-fx-background-color: #CECECE");
        topBanner.setPrefSize(500, 30);
        topBanner.setPadding(new Insets(10));
        topBanner.setAlignment(Pos.CENTER);

        Label accountOverviewLabel = new Label("Account Overview");
        accountOverviewLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        accountOverviewLabel.setTextFill(GOLD);
        accountOverviewLabel.setUnderline(true);
        HBox accountOverviewBox = new HBox(accountOverviewLabel);
        accountOverviewBox.setAlignment(Pos.CENTER);

        Label firstName = new Label("First Name: FirstName");
        firstName.setFont(Font.font("Arial", 15));
        firstName.setTextFill(MAROON);
        firstName.setStyle("-fx-background-color: #CECECE");
        firstName.setMinSize(75, 40);

        Label username = new Label("Username: Username");
        username.setFont(Font.font("Arial", 15));
        username.setTextFill(MAROON);
        username.setStyle("-fx-background-color: #CECECE");
        username.setMinSize(75, 40);

        VBox firstColumn = new VBox(40, firstName, username);
        firstColumn.setPadding(new Insets(20, 0, 0, 10));
        firstColumn.setSpacing(40);

        Label lastName = new Label("Last Name: LastName");
        lastName.setFont(Font.font("Arial", 15));
        lastName.setTextFill(MAROON);
        lastName.setStyle("-fx-background-color: #CECECE");
        lastName.setMinSize(75, 40);

        Label password = new Label("Password: ******");
        password.setFont(Font.font("Arial", 15));
        password.setTextFill(MAROON);
        password.setStyle("-fx-background-color: #CECECE");
        password.setMinSize(75, 40);

        Button changePassword = new Button("Change Password");
        changePassword.setFont(Font.font("Arial", 15));
        changePassword.setTextFill(MAROON);
        changePassword.setStyle("-fx-background-color: #FFC627");
        changePassword.setMinSize(60, 40);

        VBox secondColumn = new VBox();
        secondColumn.setPadding(new Insets(20, 10, 0, 0));
        secondColumn.setSpacing(40);

        secondColumn.getChildren().addAll(lastName, password);

        firstColumn.getChildren().addAll(firstName, username);
        myAccount.add(topBanner, 0, 0);
        myAccount.add(accountOverviewBox, 0, 1);
        myAccount.add(firstColumn, 0, 2);
        myAccount.add(secondColumn, 0, 2);
        Scene sc = new Scene(myAccount,500,400);
        PageHandler.updateStage("Account Overview", sc);
    }

    // Utility to Show Alerts
    private void showAlert(String message, String title, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

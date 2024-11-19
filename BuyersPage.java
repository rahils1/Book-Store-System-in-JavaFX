package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class BuyersPage extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Define colors
            Color maroon = Color.web("#8C1D40");
            Color gold = Color.web("#FFC627");
            Color white = Color.web("#FFFFFF");

            // Top banner
            HBox topBanner = new HBox(10);
            topBanner.setStyle("-fx-background-color: #CECECE;");
            topBanner.setPadding(new Insets(10));
            topBanner.setAlignment(Pos.CENTER);

            Button myAccountButton = new Button("My Account");
            myAccountButton.setFont(Font.font("Arial", 12));
            myAccountButton.setStyle("-fx-background-color: #FFC627");
            myAccountButton.setTextFill(maroon);

            Button switchAccountsButton = new Button("Switch to Seller Account");
            switchAccountsButton.setFont(Font.font("Arial", 12));
            switchAccountsButton.setStyle("-fx-background-color: #FFC627");
            switchAccountsButton.setTextFill(maroon);

            Button logoutButton = new Button("Logout");
            logoutButton.setFont(Font.font("Arial", 12));
            logoutButton.setStyle("-fx-background-color: #FFC627");
            logoutButton.setTextFill(maroon);

            topBanner.getChildren().addAll(myAccountButton, switchAccountsButton, logoutButton);

            // Page title
            Label buyersPageLabel = new Label("Purchase Books");
            buyersPageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
            buyersPageLabel.setTextFill(gold);

            // Centered Title Box
            HBox titleBox = new HBox(buyersPageLabel);
            titleBox.setAlignment(Pos.CENTER);
            titleBox.setPadding(new Insets(10, 0, 20, 0));

            // Filters - Condition and Genre
            VBox filtersVBox = new VBox(15); // Adjusted spacing to improve alignment
            filtersVBox.setPadding(new Insets(20, 0, 0, 20)); // Added left padding for better positioning
            filtersVBox.setStyle("-fx-background-color: #8C1D40;");
            filtersVBox.setPrefWidth(200);

            // Condition
            Label conditionLabel = new Label("Condition");
            conditionLabel.setTextFill(gold);
            conditionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
            conditionLabel.setAlignment(Pos.CENTER);

            CheckBox newCheckBox = new CheckBox("New");
            newCheckBox.setTextFill(white);
            CheckBox moderatelyUsedCheckBox = new CheckBox("Moderately Used");
            moderatelyUsedCheckBox.setTextFill(white);
            CheckBox heavilyUsedCheckBox = new CheckBox("Heavily Used");
            heavilyUsedCheckBox.setTextFill(white);

            // Genre
            Label genreLabel = new Label("Genre");
            genreLabel.setTextFill(gold);
            genreLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
            genreLabel.setAlignment(Pos.CENTER);

            CheckBox scifiCheckBox = new CheckBox("Sci-Fi");
            scifiCheckBox.setTextFill(white);
            CheckBox fantasyCheckBox = new CheckBox("Fantasy");
            fantasyCheckBox.setTextFill(white);
            CheckBox comedyCheckBox = new CheckBox("Comedy");
            comedyCheckBox.setTextFill(white);
            CheckBox dramaCheckBox = new CheckBox("Drama");
            dramaCheckBox.setTextFill(white);
            CheckBox thrillerCheckBox = new CheckBox("Thriller");
            thrillerCheckBox.setTextFill(white);
            CheckBox adventureCheckBox = new CheckBox("Adventure");
            adventureCheckBox.setTextFill(white);
            CheckBox mysteryCheckBox = new CheckBox("Mystery");
            mysteryCheckBox.setTextFill(white);

            // Add condition and genre checkboxes to filters VBox
            filtersVBox.getChildren().addAll(
                conditionLabel, newCheckBox, moderatelyUsedCheckBox, heavilyUsedCheckBox,
                genreLabel, scifiCheckBox, fantasyCheckBox, comedyCheckBox, dramaCheckBox,
                thrillerCheckBox, adventureCheckBox, mysteryCheckBox
            );

            // Available Books Section
            VBox availableBooksVBox = new VBox(10);
            availableBooksVBox.setPadding(new Insets(10));
            Label availableBooksLabel = new Label("Available Books");
            availableBooksLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
            availableBooksLabel.setTextFill(gold);

            ListView<String> bookListView = new ListView<>();
            bookListView.setPrefSize(280, 400); // Adjusted width to better match the mockup's layout
            bookListView.getItems().addAll(
                "Book1 - $10 - Author1", "Book2 - $15 - Author2",
                "Book3 - $20 - Author3", "Book4 - $25 - Author4",
                "Book5 - $30 - Author5", "Book6 - $35 - Author6",
                "Book7 - $40 - Author7", "Book8 - $45 - Author8"
            );

            availableBooksVBox.getChildren().addAll(availableBooksLabel, bookListView);

            // Action Buttons at the bottom
            HBox buttonBox = new HBox(10);
            buttonBox.setPadding(new Insets(10));
            buttonBox.setAlignment(Pos.CENTER);
            Button addToCartButton = new Button("Add to Cart");
            Button viewCartButton = new Button("View Cart");
            Button cancelOrderButton = new Button("Cancel Order");
            Button orderButton = new Button("Order");

            addToCartButton.setStyle("-fx-background-color: #FFC627; -fx-font-size: 12;");
            viewCartButton.setStyle("-fx-background-color: #FFC627; -fx-font-size: 12;");
            cancelOrderButton.setStyle("-fx-background-color: #FFC627; -fx-font-size: 12;");
            orderButton.setStyle("-fx-background-color: #FFC627; -fx-font-size: 12;");

            buttonBox.getChildren().addAll(addToCartButton, viewCartButton, cancelOrderButton, orderButton);

            // Main layout with BorderPane to organize top banner
            BorderPane mainLayout = new BorderPane();
            mainLayout.setStyle("-fx-background-color: #8C1D40;");
            mainLayout.setTop(topBanner);
            mainLayout.setLeft(filtersVBox);
            mainLayout.setBottom(buttonBox);

            BorderPane.setAlignment(topBanner, Pos.CENTER);
            BorderPane.setMargin(topBanner, new Insets(0, 0, 10, 0));
            BorderPane.setMargin(buttonBox, new Insets(10, 0, 0, 0));

            // Center layout that holds the title and book list, aligned properly
            VBox centerContent = new VBox(10);
            centerContent.setAlignment(Pos.TOP_CENTER);
            centerContent.getChildren().addAll(titleBox, availableBooksVBox);

            mainLayout.setCenter(centerContent);

            // Scene setup
            Scene scene = new Scene(mainLayout, 800, 600);
            primaryStage.setTitle("Buyer's Page");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

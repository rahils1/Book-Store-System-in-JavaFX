import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BookSearch {
    User curr;
    ListView<String> bookListView;
    private final Color MAROON = Color.web("#8C1D40");
    private final Color GOLD = Color.web("#FFC627");
    private final Color WHITE = Color.web("#FFFFFF");

    public BookSearch(User u) {
        curr = u;

        //Top banner buttons
        Button myAccountButton = new Button("My Account");
        myAccountButton.setFont(Font.font("Arial", 12));
        myAccountButton.setStyle("-fx-background-color: #FFC627");
        myAccountButton.setTextFill(MAROON);
        myAccountButton.setOnAction(e->{});

        Button switchAccountsButton = new Button("Switch to Seller Account");
        switchAccountsButton.setFont(Font.font("Arial", 12));
        switchAccountsButton.setStyle("-fx-background-color: #FFC627");
        switchAccountsButton.setTextFill(MAROON);
        switchAccountsButton.setOnAction(e->{});
        
        Button logoutButton = new Button("Logout");
        logoutButton.setFont(Font.font("Arial", 12));
        logoutButton.setStyle("-fx-background-color: #FFC627");
        logoutButton.setTextFill(MAROON);
        logoutButton.setOnAction(e->{curr = null; new LoginPage();});

        //The Banner on the top
        HBox topBanner = new HBox(200);
        topBanner.setStyle("-fx-background-color: #CECECE;");
        topBanner.setPadding(new Insets(10));
        topBanner.setAlignment(Pos.CENTER);
        if(u.getUserType().equals("Buyer and Seller")) {topBanner.getChildren().addAll(myAccountButton, switchAccountsButton,logoutButton);}
        else {topBanner.getChildren().addAll(myAccountButton, logoutButton);}

        Label buyersPageLabel = new Label("Purchase Books");
        buyersPageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        buyersPageLabel.setTextFill(GOLD);

        HBox titleBox = new HBox(buyersPageLabel);
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setPadding(new Insets(10, 0, 20, 0));

        VBox filtersVBox = new VBox(15);
        filtersVBox.setPadding(new Insets(20, 0, 0, 20));
        filtersVBox.setStyle("-fx-background-color: #8C1D40;");
        filtersVBox.setPrefWidth(200);

        Label conditionLabel = new Label("Condition");
        conditionLabel.setTextFill(GOLD);
        conditionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        conditionLabel.setAlignment(Pos.CENTER);

        CheckBox newCheckBox = new CheckBox("New");
        newCheckBox.setTextFill(WHITE);
        CheckBox moderatelyUsedCheckBox = new CheckBox("Moderately Used");
        moderatelyUsedCheckBox.setTextFill(WHITE);
        CheckBox heavilyUsedCheckBox = new CheckBox("Heavily Used");
        heavilyUsedCheckBox.setTextFill(WHITE);

        Label genreLabel = new Label("Genre");
        genreLabel.setTextFill(GOLD);
        genreLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        genreLabel.setAlignment(Pos.CENTER);

        CheckBox scifiCheckBox = new CheckBox("Sci-Fi");
        scifiCheckBox.setTextFill(WHITE);
        CheckBox fantasyCheckBox = new CheckBox("Fantasy");
        fantasyCheckBox.setTextFill(WHITE);
        CheckBox comedyCheckBox = new CheckBox("Comedy");
        comedyCheckBox.setTextFill(WHITE);
        CheckBox dramaCheckBox = new CheckBox("Drama");
        dramaCheckBox.setTextFill(WHITE);
        CheckBox thrillerCheckBox = new CheckBox("Thriller");
        thrillerCheckBox.setTextFill(WHITE);
        CheckBox adventureCheckBox = new CheckBox("Adventure");
        adventureCheckBox.setTextFill(WHITE);
        CheckBox mysteryCheckBox = new CheckBox("Mystery");
        mysteryCheckBox.setTextFill(WHITE);

        filtersVBox.getChildren().addAll(conditionLabel, newCheckBox, moderatelyUsedCheckBox, heavilyUsedCheckBox, genreLabel, scifiCheckBox, fantasyCheckBox, comedyCheckBox, dramaCheckBox, thrillerCheckBox, adventureCheckBox, mysteryCheckBox);

        VBox availableBooksVBox = new VBox(10);
        availableBooksVBox.setPadding(new Insets(10));
        Label availableBooksLabel = new Label("Available Books");
        availableBooksLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        availableBooksLabel.setTextFill(GOLD);

        bookListView = new ListView<>();
        bookListView.setPrefSize(280, 400);
        bookListView.getItems().addAll(
                "Book1 - $10 - Author1", "Book2 - $15 - Author2",
                "Book3 - $20 - Author3", "Book4 - $25 - Author4",
                "Book5 - $30 - Author5", "Book6 - $35 - Author6",
                "Book7 - $40 - Author7", "Book8 - $45 - Author8"
        );

        availableBooksVBox.getChildren().addAll(availableBooksLabel, bookListView);

        // Action Buttons at the bottom
        HBox buttonBox = new HBox(100);
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

        BorderPane mainLayout = new BorderPane();
        mainLayout.setStyle("-fx-background-color: #8C1D40;");
        mainLayout.setTop(topBanner);
        mainLayout.setLeft(filtersVBox);
        mainLayout.setBottom(buttonBox);

        BorderPane.setAlignment(topBanner, Pos.CENTER);
        BorderPane.setMargin(topBanner, new Insets(0, 0, 10, 0));
        BorderPane.setMargin(buttonBox, new Insets(10, 0, 0, 0));

        VBox centerContent = new VBox(10);
        centerContent.setAlignment(Pos.TOP_CENTER);
        centerContent.getChildren().addAll(titleBox, availableBooksVBox);

        mainLayout.setCenter(centerContent);

        Scene sc = new Scene(mainLayout, 800, 600);
        PageHandler.updateStage("Book Search", sc);
    }
}
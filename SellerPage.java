import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.random.RandomGenerator;

public class SellerPage {
    User curr;
    private final Color MAROON = Color.web("#8C1D40");
    private final Color GOLD = Color.web("#FFC627");
    private final Color WHITE = Color.web("#FFFFFF");
    private Label auto_price_label;

    public SellerPage(User u) {
        curr = u;

        //Code starts for top banner

        //Top Banner Buttons
        Button myAccountButton = new Button("My Account");
        myAccountButton.setFont(Font.font("Arial", 12));
        myAccountButton.setStyle("-fx-background-color: #FFC627");
        myAccountButton.setTextFill(MAROON);
        myAccountButton.setOnAction(e -> {
            new AccountOverview(curr);
        });

        Button logoutButton = new Button("Logout");
        logoutButton.setFont(Font.font("Arial", 12));
        logoutButton.setStyle("-fx-background-color: #FFC627");
        logoutButton.setTextFill(MAROON);
        logoutButton.setOnAction(e -> {
            curr = null;
            new LoginPage();
        });

        //Top Banner layout
        HBox topBanner = new HBox(200);
        topBanner.setStyle("-fx-background-color: #CECECE;");
        topBanner.setPadding(new Insets(10));
        topBanner.setAlignment(Pos.CENTER);
        if (u.getUserType().equals("Seller") || u.getUserType().equals("Buyer and Seller")) {
            topBanner.getChildren().addAll(myAccountButton, logoutButton);
        }

        //Title of the page
        Label sellerPageLabel = new Label("Sell Books");
        sellerPageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        sellerPageLabel.setTextFill(GOLD);

        HBox titleBox = new HBox(sellerPageLabel);
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setPadding(new Insets(10, 0, 20, 0));

        //Vbox to add title of the page and the top banner
        VBox top_page = new VBox(10);
        top_page.setPrefWidth(800);
        top_page.getChildren().addAll(topBanner, titleBox);

        //Code ends for top banner

        //Body of the seller page starts below

        //Genre label, check boxes for genre and list my book button

        //Genre label
        Label genreLabel = new Label("Genre");
        genreLabel.setTextFill(GOLD);
        genreLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        genreLabel.setAlignment(Pos.CENTER);

        //Checkbox genre
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

        //Button List My Book
        Button listMyBook = new Button("List My Book");
        listMyBook.setStyle("-fx-background-color: #FFC627; -fx-font-size: 12;");
        listMyBook.setOnAction(e -> {
        });

        //Vbox for genre checkboxes and setting margin for each checkbox
        VBox genre_set = new VBox(15);
        genre_set.setStyle("-fx-background-color: #8C1D40;");
        VBox.setMargin(scifiCheckBox, new Insets(0, 0, 0, 80));
        VBox.setMargin(fantasyCheckBox, new Insets(0, 0, 0, 80));
        VBox.setMargin(comedyCheckBox, new Insets(0, 0, 0, 80));
        VBox.setMargin(dramaCheckBox, new Insets(0, 0, 0, 80));
        VBox.setMargin(thrillerCheckBox, new Insets(0, 0, 0, 80));
        VBox.setMargin(adventureCheckBox, new Insets(0, 0, 0, 80));
        VBox.setMargin(mysteryCheckBox, new Insets(0, 0, 0, 80));

        genre_set.getChildren().addAll(scifiCheckBox, fantasyCheckBox, comedyCheckBox, dramaCheckBox, thrillerCheckBox, adventureCheckBox, mysteryCheckBox);

        //Vbox for label, checkbox and button
        VBox left_page = new VBox(50);
        left_page.setStyle("-fx-background-color: #8C1D40;");
        left_page.setPrefWidth(250);
        left_page.setAlignment(Pos.TOP_CENTER);
        left_page.getChildren().addAll(genreLabel, genre_set, listMyBook);

        //Genre label, check boxes for genre and list my book button done

        //Quality, price and generate price button

        //Quality label
        Label quality_label = new Label("Quality");
        quality_label.setTextFill(GOLD);
        quality_label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        quality_label.setAlignment(Pos.CENTER);

        //quality radio buttons
        ToggleGroup qualityGroup = new ToggleGroup();
        RadioButton used = new RadioButton("Used Like New");
        used.setToggleGroup(qualityGroup);
        used.setTextFill(Color.WHITE);
        RadioButton moderately_used = new RadioButton("Moderately Used");
        moderately_used.setToggleGroup(qualityGroup);
        moderately_used.setTextFill(Color.WHITE);
        RadioButton heavily_used = new RadioButton("Heavily Used");
        heavily_used.setToggleGroup(qualityGroup);
        heavily_used.setTextFill(Color.WHITE);


        //Price label
        Label price_label = new Label("Price");
        price_label.setTextFill(GOLD);
        price_label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        price_label.setAlignment(Pos.CENTER);

        //generate price
        TextField priceInput = new TextField();
        priceInput.setPromptText("Enter price in $");
        priceInput.setStyle("-fx-font-size: 14;");
        priceInput.setMaxWidth(120);

        Button generateButton = new Button("Generate Price");
        generateButton.setStyle("-fx-background-color: #FFC627; -fx-font-size: 12;");
        final double[] display_price = new double[1];
        display_price[0] = 5;
        generateButton.setOnAction(e -> {
            display_price[0] = generate_price(0, "a");
            auto_price_label.setText(String.format("Price: $%.2f", display_price[0]));
        });

        //Add radio buttons to a vbox
        VBox radio_buttons = new VBox(15);
        radio_buttons.setStyle("-fx-background-color: #8C1D40;");
        radio_buttons.getChildren().addAll(used, moderately_used, heavily_used);

        //Add Quality, price and generate price button to a vbox
        VBox center_page = new VBox(50);
        center_page.setStyle("-fx-background-color: #8C1D40;");
        center_page.setPrefWidth(200);
        center_page.setAlignment(Pos.TOP_LEFT);
        center_page.getChildren().addAll(quality_label, radio_buttons, price_label, priceInput, generateButton);

        //Quality, price and generate price button done

        //Title and Selling price

        //title and text field to enter the title
        Label title_label = new Label("Title");
        title_label.setTextFill(GOLD);
        title_label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        title_label.setAlignment(Pos.CENTER);

        TextArea book_title = new TextArea();
        book_title.setPromptText("Enter the name of the book");
        book_title.setStyle("-fx-font-size: 18;");
        book_title.setWrapText(true);
        book_title.setMaxWidth(250);
        book_title.setPrefHeight(120);

        //Selling price label and text
        Label selling_price_label = new Label("Selling Price");
        selling_price_label.setTextFill(GOLD);
        selling_price_label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        selling_price_label.setAlignment(Pos.CENTER);

        auto_price_label = new Label("5");
        auto_price_label.setTextFill(WHITE);
        auto_price_label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        auto_price_label.setAlignment(Pos.CENTER);

        //Vbox to add everything
        VBox right_page = new VBox(40);
        right_page.setStyle("-fx-background-color: #8C1D40;");
        right_page.setPrefWidth(300);
        right_page.setAlignment(Pos.TOP_LEFT);
        right_page.getChildren().addAll(title_label, book_title, selling_price_label, auto_price_label);


        BorderPane mainLayout = new BorderPane();
        mainLayout.setStyle("-fx-background-color: #8C1D40;");
        mainLayout.setTop(top_page);
        mainLayout.setLeft(left_page);
        mainLayout.setCenter(center_page);
        mainLayout.setRight(right_page);

        BorderPane.setAlignment(top_page, Pos.CENTER);
        BorderPane.setMargin(top_page, new Insets(0, 0, 10, 0));


        Scene sc = new Scene(mainLayout, 800, 600);
        PageHandler.updateStage("Book Sell", sc);

    }

    private double generate_price(int price, String condition) {
        return RandomGenerator.getDefault().nextDouble();
    }
}
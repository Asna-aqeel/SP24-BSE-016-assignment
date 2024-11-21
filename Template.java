package com.company.demo2;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import java.io.File;
import java.util.ArrayList;

public class Template extends Application{
    private ArrayList<Person> personList = new ArrayList<>();
    @Override
    public void start(Stage primaryStage){
        Label banner = new Label("Data Entry Form");
        banner.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-background-color: #87CEEB; -fx-text-fill: white;");
        banner.setMaxWidth(Double.MAX_VALUE);
        banner.setAlignment(Pos.CENTER);

        TextField nameField = new TextField();
        nameField.setPromptText("Enter name");
        TextField fatherName = new TextField();
        fatherName.setPromptText("Enter your father's name: ");
        TextField cnic = new TextField();
        cnic.setPromptText("Enter your CNIC");

        DatePicker datePicker = new DatePicker();

        ToggleGroup gender = new ToggleGroup();
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        male.setToggleGroup(gender);
        female.setToggleGroup(gender);
        HBox genderBox = new HBox(10, male, female);

        ComboBox<String> city = new ComboBox<>();
        city.getItems().addAll("Karachi", "Lahore", "Islamabad", "Multan", "Gujranwala", "Peshawar");
        city.setPromptText("select your city");

        ImageView imageView = new ImageView();
        imageView.setFitHeight(150);
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);

        Button uploadImage = new Button("Upload Image");

        FileChooser fileChooser = new FileChooser();
        uploadImage.setOnAction(event -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if(selectedFile != null){
                Image image =new Image(selectedFile.toURI().toString());
                imageView.setImage(image);
            }
        });

        VBox imageBox = new VBox(10, imageView, uploadImage);
        imageBox.setAlignment(Pos.CENTER);

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(20));
        form.setStyle("-fx-background-color: #F5F5F5; -fx-border-color: #87CEEB; -fx-border-width: 2px;");
        form.add(new Label("Name:"), 0, 0);
        form.add(nameField, 1, 0);
        form.add(new Label("Fathers Name:"), 0,1 );
        form.add(fatherName, 1, 1);
        form.add(new Label("CNIC:"), 0, 2);
        form.add(cnic, 1, 2);
        form.add(new Label("Date:"), 0, 3);
        form.add(datePicker, 1, 3);
        form.add(new Label("Gender:"), 0, 4);
        form.add(genderBox, 1, 4);
        form.add(new Label("City:"), 0, 5);
        form.add(city, 1, 5);
        Button saveButton = new Button("Save");

        HBox mainContent = new HBox(20, form, imageBox);
        mainContent.setPadding(new Insets(20));

        VBox mainLayout = new VBox(10, banner, mainContent, saveButton);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setStyle("-fx-background-color: #F0FFFF;");


        saveButton.setOnAction(event -> {
            String name = nameField.getText();
            String fathername = fatherName.getText();
            String CNIC = cnic.getText();
            String date = String.valueOf(datePicker.getValue() != null);
            String Persongender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : "";
            String Personcity = city.getValue();

            Person person = new Person(name, fathername, CNIC, date, Persongender, Personcity);
            personList.add(person);
            System.out.println("Person saved: " + person);
        });

        Scene scene = new Scene(mainLayout, 600, 500);
        primaryStage.setTitle("Data Entry Template");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}

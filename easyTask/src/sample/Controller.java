package sample;

import java.io.IOException;
import java.net.URL;
import java.time.Year;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button sendButton;

    @FXML
    private TextField passportIDField;

    @FXML
    private TextField avtoMarkField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextArea messageField;

    @FXML
    private DatePicker beforeDatePicker;

    @FXML
    private Button adminButton;

    @FXML
    private ImageView imageButtonUser;
    private int errorMessage;

    @FXML
    void initialize() {
        sendButton.setOnAction((ActionEvent event) -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            String passportID = passportIDField.getText().trim();
            String avtoMark = avtoMarkField.getText().trim();
            String phoneNumber = phoneNumberField.getText().trim();
            String message = messageField.getText().trim();
            String date = Integer.toString(day) + ";" + Integer.toString(month) + ";" + Integer.toString(year).trim();

            if(!passportID.equals("") && !avtoMark.equals("") && !phoneNumber.equals("") && !message.equals("")
                     && !date.equals("")){
                sendInquiry(passportID, avtoMark, phoneNumber, message, date);
                passportIDField.setText("");
                avtoMarkField.setText("");
                phoneNumberField.setText("");
                messageField.setText("");
                messageBox("the request was send!");

            }
        });

        adminButton.setOnAction(event -> {
            if(passportIDField.getText().trim().equals("admin")&&avtoMarkField.getText().trim().equals("admin")){
                openNewScene("/sample/adminRoom.fxml");
            }
        });

    }

    private void sendInquiry(String passportID,String avtoMark,String phoneNumber,String message,String date) {
        Inquiry inquiry = new Inquiry(passportID, avtoMark, phoneNumber, date, message);
        DataBase dataBase = new DataBase();
        dataBase.add_inquiry(inquiry);
    }
    private void messageBox(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message Here...");
        alert.setHeaderText(message);
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public void openNewScene(String window){
        adminButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }
}

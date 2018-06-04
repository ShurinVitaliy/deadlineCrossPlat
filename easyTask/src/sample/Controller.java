package sample;

import java.net.URL;
import java.time.Year;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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

    @FXML
    void initialize() {
        sendButton.setOnAction(event -> {
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
            }
        });

    }

    private void sendInquiry(String passportID,String avtoMark,String phoneNumber,String message,String date) {
        Inquiry inquiry = new Inquiry(passportID, avtoMark, phoneNumber, date, message);
        DataBase dataBase = new DataBase();
        dataBase.add_inquiry(inquiry);
    }
}

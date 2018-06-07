package sample;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class Admin {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button sendButton;

    @FXML
    private TextArea messageField;

    @FXML
    private ListView<String> listRecuestQuery;

    @FXML
    private Button adminButton;

    @FXML
    void initialize() {
        DataBase dataBase = new DataBase();
        List<Inquiry> inquiries = dataBase.getInquiry();
        for (Inquiry inquirie:inquiries) {
            listRecuestQuery.getItems().addAll(inquirie.getPassportId());
        }
        sendButton.setOnAction(event -> {
            System.out.println(index);
        });
    }
}

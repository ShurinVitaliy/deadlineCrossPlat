package sample;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button sendButton;

    @FXML
    private TextArea messageField;

    @FXML
    private ListView<?> listRecuestQuery;

    @FXML
    private Button adminButton;

    @FXML
    private ImageView imageButtonUser;

    @FXML
    void initialize() {
        sendButton.setOnAction(event -> {
            System.out.println("tcn!");
            Inquiry inquiry = new Inquiry();
            DataBase dataBase = new DataBase();
            inquiry = dataBase.getInquiry();
            List<Inquiry> listInquiry = new ArrayList<Inquiry>();
        });

    }
}

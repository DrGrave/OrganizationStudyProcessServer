package controllers.studentsControllers;

import com.vkkzlabs.entity.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class TableOfDebitsController {

    @FXML
    private AnchorPane tableOfDebits;

    @FXML
    private TableView<Subject> subjectTable;

    @FXML
    private TableColumn<Subject, String> subjectCollom;

    @FXML
    private TableView<?> debtTable;

    @FXML
    private TableColumn<?, ?> numberOfWorkCollom;

    @FXML
    private TableColumn<?, ?> nameOfWorkCollom;

    @FXML
    private TableColumn<?, ?> lastDateCollom;

    @FXML
    private Button watchWork;

    @FXML
    private Button stayInQueue;

    @FXML
    void stayInQueueAction(ActionEvent event) {

    }

    @FXML
    void watchWorkAction(ActionEvent event) {

    }


}

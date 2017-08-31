package controllers.professorControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class ProfessorQueueController {
    @FXML
    private AnchorPane professorQueueAnchorPane;

    @FXML
    private HBox queueTableHbox;

    @FXML
    private TableView<?> tableOfQueueProfessor;

    @FXML
    private TableColumn<?, ?> firstNamePersonInQueueOfProfessor;

    @FXML
    private TableColumn<?, ?> seccondNAmeOfStudentInQueue;

    @FXML
    private TableView<?> tableOfWorksInQueueProfessor;

    @FXML
    private TableColumn<?, ?> subjectStudentCell;

    @FXML
    private TableColumn<?, ?> numberOfWorkCell;

    @FXML
    private TableView<?> tableOfCommentWork;

    @FXML
    private TableColumn<?, ?> dateOfCommentOfWork;

    @FXML
    private TextArea textOfWorkQueue;

    @FXML
    private TextField nameOfWorkQueue;

    @FXML
    private TextField typeOfWorkQueue;

    @FXML
    private Label nameOfStudentRecensionLable;

    @FXML
    private TextArea recensionLableProfessor;

    @FXML
    private TextArea wrongLableProfessor;

    @FXML
    private Label recomendedMarkLableProfessor;

    @FXML
    private ChoiceBox<?> realMarkProfessor;

    @FXML
    void InLastProfessorWork(ActionEvent event) {

    }

    @FXML
    void accaptProfessorWork(ActionEvent event) {

    }

    @FXML
    void deceptProfessorWork(ActionEvent event) {

    }

    @FXML
    void refreshQueue(ActionEvent event) {

    }
}

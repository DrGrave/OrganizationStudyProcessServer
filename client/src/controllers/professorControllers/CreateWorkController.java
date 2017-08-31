package controllers.professorControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class CreateWorkController {
    @FXML
    private AnchorPane createWorkAnchorPane;

    @FXML
    private TableView<?> tableSubjectProfessor;

    @FXML
    private TableColumn<?, ?> subjectNameCollomProfessor;

    @FXML
    private TableView<?> tableWorkProfessor;

    @FXML
    private TableColumn<?, ?> workNumberAddWork;

    @FXML
    private TableColumn<?, ?> workInfoAddWork;

    @FXML
    private Button changeWork;

    @FXML
    private Button createWork;

    @FXML
    private Button deleteWork;

    @FXML
    private TextField numberOfWorkTextField;

    @FXML
    private ChoiceBox<?> typeOfWorkChoiceBox;

    @FXML
    private TextField nameOfWorkTextField;

    @FXML
    private TextArea textOfWorkAddProfessor;

    @FXML
    private Button cansallWork;

    @FXML
    private Button accaptChangeWork;

    @FXML
    private Button accaptCreateWork;

    @FXML
    private Button accaptDeleteWork;

    @FXML
    void accaptCreateWorkAction(ActionEvent event) {

    }

    @FXML
    void acceptChangeCreateWork(ActionEvent event) {

    }

    @FXML
    void acceptDeleteWork(ActionEvent event) {

    }

    @FXML
    void canselCDCwork(ActionEvent event) {

    }

    @FXML
    void changeCreateWork(ActionEvent event) {

    }

    @FXML
    void createWorkAction(ActionEvent event) {

    }

    @FXML
    void deleteWorkAction(ActionEvent event) {

    }

}

package controllers.studentsControllers;

import com.vkkzlabs.api.entity.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.thymeleaf.dom.Comment;
import requests.CommentToWorkRequest;
import requests.StudentWorksController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vadim on 23.08.17.
 */
public class TableOfMarksController {
    @FXML
    private TableView<M2MStudentWork> subjectTable;

    @FXML
    private TableColumn<M2MStudentWork, String> subjectCollom;

    @FXML
    private TableView<M2MStudentWork> workTable;

    @FXML
    private TableColumn<M2MStudentWork, String> numerOfWorkCollom;

    @FXML
    private TableColumn<M2MStudentWork, String> nameOfWorkCollom;

    @FXML
    private TableColumn<M2MStudentWork, String> markCollom;

    @FXML
    private TableColumn<M2MStudentWork, String> dateOfAcceptWorkCollom;

    @FXML
    private TableColumn<M2MStudentWork, String> deadlineOfAccaptWorkCollom;

    @FXML
    private TableView<CommentToWork> commentTable;

    @FXML
    private TableColumn<CommentToWork, String> dateOfCommentCollom;

    @FXML
    private Button watchWorkButton;

    @FXML
    void watchWorkAction(ActionEvent event) {

    }

    private MyUser iUser;
    private String token;
    private MyUserCredentials myUserCredentials;

    public TableOfMarksController(MyUser iUser, String token, MyUserCredentials myUserCredentials) {
        this.iUser = iUser;
        this.token = token;
        this.myUserCredentials = myUserCredentials;
    }


    public void initialize(){
        initializeMarksTable();
    }

    private void initializeMarksTable() {
        StudentWorksController studentWorksController = new StudentWorksController();
        M2MStudentWork[] subjectMarks = studentWorksController.getSubjectsToList(iUser.getIdUser(), token);
        if (subjectMarks != null) {
            List<M2MStudentWork> studentWorkList = deleteDuplicatesSubjects(subjectMarks);
            ObservableList<M2MStudentWork> studentWorkObservableList = FXCollections.observableList(studentWorkList);
            subjectTable.setItems(studentWorkObservableList);
            subjectCollom.setCellValueFactory(
                    cellDate -> new SimpleStringProperty(cellDate.getValue().getIdOfWork().getSubject().getNameSubject())
            );
            subjectTable.getSelectionModel().selectedItemProperty().addListener(
                    ((observable, oldValue, newValue) -> initializeWorks(newValue))
            );
        }

    }

    private void initializeWorks(M2MStudentWork subject) {
        StudentWorksController studentWorksController = new StudentWorksController();
        M2MStudentWork[] studentWorks = studentWorksController.getAllAcceptedWork(iUser.getIdUser(), token, subject.getIdOfWork().getSubject().getIdSubject());
        if (studentWorks != null) {
            List<M2MStudentWork> studentWorkList = Arrays.asList(studentWorks);
            ObservableList<M2MStudentWork> observableList = FXCollections.observableList(studentWorkList);
            workTable.setItems(observableList);
            numerOfWorkCollom.setCellValueFactory(
                    cellDate -> new SimpleStringProperty(cellDate.getValue().getIdOfWork().getNumberOfWOrk())
            );
            nameOfWorkCollom.setCellValueFactory(
                    cellDate -> new SimpleStringProperty(cellDate.getValue().getIdOfWork().getNameOfWork())
            );
            markCollom.setCellValueFactory(
                    cellDate -> new SimpleStringProperty(String.valueOf(cellDate.getValue().getMark()))
            );
            dateOfAcceptWorkCollom.setCellValueFactory(
                    cellDate -> new SimpleStringProperty(String.valueOf(cellDate.getValue().getTimetable().getDate()))
            );
            deadlineOfAccaptWorkCollom.setCellValueFactory(
                    cellDate -> new SimpleStringProperty(String.valueOf(cellDate.getValue().getDeadlineForWork()))
            );
            workTable.getSelectionModel().selectedItemProperty().addListener(
                    ((observable, oldValue, newValue) -> initializeCommentsToWork(newValue))
            );
        }
    }

    private void initializeCommentsToWork(M2MStudentWork work) {
        CommentToWorkRequest commentToWorkRequest = new CommentToWorkRequest();
        CommentToWork[] commentToWorks = commentToWorkRequest.getCommentsToWorkByIdUserAndIdWork(iUser, work.getIdOfWork().getIdOfWork(), token);
        if (commentToWorks != null){
            ObservableList<CommentToWork> commentToWorkObservableList = FXCollections.observableList(Arrays.asList(commentToWorks));
            commentTable.setItems(commentToWorkObservableList);
            dateOfCommentCollom.setCellValueFactory(
                    cellDate -> new SimpleStringProperty(String.valueOf(cellDate.getValue().getDate()))
            );
        }
    }

    private List<M2MStudentWork> deleteDuplicatesSubjects(M2MStudentWork[] subjectMarks) {
        List<M2MStudentWork> studentWorks = new ArrayList<>();
        if (subjectMarks != null) {
            for (M2MStudentWork work : subjectMarks){
                if (!ifExistsInList(studentWorks, work) && work.getIdOfAccaptWork().getIdOfAccaptWork() == 5){
                    studentWorks.add(work);
                }
            }
            return studentWorks;
        }return null;
    }

    private boolean ifExistsInList(List<M2MStudentWork> subjects, M2MStudentWork thisSubject){
        for (M2MStudentWork subject : subjects) {
            if (subject.getIdOfWork().getSubject().getIdSubject() == thisSubject.getIdOfWork().getSubject().getIdSubject()) {
                return true;
            }
        }
        return false;
    }
}

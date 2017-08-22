package controllers.studentsControllers;

import com.vkkzlabs.api.entity.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import requests.CommentToWorkRequest;
import requests.QueueRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueTabController {

    @FXML
    private TableView<Queue> studentTable;

    @FXML
    private TableColumn<Queue, String> studentNameCollom;

    @FXML
    private TableColumn<Queue, String> studentSurnameCollom;

    @FXML
    private TableView<Queue> subjectTable;

    @FXML
    private TableColumn<Queue, String> subjectCollom;

    @FXML
    private TableColumn<Queue, String> workCollom;

    @FXML
    private TableView<CommentToWork> commentTable;

    @FXML
    private TableColumn<CommentToWork, String> commentToWorkCollom;

    private final MyUser iUser;
    private final MyUserCredentials myUserCredentials;
    private final String token;
    private Queue[] queues;

    public QueueTabController(MyUser iUser, String token, MyUserCredentials myUserCredentials, Queue[] queues) {
        this.iUser = iUser;
        this.myUserCredentials = myUserCredentials;
        this.token = token;
        this.queues = queues;
    }

    public void initialize(){
        List<Queue> queueList = new ArrayList<>();
        for (Queue queu : queues){
            if (!ifExistsInList(queueList, queu)) {
                queueList.add(queu);
            }
        }
        ObservableList<Queue> queueObservableList = FXCollections.observableList(queueList);
        studentTable.setItems(queueObservableList);
        studentNameCollom.setCellValueFactory(
                cellDate -> new SimpleStringProperty(cellDate.getValue().getStudent().getUserName())
        );
        studentSurnameCollom.setCellValueFactory(
                cellDate -> new SimpleStringProperty(cellDate.getValue().getStudent().getUserSurname())
        );

        studentTable.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> initializeSubjectsList(newValue.getTimetable(), newValue.getStudent().getIdUser(), subjectTable.getFocusModel().getFocusedIndex()))
        );


        studentTable.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.RIGHT) {
                Queue pos = studentTable.getFocusModel().getFocusedItem();
                if (pos != null) {
                    int position;
                    position = studentTable.getFocusModel().getFocusedIndex();
                    initializeSubjectsList(pos.getTimetable(), pos.getStudent().getIdUser(), position);
                    subjectTable.requestFocus();
                    subjectTable.getSelectionModel().select(0);
                    subjectTable.getFocusModel().focus(0);
                }
            }
        });
    }

    private void initializeSubjectsList(Timetable timetable, int idUser, int position) {
        QueueRequest queueRequest = new QueueRequest();
        Queue[] queueArray = queueRequest.getSubjectsToStudent(timetable.getIdTimetable(), idUser, token);
        List<Queue> subjects = new ArrayList<>();
        for (Queue queue : queueArray){
            if (!ifExistsinListBySubjects(subjects, queue)){
                subjects.add(queue);
            }
        }
        ObservableList<Queue> queueObservableList = FXCollections.observableList(subjects);
        subjectTable.setItems(queueObservableList);
        subjectCollom.setCellValueFactory(
                cellDate -> new SimpleStringProperty(cellDate.getValue().getWork().getSubject().getNameSubject())
        );
        workCollom.setCellValueFactory(
                cellDate -> new SimpleStringProperty(cellDate.getValue().getWork().getNumberOfWOrk())
        );

        subjectTable.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> initializeCommentToWorkTable(newValue))
        );

    }

    private void initializeCommentToWorkTable(Queue newValue) {
        CommentToWorkRequest commentToWorkRequest = new CommentToWorkRequest();
        CommentToWork[] commentToWorks = commentToWorkRequest.getCommentsToWorkByIdUserAndIdWork(newValue.getStudent(), newValue.getWork().getIdOfWork(), token);
        List<CommentToWork> commentToWorkList = Arrays.asList(commentToWorks);
        ObservableList<CommentToWork> commentToWorkObservableList = FXCollections.observableList(commentToWorkList);
        commentTable.setItems(commentToWorkObservableList);
        commentToWorkCollom.setCellValueFactory(
                cellDate -> new SimpleStringProperty(String.valueOf(cellDate.getValue().getDate()))
        );
    }

    private boolean ifExistsInList(List<Queue> queues, Queue thisQueue){
        for (Queue queue : queues) {
            if (queue.getWork().getIdOfWork() == thisQueue.getWork().getIdOfWork() || queue.getStudent().getIdUser() == thisQueue.getStudent().getIdUser()) {
                return true;
            }
        }
        return false;
    }

    private boolean ifExistsinListBySubjects(List<Queue> queues, Queue thisQueue){
        for (Queue queue : queues) {
            if (queue.getWork().getSubject().getIdSubject() == thisQueue.getWork().getSubject().getIdSubject()) {
                return true;
            }
        }
        return false;
    }
}

package controllers.professorControllers;

import com.vkkzlabs.api.entity.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import requests.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static controllers.calendarControllers.PaneOfEventsController.nowTimetable;

public class ProfessorQueueController {
    @FXML
    private AnchorPane professorQueueAnchorPane;

    @FXML
    private HBox queueTableHbox;

    @FXML
    private TableView<MyUser> tableOfQueueProfessor;

    @FXML
    private TableColumn<MyUser, String> firstNamePersonInQueueOfProfessor;

    @FXML
    private TableColumn<MyUser, String> seccondNAmeOfStudentInQueue;

    @FXML
    private TableView<Work> tableOfWorksInQueueProfessor;

    @FXML
    private TableColumn<Work, String> subjectStudentCell;

    @FXML
    private TableColumn<Work, String> numberOfWorkCell;

    @FXML
    private TableView<CommentToWork> tableOfCommentWork;

    @FXML
    private TableColumn<CommentToWork, String> dateOfCommentOfWork;

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
    private ChoiceBox<Integer> realMarkProfessor;
    private String token;
    private MyUser iUser;
    private MyUser position;
    private int positionWork;

    public ProfessorQueueController(MyUser iUser, String token, MyUserCredentials myUserCredentials) {
        this.iUser = iUser;
        this.token = token;
    }

    @FXML
    void InLastProfessorWork(ActionEvent event) {

    }

    public void initialize(){
        initializeListeners();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(20), ev -> professorQueueInitialize(iUser)));

        timeline.setCycleCount(Animation.INDEFINITE);
        Platform.runLater(timeline::play);

    }

    private void initializeListeners() {
        tableOfQueueProfessor.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setColumnStudentInQueueProfessor(newValue));

        tableOfWorksInQueueProfessor.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCommentsToWorkInQueueProfessor(newValue, tableOfQueueProfessor.getSelectionModel().getSelectedItem())
        );

        tableOfCommentWork.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setInfoCommentWorks(newValue)
        );
    }

    @FXML
    void accaptProfessorWork(ActionEvent event) {
        QueueRequest getQueueControl = new QueueRequest();
        StudentWorksController studentWorksController = new StudentWorksController();
        TypeOfAcceptWorkRequest typeOfAcceptWorkRequest = new TypeOfAcceptWorkRequest();
        MyUser student = tableOfQueueProfessor.getSelectionModel().getSelectedItem();
        Work work = tableOfWorksInQueueProfessor.getSelectionModel().getSelectedItem();
        M2MStudentWork studentWork = studentWorksController.getWorkByUserIdAndIdWork(student.getIdUser(), work.getIdOfWork());
        studentWork.setMark(realMarkProfessor.selectionModelProperty().getValue().getSelectedItem());
        studentWork.setIdOfAccaptWork(typeOfAcceptWorkRequest.getTypeOfAcceptWorkById(5, token));
        studentWork.setTimetable(nowTimetable);
        studentWorksController.updateWork(studentWork, token);
        getQueueControl.deleteQueueByQueue(nowTimetable.getIdTimetable(), studentWork.getIdOfWork().getIdOfWork(), studentWork.getIdUser().getIdUser(), token);
        professorQueueInitialize(iUser);
        tableOfQueueProfessor.getSelectionModel().select(student);
    }

    private boolean ifExistsInList(List<MyUser> myUsers, MyUser myUser){
        for (int i = 0; i < myUsers.size(); i++){
            if (myUsers.get(i).getIdUser() == myUser.getIdUser()){
                return true;
            }
        }
        return false;
    }

    private void professorQueueInitialize(MyUser iProfessor){
        QueueRequest getQueueControl = new QueueRequest();
        if (nowTimetable != null) {
            Queue[] queues = getQueueControl.getAllQueueToUser(nowTimetable, token);
            if (queues != null) {
                List<MyUser> myUserList = new ArrayList<>();
                for (Queue queue : queues) {
                    if (!ifExistsInList(myUserList, queue.getStudent())) {
                        myUserList.add(queue.getStudent());
                    }
                }
                List<MyUser> deleteDuplicates = new ArrayList<>();
                for (MyUser myUser : myUserList) {
                    if (!deleteDuplicates.contains(myUser)) {
                        deleteDuplicates.add(myUser);
                    }
                }
                ObservableList<MyUser> listUsers = FXCollections.observableList(deleteDuplicates);
                tableOfQueueProfessor.setItems(listUsers);
                seccondNAmeOfStudentInQueue.setCellValueFactory(
                        cellData -> new SimpleStringProperty(cellData.getValue().getUserSurname())
                );

                firstNamePersonInQueueOfProfessor.setCellValueFactory(
                        cellData -> new SimpleStringProperty(cellData.getValue().getUserName())
                );

                tableOfQueueProfessor.requestFocus();
                tableOfQueueProfessor.getSelectionModel().select(position);
            }
        }else {
            //TODO alert to say "No timetable to queue"
        }
    }

    private void setColumnStudentInQueueProfessor(MyUser student) {
        position = tableOfQueueProfessor.getFocusModel().getFocusedItem();
        clearFieldQueue();
        tableOfWorksInQueueProfessor.getItems().clear();
        QueueRequest queueControl = new QueueRequest();
        if (student != null){
            Work[] works = queueControl.listOfWorksQueueToStudent(student.getIdUser(), nowTimetable, token);
            if (works != null) {
                List<Work> myUserList = new ArrayList<>();
                myUserList.addAll(Arrays.asList(works));
                ObservableList<Work> listWorks = FXCollections.observableList(myUserList);
                tableOfWorksInQueueProfessor.setItems(listWorks);
                subjectStudentCell.setCellValueFactory(
                        cellData -> new SimpleStringProperty(cellData.getValue().getSubject().getNameSubject())
                );
                numberOfWorkCell.setCellValueFactory(
                        cellData -> new SimpleStringProperty(cellData.getValue().getNumberOfWOrk())
                );
                tableOfWorksInQueueProfessor.requestFocus();
                tableOfWorksInQueueProfessor.getSelectionModel().select(positionWork);
                tableOfWorksInQueueProfessor.getFocusModel().focus(positionWork);
            }
        }

    }

    private void setCommentsToWorkInQueueProfessor(Work work, MyUser student){
        positionWork = tableOfWorksInQueueProfessor.getFocusModel().getFocusedIndex();
        tableOfCommentWork.getItems().clear();
        CommentToWorkRequest commentToWorkRequest = new CommentToWorkRequest();
        if (work != null) {
            CommentToWork[] commentToWork = commentToWorkRequest.getCommentsToWorkByIdUserAndIdWork(student, work.getIdOfWork(), token);
            if (commentToWork != null) {
                List<CommentToWork> commentToWorkList = new ArrayList<>();
                commentToWorkList.addAll(Arrays.asList(commentToWork));
                textOfWorkQueue.setText(work.getTextOfWork());
                nameOfWorkQueue.setText(work.getNameOfWork());
                typeOfWorkQueue.setText(work.getTypeOfWork().getNameTypeOfWOrk());
                ObservableList<CommentToWork> commentToWorks = FXCollections.observableList(commentToWorkList);
                tableOfCommentWork.setItems(commentToWorks);
                dateOfCommentOfWork.setCellValueFactory(
                        cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDate()))
                );
            }
        }
    }

    private void setInfoCommentWorks(CommentToWork commentWorks) {
        if (commentWorks != null) {
            recensionLableProfessor.setText(commentWorks.getTextOfCommentWork());
        }
    }

    private void clearFieldQueue(){
        textOfWorkQueue.clear();
        nameOfWorkQueue.clear();
        typeOfWorkQueue.clear();
        recensionLableProfessor.clear();
    }

    @FXML
    void deceptProfessorWork(ActionEvent event) {

    }

    @FXML
    void refreshQueue(ActionEvent event) {

    }
}

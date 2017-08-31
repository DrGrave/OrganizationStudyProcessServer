package controllers.professorControllers;

import com.vkkzlabs.api.entity.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import requests.QueueRequest;
import requests.StudentWorksController;
import requests.TimetableRequest;
import requests.TypeOfAcceptWorkRequest;

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

    @FXML
    void InLastProfessorWork(ActionEvent event) {

    }

    @FXML
    void accaptProfessorWork(ActionEvent event) {
        TimetableRequest timetableControl = new TimetableRequest();
        QueueRequest getQueueControl = new QueueRequest();
        StudentWorksController studentWorksController = new StudentWorksController();
        TypeOfAcceptWorkRequest typeOfAcceptWorkRequest = new TypeOfAcceptWorkRequest();
        MyUser student = tableOfQueueProfessor.getSelectionModel().getSelectedItem();
        Work work = tableOfWorksInQueueProfessor.getSelectionModel().getSelectedItem();
        M2MStudentWork studentWork = studentWorksController.getWorkByUserIdAndIdWork(student.getIdUser(), work.getIdOfWork());
        studentWork.setMark(realMarkProfessor.selectionModelProperty().getValue().getSelectedItem());
        studentWork.setIdOfAccaptWork(typeOfAcceptWorkRequest.getTypeOfAcceptWorkById(5, token));
        studentWork.setTimetable(nowTimetable);
//        Marks marks = new Marks();
//        marks.setMark(realMarkProfessor.selectionModelProperty().getValue().getSelectedItem());
//        marks.setWork(work);
//        marks.setTimeteable(timetableControl.getNowTimeteableProf(IUser.getIdUser()));
//        marks.setMyUser(student);
//        getMarksControl.createMarks(marks);
//        getQueueControl.deleteQueue(getQueueControl.getQueueIdWorkStudent(IUser.getIdUser(), marks.getWork().getIdOfWork(), marks.getMyUser().getIdUser()));
//        professorQueueInitialize(IUser);
//        tableOfQueueProfessor.getSelectionModel().select(student);
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
//        QueueRequest getQueueControl = new QueueRequest();
//        Queue[] queues = getQueueControl.listAllQueueToProfessor(iProfessor.getIdUser());
//        if (queues != null) {
//            List<MyUser> myUserList = new ArrayList<>();
//            for (Queue queue : queues) {
//                if (!ifExistsInList(myUserList, queue.getMyUser())) {
//                    myUserList.add(queue.getMyUser());
//                }
//            }
//            List<MyUser> deleteDuplicates = new ArrayList<>();
//            for (MyUser myUser : myUserList) {
//                if (!deleteDuplicates.contains(myUser)) {
//                    deleteDuplicates.add(myUser);
//                }
//            }
//            ObservableList<MyUser> listUsers = FXCollections.observableList(deleteDuplicates);
//            tableOfQueueProfessor.setItems(listUsers);
//            seccondNAmeOfStudentInQueue.setCellValueFactory(
//                    cellData -> new SimpleStringProperty(cellData.getValue().getUserSeccondname())
//            );
//
//            firstNamePersonInQueueOfProfessor.setCellValueFactory(
//                    cellData -> new SimpleStringProperty(cellData.getValue().getUserName())
//            );
//            tableOfQueueProfessor.getSelectionModel().selectedItemProperty().addListener(
//                    (observable, oldValue, newValue) -> setSirdColllomStudentInQueueProfessor(newValue, iProfessor));
//        }
    }

    private void setSirdColllomStudentInQueueProfessor(MyUser user, MyUser professor) {
//        clearFieldQueue();
//        tableOfWorksInQueueProfessor.getItems().clear();
//        QueueRequest queueControl = new QueueRequest();
//        Work[] works = queueControl.listOfWorksQueueToStudent(user.getIdUser(), professor.getIdUser());
//        if (works != null) {
//            List<Work> myUserList = new ArrayList<>();
//            myUserList.addAll(Arrays.asList(works));
//            ObservableList<Work> listWorks = FXCollections.observableList(myUserList);
//            tableOfWorksInQueueProfessor.setItems(listWorks);
//            subjectStudentCell.setCellValueFactory(
//                    cellData -> new SimpleStringProperty(cellData.getValue().getSubject().getNameSubject())
//            );
//            numberOfWorkCell.setCellValueFactory(
//                    cellData -> new SimpleStringProperty(cellData.getValue().getNumberOfWOrk())
//            );
//            tableOfWorksInQueueProfessor.getSelectionModel().selectedItemProperty().addListener(
//                    (observable, oldValue, newValue) -> setCommentsToWorkInQueueProfessor(newValue, user)
//            );
//        }
    }

    private void setCommentsToWorkInQueueProfessor(Work work, MyUser user){
//        tableOfCommentWork.getItems().clear();
//        QueueRequest getQueueControl = new QueueRequest();
//        if (work != null) {
//            CommentToWork[] commentToWork = getQueueControl.listCommentToWork(work.getIdOfWork(), user.getIdUser());
//            if (commentToWork != null) {
//                List<CommentToWork> commentToWorkList = new ArrayList<>();
//                commentToWorkList.addAll(Arrays.asList(commentToWork));
//                textOfWorkQueue.setText(work.getTextOfWork());
//                nameOfWorkQueue.setText(work.getNameOfWork());
//                typeOfWorkQueue.setText(work.getTypeOfWork().getNameTypeOfWOrk());
//                ObservableList<CommentToWork> commentToWorks = FXCollections.observableList(commentToWorkList);
//                tableOfCommentWork.setItems(commentToWorks);
//                dateOfCommentOfWork.setCellValueFactory(
//                        cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDate()))
//                );
//                tableOfCommentWork.getSelectionModel().selectedItemProperty().addListener(
//                        (observable, oldValue, newValue) -> setInfoCommentWorks(newValue)
//                );
//            }
//        }
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

package controllers.studentsControllers;

import com.vkkzlabs.api.entity.*;
import com.vkkzlabs.api.entity.Queue;
import controllers.StudentController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.util.Callback;
import requests.QueueRequest;
import requests.StudentWorksController;
import requests.TimetableRequest;
import requests.TypeOfAcceptWorkRequest;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class TableOfDebitsController {
    private StudentWorksController studentWorksController = new StudentWorksController();

    @FXML
    private AnchorPane tableOfDebits;

    @FXML
    private TableView<M2MStudentWork> subjectTable;

    @FXML
    private TableColumn<M2MStudentWork, String> subjectCollom;

    @FXML
    private TableView<M2MStudentWork> debtTable;

    @FXML
    private TableColumn<M2MStudentWork, String> numberOfWorkCollom;

    @FXML
    private TableColumn<M2MStudentWork, String> nameOfWorkCollom;

    @FXML
    private TableColumn<M2MStudentWork, String> lastDateCollom;

    @FXML
    private Button watchWork;

    @FXML
    private Button stayInQueue;

    private MyUser iUser;
    private String token;
    private MyUserCredentials myUserCredentials;
    private Pane queuePane;
    private Tab queueTab;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public TableOfDebitsController(MyUser iUser, String token, MyUserCredentials myUserCredentials, Pane queuePane, Tab queueTab) {
        this.iUser = iUser;
        this.myUserCredentials = myUserCredentials;
        this.token = token;
        this.queuePane = queuePane;
        this.queueTab = queueTab;
    }

    @FXML
    void stayInQueueAction(ActionEvent event) throws IOException {
        QueueRequest queueRequest = new QueueRequest();
        if (debtTable.getSelectionModel().getSelectedItem() != null) {
            TimetableRequest timetableRequest = new TimetableRequest();
            Timetable timetable = timetableRequest.getTimetableByProfessorIdAndSubjectId(debtTable.getSelectionModel().getSelectedItem().getIdOfWork().getMyUser(), debtTable.getSelectionModel().getSelectedItem().getIdOfWork().getSubject().getIdSubject(), token);
            if (timetable != null) {
                Queue queue = new Queue();
                queue.setTimetable(timetable);
                queue.setStudent(iUser);
                queue.setWork(debtTable.getSelectionModel().getSelectedItem().getIdOfWork());
                Queue[] queues = queueRequest.stayInQueue(queue, token);
                if (queues != null) {
                    initializeQueueTab(queues);
                } else {
                    initializeQueueTab(queueRequest.getAllQueueToUser(queue, token));
                }
            }else {
                //TODO нет пары для сдачи работы!
            }
        } else {
            //TODO print select work!
        }
    }

    private void initializeQueueTab(Queue[] queues) throws IOException {
        FXMLLoader queueTabs = new  FXMLLoader(getClass().getResource("../../samples/studentFXML/QueueToStudent.fxml"));
        QueueTabController queueTabController = new QueueTabController(iUser, token, myUserCredentials, queues);
        queueTabs.setController(queueTabController);
        queuePane.getChildren().add(queueTabs.load());
    }

    @FXML
    void watchWorkAction(ActionEvent event) throws IOException {
        initializeInfoOfWork(debtTable.getSelectionModel().getSelectedItem(), iUser);
    }

    public void initialize(){
        M2MStudentWork[] studentWorks = studentWorksController.getSubjectsToList(iUser.getIdUser(), token);
        subjectTable.refresh();
        if (studentWorks != null) {
            List<M2MStudentWork> subjects = new ArrayList<>();
            List<M2MStudentWork> toSort = Arrays.asList(studentWorks);
            Collections.sort(toSort, Collections.reverseOrder(M2MStudentWork.COMPARE_BY_DATE));
            studentWorks = toSort.toArray(studentWorks);
            for (M2MStudentWork m2MStudentWork : studentWorks) {
                if (!ifExistsInList(subjects, m2MStudentWork)) {
                    subjects.add(m2MStudentWork);
                }else{
                    for (M2MStudentWork studentWork : subjects){
                        if (studentWork.getIdOfWork().getSubject().getIdSubject() == m2MStudentWork.getIdOfWork().getSubject().getIdSubject() && 4 > m2MStudentWork.getIdOfAccaptWork().getIdOfAccaptWork()){
                            subjects.remove(studentWork);
                            subjects.add(m2MStudentWork);
                        }
                    }
                }
            }
            Date thisDate = studentWorksController.getServerDate(token);
            LocalDate date7 = thisDate.toLocalDate().plusDays(7);
            LocalDate date15 = thisDate.toLocalDate().minusDays(15);
            Tooltip tooltip = new Tooltip("New work by this subject");
            ObservableList<M2MStudentWork> subjectObservableList = FXCollections.observableList(subjects);
            subjectTable.setItems(subjectObservableList);
            subjectCollom.setCellValueFactory(
                    cellDate -> new SimpleStringProperty(cellDate.getValue().getIdOfWork().getSubject().getNameSubject())
            );
            subjectTable.getSelectionModel().selectedItemProperty().addListener(
                    ((observable, oldValue, newValue) -> initializeWorksTable(newValue.getIdOfWork().getSubject(), iUser, subjectTable.getFocusModel().getFocusedIndex()))
            );
            subjectTable.setRowFactory(new Callback<TableView<M2MStudentWork>, TableRow<M2MStudentWork>>() {
                @Override
                public TableRow<M2MStudentWork> call(TableView<M2MStudentWork> m2MStudentWorkTableView) {
                    return new TableRow<M2MStudentWork>(){
                        @Override
                        protected void updateItem(M2MStudentWork item, boolean empty) {
                            if (item != null){
                                setStyle("");
                                if (item.getIdOfAccaptWork().getIdOfAccaptWork() == 1){
                                    setTooltip(tooltip);
                                }
                                if (item.getIdOfAccaptWork().getIdOfAccaptWork() == 4){
                                    setStyle("-fx-background-color: green");
                                }else
                                if (item.getDeadlineForWork().before(thisDate)) {
                                    setStyle("-fx-background-color: lightcoral;");
                                }else
                                if (item.getDeadlineForWork().before(java.sql.Date.valueOf(date7))){
                                    setStyle("-fx-background-color: coral;");
                                }else
                                if (item.getDeadlineForWork().after(java.sql.Date.valueOf(date15))){
                                    setStyle("-fx-background-color: khaki;");
                                }
                            }
                            super.updateItem(item, empty);
                        }
                    };
                }
            });

            subjectTable.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.RIGHT) {
                    M2MStudentWork pos = debtTable.getFocusModel().getFocusedItem();
                    if (pos != null) {
                        int position;
                        position = subjectTable.getFocusModel().getFocusedIndex();
                        initializeWorksTable(pos.getIdOfWork().getSubject(), iUser, position);
                        debtTable.requestFocus();
                        debtTable.getSelectionModel().select(0);
                        debtTable.getFocusModel().focus(0);
                    }
                }
            });

        }

    }

    private void initializeWorksTable(Subject subject, MyUser iUser, int position) {
        M2MStudentWork[] m2MStudentWork = studentWorksController.getWorksByUserIdAndSubjectId(iUser, subject, token);
        debtTable.refresh();
        if (m2MStudentWork != null){
            List<M2MStudentWork> works = new ArrayList<>();
            works.addAll(Arrays.asList(m2MStudentWork));
            ObservableList<M2MStudentWork> workObservableList = FXCollections.observableList(works);
            Date thisDate = studentWorksController.getServerDate(token);
            LocalDate date7 = thisDate.toLocalDate().plusDays(7);
            LocalDate date15 = thisDate.toLocalDate().minusDays(15);

            debtTable.setItems(workObservableList);

            numberOfWorkCollom.setCellValueFactory(
                    cellDate -> new SimpleStringProperty(cellDate.getValue().getIdOfWork().getNumberOfWOrk())
            );
            nameOfWorkCollom.setCellValueFactory(
                    cellDate -> new SimpleStringProperty(cellDate.getValue().getIdOfWork().getNameOfWork())
            );
            lastDateCollom.setCellValueFactory(
                    cellDate -> new SimpleStringProperty(String.valueOf(cellDate.getValue().getDeadlineForWork()))
            );

            debtTable.setRowFactory(new Callback<TableView<M2MStudentWork>, TableRow<M2MStudentWork>>() {
                @Override
                public TableRow<M2MStudentWork> call(TableView<M2MStudentWork> m2MStudentWorkTableView) {
                    return new TableRow<M2MStudentWork>(){
                        @Override
                        protected void updateItem(M2MStudentWork item, boolean empty) {
                            if (item != null){
                                setStyle("");
                                if (item.getIdOfAccaptWork().getIdOfAccaptWork() == 1){
                                    setTooltip(new Tooltip("New work"));
                                }
                                if (item.getIdOfAccaptWork().getIdOfAccaptWork() == 4){
                                    setStyle("-fx-background-color: green");
                                }else
                                if (item.getDeadlineForWork().before(thisDate)) {
                                    setStyle("-fx-background-color: lightcoral;");
                                }else
                                if (item.getDeadlineForWork().before(java.sql.Date.valueOf(date7))){
                                    setStyle("-fx-background-color: coral;");
                                }else
                                if (item.getDeadlineForWork().after(java.sql.Date.valueOf(date15))) {
                                    setStyle("-fx-background-color: khaki;");
                                }
                            }
                            super.updateItem(item, empty);
                        }
                    };
                }
            });
//            debtTable.getSelectionModel().selectedItemProperty().addListener(
//                    ((observable, oldValue, newValue) -> {
//                        try {
//                            initializeInfoOfWork(newValue, iUser);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    })
//            );
            debtTable.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.RIGHT) {
                    M2MStudentWork pos = debtTable.getFocusModel().getFocusedItem();
                    if (pos != null) {
                        try {
                            initializeInfoOfWork(pos, iUser);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (event.getCode() == KeyCode.LEFT){
                    subjectTable.requestFocus();
                    subjectTable.getSelectionModel().select(position);
                    subjectTable.getFocusModel().focus(position);
                }
            });

        }
    }

    private void initializeInfoOfWork(M2MStudentWork studentWork, MyUser iUser) throws IOException {

        if (studentWork != null){
            VBox vBox = new VBox();
            alert.setTitle("Work"+ studentWork.getIdOfWork().getNumberOfWOrk());
            DialogPane dialogPane = new DialogPane();
            GridPane infoOfWorkGridPane = new GridPane();
            fullGridPaneByUserWorkInfo(studentWork, infoOfWorkGridPane);

            FXMLLoader commentToWorkTable = new  FXMLLoader(getClass().getResource("../../samples/studentFXML/CommentToWork.fxml"));
            CommentToWorkController commentToWorkController = new CommentToWorkController(iUser, token, myUserCredentials, studentWork.getIdOfWork().getIdOfWork());
            commentToWorkTable.setController(commentToWorkController);


            vBox.getChildren().add(0, infoOfWorkGridPane);
            vBox.setSpacing(10);
            vBox.getChildren().add(1, commentToWorkTable.load());

            dialogPane.setContent(vBox);

            dialogPane.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ESCAPE){
                    alert.close();
                }
            });

            dialogPane.getButtonTypes().add(ButtonType.CLOSE);
            alert.setHeaderText("Work №" + studentWork.getIdOfWork().getNumberOfWOrk());
            alert.setDialogPane(dialogPane);
            alert.show();

        }
    }


    private void fullGridPaneByUserWorkInfo(M2MStudentWork work, GridPane infoOfWorkGridPane) {
        TypeOfAcceptWorkRequest typeOfAcceptWorkRequest = new TypeOfAcceptWorkRequest();
        Label nameOfWorkLabel = new Label("Name");
        TextField nameOfWorkTextField = new TextField();
        nameOfWorkTextField.setText(work.getIdOfWork().getNameOfWork());
        nameOfWorkTextField.editableProperty().setValue(false);
        nameOfWorkTextField.setMinSize(120,25);
        nameOfWorkTextField.setPadding(new Insets(0,5,0,5));
        nameOfWorkLabel.setPadding(new Insets(10 ,5 ,10 ,10));
        infoOfWorkGridPane.add(nameOfWorkLabel, 0 , 0);
        infoOfWorkGridPane.add(nameOfWorkTextField, 1,0);

        TextField numberOfWorkTextField = new TextField();
        numberOfWorkTextField.setText(work.getIdOfWork().getNumberOfWOrk());
        numberOfWorkTextField.setMinSize(120,25);
        numberOfWorkTextField.editableProperty().setValue(false);
        numberOfWorkTextField.setPadding(new Insets(0,5,0,5));
        Label numberOfWorkLabel = new Label("Number Of Work");
        numberOfWorkLabel.setPadding(new Insets(10 ,5 ,10 ,10));
        infoOfWorkGridPane.add(numberOfWorkLabel, 0,1);
        infoOfWorkGridPane.add(numberOfWorkTextField, 1,1);

        TextField deadlineTextField = new TextField();
        deadlineTextField.setText(String.valueOf(work.getDeadlineForWork()));
        deadlineTextField.editableProperty().setValue(false);
        deadlineTextField.setMinSize(120,25);
        Label deadlineLabel = new Label("Deadline of work");
        deadlineLabel.setPadding(new Insets(10 ,5 ,10 ,10));
        infoOfWorkGridPane.add(deadlineLabel, 0,2);
        infoOfWorkGridPane.add(deadlineTextField,1,2);

        TextField typeOfWork = new TextField();
        typeOfWork.setText(work.getIdOfWork().getTypeOfWork().getNameTypeOfWOrk());
        typeOfWork.editableProperty().setValue(false);
        typeOfWork.setMinSize(120,25);
        Label typeOfWorkLabel = new Label("Type of work");
        typeOfWorkLabel.setPadding(new Insets(10 ,5 ,10 ,10));
        infoOfWorkGridPane.add(typeOfWorkLabel, 0,3);
        infoOfWorkGridPane.add(typeOfWork, 1,3);

        TextField subject = new TextField();
        subject.setText(work.getIdOfWork().getSubject().getNameSubject());
        subject.editableProperty().setValue(false);
        subject.setMinSize(120,25);
        Label subjectLabel = new Label("Subject");
        subjectLabel.setPadding(new Insets(10 ,5 ,10 ,10));
        infoOfWorkGridPane.add(subjectLabel, 0,4);
        infoOfWorkGridPane.add(subject, 1,4);

        TextArea textOfWork = new TextArea();
        textOfWork.setText(work.getIdOfWork().getTextOfWork());
        textOfWork.editableProperty().setValue(false);
        textOfWork.setMinSize(120,80);
        textOfWork.setMaxWidth(300);
        Label textOfWorkLabel = new Label("Text of work");
        textOfWorkLabel.setPadding(new Insets(10 ,5 ,10 ,10));
        infoOfWorkGridPane.add(textOfWorkLabel, 0,5);
        infoOfWorkGridPane.add(textOfWork,1,5);

        if (work.getIdOfAccaptWork().getIdOfAccaptWork() == 1){
            work.setIdOfAccaptWork(typeOfAcceptWorkRequest.getTypeOfAcceptWorkById(2, token));
            updateWork(work);
        }


    }

    private void updateWork(M2MStudentWork work) {
        StudentWorksController studentWorksController = new StudentWorksController();
        studentWorksController.updateWork(work,token);
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





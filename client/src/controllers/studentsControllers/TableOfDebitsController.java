package controllers.studentsControllers;

import com.vkkzlabs.entity.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import org.thymeleaf.util.DateUtils;
import requests.StudentWorksController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TableOfDebitsController {
    private StudentWorksController studentWorksController = new StudentWorksController();

    @FXML
    private AnchorPane tableOfDebits;

    @FXML
    private TableView<M2MStudentWork> subjectTable;

    @FXML
    private TableColumn<M2MStudentWork, String> subjectCollom;

    @FXML
    private TableView<Work> debtTable;

    @FXML
    private TableColumn<Work, String> numberOfWorkCollom;

    @FXML
    private TableColumn<Work, String> nameOfWorkCollom;

    @FXML
    private TableColumn<Work, String> lastDateCollom;

    @FXML
    private Button watchWork;

    @FXML
    private Button stayInQueue;

    private MyUser iUser;
    private String token;
    private MyUserCredentials myUserCredentials;

    public TableOfDebitsController(MyUser iUser, String token, MyUserCredentials myUserCredentials) {
        this.iUser = iUser;
        this.myUserCredentials = myUserCredentials;
        this.token = token;
    }

    @FXML
    void stayInQueueAction(ActionEvent event) {

    }

    @FXML
    void watchWorkAction(ActionEvent event) {

    }

    public void initialize(){
        M2MStudentWork[] studentWorks = studentWorksController.getSubjectsToList(iUser.getIdUser(), token);
        if (studentWorks != null) {
            List<M2MStudentWork> subjects = new ArrayList<>();
            for (M2MStudentWork m2MStudentWork : studentWorks) {
                if (!ifExistsInList(subjects, m2MStudentWork)) {
                    subjects.add(m2MStudentWork);
                }
            }


            Date thisDate = studentWorksController.getServerDate(token);
            LocalDate date7 = thisDate.toLocalDate();
            LocalDate date15 = thisDate.toLocalDate();
            date7.minusDays(7);
            date15.minusDays(15);


            Tooltip tooltip = new Tooltip("This is new work");



            ObservableList<M2MStudentWork> subjectObservableList = FXCollections.observableList(subjects);
            subjectTable.setItems(subjectObservableList);
            subjectCollom.setCellValueFactory(
                    cellDate -> new SimpleStringProperty(cellDate.getValue().getIdOfWork().getSubject().getNameSubject())
            );
            subjectTable.getSelectionModel().selectedItemProperty().addListener(
                    ((observable, oldValue, newValue) -> initializeWorksTable(newValue.getIdOfWork().getSubject(), iUser))
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
                                if (item.getIdOfWork().getDeadlineForWork().after(java.sql.Date.valueOf(date7))) {
                                    setStyle("-fx-background-color: lightcoral;");
                                }else
                                if (item.getIdOfWork().getDeadlineForWork().after(java.sql.Date.valueOf(date15))){
                                    setStyle("-fx-background-color: coral;");
                                }else
                                if (item.getIdOfWork().getDeadlineForWork().before(java.sql.Date.valueOf(date15))){
                                    setStyle("-fx-background-color: khaki;");
                                }else
                                if (item.getIdOfAccaptWork().getIdOfAccaptWork() == 4){
                                    setStyle("-fx-background-color: aquamarine;");
                                }
                            }
                            super.updateItem(item, empty);
                        }
                    };
                }
            });


        }

    }

    private void initializeWorksTable(Subject subject, MyUser iUser) {
        M2MStudentWork[] m2MStudentWork = studentWorksController.getWorksByUserIdAndSubjectId(iUser, subject, token);
        if (m2MStudentWork != null){
            List<Work> works = new ArrayList<>();
            for (M2MStudentWork listStudentWorks : m2MStudentWork){
                works.add(listStudentWorks.getIdOfWork());
            }
            System.out.println(works.get(0).getDeadlineForWork());
            ObservableList<Work> workObservableList = FXCollections.observableList(works);
            debtTable.setItems(workObservableList);
            numberOfWorkCollom.setCellValueFactory(
                    cellDate -> new SimpleStringProperty(cellDate.getValue().getNumberOfWOrk())
            );
            nameOfWorkCollom.setCellValueFactory(
                    cellDate -> new SimpleStringProperty(cellDate.getValue().getNameOfWork())
            );
            lastDateCollom.setCellValueFactory(
                    cellDate -> new SimpleStringProperty(String.valueOf(cellDate.getValue().getDeadlineForWork()))
            );
        }
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





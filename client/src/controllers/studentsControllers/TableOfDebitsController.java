package controllers.studentsControllers;

import com.vkkzlabs.entity.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import org.thymeleaf.util.DateUtils;
import requests.StudentWorksController;

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
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

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
                                if (item.getIdOfWork().getDeadlineForWork().before(thisDate)) {
                                    setStyle("-fx-background-color: lightcoral;");
                                }else
                                if (item.getIdOfWork().getDeadlineForWork().before(java.sql.Date.valueOf(date7))){
                                    setStyle("-fx-background-color: coral;");
                                }else
                                if (item.getIdOfWork().getDeadlineForWork().after(java.sql.Date.valueOf(date15))){
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
                    cellDate -> new SimpleStringProperty(String.valueOf(cellDate.getValue().getIdOfWork().getDeadlineForWork()))
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
                                if (item.getIdOfWork().getDeadlineForWork().before(thisDate)) {
                                    setStyle("-fx-background-color: lightcoral;");
                                }else
                                if (item.getIdOfWork().getDeadlineForWork().before(java.sql.Date.valueOf(date7))){
                                    setStyle("-fx-background-color: coral;");
                                }else
                                if (item.getIdOfWork().getDeadlineForWork().after(java.sql.Date.valueOf(date15))) {
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
        Work work = new Work();
        if (studentWork != null){
            work = studentWork.getIdOfWork();

            if (work != null) {
                alert.setTitle("Work"+ work.getNumberOfWOrk());
                DialogPane dialogPane = new DialogPane();
                GridPane infoOfWorkGridPane = new GridPane();
                fullGridPaneByUserWorkInfo(work, infoOfWorkGridPane);
                dialogPane.setContent(infoOfWorkGridPane);

                dialogPane.setOnKeyPressed(keyEvent ->
                    alert.close()
                );

                dialogPane.getButtonTypes().add(ButtonType.CLOSE);
                alert.setHeaderText("Work №" + work.getNumberOfWOrk());
                alert.setDialogPane(dialogPane);
                alert.show();
            }
        }
    }


    private void fullGridPaneByUserWorkInfo(Work work, GridPane infoOfWorkGridPane) {
        Label nameOfWorkLabel = new Label("Name");
        TextField nameOfWorkTextField = new TextField();
        nameOfWorkTextField.setText(work.getNameOfWork());
        nameOfWorkTextField.editableProperty().setValue(false);
        nameOfWorkTextField.setMinSize(120,25);
        nameOfWorkTextField.setPadding(new Insets(0,5,0,5));
        nameOfWorkLabel.setPadding(new Insets(10 ,5 ,10 ,10));
        infoOfWorkGridPane.add(nameOfWorkLabel, 0 , 0);
        infoOfWorkGridPane.add(nameOfWorkTextField, 1,0);

        TextField numberOfWorkTextField = new TextField();
        numberOfWorkTextField.setText(work.getNumberOfWOrk());
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
        typeOfWork.setText(work.getTypeOfWork().getNameTypeOfWOrk());
        typeOfWork.editableProperty().setValue(false);
        typeOfWork.setMinSize(120,25);
        Label typeOfWorkLabel = new Label("Type of work");
        typeOfWorkLabel.setPadding(new Insets(10 ,5 ,10 ,10));
        infoOfWorkGridPane.add(typeOfWorkLabel, 0,3);
        infoOfWorkGridPane.add(typeOfWork, 1,3);

        TextField subject = new TextField();
        subject.setText(work.getSubject().getNameSubject());
        subject.editableProperty().setValue(false);
        subject.setMinSize(120,25);
        Label subjectLabel = new Label("Subject");
        subjectLabel.setPadding(new Insets(10 ,5 ,10 ,10));
        infoOfWorkGridPane.add(subjectLabel, 0,4);
        infoOfWorkGridPane.add(subject, 1,4);

        TextArea textOfWork = new TextArea();
        textOfWork.setText(work.getTextOfWork());
        textOfWork.editableProperty().setValue(false);
        textOfWork.setMinSize(120,80);
        textOfWork.setMaxWidth(300);
        Label textOfWorkLabel = new Label("Text of work");
        textOfWorkLabel.setPadding(new Insets(10 ,5 ,10 ,10));
        infoOfWorkGridPane.add(textOfWorkLabel, 0,5);
        infoOfWorkGridPane.add(textOfWork,1,5);



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





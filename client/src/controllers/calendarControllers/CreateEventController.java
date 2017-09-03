package controllers.calendarControllers;
import com.vkkzlabs.api.entity.*;
import controllers.converters.StudentGroupConverter;
import controllers.converters.SubjectConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import requests.EventsRequest;
import requests.GroupTimetableRequest;
import requests.StudentGroupRequest;
import requests.SubjectRequest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static controllers.calendarControllers.PaneOfEventsController.listOfEvents;
import static controllers.calendarControllers.PaneOfEventsController.timetableObservableList;


public class CreateEventController {
    @FXML
    private DatePicker dateOfStart;

    @FXML
    private Slider howersOfStart;

    @FXML
    private Slider minutesOfStart;

    @FXML
    private Label timeOfStartLabel;

    @FXML
    private Slider houersOfEnd;

    @FXML
    private Slider minutesOfEnd;

    @FXML
    private Label timeOfEndLabel;

    @FXML
    private ChoiceBox<Subject> subjectChoice;

    @FXML
    private TextField locationTextField;

    @FXML
    private ChoiceBox<StudentGroup> groupChoiceBox;

    private int row;
    private int col;
    private Calendar calendar;
    private Timetable timetable;
    private Alert alert;
    private MyUser iUser;
    private String token;
    private MyUserCredentials myUserCredentials;


    public CreateEventController(int row, int col, Calendar calendar, Timetable timetable, Alert alert, MyUser iUser, String token, MyUserCredentials myUserCredentials) {
        this.row = row;
        this.col = col;
        this.calendar = calendar;
        this.timetable = timetable;
        this.alert = alert;
        this.iUser = iUser;
        this.token = token;
        this.myUserCredentials = myUserCredentials;
    }



    @FXML
    void acceptEvent(ActionEvent event) {
        Timetable timetable = new Timetable();
        Date dateStart = new Date();
        dateStart.setTime(calendar.getTimeInMillis());
        dateStart.setDate(calendar.get(Calendar.DAY_OF_MONTH));
        dateStart.setMonth(calendar.get(Calendar.MONTH));


        dateStart.setHours(Integer.parseInt(timeOfStartLabel.getText().substring(0,2).replaceAll("[\\D]", "")));
        dateStart.setMinutes(Integer.parseInt(timeOfStartLabel.getText().substring(2, 5).replaceAll("[\\D]", "")));
        dateStart.setSeconds(0);



        Date dateEnd = new Date();
        dateEnd.setTime(calendar.getTimeInMillis());
        dateEnd.setDate(calendar.get(Calendar.DAY_OF_MONTH));
        dateEnd.setMonth(calendar.get(Calendar.MONTH));

        dateEnd.setHours(Integer.parseInt(timeOfEndLabel.getText().substring(0,2).replaceAll("[\\D]", "")));
        dateEnd.setMinutes(Integer.parseInt(timeOfEndLabel.getText().substring(2, 5).replaceAll("[\\D]", "")));
        dateEnd.setSeconds(0);
        timetable.setDate(dateStart);
        timetable.setTimeOfEndWork(dateEnd);

        String str = timeOfEndLabel.getText().substring(2,4);




        timetable.setSubject(subjectChoice.getValue());
        timetable.setProfessor(iUser);
        timetable.setAuditory(locationTextField.getText());
        EventsRequest eventsRequest = new EventsRequest();
        GroupTimetableRequest groupTimetableRequest = new GroupTimetableRequest();
        if (locationTextField.getText() != null && !Objects.equals(locationTextField.getText(), "Please write location!")) {
            timetable.setAuditory(locationTextField.getText());
            M2MGroupTimetable m2MGroupTimetable = new M2MGroupTimetable();
            m2MGroupTimetable.setIdGroup(groupChoiceBox.getValue());
            m2MGroupTimetable.setIdTimetable(eventsRequest.saveEvent(timetable,token));
            groupTimetableRequest.saveGroupTimetable(m2MGroupTimetable,token);
            timetableObservableList.add(timetable);

            alert.close();
        }else {
            locationTextField.setText("Please write location!");
        }



    }

    @FXML
    void cancelEvent(ActionEvent event) {
        alert.close();
    }

    public void initialize(){
        SubjectConverter subjectConverter = new SubjectConverter();
        SubjectRequest subjectRequest = new SubjectRequest();
        StudentGroupRequest studentGroupRequest = new StudentGroupRequest();
        ObservableList<StudentGroup> studentGroupObservableList = FXCollections.observableList(Arrays.asList(studentGroupRequest.getAllProfessorsGroup(token,iUser)));
        StudentGroupConverter studentGroupConverter = new StudentGroupConverter();
        groupChoiceBox.setConverter(studentGroupConverter);
        groupChoiceBox.setItems(studentGroupObservableList);
        subjectChoice.setConverter(subjectConverter);
        ObservableList<Subject> subjects = FXCollections.observableList(Arrays.asList(subjectRequest.getSubjectsToProfessor(iUser.getIdUser(), token)));
        subjectChoice.setItems(subjects);
        subjectChoice.getSelectionModel().select(0);

        initializeTimes();
        initializeDates();

    }

    private void initializeDates() {
        Date dateTime = new Date(calendar.getTimeInMillis());
        dateTime.setDate(calendar.get(Calendar.DAY_OF_MONTH));
        dateTime.setMonth(calendar.get(Calendar.MONTH));
        LocalDate localDate = dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (timetable.getDate() != null){
            dateOfStart.setValue(timetable.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        }else {
            dateOfStart.setValue(localDate);
        }
    }

    private void initializeTimes() {
        int hour;
        int minutes;
        int endHour;
        int endMinute;
        if (row == 0 && col == 0){
            hour = timetable.getDate().getHours();
            minutes = timetable.getDate().getMinutes();
            howersOfStart.setValue(hour*4.16);//4.16
            minutesOfStart.setValue(minutes*1.667);
            endHour = timetable.getTimeOfEndWork().getHours();
            endMinute = timetable.getTimeOfEndWork().getMinutes();
            minutesOfEnd.setValue(endMinute*1.667);
            houersOfEnd.setValue(endHour*4.16);
            minutes = minutes/15;
            endMinute = endMinute/15;
        }else {
            hour = (row - 1) / 4;
            minutes = row - ((hour * 4) + 1);
            howersOfStart.setValue(hour*4.16);//4.16
            minutesOfStart.setValue(minutes*15*1.667);
            houersOfEnd.setValue((hour+1)*4.16);
            minutesOfEnd.setValue(minutes*15*1.667);
            endHour = hour+1;
            endMinute = minutes;
        }

        //1.6
        String start;
        String end;
            if (hour < 10){
                start = "0"+String.valueOf(hour);
            } else start = String.valueOf(hour);

            if (endHour < 10){
                end = "0"+String.valueOf(endHour);
            }else end = String.valueOf(endHour);

        if (minutes == 0){
            timeOfStartLabel.setText(start+":"+"00");
        }else timeOfStartLabel.setText(String.valueOf(start)+":"+String.valueOf(minutes*15));

        if (endMinute == 0){
            timeOfEndLabel.setText(end+":"+"00");
        }else timeOfEndLabel.setText(end+":"+String.valueOf(endMinute*15));
        howersOfStart.valueProperty().addListener((observableValue, number, t1) -> {
            Double hours = howersOfStart.getValue()/4.16;
            Double minutes12 = minutesOfStart.getValue()/8.3;
            int hour12 = hours.intValue();
            int intMinutes = minutes12.intValue()*5;
            String strMinutes;
            String strHour;
            if (intMinutes == 0 || intMinutes == 5){
                strMinutes = "0"+String.valueOf(intMinutes);
            }else strMinutes = String.valueOf(intMinutes);
            if (intMinutes == 60){
                strMinutes = String.valueOf(55);
            }
            if (hour12< 10){
                strHour = "0"+String.valueOf(hour12);
            }else if (hour12 == 24){
                strHour = String.valueOf(23);
            }else strHour = String.valueOf(hour12);
            timeOfStartLabel.textProperty().setValue(strHour+":"+strMinutes);
        });

        minutesOfStart.valueProperty().addListener((observableValue, number, t1) -> {
            Double hoursFromSlider = howersOfStart.getValue()/4.16;
            Double minutesFromSlider = minutesOfStart.getValue()/8.3;
            int interpritMinutes = minutesFromSlider.intValue()*5;
            int interpritHour = hoursFromSlider.intValue();
            String strMinutes;
            String strHour;

            if (interpritMinutes == 0 || interpritMinutes == 5){
                strMinutes = "0"+String.valueOf(interpritMinutes);
            }else strMinutes = String.valueOf(interpritMinutes);
            if (interpritMinutes == 60){
                strMinutes = String.valueOf(55);
            }
            if (interpritHour< 10){
                strHour = "0"+String.valueOf(interpritHour);
            }else if (interpritHour == 24){
                strHour = String.valueOf(23);
            }else strHour = String.valueOf(interpritHour);
            timeOfStartLabel.textProperty().setValue(strHour+":"+strMinutes);
        });

        houersOfEnd.valueProperty().addListener((observableValue, number, t1) -> {
            Double hoursFromSlider = houersOfEnd.getValue()/4.16;
            Double minutesFromSlider = minutesOfEnd.getValue()/8.3;
            int interpritHour = hoursFromSlider.intValue();
            int interpritMinutes = minutesFromSlider.intValue()*5;
            String strMinutes;
            String strHour;
            if (interpritMinutes == 0 || interpritMinutes == 5){
                strMinutes = "0"+String.valueOf(interpritMinutes);
            }else strMinutes = String.valueOf(interpritMinutes);
            if (interpritMinutes == 60){
                strMinutes = String.valueOf(55);
            }
            if (interpritHour< 10){
                strHour = "0"+String.valueOf(interpritHour);
            }else if (interpritHour == 24){
                strHour = String.valueOf(23);
            }else strHour = String.valueOf(interpritHour);
            timeOfEndLabel.textProperty().setValue(strHour+":"+strMinutes);
        });

        minutesOfEnd.valueProperty().addListener((observableValue, number, t1) -> {
            Double hours = houersOfEnd.getValue()/4.16;
            Double minutes1 = minutesOfEnd.getValue()/8.3;
            int intMinutes = minutes1.intValue()*5;
            String strMinutes;
            String strHour;
            int hour1 = hours.intValue();
            if (intMinutes == 0 || intMinutes == 5){
                strMinutes = "0"+String.valueOf(intMinutes);
            }else strMinutes = String.valueOf(intMinutes);
            if (intMinutes == 60){
                strMinutes = String.valueOf(55);
            }
            if (hour1 < 10){
                strHour = "0"+String.valueOf(hour1);
            }else
            if (hour1 == 24){
                strHour = String.valueOf(23);
            }else strHour = String.valueOf(hour1);
            timeOfEndLabel.textProperty().setValue(strHour+":"+strMinutes);
        });
    }

}

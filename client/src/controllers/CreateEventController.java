package controllers;
import com.vkkzlabs.api.entity.Timetable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import requests.TimetableRequest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

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
    private ChoiceBox<?> subjectChoice;

    @FXML
    private TextField locationTextField;

    private int row;
    private int col;
    private Calendar calendar;
    private Timetable timetable;

    public CreateEventController(int row, int col, Calendar calendar, Timetable timetable) {
        this.row = row;
        this.col = col;
        this.calendar = calendar;
        this.timetable = timetable;
    }

    @FXML
    void acceptEvent(ActionEvent event) {

    }

    @FXML
    void cancelEvent(ActionEvent event) {

    }

    public void initialize(){
        initializeTimes();
        initializeDates();

    }

    private void initializeDates() {
        Date dateTime = new Date(calendar.getTimeInMillis());
        LocalDate localDate = dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
        dateOfStart.setValue(localDate);
    }

    private void initializeTimes() {
        int hour;
        int minutes;
        if (row == 0 && col == 0){
            hour = timetable.getDate().getHours();
            minutes = timetable.getDate().getMinutes();
            howersOfStart.setValue(hour*4.16);//4.16
            minutesOfStart.setValue(minutes*1.667);
            minutes = minutes/15;
        }else {
            hour = (row - 1) / 4;
            minutes = row - ((hour * 4) + 1);
            howersOfStart.setValue(hour*4.16);//4.16
            minutesOfStart.setValue(minutes*15*1.667);
        }

        //1.6
        if (minutes == 0){
            timeOfStartLabel.setText(String.valueOf(hour)+":"+"00");
        }else timeOfStartLabel.setText(String.valueOf(hour)+":"+String.valueOf(minutes*15));
        houersOfEnd.setValue((hour+1)*4.16);
        minutesOfEnd.setValue(minutes*15*1.667);
        if (minutes == 0){
            timeOfEndLabel.setText(String.valueOf(hour+1)+":"+"00");
        }else timeOfEndLabel.setText(String.valueOf(hour+1)+":"+String.valueOf(minutes*15));
        howersOfStart.valueProperty().addListener((observableValue, number, t1) -> {
            Double howers = howersOfStart.getValue()/4.16;
            Double minutes12 = minutesOfStart.getValue()/8.3;
            int hour12 = howers.intValue();
            int intMinutes = minutes12.intValue()*5;
            String strMinutes;
            String strHour;
            if (intMinutes == 0 || intMinutes == 5){
                strMinutes = "0"+String.valueOf(intMinutes);
            }else strMinutes = String.valueOf(intMinutes);
            if (intMinutes == 60){
                strMinutes = String.valueOf(55);
            }
            if (hour12 == 24){
                strHour = String.valueOf(23);
            }else strHour = String.valueOf(hour12);
            timeOfStartLabel.textProperty().setValue(strHour+":"+strMinutes);
        });

        minutesOfStart.valueProperty().addListener((observableValue, number, t1) -> {
            Double howers = howersOfStart.getValue()/4.16;
            Double minutes1 = minutesOfStart.getValue()/8.3;
            int intMinutes = minutes1.intValue()*5;
            String strMinutes;
            String strHour;
            int hour1 = howers.intValue();
            if (intMinutes == 0 || intMinutes == 5){
                strMinutes = "0"+String.valueOf(intMinutes);
            }else strMinutes = String.valueOf(intMinutes);
            if (intMinutes == 60){
                strMinutes = String.valueOf(55);
            }
            if (hour1 == 24){
                strHour = String.valueOf(23);
            }else strHour = String.valueOf(hour1);
            timeOfStartLabel.textProperty().setValue(strHour+":"+strMinutes);
        });

        houersOfEnd.valueProperty().addListener((observableValue, number, t1) -> {
            Double howers = houersOfEnd.getValue()/4.16;
            Double minutes12 = minutesOfEnd.getValue()/8.3;
            int hour12 = howers.intValue();
            int intMinutes = minutes12.intValue()*5;
            String strMinutes;
            String strHour;
            if (intMinutes == 0 || intMinutes == 5){
                strMinutes = "0"+String.valueOf(intMinutes);
            }else strMinutes = String.valueOf(intMinutes);
            if (intMinutes == 60){
                strMinutes = String.valueOf(55);
            }
            if (hour12 == 24){
                strHour = String.valueOf(23);
            }else strHour = String.valueOf(hour12);
            timeOfEndLabel.textProperty().setValue(strHour+":"+strMinutes);
        });

        minutesOfEnd.valueProperty().addListener((observableValue, number, t1) -> {
            Double howers = houersOfEnd.getValue()/4.16;
            Double minutes1 = minutesOfEnd.getValue()/8.3;
            int intMinutes = minutes1.intValue()*5;
            String strMinutes;
            String strHour;
            int hour1 = howers.intValue();
            if (intMinutes == 0 || intMinutes == 5){
                strMinutes = "0"+String.valueOf(intMinutes);
            }else strMinutes = String.valueOf(intMinutes);
            if (intMinutes == 60){
                strMinutes = String.valueOf(55);
            }
            if (hour1 == 24){
                strHour = String.valueOf(23);
            }else strHour = String.valueOf(hour1);
            timeOfEndLabel.textProperty().setValue(strHour+":"+strMinutes);
        });
    }

}

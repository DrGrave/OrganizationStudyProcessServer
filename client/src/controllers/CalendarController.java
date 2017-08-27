package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarController {

    @FXML
    private Button prevWeekButton;

    @FXML
    private Button thisDayButton;

    @FXML
    private Button nextWeekButton;

    @FXML
    private Label dateLabel;

    @FXML
    private GridPane dayGridPane;

    @FXML
    private Label mondayLabel;

    @FXML
    private Label tuesdayLabel;

    @FXML
    private Label wednesdayLabel;

    @FXML
    private Label thursdayLabel;

    @FXML
    private Label fridayLabel;

    @FXML
    private Label saturdayLabel;

    @FXML
    private Label sundayLabel;

    @FXML
    private GridPane eventGridPane;

    @FXML
    void nextWeekAction(ActionEvent event) {

    }

    @FXML
    void prevWeekAction(ActionEvent event) {

    }

    @FXML
    void thisDayAction(ActionEvent event) {

    }

    public void initialize(){
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        getDate(calendar);
        getWeek(calendar);
        getTimeLine(calendar);
        getEvent();




    }

    private void getEvent() {

        Pane pane = new Pane();
        pane.setOpacity(0.6F);
        pane.setStyle("-fx-background-color: #3c763d");
        Pane pane1 = new Pane();
        pane1.setOpacity(0.6F);
        pane1.setStyle("-fx-background-color: #3c763d");
        Pane pane2 = new Pane();
        pane2.setOpacity(0.6F);
        pane2.setStyle("-fx-background-color: #3c763d");
        Pane pane3 = new Pane();
        pane3.setOpacity(0.6F);
        pane3.setStyle("-fx-background-color: #3c763d");
        Pane pane4 = new Pane();
        pane4.setOpacity(0.6F);
        pane4.setStyle("-fx-background-color: #3c763d");
        Pane pane5 = new Pane();
        pane5.setOpacity(0.6F);
        pane5.setStyle("-fx-background-color: #3c763d");
        Pane pane6 = new Pane();
        pane6.setOpacity(0.6F);
        pane6.setStyle("-fx-background-color: #3c763d");

        eventGridPane.add(pane, 1,1);
        eventGridPane.setMargin(pane, new Insets(0,1,0,0));
        eventGridPane.add(pane1, 1,2);
        eventGridPane.setMargin(pane1, new Insets(0,1,0,0));
        eventGridPane.add(pane3, 1,3);
        eventGridPane.setMargin(pane2, new Insets(0,1,0,0));
        eventGridPane.add(pane4, 1,4);
        eventGridPane.setMargin(pane3, new Insets(0,1,0,0));
        eventGridPane.add(pane5, 1,5);
        eventGridPane.setMargin(pane4, new Insets(0,1,0,0));
        eventGridPane.add(pane6,1,6);
        eventGridPane.setMargin(pane5, new Insets(0,1,0,0));
        eventGridPane.add(pane2,1,7);
        eventGridPane.setMargin(pane6, new Insets(0,1,0,0));
    }

    private void getDate(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        dateLabel.setText(String.valueOf(month+1) + "."+ String.valueOf(year));
    }

    private void getTimeLine(Calendar calendar) {
        int i = calendar.get(Calendar.HOUR_OF_DAY);
        int timeLine = i*4+1;
        i = calendar.get(Calendar.MINUTE);
        i = i/15;
        timeLine = timeLine + i;
        Separator separator = new Separator();
        separator.setMinWidth(600);
        separator.getStylesheets().add((getClass().getResource("calendarCSS/timeLine.css")).toExternalForm());
        separator.setPadding(new Insets(0,0,8,0));
        eventGridPane.add(separator, 1, timeLine);
    }

    private void getWeek(Calendar calendar) {
        DateFormat dateFormat = new SimpleDateFormat("u");
        Date date = new Date();
        int dateOfWeek = Integer.parseInt(dateFormat.format(date));
        if (dateOfWeek == 1){
            mondayLabel.setStyle("-fx-background-color: palevioletred");
            mondayLabel.setText("  Mon "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            tuesdayLabel.setText("  Tue "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
            wednesdayLabel.setText("  Wed "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            thursdayLabel.setText("  Thu "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            fridayLabel.setText("  Fri "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            saturdayLabel.setText("  Sat "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            sundayLabel.setText("  Sun "+calendar.get(Calendar.DAY_OF_MONTH));
            sundayLabel.setStyle("-fx-text-fill: #c9302c");
            saturdayLabel.setStyle("-fx-text-fill: #c9302c");

        }if (dateOfWeek ==2){
            tuesdayLabel.setStyle("-fx-background-color: palevioletred");
            tuesdayLabel.setText("  Tue "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            mondayLabel.setText("  Mon "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
            wednesdayLabel.setText("  Wed "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            thursdayLabel.setText("  Thu "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            fridayLabel.setText("  Fri "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            saturdayLabel.setText("  Sat "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            sundayLabel.setText("  Sun "+calendar.get(Calendar.DAY_OF_MONTH));
            sundayLabel.setStyle("-fx-text-fill: #c9302c");
            saturdayLabel.setStyle("-fx-text-fill: #c9302c");

        }if (dateOfWeek == 3){
            wednesdayLabel.setStyle("-fx-background-color: palevioletred");
            wednesdayLabel.setText("  Wed "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            mondayLabel.setText("  Mon "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            tuesdayLabel.setText("  Tue "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            thursdayLabel.setText("  Thu "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            fridayLabel.setText("  Fri "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            saturdayLabel.setText("  Sat "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            sundayLabel.setText("  Sun "+calendar.get(Calendar.DAY_OF_MONTH));
            sundayLabel.setStyle("-fx-text-fill: #c9302c");
            saturdayLabel.setStyle("-fx-text-fill: #c9302c");
        }if (dateOfWeek == 4){
            thursdayLabel.setStyle("-fx-background-color: palevioletred");
            thursdayLabel.setText("  Thu "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            mondayLabel.setText("  Mon "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            tuesdayLabel.setText("  Tue "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
            wednesdayLabel.setText("  Wed "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            fridayLabel.setText("  Fri "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            saturdayLabel.setText("  Sat "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            sundayLabel.setText("  Sun "+calendar.get(Calendar.DAY_OF_MONTH));
            sundayLabel.setStyle("-fx-text-fill: #c9302c");
            saturdayLabel.setStyle("-fx-text-fill: #c9302c");
        }if (dateOfWeek == 5){
            fridayLabel.setText("  Fri "+calendar.get(Calendar.DAY_OF_MONTH));
            fridayLabel.setStyle("-fx-background-color: palevioletred");
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            mondayLabel.setText("  Mon "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            tuesdayLabel.setText("  Tue "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
            wednesdayLabel.setText("  Wed "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            thursdayLabel.setText("  Thu "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            saturdayLabel.setText("  Sat "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            sundayLabel.setText("  Sun "+calendar.get(Calendar.DAY_OF_MONTH));
            sundayLabel.setStyle("-fx-text-fill: #c9302c");
            saturdayLabel.setStyle("-fx-text-fill: #c9302c");

        }if (dateOfWeek == 6){
            saturdayLabel.setStyle("-fx-background-color: palevioletred; -fx-text-fill: #c9302c");
            saturdayLabel.setText("  Sat "+calendar.get(Calendar.DAY_OF_MONTH) );
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            sundayLabel.setStyle("-fx-text-fill: #c9302c");
            sundayLabel.setText("  Sun " +calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            fridayLabel.setText("  Fri "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            thursdayLabel.setText("  Thu "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
            wednesdayLabel.setText("  Wed "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            tuesdayLabel.setText("  Tue "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            mondayLabel.setText("  Mon "+ calendar.get(Calendar.DAY_OF_MONTH));
        }if (dateOfWeek == 7){
            sundayLabel.setStyle("-fx-background-color: palevioletred; -fx-text-fill: #c9302c");
            sundayLabel.setText("  Sun " +calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            saturdayLabel.setStyle("-fx-text-fill: #c9302c");
            saturdayLabel.setText("  Sat "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            fridayLabel.setText("  Fri "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            thursdayLabel.setText("  Thu "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
            wednesdayLabel.setText("  Wed "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            tuesdayLabel.setText("  Tue "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            mondayLabel.setText("  Mon "+ calendar.get(Calendar.DAY_OF_MONTH));
        }
    }

}

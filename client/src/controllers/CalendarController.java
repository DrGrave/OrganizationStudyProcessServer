package controllers;

import com.vkkzlabs.api.entity.Subject;
import com.vkkzlabs.api.entity.Timetable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarController {

    @FXML
    private VBox vBox;

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




    private Calendar calendar = Calendar.getInstance();
    private Calendar calendarNextWeek = Calendar.getInstance();
    @FXML
    void nextWeekAction(ActionEvent event) {
        clearEvents();
        if (calendar.get(Calendar.WEEK_OF_YEAR) == calendarNextWeek.get(Calendar.WEEK_OF_YEAR)){
            calendarNextWeek.set(Calendar.WEEK_OF_YEAR, calendar.get(Calendar.WEEK_OF_YEAR)+1);
            initializeWeeks(calendarNextWeek);
        }else {
            calendarNextWeek.set(Calendar.WEEK_OF_YEAR, calendarNextWeek.get(Calendar.WEEK_OF_YEAR)+1);
            initializeWeeks(calendarNextWeek);
        }

    }

    @FXML
    void prevWeekAction(ActionEvent event) {
        clearEvents();
        if (calendar.get(Calendar.WEEK_OF_YEAR) == calendarNextWeek.get(Calendar.WEEK_OF_YEAR)){
            calendarNextWeek.set(Calendar.WEEK_OF_YEAR, calendar.get(Calendar.WEEK_OF_YEAR)-1);
            initializeWeeks(calendarNextWeek);
        }else {
            calendarNextWeek.set(Calendar.WEEK_OF_YEAR, calendarNextWeek.get(Calendar.WEEK_OF_YEAR)-1);
            initializeWeeks(calendarNextWeek);
        }

    }

    private void clearEvents() {


    }


    @FXML
    void thisDayAction(ActionEvent event) {
        clearEvents();
        calendar = Calendar.getInstance();
        calendarNextWeek = Calendar.getInstance();
        initializeWeeks(calendar);

    }

    public void initialize() throws IOException {
        initializeLabelsTextSize();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        initializeWeeks(calendar);
        FXMLLoader gridEvent = new  FXMLLoader(getClass().getResource("../samples/GridPaneOfEvents.fxml"));
        PaneOfEventsController paneOfEventsController = new PaneOfEventsController(calendar, mondayLabel,tuesdayLabel,wednesdayLabel,thursdayLabel,fridayLabel,saturdayLabel,sundayLabel,dateLabel);
        gridEvent.setController(paneOfEventsController);
        vBox.getChildren().add(gridEvent.load());

    }

    private void initializeWeeks(Calendar calendar) {
        getDate(calendar);
        getWeek(calendar);
        //getTimeLine(calendar);
        //getEvent();
        ContextMenu contextMenu = new ContextMenu();
        MenuItem item1 = new MenuItem("Menu Item 1");
        Label label = new Label();
        item1.setOnAction(event -> label.setText("Select Menu Item 1"));
        MenuItem item2 = new MenuItem("Menu Item 2");
        item2.setOnAction(event -> label.setText("Select Menu Item 2"));
        contextMenu.getItems().addAll(item1,item2);

    }

    private void initializeLabelsTextSize() {
        dateLabel.setFont(new Font(20));
        mondayLabel.setFont(new Font(15));
        tuesdayLabel.setFont(new Font(15));
        wednesdayLabel.setFont(new Font(15));
        thursdayLabel.setFont(new Font(15));
        fridayLabel.setFont(new Font(15));
        saturdayLabel.setFont(new Font(15));
        sundayLabel.setFont(new Font(15));
    }













    private void getDate(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        dateLabel.setText(String.valueOf(month+1) + "."+ String.valueOf(year));
    }



    private void getWeek(Calendar calendar) {
        DateFormat dateFormat = new SimpleDateFormat("u");
        Date date = new Date();
        Calendar thisCalendar = Calendar.getInstance();
        thisCalendar.setTime(date);
        int dateOfWeek = Integer.parseInt(dateFormat.format(date));
        if (calendar.get(Calendar.WEEK_OF_YEAR) != thisCalendar.get(Calendar.WEEK_OF_YEAR)){
            clearLabel();
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            sundayLabel.setStyle("-fx-text-fill: #c9302c");
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
            return;
        }else if (dateOfWeek == 1){
            clearLabel();
            mondayLabel.setStyle("-fx-background-color: palevioletred; -fx-background-radius: 3;");
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
            clearLabel();
            tuesdayLabel.setStyle("-fx-background-color: palevioletred; -fx-background-radius: 3;");
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
            clearLabel();
            wednesdayLabel.setStyle("-fx-background-color: palevioletred; -fx-background-radius: 3;");
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
            clearLabel();
            thursdayLabel.setStyle("-fx-background-color: palevioletred; -fx-background-radius: 3;");
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
            clearLabel();
            fridayLabel.setText("  Fri "+calendar.get(Calendar.DAY_OF_MONTH));
            fridayLabel.setStyle("-fx-background-color: palevioletred; -fx-background-radius: 3;");
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
            clearLabel();
            saturdayLabel.setStyle("-fx-background-color: palevioletred; -fx-background-radius: 3 ; -fx-text-fill: #c9302c");
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
            clearLabel();
            sundayLabel.setStyle("-fx-background-color: palevioletred; -fx-text-fill: #c9302c; -fx-background-radius: 3;");
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

    private void clearLabel() {
        mondayLabel.setStyle(null);
        thursdayLabel.setStyle(null);
        tuesdayLabel.setStyle(null);
        wednesdayLabel.setStyle(null);
        fridayLabel.setStyle(null);
        sundayLabel.setStyle(null);
        saturdayLabel.setStyle(null);
    }

}

package sample;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import  javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.text.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class FXMLDocumentController {

  @FXML
  public Label user_alarm_time_inputted;

  @FXML
  Button set_alarm_button;

  @FXML
  ComboBox user_hour_combo_box;
  @FXML
  ComboBox user_minute_combo_box;

  @FXML
  ComboBox user_amorpm_combo_box;



  @FXML
  Label  label_to_show_current_time;




  public  void Handle_button_click_for_set_alarm_button() throws ParseException {

    String selected_hour = user_hour_combo_box.getValue().toString(); // takes the current value of what the user selected and puts it in a string.
    String selected_minute = user_minute_combo_box.getValue().toString(); // takes the current value of what the user selected and puts it in a string.
    String selected_amorpm = user_amorpm_combo_box.getValue().toString(); // takes the current value of what the user selected and puts it in a string.
    System.out.println(selected_hour);
    System.out.println("selected minute is" + selected_minute);
    System.out.println("user has selected PM/AM " + selected_amorpm);
    //Populate options for the comboBox.

    DateFormat df = new SimpleDateFormat("M/dd/yy", Locale.US);
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("M/dd/yyy");
    String nowdate = formatter.format(date);
    String DatePlusUserAlarm = nowdate + " " + selected_hour + ":" +selected_minute + " " + selected_amorpm;

    String selected_user_alarm_time = DatePlusUserAlarm;
    DateFormat df2 = new SimpleDateFormat("M/dd/yyy hh:mm a", Locale.US);
    Date dateuseralarmtime;
    dateuseralarmtime = df2.parse(selected_user_alarm_time);
    String finaldatealarmtime = df2.format(dateuseralarmtime);
    System.out.println(finaldatealarmtime);

    //user_alarm_time_inputted.setText(usereneteredtime);





  }


  @FXML
  public void  initialize() throws ParseException {
    String strtime = "8/30/19 3:45:22 PM";
    DateFormat df = new SimpleDateFormat("M/dd/yy hh:mm:ss a", Locale.US);
    Date date23;
    date23 = df.parse(strtime);

    System.out.println(df.format(date23));



    user_hour_combo_box.getItems().setAll("1","2","3","4","5","6","7","8","9","10","11","12");
    user_minute_combo_box.getItems().setAll("00","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59");
    user_amorpm_combo_box.getItems().setAll("AM","PM");



    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a", Locale.US);

    //label_to_show_current_time.textProperty().bind(bindToTime());
    Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->  {
      LocalTime timenow = LocalTime.now();
      String displaytime = timenow.format(timeFormatter);

      //String timenowstring = timenow.toString();
      label_to_show_current_time.setText(displaytime);

    }),
      new KeyFrame(Duration.seconds(1))
    );

    clock.setCycleCount(Animation.INDEFINITE);
    clock.play();


  }



}

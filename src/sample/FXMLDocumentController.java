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

import java.io.IOException;
import java.text.*;
import java.time.LocalDateTime;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

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


  public  void playsound()   {
    try {
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("alarm-clock-sound.wav"));
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

  private  class MyTimeTask extends TimerTask
  {

    public void run()
    {
      System.out.println("is this working?");
      playsound();
    }
  }

  public  void Handle_button_click_for_set_alarm_button() throws ParseException {

    String selected_hour = user_hour_combo_box.getValue().toString(); // takes the current value of what the user selected and puts it in a string.
    String selected_minute = user_minute_combo_box.getValue().toString(); // takes the current value of what the user selected and puts it in a string.
    String selected_amorpm = user_amorpm_combo_box.getValue().toString(); // takes the current value of what the user selected and puts it in a string.
    System.out.println(selected_hour); // prints out the selected hour by the user
    System.out.println("selected minute is" + selected_minute); // prints out the selected minute
    System.out.println("user has selected PM/AM " + selected_amorpm); // prints out the selected am/pm by the user.
    //Populate options for the comboBox.

    DateFormat df = new SimpleDateFormat("M/dd/yy", Locale.US); //format to be used for the date.
    Date date = new Date(); // declare new date

    SimpleDateFormat formatter = new SimpleDateFormat("M/dd/yyy"); //declare new date format
    String nowdate = formatter.format(date); // format the current date to the desired format
    String DatePlusUserAlarm = nowdate + " " + selected_hour + ":" +selected_minute + " " + selected_amorpm; // puts the user selected minute, hour, am/pm into one string.

    String selected_user_alarm_time = DatePlusUserAlarm; // puts the user alarm into one
    DateFormat df2 = new SimpleDateFormat("M/dd/yyy hh:mm a", Locale.US); // new date format declared
    Date dateuseralarmtime;  //new date variable
    dateuseralarmtime = df2.parse(selected_user_alarm_time); // parse selected user alarm time into one date format. Stored in a variable.

    System.out.println("dateuseralarmtime is  "  + dateuseralarmtime);

    String finaldatealarmtime = df2.format(dateuseralarmtime);
    System.out.println(finaldatealarmtime); //prints out the user selected time into a string
    user_alarm_time_inputted.setText(finaldatealarmtime); //sets the text to the user selected alarm time.

    Timer timer = new Timer(); //created a new timer

    Date currentdateandtime = new Date(); //this contains the current date and time.
    SimpleDateFormat formatterforcurrentdate = new SimpleDateFormat("M/dd/yy hh:mm a",Locale.US);

    if (currentdateandtime.after(dateuseralarmtime)) {
      System.out.println("The chosen date is after the current date and time. Please choose a new date. ");
      finaldatealarmtime = null;
      user_alarm_time_inputted.setText("please choose a diffrent time.");
      return;
    }


    timer.schedule(new MyTimeTask(), dateuseralarmtime);



    //fina

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

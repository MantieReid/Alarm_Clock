package sample;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import  javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class FXMLDocumentController {

  @FXML
  Button set_alarm_button;

  @FXML
  TextField user_desired_alarm_time;

  @FXML
  Label  label_to_show_current_time;




  public  void Handle_button_click_for_set_alarm_button() {

    user_desired_alarm_time.getText();
    System.out.println(user_desired_alarm_time.getText());




  }


  @FXML
  public void  initialize() {

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

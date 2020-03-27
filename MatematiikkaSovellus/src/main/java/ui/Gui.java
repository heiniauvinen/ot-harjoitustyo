/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author heiniauvinen
 */
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.Exam;
import logic.Question;

public class Gui extends Application {

    public void start(Stage stage) {

        // MAIN MENU NÄKYMÄ
        BorderPane menu = new BorderPane();

        VBox buttons = new VBox();
        Button plus = new Button("Yhteenlaskut");
        Button minus = new Button("Vähennyslaskut");
        buttons.getChildren().add(plus);
        buttons.getChildren().add(minus);
        buttons.setSpacing(10);

        Label category = new Label("Valitse kategoria seuraavista:");
        
        menu.setBackground(new Background(new BackgroundFill(Color.SEASHELL, CornerRadii.EMPTY, Insets.EMPTY)));
        menu.setTop(category);
        menu.setCenter(buttons);

        Scene mainMenu = new Scene(menu);

        // SEURAAVA NÄKYMÄ VALINNAT
        Label instruction = new Label("Kirjoita ala- ja yläraja laskutoimituksien tekijöille:");
        Label lower = new Label("Alaraja: ");
        Label upper = new Label("Yläraja: ");
        TextField upperChoice = new TextField();
        TextField lowerChoice = new TextField();
        Button ok = new Button("OK");

        GridPane asettelu = new GridPane();

        asettelu.setBackground(new Background(new BackgroundFill(Color.SEASHELL, CornerRadii.EMPTY, Insets.EMPTY)));
        asettelu.add(instruction, 0, 0);
        asettelu.add(lower, 0, 1);
        asettelu.add(upper, 0, 2);
        asettelu.add(lowerChoice, 1, 1);
        asettelu.add(upperChoice, 1, 2);
        asettelu.add(ok, 1, 4);

        Scene selectionScene = new Scene(asettelu);

        plus.setOnAction((event) -> {
            stage.setScene(selectionScene);
        });
        minus.setOnAction((event) -> {
            stage.setScene(selectionScene);
        });

        // EXAM NÄKYMÄ
        BorderPane adjustment = new BorderPane();
        Exam exam = new Exam();
//        int upperInt = Integer.parseInt(upperChoice.getText());
//        int lowerInt = Integer.parseInt(lowerChoice.getText());

        Label rules = new Label("Tee seuraavat tehtävät. Kun olet valmis, paina OK!");
        Button ready = new Button("OK");
        GridPane questions = new GridPane();
        exam.createPlusExam();
        ArrayList<Question> questionsArray = exam.getQuestions();
        for (int i = 0; i < questionsArray.size(); i++) {
            Label question = new Label(questionsArray.get(i).questionString());
            questions.add(question, 0, i);
            TextField answer = new TextField();
            questions.add(answer, 1, i);
        }

        adjustment.setTop(rules);
        adjustment.setCenter(questions);
        adjustment.setBottom(ready);
        adjustment.setBackground(new Background(new BackgroundFill(Color.PAPAYAWHIP, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene examScene = new Scene(adjustment);

        ok.setOnAction((event) -> {
//          exam.setLimits(upperInt, lowerInt);
            stage.setScene(examScene);
        });

//        
//        
//
        stage.setTitle("MatikkaPeli");
        stage.setScene(mainMenu);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

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

    Exam exam;

    public void init() {
        this.exam = new Exam();
    }

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

        GridPane grid = new GridPane();

        grid.setBackground(new Background(new BackgroundFill(Color.SEASHELL, CornerRadii.EMPTY, Insets.EMPTY)));
        grid.add(instruction, 0, 0);
        grid.add(lower, 0, 1);
        grid.add(upper, 0, 2);
        grid.add(lowerChoice, 1, 1);
        grid.add(upperChoice, 1, 2);
        grid.add(ok, 1, 4);

        Scene selectionScene = new Scene(grid);

        plus.setOnAction((event) -> {
            exam.setToPlusMode();
            stage.setScene(selectionScene);
        });
        minus.setOnAction((event) -> {
            exam.setToMinusMode();
            stage.setScene(selectionScene);
        });

        // EXAM NÄKYMÄ PLUS
        BorderPane adjustmentPlus = new BorderPane();

        Label rules = new Label("Tee seuraavat tehtävät. Kun olet valmis, paina OK!");
        Button ready = new Button("OK");
        GridPane plusQuestions = new GridPane();

        adjustmentPlus.setTop(rules);
        adjustmentPlus.setCenter(plusQuestions);
        adjustmentPlus.setBottom(ready);
        adjustmentPlus.setBackground(new Background(new BackgroundFill(Color.PAPAYAWHIP, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene examScenePlus = new Scene(adjustmentPlus);

        // EXAM NÄKYMÄ MINUS
        BorderPane adjustmentMinus = new BorderPane();

        Label rules2 = new Label("Tee seuraavat tehtävät. Kun olet valmis, paina OK!");
        Button readyMinus = new Button("OK");
        GridPane minusQuestions = new GridPane();

        adjustmentMinus.setTop(rules2);
        adjustmentMinus.setCenter(minusQuestions);
        adjustmentMinus.setBottom(readyMinus);
        adjustmentMinus.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene examSceneMinus = new Scene(adjustmentMinus);

        // 
        ok.setOnAction((event) -> {

            exam.setLimits(upperChoice.getText(), lowerChoice.getText());
            // Ennen jatkoa täytyy tarkistaa virheet

            ArrayList<Question> questionsList = exam.createAndGetQuestions();

            if (exam.getMode().equals("minus")) {

                for (int i = 0; i < questionsList.size(); i++) {
                    Label question = new Label(questionsList.get(i).questionString());
                    minusQuestions.add(question, 0, i);
                    TextField answer = new TextField();
                    minusQuestions.add(answer, 1, i);
                }
                stage.setScene(examSceneMinus);
            } else if (exam.getMode().equals("plus")) {

                for (int i = 0; i < questionsList.size(); i++) {
                    Label question = new Label(questionsList.get(i).questionString());
                    plusQuestions.add(question, 0, i);
                    TextField answer = new TextField();
                    plusQuestions.add(answer, 1, i);
                }
                stage.setScene(examScenePlus);
            }

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

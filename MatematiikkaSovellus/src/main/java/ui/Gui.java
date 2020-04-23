package ui;

/**
 * Tämä luokka on graafinen käyttöliittymä.
 *
 * @author heiniauvinen
 */
import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.Exam;
import logic.Examiner;
import logic.Question;

public class Gui extends Application {

    Exam exam;
    Examiner examiner;
    ArrayList<String> studentAnswers;
    ArrayList<TextField> textStudentAnswers;
    ArrayList<Label> questionLabels;
    private final StringProperty theResult = new SimpleStringProperty();

    @Override
    public void init() {
        this.exam = new Exam();
        this.examiner = new Examiner();
        this.studentAnswers = new ArrayList();
        this.theResult.set("");
        this.questionLabels = new ArrayList();

    }

    @Override
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
        Label numberOfQ = new Label("Kysymysten lukumäärä (1-20): ");
        TextField upperChoice = new TextField();
        TextField lowerChoice = new TextField();
        TextField numberOfQuestions = new TextField();
        Button ok = new Button("OK");

        GridPane grid = new GridPane();

        grid.setBackground(new Background(new BackgroundFill(Color.SEASHELL, CornerRadii.EMPTY, Insets.EMPTY)));
        grid.add(instruction, 0, 0);
        grid.add(lower, 0, 1);
        grid.add(upper, 0, 2);
        grid.add(numberOfQ, 0, 3);
        grid.add(lowerChoice, 1, 1);
        grid.add(upperChoice, 1, 2);
        grid.add(numberOfQuestions, 1, 3);
        grid.add(ok, 1, 5);

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
        Button readyPlus = new Button("OK");
        Button backToSelectionPlus = new Button("Takaisin valintaan.");
        HBox plusButtons = new HBox();
        Label resultPlus = new Label("tulos");
        resultPlus.textProperty().bind(theResult);
        plusButtons.getChildren().add(readyPlus);
        plusButtons.getChildren().add(resultPlus);
        plusButtons.getChildren().add(backToSelectionPlus);
        plusButtons.setSpacing(50);
        GridPane plusQuestions = new GridPane();

        adjustmentPlus.setTop(rules);
        adjustmentPlus.setCenter(plusQuestions);
        adjustmentPlus.setBottom(plusButtons);
        adjustmentPlus.setBackground(new Background(new BackgroundFill(Color.PAPAYAWHIP, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene examScenePlus = new Scene(adjustmentPlus);

        // EXAM NÄKYMÄ MINUS
        BorderPane adjustmentMinus = new BorderPane();

        Label rulesMinus = new Label("Tee seuraavat tehtävät. Kun olet valmis, paina OK!");
        Button readyMinus = new Button("OK");
        Button backToSelectionMinus = new Button("Takaisin valintaan.");
        HBox minusButtons = new HBox();
        Label resultMinus = new Label("tulos");
        resultMinus.textProperty().bind(theResult);
        minusButtons.getChildren().add(readyMinus);
        minusButtons.getChildren().add(resultMinus);
        minusButtons.getChildren().add(backToSelectionMinus);
        minusButtons.setSpacing(50);

        GridPane minusQuestions = new GridPane();

        adjustmentMinus.setTop(rulesMinus);
        adjustmentMinus.setCenter(minusQuestions);
        adjustmentMinus.setBottom(minusButtons);
        adjustmentMinus.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene examSceneMinus = new Scene(adjustmentMinus);

        // 
        ok.setOnAction((event) -> {
            exam.setNumberOfQuestions(numberOfQuestions.getText());
            exam.setLimits(upperChoice.getText(), lowerChoice.getText());
            // Ennen jatkoa täytyy tarkistaa virheet

            ArrayList<Question> questionsList = exam.createAndGetQuestions();
            this.textStudentAnswers = new ArrayList();
            theResult.set("");
            questionLabels = new ArrayList();

            if (exam.getMode().equals("minus")) {

                for (int i = 0; i < questionsList.size(); i++) {
                    Label question = new Label(questionsList.get(i).questionString());
                    questionLabels.add(question);
                    minusQuestions.add(question, 0, i);
                    TextField answer = new TextField();
                    textStudentAnswers.add(answer);
                    minusQuestions.add(answer, 1, i);
                }
                stage.setScene(examSceneMinus);

            } else if (exam.getMode().equals("plus")) {

                for (int i = 0; i < questionsList.size(); i++) {
                    Label question = new Label(questionsList.get(i).questionString());
                    questionLabels.add(question);
                    plusQuestions.add(question, 0, i);
                    TextField answer = new TextField();
                    textStudentAnswers.add(answer);
                    plusQuestions.add(answer, 1, i);
                }
                stage.setScene(examScenePlus);
            }

        });

// OK napit näyttävät tulokset
        readyMinus.setOnAction((event) -> {
            this.studentAnswers = new ArrayList();
            for (int i = 0; i < exam.getQuestions().size(); i++) {
                String answer = textStudentAnswers.get(i).getText();
                studentAnswers.add(answer);
            }
            theResult.set(String.valueOf(examiner.checkExam(studentAnswers, exam)) + "/" + exam.getNumberOfQuestions());
        });
        readyPlus.setOnAction((event) -> {
            this.studentAnswers = new ArrayList();
            for (int i = 0; i < exam.getQuestions().size(); i++) {
                String answer = textStudentAnswers.get(i).getText();
                studentAnswers.add(answer);
            }
            theResult.set(String.valueOf(examiner.checkExam(studentAnswers, exam)) + "/" + exam.getNumberOfQuestions());
        });

// Takaisin valintaan nappien toiminta
        backToSelectionMinus.setOnAction((event) -> {
            questionLabels.forEach((question) -> {
                minusQuestions.getChildren().remove(question);
            });
            stage.setScene(mainMenu);
        });
        backToSelectionPlus.setOnAction((event) -> {
            questionLabels.forEach((question) -> {
                plusQuestions.getChildren().remove(question);
            });
            stage.setScene(mainMenu);
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

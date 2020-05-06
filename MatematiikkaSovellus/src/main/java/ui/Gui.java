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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.Exam;
import logic.Examiner;
import logic.PersonalExam;
import logic.PersonalExaminer;
import logic.Question;

public class Gui extends Application {

    Exam exam;
    Examiner examiner;
    PersonalExam personalExam;
    ArrayList<String> studentAnswers;
    ArrayList<TextField> textStudentAnswers;
    ArrayList<TextArea> textAreaStudentAnswers;
    ArrayList<Label> questionLabels;
    private final StringProperty theResult = new SimpleStringProperty();
    private final StringProperty thePersonalResult = new SimpleStringProperty();
    private final StringProperty personalExamAlert = new SimpleStringProperty();

    @Override
    public void init() {
        this.exam = new Exam();
        this.examiner = new Examiner();
        this.personalExam = new PersonalExam();
        this.studentAnswers = new ArrayList();
        this.textStudentAnswers = new ArrayList();
        this.theResult.set("");
        this.thePersonalResult.set("");
        this.questionLabels = new ArrayList();

    }

    @Override
    public void start(Stage stage) {

        BorderPane menu = new BorderPane();

        VBox buttons = new VBox();
        Label description1 = new Label("Harjoittele yhteen- tai vähennyslaskuja:");
        Button plus = new Button("Yhteenlaskut");
        Button minus = new Button("Vähennyslaskut");
        Label description2 = new Label("Luo ja tee oma koe:");
        Button personalExamButton = new Button("Aloita oma koe");
        Button createQuestionButton = new Button("Luo oma kysymys");
        buttons.getChildren().add(description1);
        buttons.getChildren().add(plus);
        buttons.getChildren().add(minus);
        buttons.getChildren().add(description2);
        buttons.getChildren().add(personalExamButton);
        buttons.getChildren().add(createQuestionButton);
        buttons.setSpacing(15);

        Label category = new Label("Valitse kategoria seuraavista:");
        category.setFont(new Font("Arial", 17));

        menu.setBackground(new Background(new BackgroundFill(Color.SEASHELL, CornerRadii.EMPTY, Insets.EMPTY)));
        menu.setTop(category);
        menu.setCenter(buttons);

        Scene mainMenu = new Scene(menu);

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

        BorderPane personalPane = new BorderPane();

        Label rulesPersonal = new Label("Tee seuraavat tehtävät. Kun olet valmis, paina OK!");
        Button readyPersonal = new Button("OK");
        Button backToSelectionPersonal = new Button("Takaisin valintaan.");
        HBox personalButtons = new HBox();
        Label resultPersonal = new Label("tulos");
        resultPersonal.textProperty().bind(thePersonalResult);
        personalButtons.getChildren().add(readyPersonal);
        personalButtons.getChildren().add(resultPersonal);
        personalButtons.getChildren().add(backToSelectionPersonal);
        personalButtons.setSpacing(50);

        GridPane personalQuestions = new GridPane();

        personalPane.setTop(rulesPersonal);
        personalPane.setCenter(personalQuestions);
        personalPane.setBottom(personalButtons);
        personalPane.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene examScenePersonal = new Scene(personalPane);

        Label instructionPersonal = new Label("Kirjoita oma kysymys-vastaus -pari ja paina tallenna.");
        TextArea questionTextArea = new TextArea();
        questionTextArea.setPrefHeight(100);
        questionTextArea.setPrefWidth(400);
        TextArea answerTextArea = new TextArea();
        answerTextArea.setPrefHeight(100);
        answerTextArea.setPrefWidth(400);
        Button saveQuestionToDb = new Button("Tallenna kysymys.");
        Tooltip questionTip = new Tooltip();
        questionTip.setText("\nKirjoita kysymyksen teksti tähän.\n");
        questionTextArea.setTooltip(questionTip);
        Tooltip answerTip = new Tooltip();
        answerTip.setText("\nKirjoita vastauksen teksti tähän.\n");
        answerTextArea.setTooltip(answerTip);
        Button backToSelectionFromDbSave = new Button("Takaisin valintaan.");
        GridPane gridPersonal = new GridPane();

        gridPersonal.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        gridPersonal.add(instructionPersonal, 0, 0);
        gridPersonal.add(questionTextArea, 0, 2);
        gridPersonal.add(answerTextArea, 1, 2);
        gridPersonal.add(saveQuestionToDb, 0, 4);
        Label alertLabel = new Label("");
        alertLabel.textProperty().bind(personalExamAlert);
        gridPersonal.add(alertLabel, 0, 5);
        gridPersonal.add(backToSelectionFromDbSave, 0, 6);

        Scene personalQuestionScene = new Scene(gridPersonal);

        createQuestionButton.setOnAction((event) -> {
            stage.setScene(personalQuestionScene);
        });

        saveQuestionToDb.setOnAction((event) -> {
            String alert = personalExam.saveToDatabase(questionTextArea.getText(), answerTextArea.getText());
            personalExamAlert.set(alert);
            questionTextArea.setText("");
            answerTextArea.setText("");

        });
        backToSelectionFromDbSave.setOnAction((event) -> {
            stage.setScene(mainMenu);
        });

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

        personalExamButton.setOnAction((event) -> {
            ArrayList<Question> questionsList = personalExam.getNewQuestions();
            this.textAreaStudentAnswers = new ArrayList();
            thePersonalResult.set("");
            questionLabels = new ArrayList();

            for (int i = 0; i < questionsList.size(); i++) {
                Label question = new Label(questionsList.get(i).getQuestionText());
                questionLabels.add(question);
                personalQuestions.add(question, 0, i);
                TextArea answer = new TextArea();
                answer.setPrefHeight(50);
                answer.setPrefWidth(400);
                textAreaStudentAnswers.add(answer);
                personalQuestions.add(answer, 2, i);
            }
            stage.setScene(examScenePersonal);

        });

        ok.setOnAction((event) -> {
            exam.setNumberOfQuestions(numberOfQuestions.getText());
            exam.setLimits(upperChoice.getText(), lowerChoice.getText());

            ArrayList<Question> questionsList = exam.createAndGetQuestions();
            textStudentAnswers = new ArrayList();
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
        readyPersonal.setOnAction((event) -> {
            this.studentAnswers = new ArrayList();
            for (int i = 0; i < personalExam.getCurrentExamQuestions().size(); i++) {
                String answer = textAreaStudentAnswers.get(i).getText();
                studentAnswers.add(answer);
            }
            thePersonalResult.set(String.valueOf((PersonalExaminer.checkExam(personalExam, studentAnswers)) + "/" + personalExam.getNumberOfCurrentExamQuestions()));

        });

        backToSelectionMinus.setOnAction((event) -> {
            questionLabels.forEach((question) -> {
                minusQuestions.getChildren().remove(question);
            });
            textStudentAnswers.forEach((answer) -> {
                minusQuestions.getChildren().remove(answer);
            });
            stage.setScene(mainMenu);
        });
        backToSelectionPlus.setOnAction((event) -> {
            questionLabels.forEach((question) -> {
                plusQuestions.getChildren().remove(question);
            });
            textStudentAnswers.forEach((answer) -> {
                plusQuestions.getChildren().remove(answer);
            });
            stage.setScene(mainMenu);
        });
        backToSelectionPersonal.setOnAction((event) -> {
            questionLabels.forEach((question) -> {
                personalQuestions.getChildren().remove(question);
            });
            textAreaStudentAnswers.forEach((answer) -> {
                personalQuestions.getChildren().remove(answer);
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

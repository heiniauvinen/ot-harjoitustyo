package logic;

import java.util.ArrayList;

/**
 * Tämä luokka on kokeiden tarkistusta varten.
 *
 * @author heiniauvinen
 */
public class Examiner {

    ArrayList<Integer> answers;

    public Examiner() {
        this.answers = new ArrayList<>();
    }

    /**
     * Tarkistaa kokeen vertailemalla oikeita vastauksia käyttäjän vastauksiin.
     *
     * @param studentAnswers Käyttäjän vastaukset.
     * @param exam Koe, jota tarkistetaan.
     * @return Oikeiden vastausten lukumäärä (int).
     */
    public int checkExam(ArrayList<String> studentAnswers, Exam exam) {
        int numberOfRightAnswers = 0;
        convertAnswersToInt(studentAnswers);
        ArrayList<Question> questions = exam.getQuestions();
        for (int i = 0; i < exam.numberOfQuestions; i++) {
            Integer answer = answers.get(i);
            if (answer != null && answer == questions.get(i).getResult()) {
                numberOfRightAnswers++;
            }
        }
        return numberOfRightAnswers;
    }

    /**
     * Muuttaa käyttäjältä tulleen vastauksen merkkijonosta Integeriksi poistaen
     * ensin alusta ja lopusta välilyönnit.
     *
     * @param studentAnswers Merkkijonoja sisältävä lista käyttäjän
     * vastauksista.
     * @param index Vastauksen indeksi listalla.
     * @return Kyseisessä indeksissä oleva merkkijono muutettuna Integeriksi.
     * Jos ei ole kokonaisluku, palautetaan null.
     */
    public Integer convertToInteger(ArrayList<String> studentAnswers, int index) {
        try {
            Integer number = Integer.parseInt(studentAnswers.get(index).trim());
            return number;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Muodostaa listan vastauksista tämän luokan luokkamuuttujaan ArrayList
     * Integer answers.
     *
     * @param studentAnswers Merkkijonoja sisältävä lista käyttäjän
     * vastauksista.
     */
    public void convertAnswersToInt(ArrayList<String> studentAnswers) {
        this.answers = new ArrayList<>();
        for (int i = 0; i < studentAnswers.size(); i++) {
            Integer number = convertToInteger(studentAnswers, i);
            answers.add(number);
        }
    }

}

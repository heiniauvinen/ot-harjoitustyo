package logic;

/**
 * Tämä luokka on kysymysten hallinnointia varten.
 *
 * @author heiniauvinen
 */
public class Question {

    int left;
    int right;
    int result;
    String type;
    String answerText;
    String questionText;

    /**
     * Luo uuden Question-olion.
     *
     * @param left Kysymyksen vasen operandi.
     * @param right Kysymyksen oikea operandi.
     * @param result Kysymyksen vastaus.
     * @param type Operaation tyyppi.
     */
    public Question(int left, int right, int result, String type) {
        this.left = left;
        this.right = right;
        this.result = result;
        this.type = type;
        this.answerText = String.valueOf(result);
    }

    /**
     * Luo uuden Question olion käyttäjän itse luomasta kysymys-vastaus parista.
     *
     * @param questionText Merkkijonona kysymys.
     * @param answerText Merkkijonona vastaus.
     */
    public Question(String questionText, String answerText) {
        this.answerText = answerText.trim();
        this.questionText = questionText.trim();
        this.type = "general";
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return left + " " + type + " " + right + " = " + result;
    }

    /**
     * Antaa Question olion kirjoitusasun ilman vastausta.
     *
     * @return Olion kirjoitusasu.
     */
    public String questionString() {
        if (!type.equals("general")) {
            return left + " " + type + " " + right + " = ";
        } else {
            return questionText;
        }
    }

    public String getAnswerText() {
        return this.answerText;
    }

    public String getQuestionText() {
        return questionString();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author heiniauvinen
 */
public class Question {

    int left;
    int right;
    int result;
    String type;

    public Question(int left, int right, int result, String type) {
        this.left = left;
        this.right = right;
        this.result = result;
        this.type = type;
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

    public String questionString() {
        return left + " " + type + " " + right + " = ";
    }

}

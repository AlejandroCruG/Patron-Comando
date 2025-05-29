/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron.comando;
import javax.swing.*;
/**
 *
 * @author DELL
 */
public class Editor {
     private JTextField textField;
    private String selection = "";

    public void setTextField(JTextField field) {
        this.textField = field;
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String text) {
        textField.setText(text);
    }

    public void updateSelection() {
        int start = textField.getSelectionStart();
        int end = textField.getSelectionEnd();
        selection = textField.getText().substring(start, end);
    }

    public String getSelection() {
        return selection;
    }

    public void deleteSelection() {
        int start = textField.getSelectionStart();
        int end = textField.getSelectionEnd();
        String text = textField.getText();
        textField.setText(text.substring(0, start) + text.substring(end));
    }

    public void replaceSelection(String newText) {
        int start = textField.getSelectionStart();
        int end = textField.getSelectionEnd();
        String text = textField.getText();
        textField.setText(text.substring(0, start) + newText + text.substring(end));
    }
}

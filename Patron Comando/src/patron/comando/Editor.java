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
    private JTextArea textArea;
    private String selection="";
    private String backup="";

    public Editor(JTextArea textArea) {
        this.textArea = textArea;
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public String getSelection() {
        return selection;
    }
    
    public void setBackup(String newBackup){
        this.backup=newBackup;
    }
    
    public String getBackup(){
        return this.backup;
    }
    
    public void updateSelection(){
        int start = textArea.getSelectionStart();
        int end = textArea.getSelectionEnd();
        selection = textArea.getText().substring(start,end);
    }

    public void deleteSelection() {
        int start = textArea.getSelectionStart();
        int end = textArea.getSelectionEnd();
        String text=textArea.getText();
        textArea.setText(text.substring(0, start) + text.substring(end));
    }

    public void replaceSelection(String newText) {
        int start = textArea.getSelectionStart();
        int end = textArea.getSelectionEnd();
        String text = textArea.getText();
        textArea.setText(text.substring(0, start) + newText + text.substring(end));
    }
}

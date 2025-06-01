/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron.comando;
/**
 *
 * @author DELL
 */
public class PasteCommand implements Command {
    private Editor editor;
    private String contentToPaste;
    private String backup;

    public PasteCommand(Editor editor) {
        this.editor = editor;
        this.contentToPaste = editor.getBackup();
        
    }
    public void saveBackup(){
        backup=editor.getText();
    }

    @Override
    public void execute() {
        saveBackup();
        editor.replaceSelection(contentToPaste);
    }

    @Override
    public void undo() {
        editor.setText(backup);
    }
}

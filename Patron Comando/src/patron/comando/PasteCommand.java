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
    private Application app;
    private Editor editor;
    private String backup;

    public PasteCommand(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }

    private void saveBackup() {
        backup = editor.getText();
    }

    @Override
    public void execute() {
        saveBackup();
        editor.replaceSelection(app.getClipboard());
    }

    @Override
    public void undo() {
        editor.setText(backup);
    }
}

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
public class CopyCommand implements Command {
    private Application app;
    private Editor editor;

    public CopyCommand(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }

    @Override
    public void execute() {
        app.setClipboard(editor.getSelection());
    }

    @Override
    public void undo() {
        // Copy command does not modify the state
    }
}

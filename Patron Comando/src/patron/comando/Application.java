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
public class Application {
    private Editor activeEditor;
    private String clipboard;
    private CommandHistory history = new CommandHistory();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undo() {
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }

    public void setClipboard(String text) {
        clipboard = text;
    }

    public String getClipboard() {
        return clipboard;
    }

    public Editor getActiveEditor() {
        return activeEditor;
    }

    public void setActiveEditor(Editor editor) {
        this.activeEditor = editor;
    }
}

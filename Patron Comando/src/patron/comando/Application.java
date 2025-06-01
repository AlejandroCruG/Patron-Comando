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
    private CommandHistory history = new CommandHistory();
    private String clipboard = "";

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }
    public CommandHistory getHistory() {
        return history;
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command last = history.pop();
            last.undo();
        }
    }

    public String getClipboard() {
        return clipboard;
    }
    
    public void setClipboard(String text){
        this.clipboard=text;
    }
    
}

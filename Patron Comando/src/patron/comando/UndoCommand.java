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
public class UndoCommand implements Command {
     private Application app;

    public UndoCommand(Application app) {
        this.app = app;
    }

    @Override
    public void execute() {
        app.undo();
    }

    @Override
    public void undo() {
        // Comando Undo no necesita deshacerse
    }
}

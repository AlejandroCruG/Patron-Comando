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
public class CutCommand implements Command {
    private Editor editor;
  
    public CutCommand(Editor editor) {
        this.editor = editor;         
    }
    
    @Override
    public void execute() {
        editor.setBackup(editor.getSelection());    
        editor.deleteSelection();
    }

}

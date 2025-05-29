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
    private Application app;
    private Editor editor;
    private String backup;
    
    public CutCommand(Application app, Editor editor){
        this.app=app;
        this.editor=editor;
    }
    
    private void saveBackup(){
        backup=editor.getText();
    }
    
    @Override
    public void execute(){
        saveBackup();
        app.setClipboard(editor.getSelection());
        editor.deleteSelection();
    }
    
    @Override
    public void undo(){
        editor.setText(backup);
    }
}

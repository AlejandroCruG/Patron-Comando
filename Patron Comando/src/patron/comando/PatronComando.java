/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron.comando;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author DELL
 */
public class PatronComando {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Application app = new Application();
            Editor editor = new Editor();
            app.setActiveEditor(editor);

            JFrame frame = new JFrame("Editor con Patrón Command");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(450, 200);
            frame.setLayout(new BorderLayout());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // TextField (el editor visual)
            JTextField textField = new JTextField();
            editor.setTextField(textField);
            frame.add(textField, BorderLayout.NORTH);

            // Panel de botones
            JPanel panel = new JPanel();
            JButton cutButton = new JButton("Cortar");
            JButton copyButton = new JButton("Copiar");
            JButton pasteButton = new JButton("Pegar");
            JButton undoButton = new JButton("Deshacer");

            panel.add(copyButton);
            panel.add(cutButton);
            panel.add(pasteButton);
            panel.add(undoButton);
            frame.add(panel, BorderLayout.SOUTH);
            

            // Acción común para botones y shortcuts
            Runnable cutAction = () -> {
                editor.updateSelection();
                app.executeCommand(new CutCommand(app, editor));
            };
            Runnable copyAction = () -> {
                editor.updateSelection();
                app.executeCommand(new CopyCommand(app, editor));
            };
            Runnable pasteAction = () -> {
                editor.updateSelection();
                app.executeCommand(new PasteCommand(app, editor));
            };
            Runnable undoAction = app::undo;

            // Botones
            cutButton.addActionListener(e -> cutAction.run());
            copyButton.addActionListener(e -> copyAction.run());
            pasteButton.addActionListener(e -> pasteAction.run());
            undoButton.addActionListener(e -> undoAction.run());

            // Atajos de teclado
            InputMap inputMap = textField.getInputMap(JComponent.WHEN_FOCUSED);
            ActionMap actionMap = textField.getActionMap();

            inputMap.put(KeyStroke.getKeyStroke("control X"), "cut");
            inputMap.put(KeyStroke.getKeyStroke("control C"), "copy");
            inputMap.put(KeyStroke.getKeyStroke("control V"), "paste");
            inputMap.put(KeyStroke.getKeyStroke("control Z"), "undo");

            actionMap.put("cut", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cutAction.run();
                }
            });
            actionMap.put("copy", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    copyAction.run();
                }
            });
            actionMap.put("paste", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pasteAction.run();
                }
            });
            actionMap.put("undo", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    undoAction.run();
                }
            });

            frame.setVisible(true);
        });
    }
    
}

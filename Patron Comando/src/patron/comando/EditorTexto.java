/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron.comando;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author DELL
 */
public class EditorTexto {

    private static Editor editor;
    private static Application app;
    
    private static CutCommand cut;
    private static CopyCommand copy;
    private static PasteCommand paste;
    

    public EditorTexto(){

    }

    public static void main(String[] args) {
        

        SwingUtilities.invokeLater(EditorTexto::createUI);
    }

    public static void createUI(){


            JFrame frame = new JFrame("Editor con Patrón Command");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // TextField (el editor visual)
            JTextArea textArea = new JTextArea();
            JTextArea areaClipboard = new JTextArea(5,20);
           

            areaClipboard.setEditable(false);
            editor = new Editor();
            editor.setTextArea(textArea);
            copy = new CopyCommand(editor);
            cut =new CutCommand(editor);
            paste = new PasteCommand(editor);
            app= new Application();
            
            frame.add(textArea, BorderLayout.NORTH);

            JLabel labelInput = new JLabel("Texto Principal");
            JLabel labelClipboard = new JLabel("Clipboard");
           

            // === Panel superior con input ===
            JPanel panelInput = new JPanel(new BorderLayout());
            panelInput.add(labelInput, BorderLayout.NORTH);
            panelInput.add(new JScrollPane(textArea), BorderLayout.CENTER);

            // === Panel inferior con clipboard e historial ===
            JPanel panelInfo = new JPanel(new GridLayout(1, 2));
            JPanel clipboardPanel = new JPanel(new BorderLayout());
            clipboardPanel.add(labelClipboard, BorderLayout.NORTH);
            clipboardPanel.add(new JScrollPane(areaClipboard), BorderLayout.CENTER);

            panelInfo.add(clipboardPanel);

            // === Botones ===
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JButton cutButton = new JButton("Cortar");
            JButton copyButton = new JButton("Copiar");
            JButton pasteButton = new JButton("Pegar");

            panel.add(copyButton);
            panel.add(cutButton);
            panel.add(pasteButton);
          
            // === Acciones ===
            Runnable actualizarVistas = () -> {
                areaClipboard.setText(editor.getBackup());
            };
            Action doCopy = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    editor.updateSelection();


                    app.setCommand(copy);
                    app.executeCommand();

                    actualizarVistas.run();
                }
            };

            Action doCut = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    editor.updateSelection();

                    app.setCommand(cut);
                    app.executeCommand();

                    actualizarVistas.run();
                }
            };

            Action doPaste = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {

                   // editor.updateSelection();

                    app.setCommand(paste);
                    app.executeCommand();
                    actualizarVistas.run();
                }
            };


            // Botones
            copyButton.addActionListener(doCopy);
            cutButton.addActionListener(doCut);
            pasteButton.addActionListener(doPaste);
 

            // Atajos de teclado
            InputMap inputMap = textArea.getInputMap(JComponent.WHEN_FOCUSED);
            ActionMap actionMap = textArea.getActionMap();

            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK), "copy");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK), "cut");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK), "paste");

            actionMap.put("copy", doCopy);
            actionMap.put("cut", doCut);
            actionMap.put("paste", doPaste);

            // === Layout general ===
            frame.setLayout(new BorderLayout());
            frame.add(panelInput, BorderLayout.CENTER);
            frame.add(panelInfo, BorderLayout.SOUTH);
            frame.add(panel, BorderLayout.NORTH);
            frame.setVisible(true);

            copyButton.setBackground(new Color(204, 255, 204)); // verde claro
            cutButton.setBackground(new Color(255, 204, 204)); // rojo claro
            pasteButton.setBackground(new Color(204, 229, 255)); // azul claro
    }

    
}

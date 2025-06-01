/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron.comando;

import java.util.Stack;
/**
 *
 * @author DELL
 */
public class CommandHistory {
     private Stack<Command> history = new Stack<>();

    public void push(Command c) {
        history.push(c);
    }

    public Command pop() {
        return history.pop();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Command cmd : history) {
            sb.append(cmd.getClass().getSimpleName()).append("\n");
        }
        return sb.toString();
    }

    public boolean isEmpty() { return history.isEmpty(); }
}

package com.smarthome.behavioral.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandHistory {
    private final Deque<Command> stack=new ArrayDeque<>();
    public void push(Command c){ stack.push(c); }
    public void undoLast(){ if(!stack.isEmpty()) stack.pop().undo(); }
}

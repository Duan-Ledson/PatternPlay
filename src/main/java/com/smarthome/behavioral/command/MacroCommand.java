// MacroCommand e CommandHistory (histórico)
package com.smarthome.behavioral.command;
import java.util.*;
public class MacroCommand implements Command {
    private final String name; private final List<Command> list=new ArrayList<>();
    public MacroCommand(String n){ this.name=n; }
    public MacroCommand add(Command c){ list.add(c); return this; }
    public void execute(){ list.forEach(Command::execute); }
    public void undo(){ for(int i=list.size()-1;i>=0;i--) list.get(i).undo(); }
    public String label(){ return "Macro("+name+")"; }
}

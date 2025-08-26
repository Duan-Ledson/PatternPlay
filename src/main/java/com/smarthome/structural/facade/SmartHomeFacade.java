// com.smarthome.structural.facade.SmartHomeFacade
package com.smarthome.structural.facade;
import com.smarthome.behavioral.command.*;
import com.smarthome.common.Device;
import com.smarthome.common.Logger;
public class SmartHomeFacade {
    private final CommandHistory history = new CommandHistory();
    private void exec(Command c){ Logger.info("EXEC → "+c.label()); c.execute(); history.push(c); }
    public void goodMorning(Device... devices){ MacroCommand m=new MacroCommand("GoodMorning"); for(Device d:devices) m.add(new TurnOnCommand(d)); exec(m); }
    public void goodNight(Device... devices){ MacroCommand m=new MacroCommand("GoodNight"); for(Device d:devices) m.add(new TurnOffCommand(d)); exec(m); }
    public void undoLast(){ history.undoLast(); }
}

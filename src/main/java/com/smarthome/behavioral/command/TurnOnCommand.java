// TurnOn, TurnOff — usam Device
package com.smarthome.behavioral.command;
import com.smarthome.common.Device;
public class TurnOnCommand implements Command {
    private final Device device;
    public TurnOnCommand(Device d){ this.device=d; }
    public void execute(){ device.on(); }
    public void undo(){ device.off(); }
    public String label(){ return "TurnOn("+device.name()+")"; }
}

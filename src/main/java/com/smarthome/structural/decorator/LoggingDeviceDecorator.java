// com.smarthome.structural.decorator.LoggingDeviceDecorator
package com.smarthome.structural.decorator;
import com.smarthome.common.Device;
import com.smarthome.common.Logger;
public class LoggingDeviceDecorator extends DeviceDecorator {
    public LoggingDeviceDecorator(Device d){ super(d); }
    public void on(){ Logger.info("[Decor] before ON: "+name()); inner.on(); }
    public void off(){ Logger.info("[Decor] before OFF: "+name()); inner.off(); }
}

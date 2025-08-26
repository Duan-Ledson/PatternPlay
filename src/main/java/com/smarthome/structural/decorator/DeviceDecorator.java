// com.smarthome.structural.decorator.DeviceDecorator
package com.smarthome.structural.decorator;
import com.smarthome.common.Device;
public abstract class DeviceDecorator implements Device {
    protected final Device inner;
    protected DeviceDecorator(Device d){ this.inner=d; }
    public String id(){ return inner.id(); }
    public String name(){ return inner.name(); }
    public boolean isOn(){ return inner.isOn(); }
}

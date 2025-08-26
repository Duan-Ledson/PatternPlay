// com.smarthome.structural.adapter.HueLightAdapter
package com.smarthome.structural.adapter;
import com.smarthome.common.Device;
import com.smarthome.common.Logger;
public class HueLightAdapter implements Device {
    private final ThirdPartyHueLight light;
    public HueLightAdapter(String id,String name){ this.light=new ThirdPartyHueLight(id,name); }
    public String id(){ return light.getUuid(); }
    public String name(){ return light.getLabel(); }
    public void on(){ light.powerOn(); Logger.info(name()+" → ON"); }
    public void off(){ light.powerOff(); Logger.info(name()+" → OFF"); }
    public boolean isOn(){ return light.status(); }
}

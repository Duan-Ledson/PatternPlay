// com.smarthome.structural.adapter.ThirdPartyHueLight
package com.smarthome.structural.adapter;
public class ThirdPartyHueLight {
    private boolean power; private final String uuid, label;
    public ThirdPartyHueLight(String uuid,String label){ this.uuid=uuid; this.label=label; }
    public void powerOn(){ power=true; }
    public void powerOff(){ power=false; }
    public boolean status(){ return power; }
    public String getUuid(){ return uuid; }
    public String getLabel(){ return label; }
}

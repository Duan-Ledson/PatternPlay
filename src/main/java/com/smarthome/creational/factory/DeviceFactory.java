// com.smarthome.creational.factory.DeviceFactory
package com.smarthome.creational.factory;
import com.smarthome.common.Device;
import com.smarthome.structural.adapter.HueLightAdapter;
public class DeviceFactory {
    public static Device create(String type,String id,String name){
        return switch(type.toLowerCase()){
            case "light" -> new HueLightAdapter(id,name);
            default -> throw new IllegalArgumentException("Unknown device: "+type);
        };
    }
}

// com.smarthome.creational.singleton.ConfigCenter
package com.smarthome.creational.singleton;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
public final class ConfigCenter {
    private static volatile ConfigCenter INSTANCE;
    private final Map<String,String> values = new ConcurrentHashMap<>();
    private ConfigCenter(){}
    public static ConfigCenter getInstance(){
        if(INSTANCE==null){
            synchronized(ConfigCenter.class){
                if(INSTANCE==null) INSTANCE = new ConfigCenter();
            }
        }
        return INSTANCE;
    }
    public void set(String k,String v){ values.put(k,v); }
    public String get(String k,String def){ return values.getOrDefault(k,def); }
}

// com.smarthome.common.Device
package com.smarthome.common;
public interface Device {
    String id();
    String name();
    void on();
    void off();
    boolean isOn();
}

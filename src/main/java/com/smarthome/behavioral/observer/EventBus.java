// com.smarthome.behavioral.observer.EventBus
package com.smarthome.behavioral.observer;
import java.util.*;
import java.util.function.Consumer;
public class EventBus {
    private final List<Consumer<SensorEvent>> subs = new ArrayList<>();
    public void subscribe(Consumer<SensorEvent> c){ subs.add(c); }
    public void publish(SensorEvent e){ subs.forEach(s->s.accept(e)); }
}

// com.smarthome.creational.builder.AutomationRule (exemplo simples)
package com.smarthome.creational.builder;
import java.time.LocalTime;
public class AutomationRule {
    private final String name; private final LocalTime start; private final LocalTime end; private final String deviceId;
    private AutomationRule(Builder b){ name=b.name; start=b.start; end=b.end; deviceId=b.deviceId; }
    public static class Builder {
        private String name; private LocalTime start; private LocalTime end; private String deviceId;
        public Builder name(String n){ this.name=n; return this; }
        public Builder start(LocalTime s){ this.start=s; return this; }
        public Builder end(LocalTime e){ this.end=e; return this; }
        public Builder deviceId(String id){ this.deviceId=id; return this; }
        public AutomationRule build(){ return new AutomationRule(this); }
    }
    @Override public String toString(){ return "Rule["+name+" "+start+"-"+end+", device="+deviceId+"]"; }
}

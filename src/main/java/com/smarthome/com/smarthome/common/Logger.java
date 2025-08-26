// com.smarthome.common.Logger
package com.smarthome.common;
public final class Logger {
    private Logger(){}
    public static void info(String msg){ System.out.println("[INFO] "+msg); }
    public static void warn(String msg){ System.out.println("[WARN] "+msg); }
}

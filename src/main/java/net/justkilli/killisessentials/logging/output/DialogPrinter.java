package net.justkilli.killisessentials.logging.output;

import net.justkilli.killisessentials.logging.LogLevel;

import javax.swing.*;
import java.util.List;

public class DialogPrinter implements IOutputPrinter {
    @Override
    public void print(LogLevel level, List<String> message) {
        switch(level) {
            case INFO -> JOptionPane.showMessageDialog(null, String.join("\n", message), LogLevel.INFO.toString(), JOptionPane.INFORMATION_MESSAGE);
            case WARN -> JOptionPane.showMessageDialog(null, String.join("\n", message), LogLevel.WARN.toString(), JOptionPane.WARNING_MESSAGE);
            case ERROR -> JOptionPane.showMessageDialog(null, String.join("\n", message), LogLevel.ERROR.toString(), JOptionPane.ERROR_MESSAGE);
            case DEBUG -> JOptionPane.showMessageDialog(null, String.join("\n", message), LogLevel.DEBUG.toString(), JOptionPane.PLAIN_MESSAGE);
        }
    }

    @Override
    public void print(LogLevel level, String message) {
        print(level, List.of(message));
    }

    @Override
    public String format(LogLevel logLevel, String loggerName, List<String> message, Exception ex) {
        return String.join("\n", message);
    }

    @Override
    public String format(LogLevel logLevel, String loggerName, String message, Exception ex) {
        return message;
    }
}

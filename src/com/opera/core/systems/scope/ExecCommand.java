package com.opera.core.systems.scope;

import com.opera.core.systems.model.ICommand;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * This enum maps the commands for the Exec service.
 *
 * The declaration can be found here:
 * http://dragonfly.opera.com/app/scope-interface/Exec.html#error-handling
 * 
 */
public enum ExecCommand implements ICommand {
    EXEC(1), 
    GET_ACTION_LIST(2), 
    SETUP_SCREEN_WATCHER(3), 
    SEND_MOUSE_ACTION(5),
    DEFAULT(-1);

    private int code;
    private static final Map<Integer, ExecCommand> lookup = new HashMap<Integer, ExecCommand>();

    static {
        for (ExecCommand command : EnumSet.allOf(ExecCommand.class))
            lookup.put(command.getCommandID(), command);
    }

    private ExecCommand(int code) {
        this.code = code;
    }

    public int getCommandID() {
        return code;
    }

    public static ExecCommand get(int code) {
        ExecCommand command = lookup.get(code);
        if(command == null)
            return DEFAULT;
        return command;
    }

}
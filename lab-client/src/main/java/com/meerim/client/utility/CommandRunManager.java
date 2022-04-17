package com.meerim.client.utility;

import com.meerim.client.commands.Command;
import com.meerim.client.commands.CommandResult;

public class CommandRunManager {
    private final CommandManager commandManager;


    public CommandRunManager(CommandManager commandManager) {
        this.commandManager = commandManager;

    }

    public CommandResult runCommand(String name, String arg) {
        CommandResult commandResult = null;
        for (Command command : commandManager.getCommands()) {
            if (command.getName().equals(name)) {
                commandResult = command.execute(arg);
                break;
            }
        }
        if (commandResult == null) {
            return new CommandResult(false, "This command was not found. Please use \"help\" to know about available commands");
        }
        return commandResult;
    }
}

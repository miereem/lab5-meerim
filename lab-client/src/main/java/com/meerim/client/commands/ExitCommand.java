package com.meerim.client.commands;

public class ExitCommand extends Command {
    public ExitCommand() {
        super("exit");
    }

    @Override
    public CommandResult execute(String arg) {
        return new CommandResult(true, "Exiting...");
    }
}

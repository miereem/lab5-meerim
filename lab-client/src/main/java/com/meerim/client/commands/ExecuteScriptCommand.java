package com.meerim.client.commands;

import com.meerim.client.utility.UserInputManager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExecuteScriptCommand extends Command {

    private UserInputManager userInputManager;

    public ExecuteScriptCommand(UserInputManager userInputManager) {
        super("execute_script");
        this.userInputManager = userInputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        try {
            this.userInputManager.connectToFile(new File(arg));
            return new CommandResult(false, "Starting to execute script...");
        } catch (IOException e) {
            return new CommandResult(false, "There was a problem opening the file. Check if it is available and you have written it in the command arg correctly.");
        } catch (UnsupportedOperationException e) {
            return new CommandResult(false, e.getMessage());
        }
    }
}

package com.meerim.client;

import com.meerim.client.utility.OutputManager;
import com.meerim.client.utility.CollectionManager;
import com.meerim.client.utility.CommandManager;
import com.meerim.client.utility.CommandRunManager;
import com.meerim.client.utility.Console;
import com.meerim.client.utility.FileManager;
import com.meerim.client.utility.UserInputManager;
import com.meerim.client.utility.CollectionInfo;

import java.io.IOException;
import java.util.Scanner;

public final class Client {
    static final String ENVIRONMENT_VARIABLE = "PROG_PATH";

    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }


    public static void main(String[] args) {

        final OutputManager outputManager = new OutputManager();

        if (ENVIRONMENT_VARIABLE == null) {
            outputManager.println("Environment variable is null.");
            return;
        }
        final CollectionManager collectionManager = new CollectionManager();
        final FileManager fileManager = new FileManager(ENVIRONMENT_VARIABLE);
        final UserInputManager userInputManager = new UserInputManager(new Scanner(System.in));
        final CollectionInfo collectionInfo = new CollectionInfo(collectionManager);
        final CommandManager commandManager = new CommandManager(fileManager, userInputManager, collectionManager, outputManager, collectionInfo);
        final CommandRunManager commandRunManager = new CommandRunManager(commandManager);
        final Console console = new Console(fileManager,
                userInputManager, collectionManager, outputManager,
                commandRunManager);
        try {
            console.start();
        } catch (IllegalArgumentException e) {
            outputManager.println("The file does not keep data in correct format.");
        } catch (IOException e) {
            outputManager.println("Could not read the file. Check if it is available.");
        } catch (Exception e) {
            outputManager.println("Could not execute the program");
        }
    }
}

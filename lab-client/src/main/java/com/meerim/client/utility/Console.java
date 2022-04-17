package com.meerim.client.utility;



import com.meerim.client.commands.CommandResult;
import com.meerim.client.data.Dragon;

import java.io.IOException;
import java.util.Objects;
import java.util.LinkedHashSet;

public class Console {
    private final CommandRunManager commandRunManager;

    private final OutputManager outputManager;
    private final CollectionManager collectionManager;
    private final FileManager fileManager;
    private final UserInputManager userInputManager;

    public Console(FileManager fileManager, UserInputManager userInputManager,
                   CollectionManager collectionManager, OutputManager outputManager,
                   CommandRunManager commandRunManager) {
        this.fileManager = fileManager;
        this.userInputManager = userInputManager;
        this.collectionManager = collectionManager;
        this.outputManager = outputManager;
        this.commandRunManager = commandRunManager;
    }


    public void start() throws IllegalArgumentException, IOException {
        String stringData = fileManager.read();
        CSVParser parser = new CSVParser();
        LinkedHashSet<Dragon> dragons = parser.deserialize(stringData, Dragon.class);
        collectionManager.initialiseData(dragons);

        startCommandCycle();
    }


    private String[] parseToNameAndArg(String input) {
        String[] arrayInput = input.split(" ");
        String inputCommand = arrayInput[0];
        String inputArg = "";

        if (arrayInput.length >= 2) {
            inputArg = arrayInput[1];
        }

        return new String[]{inputCommand, inputArg};
    }

    private String readNextCommand() {
        outputManager.print(">>>");
        return userInputManager.nextLine();
    }

    private void startCommandCycle() {
        CommandResult commandResult;
        do {
            String name = "";
            String arg = "";
            String input = readNextCommand();
            String[] commandNameAndArg = parseToNameAndArg(input);
            if (commandNameAndArg.length >= 1) {
                name = commandNameAndArg[0];
            }
            if (commandNameAndArg.length >= 2) {
                arg = commandNameAndArg[1];
            }
            commandResult = commandRunManager.runCommand(name, arg);
            outputManager.println(commandResult.getOutput());
        } while (!Objects.requireNonNull(commandResult).isExit());
    }
}

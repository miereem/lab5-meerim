package com.meerim.client.utility;

import com.meerim.client.commands.HelpCommand;
import com.meerim.client.commands.AddCommand;
import com.meerim.client.commands.SaveCommand;
import com.meerim.client.commands.ShowCommand;
import com.meerim.client.commands.UpdateCommand;
import com.meerim.client.commands.RemoveByIdCommand;
import com.meerim.client.commands.ClearCommand;
import com.meerim.client.commands.ExecuteScriptCommand;
import com.meerim.client.commands.AddIfMinCommand;
import com.meerim.client.commands.RemoveGreaterCommand;
import com.meerim.client.commands.MinByIDCommand;
import com.meerim.client.commands.MinByCaveCommand;
import com.meerim.client.commands.AverageOfAgeCommand;
import com.meerim.client.commands.PrintAscendingCommand;
import com.meerim.client.commands.InfoCommand;
import com.meerim.client.commands.ExitCommand;
import com.meerim.client.commands.Command;


import java.util.HashSet;

/**
 * Class for storing commands objects.
 */
public class CommandManager {
    private final HashSet<Command> commands = new HashSet<>();

    public CommandManager(FileManager fileManager, UserInputManager userInputManager,
                          CollectionManager collectionManager, OutputManager outputManager) {
        commands.add(new HelpCommand());
        commands.add(new AddCommand(collectionManager, userInputManager, outputManager));
        commands.add(new SaveCommand(fileManager, collectionManager));
        commands.add(new ShowCommand(collectionManager));
        commands.add(new UpdateCommand(collectionManager, userInputManager, outputManager));
        commands.add(new RemoveByIdCommand(collectionManager));
        commands.add(new ClearCommand(collectionManager));
        commands.add(new ExecuteScriptCommand(userInputManager));
        commands.add(new AddIfMinCommand(collectionManager, userInputManager, outputManager));
        commands.add(new RemoveGreaterCommand(collectionManager, userInputManager, outputManager));
        commands.add(new MinByIDCommand(collectionManager));
        commands.add(new MinByCaveCommand(collectionManager));
        commands.add(new AverageOfAgeCommand(collectionManager));
        commands.add(new PrintAscendingCommand(collectionManager));
        commands.add(new InfoCommand(collectionManager));
        commands.add(new ExitCommand());
    }

    public HashSet<Command> getCommands() {
        return commands;
    }
}

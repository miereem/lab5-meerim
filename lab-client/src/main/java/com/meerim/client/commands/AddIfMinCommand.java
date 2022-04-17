package com.meerim.client.commands;

import com.meerim.client.data.Dragon;
import com.meerim.client.utility.OutputManager;
import com.meerim.client.utility.CollectionManager;
import com.meerim.client.utility.DragonMaker;
import com.meerim.client.utility.UserInputManager;

import java.util.Collections;


public class AddIfMinCommand extends Command {
    private final OutputManager outputManager;
    private final CollectionManager collectionManager;
    private final UserInputManager userInputManager;

    public AddIfMinCommand(CollectionManager collectionManager, UserInputManager userInputManager, OutputManager outputManager) {
        super("add_if_min");
        this.collectionManager = collectionManager;
        this.userInputManager = userInputManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        Dragon dragon = new DragonMaker(userInputManager, outputManager, collectionManager).makeDragon();

        if (collectionManager.getMainData().isEmpty() || dragon.compareTo(Collections.min(collectionManager.getMainData())) < 0) {
            collectionManager.getMainData().add(dragon);
            return new CommandResult(false, "The element was added successfully");
        } else {
            return new CommandResult(false, "The element was not min, so it was not added");
        }
    }
}

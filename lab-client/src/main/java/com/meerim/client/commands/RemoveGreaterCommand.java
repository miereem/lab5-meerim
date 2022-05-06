package com.meerim.client.commands;

import com.meerim.client.data.Dragon;
import com.meerim.client.utility.CollectionManager;
import com.meerim.client.utility.OutputManager;
import com.meerim.client.utility.DragonMaker;
import com.meerim.client.utility.UserInputManager;

public class RemoveGreaterCommand extends Command {

    private final OutputManager outputManager;
    private final CollectionManager collectionManager;
    private final UserInputManager userInputManager;

    public RemoveGreaterCommand(CollectionManager collectionManager, UserInputManager userInputManager, OutputManager outputManager) {
        super("remove_greater");
        this.outputManager = outputManager;
        this.collectionManager = collectionManager;
        this.userInputManager = userInputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        Dragon dragon = new DragonMaker(userInputManager, outputManager, collectionManager).makeDragon();
        collectionManager.removeGreater(dragon);
        return new CommandResult(false, "Greater elements were removed successfully");
    }
}

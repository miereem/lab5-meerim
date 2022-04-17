package com.meerim.client.commands;


import com.meerim.client.data.Dragon;
import com.meerim.client.utility.OutputManager;
import com.meerim.client.utility.CollectionManager;
import com.meerim.client.utility.DragonMaker;
import com.meerim.client.utility.UserInputManager;


public class AddCommand extends Command {
    private final UserInputManager userInputManager;
    private final OutputManager outputManager;
    private final CollectionManager collectionManager;

    public AddCommand(CollectionManager collectionManager, UserInputManager userInputManager, OutputManager outputManager) {
        super("add");
        this.collectionManager = collectionManager;
        this.userInputManager = userInputManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        Dragon dragon = new DragonMaker(userInputManager, outputManager, collectionManager).makeDragon();
        collectionManager.getMainData().add(dragon);
        return new CommandResult(false, "The element was added successfully");
    }
}

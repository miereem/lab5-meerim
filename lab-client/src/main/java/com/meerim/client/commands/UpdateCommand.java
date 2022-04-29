package com.meerim.client.commands;

import com.meerim.client.data.Dragon;
import com.meerim.client.utility.OutputManager;
import com.meerim.client.utility.CollectionManager;
import com.meerim.client.utility.DragonMaker;
import com.meerim.client.utility.UserInputManager;

public class UpdateCommand extends Command {

    private final OutputManager outputManager;
    private final UserInputManager userInputManager;
    private final CollectionManager collectionManager;

    public UpdateCommand(CollectionManager collectionManager, UserInputManager userInputManager, OutputManager outputManager) {
        super("update");
        this.userInputManager = userInputManager;
        this.collectionManager = collectionManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        int intArg;
        try {
            intArg = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            return new CommandResult(false, "Your argument was incorrect. The command was not executed.");
        }

        if (collectionManager.removeById(intArg)) {
            Dragon dragon = new DragonMaker(userInputManager, outputManager, collectionManager).makeDragon();
            collectionManager.removeId(dragon.getId());
            dragon.setId(intArg);
            collectionManager.add(dragon);
            return new CommandResult(false, "The element was updated successfully");
        } else {
            return new CommandResult(false, "Written id was not found. The command was not executed");
        }
    }
}

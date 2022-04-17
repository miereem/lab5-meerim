package com.meerim.client.commands;

import com.meerim.client.data.Dragon;
import com.meerim.client.utility.CollectionManager;

import java.util.StringJoiner;


public class ShowCommand extends Command {
    private final CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        super("show");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        StringJoiner output = new StringJoiner("\n\n");
        if (collectionManager.getMainData().isEmpty()) {
            return new CommandResult(false, "Collection is empty");
        }
        for (Dragon dragon : collectionManager.getMainData()) {
            output.add(dragon.toString());
        }

        return new CommandResult(false, output.toString());
    }
}

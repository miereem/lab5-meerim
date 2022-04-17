package com.meerim.client.commands;

import com.meerim.client.utility.CollectionManager;


import java.util.Collections;


public class InfoCommand extends Command {

    private final CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager) {
        super("info");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        if (!collectionManager.getMainData().isEmpty()) {
            return new CommandResult(false, "Collection type: " + collectionManager.getMainData().getClass().toString() + "\n"
                    + "Number of elements: " + collectionManager.getMainData().size() + "\n"
                    + "Creation date: " + collectionManager.getCreationDate() + "\n"
                    + "The oldest dragon in collection is " + Collections.max(collectionManager.getMainData()).getAge());
        } else {
            return new CommandResult(false, "Collection type: " + collectionManager.getMainData().getClass().toString() + "\n"
                    + "Number of elements: " + collectionManager.getMainData().size() + "\n"
                    + "Creation date: " + collectionManager.getCreationDate());
        }
    }
}

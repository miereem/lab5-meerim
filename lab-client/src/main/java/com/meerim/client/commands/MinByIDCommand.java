package com.meerim.client.commands;

import com.meerim.client.data.Dragon;
import com.meerim.client.utility.CollectionManager;



public class MinByIDCommand extends Command {

    private final CollectionManager collectionManager;

    public MinByIDCommand(CollectionManager collectionManager) {
        super("min_by_id");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {

        if (collectionManager.getMainData().isEmpty()) {
            return new CommandResult(false, "The method wasn't executed due to empty collection.");
        }

        Dragon minIdDragon = collectionManager.getMinId();
        return new CommandResult(false, minIdDragon.toString());
    }
}

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
        int minID = Integer.MAX_VALUE;
        Dragon minIdDragon = null;

        for (Dragon dragon : collectionManager.getMainData()) {
            if (minID > dragon.getId()) {
                minID = dragon.getId();
                minIdDragon = dragon;
            }
        }

        assert minIdDragon != null;
        return new CommandResult(false, minIdDragon.toString());
    }
}

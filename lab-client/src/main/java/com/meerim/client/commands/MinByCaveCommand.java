package com.meerim.client.commands;

import com.meerim.client.data.Dragon;
import com.meerim.client.utility.CollectionManager;



public class MinByCaveCommand extends Command {

    private final CollectionManager collectionManager;

    public MinByCaveCommand(CollectionManager collectionManager) {
        super("min_by_cave");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        float minCave = Integer.MAX_VALUE;
        Dragon minCaveDragon = null;

        for (Dragon dragon : collectionManager.getMainData()) {
            if (minCave > dragon.getCave()) {
                minCave = dragon.getCave();
                minCaveDragon = dragon;
            }
        }

        assert minCaveDragon != null;
        return new CommandResult(false, minCaveDragon.toString());
    }
}

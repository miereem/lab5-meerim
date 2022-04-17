package com.meerim.client.commands;

import com.meerim.client.data.Dragon;
import com.meerim.client.utility.CollectionManager;


public class AverageOfAgeCommand extends Command {

    private final CollectionManager collectionManager;

    public AverageOfAgeCommand(CollectionManager collectionManager) {
        super("average_of_age");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        int avAge = 0;

        for (Dragon dragon : collectionManager.getMainData()) {
            avAge = avAge + dragon.getAge();
        }
        avAge = avAge / collectionManager.getMainData().size();
        assert avAge != 0;
        return new CommandResult(false, String.valueOf(avAge));
    }
}

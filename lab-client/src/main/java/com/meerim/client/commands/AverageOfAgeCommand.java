package com.meerim.client.commands;


import com.meerim.client.utility.CollectionManager;


public class AverageOfAgeCommand extends Command {

    private final CollectionManager collectionManager;

    public AverageOfAgeCommand(CollectionManager collectionManager) {
        super("average_of_age");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        if (collectionManager.getMainData().isEmpty()) {
            return new CommandResult(false, "The method wasn't executed due to empty collection.");
        }
        return new CommandResult(false, String.valueOf(collectionManager.getAverage()));
    }
}

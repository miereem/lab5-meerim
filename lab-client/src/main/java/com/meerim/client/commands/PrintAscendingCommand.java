package com.meerim.client.commands;

import com.meerim.client.data.Dragon;
import com.meerim.client.utility.CollectionManager;

import java.util.StringJoiner;


public class PrintAscendingCommand extends Command {

    private final CollectionManager collectionManager;

    public PrintAscendingCommand(CollectionManager collectionManager) {
        super("print_ascending");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        StringJoiner output = new StringJoiner("\n\n");

        for (Dragon dragon : collectionManager.getMainData()) {
            output.add(dragon.toString());
        }

        return new CommandResult(false, output.toString());
    }
}

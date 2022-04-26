package com.meerim.client.commands;

import com.meerim.client.utility.CollectionInfo;
import com.meerim.client.utility.CollectionManager;



public class InfoCommand extends Command {

    private final CollectionManager collectionManager;
    private final CollectionInfo collectionInfo;

    public InfoCommand(CollectionManager collectionManager, CollectionInfo collectionInfo) {
        super("info");
        this.collectionManager = collectionManager;
        this.collectionInfo = collectionInfo;
    }

    @Override
    public CommandResult execute(String arg) {
            return new CommandResult(false, collectionInfo.info());
        }
    }


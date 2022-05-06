package com.meerim.client.commands;

import com.meerim.client.utility.CSVMapper;
import com.meerim.client.utility.CollectionManager;
import com.meerim.client.utility.FileManager;

public class SaveCommand extends Command {
    private final FileManager fileManager;
    private final CollectionManager collectionManager;

    public SaveCommand(FileManager fileManager, CollectionManager collectionManager) {
        super("save");
        this.fileManager = fileManager;
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        new CSVMapper().serialize(fileManager.getFilename(), collectionManager.getDataForSerialization());
        return new CommandResult(false, "The data was saved successfully");
    }
}

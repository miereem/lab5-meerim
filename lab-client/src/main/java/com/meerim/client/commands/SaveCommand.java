package com.meerim.client.commands;

import com.meerim.client.data.Dragon;
import com.meerim.client.utility.CSVParser;
import com.meerim.client.utility.CollectionManager;
import com.meerim.client.utility.FileManager;
import java.io.IOException;

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
        try {
            fileManager.save(new CSVParser().serialize(collectionManager.getMainData(), Dragon.class));
        } catch (IOException e) {
            return new CommandResult(false, "There was a problem saving a file. Please restart the program with another one");
        }
        return new CommandResult(false, "The data was saved successfully");
    }
}

package com.meerim.client.utility;

import java.util.Collections;

public class CollectionInfo {
    private final CollectionManager collectionManager;

    public CollectionInfo(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
    public String info() {
        if (!collectionManager.isEmpty()) {
            return  "Collection type: " + collectionManager.getMainData().getClass().toString() + "\n"
                    + "Number of elements: " + collectionManager.getMainData().size() + "\n"
                    + "Creation date: " + collectionManager.getCreationDate() + "\n"
                    + "The oldest dragon in collection is " + Collections.max(collectionManager.getMainData()).getAge();
        } else {
            return "Collection type: " + collectionManager.getMainData().getClass().toString() + "\n"
                    + "Number of elements: " + collectionManager.getMainData().size() + "\n"
                    + "Creation date: " + collectionManager.getCreationDate();
        }
    }
}

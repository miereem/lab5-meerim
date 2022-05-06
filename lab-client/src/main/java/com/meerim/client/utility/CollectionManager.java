package com.meerim.client.utility;

import com.meerim.client.data.Dragon;

import java.time.LocalDate;
import java.util.LinkedHashSet;

public class CollectionManager {
    private LinkedHashSet<Dragon> mainData = new LinkedHashSet<>();
    private final LocalDate creationDate = LocalDate.now();

    public void initialiseData(LinkedHashSet<Dragon> linkedHashSet) {
        this.mainData = linkedHashSet;
    }


    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LinkedHashSet<Dragon> getMainData() {
        return mainData;
    }

    public int getMaxId() {
        int maxId = 0;
        for (Dragon dragon : mainData) {
            if (dragon.getId() > maxId) {
                maxId = dragon.getId();
            }
        }
        return maxId;
    }
}

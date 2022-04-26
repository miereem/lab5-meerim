package com.meerim.client.utility;

import com.meerim.client.data.Dragon;


import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashSet;

public class CollectionManager {
    private LinkedHashSet<Dragon> mainData = new LinkedHashSet<>();
    private final LocalDate creationDate = LocalDate.now();

        public int getMaxId() {
            int maxId = 0;
            for (Dragon dragon : mainData) {
                if (dragon.getId() > maxId) {
                    maxId = dragon.getId();
                }
            }
            return maxId;
        }

    public void initialiseData(LinkedHashSet<Dragon> linkedHashSet) {
        this.mainData = linkedHashSet;
    }


    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LinkedHashSet<Dragon> getMainData() {
        return mainData;
    }
    public Dragon getMinId() {
        Dragon minIdDragon = null;
        int minId = Integer.MAX_VALUE;
        for (Dragon dragon : mainData) {
            if (dragon.getId() < minId) {
                minId = dragon.getId();
                minIdDragon = dragon;
            }
        }
        return minIdDragon;
    }

    public void clear() {
        mainData.clear();
    }
    public void add(Dragon dragon) {
        mainData.add(dragon);
    }
    public boolean addIfMin(Dragon dragon) {
        if (mainData.isEmpty() || dragon.compareTo(Collections.min(mainData)) < 0) {
            mainData.add(dragon);
        }
        return true;
    }
    public Integer getAverage() {
        int avAge = 0;
        for (Dragon dragon : mainData) {
            avAge = avAge + dragon.getAge();
        }
        avAge = avAge / mainData.size();
        return avAge;
    }
    public Dragon getMinCave() {
        float minCave = Integer.MAX_VALUE;
        Dragon minCaveDragon = null;
        for (Dragon dragon : mainData) {
            if (minCave > dragon.getCave()) {
                minCave = dragon.getCave();
                minCaveDragon = dragon;
            }
        }
        return minCaveDragon;
    }
    public boolean isEmpty() {
        return mainData.isEmpty();
    }
    public void removeGreater(Dragon dragon) {
        mainData.removeIf(x -> x.compareTo(dragon) > 0);
    }
    public boolean removeById(int intArg) {
        if (mainData.removeIf(x -> x.getId() == intArg)) {
            return true;
        }
        return false;
    }
}

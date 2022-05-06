package com.meerim.client.utility;

import com.meerim.client.data.Dragon;
import com.meerim.client.data.DragonCave;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class CollectionManager {
    private LinkedHashSet<Dragon> mainData = new LinkedHashSet<>();
    private final LocalDate creationDate = LocalDate.now();
    private LinkedHashSet<Integer> idSet = new LinkedHashSet<>();
    private int nextId = 1;

        public int getNextId() {
            while(idSet.contains(nextId)) {
                nextId++;
            }
            return nextId;
        }

    public void initialiseData(LinkedHashSet<Dragon> linkedHashSet) {
        this.mainData = linkedHashSet;
        idSet.clear();
        for (Dragon dragon: mainData){
            idSet.add(dragon.getId());
        }
    }


    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LinkedHashSet<Dragon> getMainData() {
        return mainData;
    }
    public List<Dragon> getDataForSerialization() {
        List<Dragon> list = new ArrayList<Dragon>(mainData);
        return list;
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
        idSet.clear();
    }
    public void add(Dragon dragon) {
            dragon.setId(getNextId());
            mainData.add(dragon);
            idSet.add(dragon.getId());
    }
    public boolean addIfMin(Dragon dragon) {
        if (mainData.isEmpty() || dragon.compareTo(Collections.min(mainData)) > 0) {
            System.out.println(dragon.compareTo(Collections.min(mainData)));
            mainData.add(dragon);
            idSet.add(dragon.getId());
            return true;
        }
        return false;
    }
    public double getAverage() {
        double avAge = 0;
        for (Dragon dragon : mainData) {
            avAge = avAge + dragon.getAge();
        }
        avAge = avAge / mainData.size();
        return avAge;
    }
    public Dragon getMinCave() {
        DragonCave minCave = new DragonCave(Integer.MAX_VALUE);
        Dragon minCaveDragon = null;
        for (Dragon dragon : mainData) {
            if (minCave.compareTo(dragon.getCave()) > 0) {
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
        mainData.removeIf(x -> x.compareTo(dragon) < 0);
        initialiseData(mainData);
    }
    public boolean removeById(int intArg) {
        if (mainData.removeIf(x -> x.getId() == intArg)) {
            idSet.remove(intArg);
            return true;
        }
        return false;
    }
    public void removeId(int id) {
            idSet.remove(id);
    }
}

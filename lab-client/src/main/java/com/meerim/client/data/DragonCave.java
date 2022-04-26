package com.meerim.client.data;

import java.util.Objects;

public class DragonCave {
    private float numberOfTreasures; //Значение поля должно быть больше 0

    public DragonCave(float numberOfTreasures) {
        this.numberOfTreasures = numberOfTreasures;
    }

    public float getNumberOfTreasures() {
        return numberOfTreasures;
    }

    public void setNumberOfTreasures(float numberOfTreasures) {
        this.numberOfTreasures = numberOfTreasures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DragonCave)) {
            return false;
        }
        DragonCave that = (DragonCave) o;
        return Float.compare(that.getNumberOfTreasures(), getNumberOfTreasures()) == 0;
    }

    public String getData() {
        return String.valueOf(numberOfTreasures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfTreasures());
    }

    @Override
    public String toString() {
        return "DragonCave{"
                + "numberOfTreasures=" + numberOfTreasures
                + '}';
    }

}


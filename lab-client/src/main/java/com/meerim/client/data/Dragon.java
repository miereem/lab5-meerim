package com.meerim.client.data;


import com.meerim.client.utility.CollectionManager;

import java.time.LocalDate;
import java.util.Objects;


public class Dragon implements Comparable<Dragon> {

    private final String name; //not null, not empty
    private final Coordinates coordinates; //not null
    private final java.time.LocalDate creationDate; //not null, automatic generation
    private final Integer age; // >0, not null
    private Color color; //null-able
    private DragonType type; //null-able
    private DragonCharacter character; // null-able
    private final DragonCave cave; //null-able
    private int id; // >0, unique, automatic generation

    public Dragon(String token, Coordinates coordinates, Integer integer, Color color, DragonType dragonType, DragonCharacter dragonCharacter, DragonCave dragonCave, LocalDate parse, Integer valueOf)  {
        this.name = token;
        this.coordinates = coordinates;
        this.age = integer;
        this.color = color;
        this.type = dragonType;
        this.character = dragonCharacter;
        this.cave = dragonCave;
        this.creationDate = parse;
        this.id = valueOf;
    }

    public Dragon(String name,
                  Coordinates coordinates,
                  Integer age,
                  Color color,
                  DragonType type,
                  DragonCharacter character,
                  DragonCave cave,
                  CollectionManager collectionManager) {
        this.name = name;
        this.coordinates = coordinates;
        this.age = age;
        this.color = color;
        this.type = type;
        this.character = character;
        this.cave = cave;
        this.creationDate = java.time.LocalDate.now();
        this.id = collectionManager.getMaxId() + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Dragon)) {
            return false;
        }
        Dragon dragon = (Dragon) o;
        return getId() == dragon.getId() && Objects.equals(name, dragon.name) && Objects.equals(coordinates, dragon.coordinates) && Objects.equals(creationDate, dragon.creationDate) && Objects.equals(age, dragon.age) && color == dragon.color && type == dragon.type && character == dragon.character && Objects.equals(cave, dragon.cave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coordinates, creationDate, age, color, type, character, cave, getId());
    }


    public Integer getAge() {
        return age;
    }

    public Float getCave() {
        return cave.getNumberOfTreasures();
    }

    @Override
    public String toString() {
        return "Dragon{"
                + "name='" + name + '\''
                + ", coordinates=" + coordinates
                + ", creationDate=" + creationDate
                + ", age=" + age
                + ", color=" + color
                + ", type=" + type
                + ", character=" + character
                + ", cave=" + cave
                + ", id=" + id
                + '}';
    }

    public String getData() {
        return name + "," + coordinates.getData() + "," + age + "," + color + "," + type + "," + character + "," + cave.getData() + "," + creationDate + "," + id + '\n';
    }

    @Override
    public int compareTo(Dragon o) {
        Integer oValue = o.getAge();
        Integer thisValue = this.getAge();
        // null handling
        if (oValue == null) {
            oValue = -1;
        }
        if (thisValue == null) {
            thisValue = -1;
        }
        if (oValue - thisValue != 0) {
            return thisValue - oValue;
        } else {
            return this.getId() - o.getId();
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public DragonType getType() {
        return type;
    }

    public DragonCharacter getCharacter() {
        return character;
    }
    public void setColor(Color c) {
        this.color = c;
    }

    public void setType(DragonType t) {
        this.type = t;
    }

    public void setCharacter(DragonCharacter ch) {
        this.character = ch;
    }


}

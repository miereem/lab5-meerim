package com.meerim.client.utility;

import com.meerim.client.data.Dragon;
import com.meerim.client.data.DragonCharacter;
import com.meerim.client.data.Color;
import com.meerim.client.data.DragonCave;
import com.meerim.client.data.DragonType;
import com.meerim.client.data.Coordinates;


import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class CSVParser {
    public String serialize(LinkedHashSet<Dragon> collectionData) throws IOException {
        StringBuffer ans = new StringBuffer();
        for (Dragon dragon : collectionData) {
            ans.append(dragon.getData());
        }
        return ans.toString();
    }

    public LinkedHashSet<Dragon> deserialize(final String csv) throws IOException {
        if (csv.length() < 2) {
            return new LinkedHashSet<>();
        }

        LinkedList<String> tokens = new LinkedList<>();
        for (String c: csv.split(",")) {
            tokens.add(c);
        }
        LinkedHashSet<Dragon> dragons = new LinkedHashSet<>();
        while (tokens.size() > 1) {
            String name = tokens.poll();
            Coordinates coordinates = new Coordinates(Integer.valueOf(tokens.poll()), Long.valueOf(tokens.poll()));
            Integer age = Integer.valueOf(tokens.poll());
            Color color;
            if (tokens.poll().equals("null")) {
                color = null;
            } else {
                color = Color.valueOf(tokens.poll());
            }
            DragonType type;
            if (tokens.poll().equals("null")) {
                type = null;
            } else {
                type = DragonType.valueOf(tokens.poll());
            }
            DragonCharacter character;
            if (tokens.poll().equals("null")) {
                character = null;
            } else {
                character = DragonCharacter.valueOf(tokens.poll());
            }
            DragonCave cave = new DragonCave(Float.parseFloat(tokens.poll()));
            dragons.add(new Dragon(name, coordinates, age, color, type, character, cave, java.time.LocalDate.parse(tokens.poll()), Integer.valueOf(tokens.poll())));
        }
            return dragons;
    }
}

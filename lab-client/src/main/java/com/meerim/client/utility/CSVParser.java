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
    public String serialize(LinkedHashSet<Dragon> collectionData, final Class type) throws IOException {
        String ans = "";
        for (Dragon dragon : collectionData) {
            ans += dragon.getData();
        }
        return ans;
    }

    public LinkedHashSet<Dragon> deserialize(final String csv, final Class type) throws IOException {
        if (csv.length() < 2) {
            return new LinkedHashSet<>();
        }
        String col = csv.replace("null", "NULL");
        LinkedList<String> tokens = new LinkedList<>();
        for (String c: col.split(",")) {
            tokens.add(c);
        }
        LinkedHashSet<Dragon> dragons = new LinkedHashSet<>();
        while (tokens.size() > 1) {
            dragons.add(new Dragon(tokens.poll(), new Coordinates(Integer.valueOf(tokens.poll()), Long.valueOf(tokens.poll())), Integer.valueOf(tokens.poll()), Color.valueOf(tokens.poll()), DragonType.valueOf(tokens.poll()), DragonCharacter.valueOf(tokens.poll()), new DragonCave(Float.parseFloat(tokens.poll())), java.time.LocalDate.parse(tokens.poll()), Integer.valueOf(tokens.poll())));
        }
        for (Dragon dragon : dragons) {
                if (dragon.getColor().equals(Color.NULL)) {
                    dragon.setColor(null);
                }
                if (dragon.getCharacter().equals(DragonCharacter.NULL)) {
                    dragon.setCharacter(null);
                }
                if (dragon.getType() == DragonType.NULL) {
                    dragon.setType(null);
                }
            }
            return dragons;

    }
}

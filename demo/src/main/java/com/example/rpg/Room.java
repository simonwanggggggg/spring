package com.example.rpg;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private final String name;
    private final String description;
    private final Monster monster;
    private boolean hasPotion;
    private final Map<String, Room> exits = new HashMap<>();

    public Room(String name, String description, Monster monster, boolean hasPotion) {
        this.name = name;
        this.description = description;
        this.monster = monster;
        this.hasPotion = hasPotion;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Monster getMonster() {
        return monster;
    }

    public boolean hasPotion() {
        return hasPotion;
    }

    public void removePotion() {
        hasPotion = false;
    }

    public void setExit(String direction, Room room) {
        exits.put(direction.toLowerCase(), room);
    }

    public Room getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }

    public String getExitString() {
        return String.join(", ", exits.keySet());
    }
}

package com.example.rpg;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private Monster monster;
    private boolean hasPotion;
    private Map<String, Room> exits = new HashMap<>();

    public Room(String name, String description, Monster monster, boolean hasPotion) {
        this.name = name;
        this.description = description;
        this.monster = monster;
        this.hasPotion = hasPotion;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Monster getMonster() { return monster; }
    public boolean hasPotion() { return hasPotion; }
    public void removePotion() { hasPotion = false; }
    public void setExit(String direction, Room room) { exits.put(direction, room); }
    public Room getExit(String direction) { return exits.get(direction); }
    public String getExitString() { return String.join(", ", exits.keySet()); }
    public Map<String, Room> getExits() { return exits; }

    // ✅ 深度複製房間
    public Room cloneDeep() {
        Room copy = new Room(this.name, this.description,
                             this.monster != null ? new Monster(this.monster) : null,
                             this.hasPotion);
        for (Map.Entry<String, Room> entry : this.exits.entrySet()) {
            copy.exits.put(entry.getKey(), entry.getValue()); // shallow copy of exits
        }
        return copy;
    }
}

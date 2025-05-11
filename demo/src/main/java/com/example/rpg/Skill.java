package com.example.rpg;

public interface Skill {
    String getName();
    String use(Player player, Monster monster);
}

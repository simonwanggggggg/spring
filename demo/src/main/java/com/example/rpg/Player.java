package com.example.rpg;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private final String name;
    private int hp;
    private final int attack;
    private int killCount = 0;
    private int totalDamage = 0;
    private final Map<String, Skill> skills = new HashMap<>();

    public Player(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int dmg) {
        hp = Math.max(0, hp - dmg);
    }

    public void heal(int amount) {
        hp += amount;
    }

    public void addKill() {
        killCount++;
    }

    public void addDamage(int dmg) {
        totalDamage += dmg;
    }

    public void addSkill(Skill skill) {
        skills.put(skill.getName().toLowerCase(), skill);
    }

    public Skill getSkill(String name) {
        return skills.get(name.toLowerCase());
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getKillCount() {
        return killCount;
    }

    public int getTotalDamage() {
        return totalDamage;
    }
    public Map<String, Skill> getSkills() {
        return skills;
    }
}

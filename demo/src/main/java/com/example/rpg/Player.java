// ✅ Player.java 補上複製建構子
package com.example.rpg;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private int hp;
    private int attack;
    private int killCount = 0;
    private int totalDamage = 0;
    private Map<String, Skill> skills = new HashMap<>();

    public Player(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    // 複製建構子
    public Player(Player other) {
        this.name = other.name;
        this.hp = other.hp;
        this.attack = other.attack;
        this.killCount = other.killCount;
        this.totalDamage = other.totalDamage;
        this.skills = new HashMap<>();
        for (Map.Entry<String, Skill> entry : other.skills.entrySet()) {
            this.skills.put(entry.getKey(), entry.getValue());
        }
    }

    public boolean isAlive() { return hp > 0; }
    public void takeDamage(int dmg) { hp -= dmg; }
    public int getHp() { return hp; }
    public int getAttack() { return attack; }
    public void addKill() { killCount++; }
    public void addDamage(int dmg) { totalDamage += dmg; }
    public String getName() { return name; }
    public int getKillCount() { return killCount; }
    public int getTotalDamage() { return totalDamage; }
    public void addSkill(Skill skill) { skills.put(skill.getName().toLowerCase(), skill); }
    public Skill getSkill(String name) { return skills.get(name.toLowerCase()); }
    public void heal(int amount) { this.hp += amount; }
    public Map<String, Skill> getSkills() { return skills; }
}

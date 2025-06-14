package com.example.rpg;

public class Monster {
    private final String name;
    private int hp;
    private final int attack;

    public Monster(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    // 複製建構子
    public Monster(Monster other) {
        this.name = other.name;
        this.hp = other.hp;
        this.attack = other.attack;
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

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int damage) {
        hp = Math.max(0, hp - damage);
    }
}

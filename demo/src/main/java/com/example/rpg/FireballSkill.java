package com.example.rpg;

public class FireballSkill implements Skill {
    @Override
    public String getName() {
        return "fireball";
    }

    @Override
    public String use(Player player, Monster monster) {
        int damage = player.getAttack() + 25;
        monster.takeDamage(damage);
        player.addDamage(damage);
        return "\uD83D\uDD25  你施放了【火球術】！對 " + monster.getName() + " 造成 " + damage + " 傷害！\n";
    }
}

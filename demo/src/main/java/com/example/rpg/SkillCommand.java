package com.example.rpg;

public class SkillCommand implements Command {
    private final String skillName;

    public SkillCommand(String skillName) {
        this.skillName = skillName.toLowerCase();
    }

    @Override
    public String execute(GameContext context) {
        Player player = context.getPlayer();
        Monster monster = context.getCurrentRoom().getMonster();

        Skill skill = player.getSkill(skillName);
        if (skill == null) {
            return "\u274C  你沒有這個技能。\n";
        }
        if (monster == null || !monster.isAlive()) {
            return "\u274C  這裡沒有怪物或怪物已經被擊敗。\n";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(skill.use(player, monster)).append("\n");

        if (monster.isAlive()) {
            int counter = monster.getAttack();
            player.takeDamage(counter);
            sb.append(monster.getName()).append(" 反擊你，造成 ").append(counter).append(" 傷害！\n");
        } else {
            sb.append(monster.getName()).append(" 被你燒成灰燼了！\n");
            player.addKill();
        }

        sb.append("=== 狀態更新 ===\n");
        sb.append("你的 HP：").append(player.getHp()).append("\n");
        sb.append(monster.getName()).append(" HP：").append(monster.getHp()).append("\n");

        return sb.toString();
    }
}

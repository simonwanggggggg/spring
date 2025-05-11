package com.example.rpg;

public class AttackCommand implements Command {
    @Override
    public String execute(GameContext context) {
        Player p = context.getPlayer();
        Room room = context.getCurrentRoom();
        Monster m = room.getMonster();

        if (m != null && m.isAlive()) {
            int dmg = p.getAttack();
            m.takeDamage(dmg);
            p.addDamage(dmg);
            StringBuilder sb = new StringBuilder();
            sb.append("你對 ").append(m.getName()).append(" 造成 ").append(dmg).append(" 傷害！\n");

            if (m.isAlive()) {
                int counter = m.getAttack();
                p.takeDamage(counter);
                sb.append(m.getName()).append(" 反擊你，造成 ").append(counter).append(" 傷害！\n");
            } else {
                sb.append(m.getName()).append(" 被你擊敗了！\n");
                p.addKill();
                sb.append("目前擊殺數：").append(p.getKillCount()).append("\n");
            }

            sb.append("=== 狀態更新 ===\n");
            sb.append("你的 HP：").append(p.getHp()).append("\n");
            sb.append(m.getName()).append(" HP：").append(m.getHp()).append("\n");
            return sb.toString();
        } else {
            return "這裡沒有怪物或怪物已經被擊敗。\n";
        }
    }
}

package com.example.rpg;

public class StatusCommand implements Command {
    @Override
    public String execute(GameContext context) {
        Player p = context.getPlayer();
        return String.format(
            "🧍 角色：%s\n❤️  HP：%d\n⚔️  攻擊力：%d\n🔥 技能數量：%d\n☠️  擊殺數：%d\n💥 總輸出傷害：%d\n",
            p.getName(), p.getHp(), p.getAttack(),
            p.getSkills().size(), p.getKillCount(), p.getTotalDamage()
        );
    }
}

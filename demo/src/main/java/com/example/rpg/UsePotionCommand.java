package com.example.rpg;

public class UsePotionCommand implements Command {
    @Override
    public String execute(GameContext context) {
        Room room = context.getCurrentRoom();
        Player player = context.getPlayer();
        if (room.hasPotion()) {
            player.heal(30);
            room.removePotion();
            return "\uD83C\uDF7C  你使用了治療藥水，HP 回復 30！目前 HP：" + player.getHp() +"\n";
        } else {
            return "\u274C  這裡沒有藥水可用。\n";
        }
    }
}

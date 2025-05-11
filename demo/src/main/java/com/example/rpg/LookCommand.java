package com.example.rpg;

public class LookCommand implements Command {
    @Override
    public String execute(GameContext context) {
        Room room = context.getCurrentRoom();
        StringBuilder sb = new StringBuilder();

        sb.append("\uD83C\uDFE0  地點：").append(room.getName()).append("\n");
        sb.append("\uD83D\uDCD6  描述：").append(room.getDescription()).append("\n");

        Monster m = room.getMonster();
        if (m != null && m.isAlive()) {
            sb.append("\uD83E\uDDDD  怪物：").append(m.getName()).append("（HP: ").append(m.getHp()).append(")\n");
        }

        if (room.hasPotion()) {
            sb.append("\uD83C\uDF7C  你看到一瓶治療藥水。\n");
        }

        sb.append("\uD83D\uDCCD  可前往方向：").append(room.getExitString()).append("\n");

        return sb.toString();
    }
}

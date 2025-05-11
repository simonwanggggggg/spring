package com.example.rpg;

public class MoveCommand implements Command {
    private final String direction;

    public MoveCommand(String direction) {
        this.direction = direction.toLowerCase();
    }

    @Override
    public String execute(GameContext context) {
        Room current = context.getCurrentRoom();
        Room next = current.getExit(direction);
        if (next != null) {
            context.setCurrentRoom(next);
            return "\uD83D\uDEB6  你前往了：" + next.getName() + "\n\n" + new LookCommand().execute(context);
        } else {
            return "\u274C  這個方向沒有路。\n";
        }
    }
}

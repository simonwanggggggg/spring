package com.example.rpg;

public class ExitCommand implements Command {
    @Override
    public String execute(GameContext context) {
        return "\uD83D\uDC4B 你選擇離開遊戲，下次再見！\n（若要重新開始請呼叫 /game/start）\n";
    }
}

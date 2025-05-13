package com.example.rpg;

import java.util.HashMap;
import java.util.Map;

public class GameEngine {
    private final GameContext context;
    private final Map<String, Command> commands = new HashMap<>();

    public GameEngine(GameContext context) {
        this.context = context;
        registerCommands();
    }

    private void registerCommands() {
        commands.put("look", new LookCommand());
        commands.put("attack", new AttackCommand());
        commands.put("use potion", new UsePotionCommand());
        commands.put("exit", new ExitCommand());
        commands.put("status", new StatusCommand());
        // skill / move 指令用動態解析，不在這邊註冊
    }

    public String processCommand(String input) {
        if (input.startsWith("move ")) {
            return new MoveCommand(input.substring(5)).execute(context);
        }
        if (input.startsWith("skill ")) {
            return new SkillCommand(input.substring(6)).execute(context);
        }
        Command command = commands.get(input.toLowerCase());
        if (command != null) {
            return command.execute(context);
        }
        return "\u26A0\uFE0F  指令無效，請重新輸入。\n";
    }

    public GameContext getContext() {
        return context;
    }

    public GameContext cloneContext() {
        return context.deepCopy();  // 請在 GameContext 加一個 deepCopy 方法
    }
}

package com.example.rpg;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    @PostMapping("/start")
    public String startGame(HttpSession session) {
        GameContext context = GameInitializer.init();
        session.setAttribute("game", new GameEngine(context));
        return "\uD83C\uDF10 遊戲開始！你是勇者，位於森林入口。輸入指令開始冒險！\n";
    }

    @PostMapping("/command")
    public String command(@RequestBody String input, HttpSession session) {
        GameEngine engine = (GameEngine) session.getAttribute("game");
        if (engine == null) {
            return "\u26A0\uFE0F 尚未開始遊戲，請先按\"🎮 開始遊戲\"按鈕。\n";
        }
        return engine.processCommand(input.trim());
    }

    @PostMapping("/restart")
    public String restart(HttpSession session) {
        session.removeAttribute("game");
        return "\uD83D\uDD04 遊戲已重置，請重新按\"🎮 開始遊戲\"按鈕以開始遊戲。\n";
    }

    @PostMapping("/save")
    public String saveGame(HttpSession session) {
        GameEngine engine = (GameEngine) session.getAttribute("game");
        if (engine == null) return "⚠️ 尚未開始遊戲。";

        session.setAttribute("savedGame", engine.cloneContext());
        return "💾 遊戲已儲存！";
    }

    @PostMapping("/load")
    public String loadGame(HttpSession session) {
        GameContext saved = (GameContext) session.getAttribute("savedGame");
        if (saved == null) return "⚠️ 尚未儲存任何遊戲。";

        session.setAttribute("game", new GameEngine(saved));
        return "📂 遊戲已載入成功！";
    }
} 
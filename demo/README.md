# RPG 遊戲系統（Spring Boot）🧙‍♂️

這是一個以 Spring Boot 實作的簡易文字 RPG 遊戲，支援指令式操作，具備單人遊玩與多房間怪物、技能、藥水等功能。

---

## 🚀 快速開始

### ✅ 啟動應用
```bash
./mvnw spring-boot:run
```

---

## 🎮 遊戲指令清單

| 指令             | 說明                             |
|------------------|---------------------------------|
| `look`           | 查看目前所在房間與怪物狀況        |
| `attack`         | 攻擊怪物                        |
| `skill fireball` | 使用技能（如火球術）             |
| `use potion`     | 使用房間內的治療藥水（若有）      |
| `move north`     | 向北移動到神殿大廳               |
| `move south`     | 返回森林入口                    |
| `status`         | 查看角色資訊、擊殺數與技能清單    |
| `exit`           | 離開遊戲                        |

---

## 🧪 自動測試腳本

### ✅ 完整功能測試（含移動與第二場怪物戰）
```bash
bash rpg_test.sh
```

> 執行前請確認 server 已啟動在 `http://localhost:8080`

---

## 📁 結構說明

- `GameController.java`：REST API 入口
- `GameEngine.java`：遊戲指令解析與執行管理器
- `Command.java`：指令介面，所有指令都實作它
- `Player/Monster/Room/GameContext`：遊戲邏輯核心
- `SkillCommand/AttackCommand/...`：各式指令實作
- `rpg_test.sh`：自動測試腳本（建議加入版本控制）

---

## 📝 作者

- 開發者：你（simonwanggggggg）
- 範例技能：`FireballSkill.java`
- 使用技術：Spring Boot, Session, RESTful API

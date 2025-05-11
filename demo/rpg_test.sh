#!/bin/bash
# RPG 遊戲完整功能測試腳本

# 啟動遊戲並儲存 cookie
curl -c cookie.txt -X POST http://localhost:8080/game/start
echo -e "\n--- 遊戲啟動完成 ---\n"

# 查看當前環境
curl -b cookie.txt -X POST http://localhost:8080/game/command -H "Content-Type: text/plain" -d "look"
echo -e "---\n"

# 對第一隻怪施放技能
curl -b cookie.txt -X POST http://localhost:8080/game/command -H "Content-Type: text/plain" -d "skill fireball"
echo -e "---\n"

# 攻擊補刀
curl -b cookie.txt -X POST http://localhost:8080/game/command -H "Content-Type: text/plain" -d "attack"
echo -e "---\n"

# 使用藥水
curl -b cookie.txt -X POST http://localhost:8080/game/command -H "Content-Type: text/plain" -d "use potion"
echo -e "---\n"

# 向北移動（到神殿大廳）
curl -b cookie.txt -X POST http://localhost:8080/game/command -H "Content-Type: text/plain" -d "move north"
echo -e "---\n"

# 查看環境（神殿）
curl -b cookie.txt -X POST http://localhost:8080/game/command -H "Content-Type: text/plain" -d "look"
echo -e "\n---\n"

# 攻擊第二隻怪（亡靈戰士）
curl -b cookie.txt -X POST http://localhost:8080/game/command -H "Content-Type: text/plain" -d "attack"
echo -e "---\n"

# 再次使用技能
curl -b cookie.txt -X POST http://localhost:8080/game/command -H "Content-Type: text/plain" -d "skill fireball"
echo -e "---\n"

# 查看狀態
curl -b cookie.txt -X POST http://localhost:8080/game/command -H "Content-Type: text/plain" -d "status"
echo -e "---\n"

# 向南移動回森林
curl -b cookie.txt -X POST http://localhost:8080/game/command -H "Content-Type: text/plain" -d "move south"
echo -e "---\n"

# 離開遊戲
curl -b cookie.txt -X POST http://localhost:8080/game/command -H "Content-Type: text/plain" -d "exit"

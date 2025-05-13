package com.example.rpg;

public class GameContext {
    private Player player;
    private Room currentRoom;

    public GameContext(Player player, Room startRoom) {
        this.player = player;
        this.currentRoom = startRoom;
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public GameContext deepCopy() {
        Player newPlayer = new Player(this.player);
        Room newRoom = this.currentRoom.cloneDeep();
        return new GameContext(newPlayer, newRoom);
    }
}

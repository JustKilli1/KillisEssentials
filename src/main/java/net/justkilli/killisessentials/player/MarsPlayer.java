package net.justkilli.killisessentials.player;

import net.justkilli.killisessentials.player.playersessions.SessionManager;

import java.util.UUID;

//Possible things to add:
//String ip,
//String lastSeen,
//String firstSeen,
//String lastLocation,
//String lastDeath,
//String lastLogin,
//String lastLogout,
//String lastChat,
//String lastCommand
public record MarsPlayer(int id, String name, UUID uuid, SessionManager sessionManager) {



}

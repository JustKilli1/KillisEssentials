package net.justkilli.killisessentials.player.listeners;

import net.justkilli.killisessentials.config.handler.IConfigHandler;
import net.justkilli.killisessentials.player.database.DBAccessLayerPlayer;
import net.justkilli.killisessentials.player.database.DBHandlerPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final DBAccessLayerPlayer sql;
    private final DBHandlerPlayer dbHandler;

    public PlayerJoinListener(IConfigHandler mysqlConfigHandler) {
        sql = new DBAccessLayerPlayer(mysqlConfigHandler);
        dbHandler = new DBHandlerPlayer(sql);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(dbHandler.playerExists(player.getUniqueId())) return;
    }

}

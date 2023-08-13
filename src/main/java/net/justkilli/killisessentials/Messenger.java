package net.justkilli.killisessentials;

import net.justkilli.killisessentials.config.values.ConfigValue;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

public class Messenger {

    public static Component sendMessage(Player player, String message) {
        Component miniMessageComponent = MiniMessage.miniMessage().deserialize(message);
        player.sendMessage(miniMessageComponent);
        return miniMessageComponent;
    }

    public static Component sendMessage(Audience audience, String message) {
        Component miniMessageComponent = MiniMessage.miniMessage().deserialize(message);
        audience.sendMessage(miniMessageComponent);
        return miniMessageComponent;
    }

    public static <T> Component sendMessage(Player player, ConfigValue<T> message) {
        Component miniMessageComponent = MiniMessage.miniMessage().deserialize(message.toString());
        player.sendMessage(miniMessageComponent);
        return miniMessageComponent;
    }

    public static <T> Component sendMessage(Audience audience, ConfigValue<T> message) {
        Component miniMessageComponent = MiniMessage.miniMessage().deserialize(message.toString());
        audience.sendMessage(miniMessageComponent);
        return miniMessageComponent;
    }

}

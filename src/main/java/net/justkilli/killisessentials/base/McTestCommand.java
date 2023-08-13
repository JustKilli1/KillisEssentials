package net.justkilli.killisessentials.base;

import net.justkilli.killisessentials.Messenger;
import net.justkilli.killisessentials.config.handler.IConfigHandler;
import net.justkilli.killisessentials.config.values.ConfigValue;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class McTestCommand implements CommandExecutor {

    private IConfigHandler configHandler;

    public McTestCommand(IConfigHandler configHandler) {
        this.configHandler = configHandler;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player player)) return true;
        if(args.length > 0) return false;
        ConfigValue<String> val = ConfigValue.SQL_HOST;
        ConfigValue<String> val2 = ConfigValue.SQL_PASSWORD;
        Messenger.sendMessage(player, val);
        Messenger.sendMessage(player, val2);
        return true;
    }
}

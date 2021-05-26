package fr.k0bus.creativemanager.event;

import fr.k0bus.creativemanager.CreativeManager;
import fr.k0bus.creativemanager.settings.Protections;
import fr.k0bus.k0buslib.utils.Messages;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;
import java.util.Locale;

public class PlayerPreCommand implements Listener {

    CreativeManager plugin;

    public PlayerPreCommand(CreativeManager plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent e)
    {
        if(!plugin.getSettings().getProtection(Protections.COMMANDS)) return;
        String cmd = e.getMessage().toLowerCase().substring(1);
        for (String blCmd:plugin.getSettings().getCommandBL()) {
            if(blCmd.toLowerCase().startsWith(cmd))
            {
                e.setCancelled(true);
                if(plugin.getSettings().getBoolean("send-player-messages"))
                    Messages.sendMessage(plugin.getMessageManager(), e.getPlayer(), "blacklist.commands");
            }
        }
    }
}

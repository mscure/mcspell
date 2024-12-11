package plugin.mcspell.event;

import plugin.mcspell.Mcspell;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        Mcspell plugin = Mcspell.getPlugin();
        if(!plugin.getConfig().getBoolean("display-message"))
            return;
        player.sendMessage(Mcspell.prefix + plugin.getConfig().getString("message"));
    }
}
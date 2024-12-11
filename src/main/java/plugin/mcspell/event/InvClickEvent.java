package plugin.mcspell.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClickEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getClickedInventory() == null)
            return;
        if(ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("TESTGUI")){
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
        }
    }
}
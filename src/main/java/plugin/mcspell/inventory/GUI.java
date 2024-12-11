package plugin.mcspell.inventory;

import plugin.mcspell.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class GUI implements InventoryHolder {
    private final Inventory inv;

    private void initItemSetting() {
        for(int i = 0; i < 9; i++){
            if(i==4)
                inv.setItem(i,ItemManager.dia);
            else
                inv.setItem(i,ItemManager.guiGrayGlassPane);
        }
    }

    public GUI() {
        this.inv = Bukkit.createInventory(null,9,"TEST");
        initItemSetting();
    }

    public void open(Player player){
        player.openInventory(inv);
    }



    @Override
    public Inventory getInventory() {
        return inv;
    }
}
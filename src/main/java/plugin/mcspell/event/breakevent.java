package plugin.mcspell.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import plugin.mcspell.ItemManager;

import javax.swing.*;


public class breakevent implements Listener {


    @EventHandler
    public void breakDirt(BlockBreakEvent e) {
        Material brBlock = e.getBlock().getBlockData().getMaterial();
        if(brBlock == Material.DIAMOND_ORE){
            Player p = e.getPlayer();
            if(Math.floor(Math.random() * 10) < 9.9) {
                p.getInventory().addItem(ItemManager.dia);
            }else{
                if (Math.floor(Math.random() * 10) < 0.1) {
                    p.getInventory().addItem(ItemManager.enchantDia);
                    p.sendMessage("0.1%의 확률로 행운의 다이아를 발견하셨습니다!");
                }
            }
        }
    }

}
package plugin.mcspell;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class ItemManager {

    private static ItemStack buildItem(Material type, int amount, String displayName, String... lore) {
        ItemStack stack = new ItemStack(type, amount);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(Arrays.asList(lore));
        stack.setItemMeta(meta);
        return stack;
    }

    private static ItemStack buildItem(Material type, int amount, String displayName, Enchantment enchant, int enchantlvl, boolean enchantRestrict, String... lore) {
        ItemStack stack = new ItemStack(type, amount);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(Arrays.asList(lore));
        meta.addEnchant(enchant, enchantlvl, enchantRestrict);
        stack.setItemMeta(meta);
        return stack;
    }

    public static final ItemStack dia = buildItem(Material.DIAMOND, 1, ChatColor.AQUA +"다이아",ChatColor.WHITE + "일반적인 다이아몬드이다.",
            ChatColor.WHITE + "등급 : 노말");

    public static final ItemStack enchantDia = buildItem(Material.DIAMOND, 1, ChatColor.AQUA +"행운의 다이아",
            Enchantment.FORTUNE, 1, false,ChatColor.WHITE + "1%의 확률로 행운의 다이아를 얻었다.", ChatColor.LIGHT_PURPLE + "등급 : 에픽");

    public static final ItemStack guiGrayGlassPane = buildItem(Material.GRAY_STAINED_GLASS_PANE, 1, ChatColor.GRAY + "빈칸","빈칸이다.");
}
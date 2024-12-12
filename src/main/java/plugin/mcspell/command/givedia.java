package plugin.mcspell.command;

import plugin.mcspell.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class givedia implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("콘솔로 치지마세요 ~ ");
            return false;
        }

        Player executor = (Player) sender;

        if (args.length == 0) {
            executor.sendMessage("사용법: /givedia <플레이어 이름> [enchant] [수량]");
            return false;
        }

        // 대상 플레이어 검색
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            executor.sendMessage("지정된 플레이어를 찾을 수 없습니다.");
            return false;
        }

        // 기본 아이템 (일반 다이아몬드)
        ItemStack item = ItemManager.dia;
        int amount = 1; // 기본 수량

        try {
            // 두 번째 인자가 "enchant"라면 인첸트된 다이아몬드를 지급
            if (args.length >= 2 && args[1].equalsIgnoreCase("enchant")) {
                item = ItemManager.enchantDia;
            }

            // 세 번째 인자가 있으면 수량을 설정
            if (args.length == 3) {
                amount = Integer.parseInt(args[2]);
                if (amount <= 0) {
                    executor.sendMessage("수량은 1 이상이어야 합니다.");
                    return false;
                }
            }

            // 아이템 설정 및 지급
            item.setAmount(amount);
            target.getInventory().addItem(item);
            executor.sendMessage(target.getName() + "에게 다이아가 지급되었습니다.");
            target.sendMessage("플레이어 " + executor.getName() + "이(가) 당신에게 다이아를 지급했습니다!");
        } catch (NumberFormatException e) {
            executor.sendMessage("수량은 숫자로 입력해야 합니다.");
            return false;
        } catch (Exception e) {
            executor.sendMessage("명령어 처리 중 오류가 발생했습니다.");
            return false;
        }

        return true;
    }
}
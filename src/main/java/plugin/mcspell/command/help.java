package plugin.mcspell.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command,  String label,  String[] args) {
        sender.sendMessage("흙블럭이나 잔디블럭을 부수면 50%의 확률로 다이아가, 0.1%의 확률로 행운의 다이아가 나와요");
        return false;
    }
}
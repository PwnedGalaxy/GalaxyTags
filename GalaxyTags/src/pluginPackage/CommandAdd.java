package pluginPackage;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;


public class CommandAdd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			
			ItemStack heldItem = player.getInventory().getItemInMainHand();
			
			UUID uuid = player.getUniqueId();
			
			if (heldItem.getType() == Material.AIR) {
				player.sendMessage(ChatColor.RED + "You must be holding an item in your main hand.");
				
			} else if (args.length == 0) {
					player.sendMessage(ChatColor.RED + "A tag must be entered.");
				
			} else if (heldItem.getItemMeta().hasLore()) {
				player.sendMessage(ChatColor.RED + "Item already has data attached.");
				
			} else {
				ItemMeta meta = heldItem.getItemMeta();
				ArrayList<String> lore = new ArrayList<String>();
				lore.add(uuid.toString());
				lore.add(args[0]);
				meta.setLore(lore);
				
				heldItem.setItemMeta(meta);
				
				player.sendMessage(ChatColor.GREEN + "Tag '" + args[0] + "' successfully added.");
				}
		}
		return true;
	}

}

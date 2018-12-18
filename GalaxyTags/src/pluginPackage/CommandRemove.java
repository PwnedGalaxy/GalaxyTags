package pluginPackage;

import java.util.List;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class CommandRemove implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			ItemStack heldItem = player.getInventory().getItemInMainHand();
			UUID uuid = player.getUniqueId();
			ItemMeta meta = heldItem.getItemMeta();
			
			if (heldItem.getType() == Material.AIR) {
				player.sendMessage(ChatColor.RED + "You must be holding an item in your main hand.");

			//If the item has lore
			} else if (heldItem.getItemMeta().hasLore()) {
				List<String> lore = heldItem.getItemMeta().getLore();
				
				if(player.hasPermission("galaxytags.adminremove") || (lore.get(0).equals(uuid.toString())) || (player.isOp())) {
					
					meta.setLore(null);
					heldItem.setItemMeta(meta);
					
					
					player.sendMessage(ChatColor.GREEN + "Tags successfully removed.");
					
				} else {
					player.sendMessage(ChatColor.RED + "You do not have permission to remove a tag on an item that is not yours.");
				}
			//Item does not yet have lore
			} else {
				player.sendMessage(ChatColor.RED + "Item does not have tags attached.");
				}
		}
		return true;
	}

}

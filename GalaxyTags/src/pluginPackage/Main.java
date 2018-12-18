package pluginPackage;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	// Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	this.getCommand("gtadd").setExecutor(new CommandAdd());
    	this.getCommand("gtremove").setExecutor(new CommandRemove());
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
}

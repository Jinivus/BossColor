package jinivus.BossCrewColor;

import org.bukkit.plugin.java.JavaPlugin;
import org.anjocaido.groupmanager.GroupManager;
import org.anjocaido.groupmanager.dataholder.worlds.WorldsHolder;

public class BossCrewColor extends JavaPlugin
{
	public GroupManager groupManager;
	public WorldsHolder worldData;

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onEnable() {

		getCommand("color").setExecutor(new BCCCommand(this));
		System.out.println("Enabled BossCrewColor");

	}


}

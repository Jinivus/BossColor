package jinivus.BossCrewColor;

import org.anjocaido.groupmanager.GroupManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BCCCommand implements CommandExecutor {

	private final BossCrewColor plugin;
	/*
	public Color Black = new Color("black","&0",ChatColor.BLACK);
	public Color DarkBlue = new Color("darkblue","&1",ChatColor.DARK_BLUE);
	public Color DarkGreen = new Color("darkgreen","&2",ChatColor.DARK_GREEN);
	public Color DarkTeal = new Color("darkteal","&3",ChatColor.DARK_AQUA);
	public Color DarkRed = new Color("darkred","&4",ChatColor.DARK_RED);
	public Color Purple = new Color("purple","&5",ChatColor.DARK_PURPLE);
	public Color Gold = new Color("gold","&6",ChatColor.GOLD);
	public Color Gray = new Color("gray","&7",ChatColor.GRAY);
	public Color DarkGray = new Color("darkgray","&8",ChatColor.DARK_GRAY);
	public Color Blue = new Color("blue","&9",ChatColor.BLUE);
	public Color BrightGreen = new Color("brightgreen","&a",ChatColor.GREEN);
	public Color Teal = new Color("teal","&b",ChatColor.AQUA);
	public Color Red = new Color("red","&c",ChatColor.RED);
	public Color Pink = new Color("pink","&d",ChatColor.LIGHT_PURPLE);
	public Color Yellow = new Color("yellow","&e",ChatColor.YELLOW);
	public Color White = new Color("white","&f",ChatColor.WHITE);
	 */

	public BCCCommand(BossCrewColor p)
	{
		this.plugin = p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) 
		{
			sender.sendMessage(ChatColor.RED + "You are not a player!");
			return false;
		}
		GroupManager gm = (GroupManager) plugin.getServer().getPluginManager().getPlugin("GroupManager");
		Player senderPlayer = (Player) sender;
		
		if(!gm.getWorldsHolder().getWorldPermissions(senderPlayer).has(senderPlayer, "bosscolor.change"))
		{
			sender.sendMessage(ChatColor.RED + "You do not have permission to do that.");
			return true;
		}
		if(args.length != 1)
		{
			sender.sendMessage("Please enter a color.");
			return false;
		}
		else
		{
			String colorName = args[0];
			if(isValidColor(colorName))
			{
				Color color = getColorFromName(colorName);
				if(isAdminColor(color))
				{
					System.out.println("test3");
					sender.sendMessage("You can't use Red or Dark Red, please try another color.");
					return false;
				}
				else
				{
					if(gm.getWorldsHolder().getWorldData(senderPlayer).getUser(senderPlayer.getName()).getVariables().hasVar("forcedprefix"))
					{
						String pre = gm.getWorldsHolder().getWorldData(senderPlayer).getUser(senderPlayer.getName()).getVariables().getVarString("forcedprefix");
						gm.getWorldsHolder().getWorldData(senderPlayer).getUser(senderPlayer.getName()).getVariables().addVar("prefix", pre + color.Code);
						sender.sendMessage("Color set to " + color.ChatColor + color.ColorName);
						return true;
					}
					gm.getWorldsHolder().getWorldData(senderPlayer).getUser(senderPlayer.getName()).getVariables().addVar("prefix", color.Code);
					sender.sendMessage("Color set to " + color.ChatColor + color.ColorName);
					return true;
				}

			}
			else if(colorName.toLowerCase().startsWith("list"))
			{
				String colorListString = "Available colors are: ";
				for(Color x:ColorManager.getInstance().getList())
				{
					colorListString = colorListString + x.ChatColor + x.ColorName + ", ";
				}
				colorListString = colorListString.substring(0, colorListString.length()-2);
				sender.sendMessage(colorListString);
				return true;
			}
			else
			{
				sender.sendMessage(colorName + " is not a valid color");
				return false;
			}

		}
	}

	public Color getColorFromName(String colorName) 
	{
		for (Color x:ColorManager.getInstance().getList())
		{
			if(x.ColorName.startsWith(colorName))
			{
				return x;
			}
			if(x.Code.startsWith(colorName))
			{
				return x;
			}
		}
		return null;
	}

	public String convertToColorCode(String colorText)
	{
		for (Color x:ColorManager.getInstance().getList())
		{
			if(x.ColorName.startsWith(colorText))
			{
				return x.Code;
			}
			if(x.Code.startsWith(colorText))
			{
				return x.Code;
			}
		}
		return null;
	}


	public boolean isValidColor(String colorText)
	{
		for (Color x:ColorManager.getInstance().getList())
		{
			if(x.ColorName.startsWith(colorText))
			{
				return true;
			}
			if(x.Code.startsWith(colorText))
			{
				return true;
			}
		}
		return false;
	}

	public boolean isAdminColor(String colorText)
	{
		if(colorText.toLowerCase().startsWith("red") || colorText.toLowerCase().startsWith("darkred") || colorText.toLowerCase().startsWith("&4") || colorText.toLowerCase().startsWith("c"))
		{
			return true;
		}
		return false;
	}
	
	public boolean isAdminColor(Color color)
	{
		if(color.ColorName.toLowerCase().startsWith("red") || color.ColorName.toLowerCase().startsWith("darkred"))
		{
			return true;
		}
		return false;
	}

}

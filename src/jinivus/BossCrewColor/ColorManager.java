package jinivus.BossCrewColor;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class ColorManager {
	private static ColorManager instance = null;
	public static List<Color> ColorList = new ArrayList<Color>();
	
	protected ColorManager()
	{
		Color Black = new Color("black","&0",ChatColor.BLACK);
		Color DarkBlue = new Color("darkblue","&1",ChatColor.DARK_BLUE);
		Color DarkGreen = new Color("darkgreen","&2",ChatColor.DARK_GREEN);
		Color DarkTeal = new Color("darkteal","&3",ChatColor.DARK_AQUA);
		Color DarkRed = new Color("darkred","&4",ChatColor.DARK_RED);
		Color Purple = new Color("purple","&5",ChatColor.DARK_PURPLE);
		Color Gold = new Color("gold","&6",ChatColor.GOLD);
		Color Gray = new Color("gray","&7",ChatColor.GRAY);
		Color DarkGray = new Color("darkgray","&8",ChatColor.DARK_GRAY);
		Color Blue = new Color("blue","&9",ChatColor.BLUE);
		Color BrightGreen = new Color("brightgreen","&a",ChatColor.GREEN);
		Color Teal = new Color("teal","&b",ChatColor.AQUA);
		Color Red = new Color("red","&c",ChatColor.RED);
		Color Pink = new Color("pink","&d",ChatColor.LIGHT_PURPLE);
		Color Yellow = new Color("yellow","&e",ChatColor.YELLOW);
		Color White = new Color("white","&f",ChatColor.WHITE);

		ColorList.add(Black);
		ColorList.add(DarkBlue);
		ColorList.add(DarkGreen);
		ColorList.add(DarkTeal);
		ColorList.add(DarkRed);
		ColorList.add(Purple);
		ColorList.add(Gold);
		ColorList.add(Gray);
		ColorList.add(DarkGray);
		ColorList.add(Blue);
		ColorList.add(BrightGreen);
		ColorList.add(Teal);
		ColorList.add(Red);
		ColorList.add(Pink);
		ColorList.add(Yellow);
		ColorList.add(White);
	}
	
	public static ColorManager getInstance()
	{
		if(instance == null)
		{
			instance = new ColorManager();
		}
		return instance;
	}
	
	public List<Color> getList()
	{
		return ColorList;
	}

}

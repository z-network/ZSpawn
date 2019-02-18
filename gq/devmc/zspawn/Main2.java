package gq.devmc.zspawn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main2
  extends JavaPlugin
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(ChatColor.RED + "Only players can execute this command ?");
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("tp"))
    {
      if (args.length == 0)
      {
        p.sendMessage(ChatColor.RED + "§8[§6§lZ§8] §7Please specify a player.");
        return true;
      }
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target == null)
      {
        p.sendMessage(ChatColor.RED + "§8[§6§lZ§8] §7Could not find player " + args[0] + "!");
        return true;
      }
      p.teleport(target.getLocation());
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("setspawn"))
    {
      getConfig().set("spawn.world", p.getLocation().getWorld().getName());
      getConfig().set("spawn.x", Double.valueOf(p.getLocation().getX()));
      getConfig().set("spawn.y", Double.valueOf(p.getLocation().getY()));
      getConfig().set("spawn.z", Double.valueOf(p.getLocation().getZ()));
      saveConfig();
      p.sendMessage(ChatColor.GREEN + "§8[§6§lZ§8] §7Spawn set!");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("spawn"))
    {
      if (getConfig().getConfigurationSection("spawn") == null)
      {
        p.sendMessage(ChatColor.RED + "§8[§6§lZ§8] §7The spawn has not yet been set!");
        return true;
      }
      World w = Bukkit.getServer().getWorld(getConfig().getString("spawn.world"));
      double x = getConfig().getDouble("spawn.x");
      double y = getConfig().getDouble("spawn.y");
      double z = getConfig().getDouble("spawn.z");
      p.teleport(new Location(w, x, y, z));
      p.sendMessage(ChatColor.GREEN + "§8[§6§lZ§8] §7Teloporting to spawn..");
    }
    return true;
  }
}

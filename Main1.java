package gq.devmc.zmaint;

import gq.devmc.zmaint.commands.Command_Maintenance;
import gq.devmc.zmaint.commands.Command_Whitelist;
import gq.devmc.zmaint.listeners.Listener_LoginEvent;
import gq.devmc.zmaint.listeners.Listener_ProxyPingEvent;
import gq.devmc.zmaint.utilities.Config;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;

public class Main5
  extends Plugin
{
  private static Main5 instance;
  
  public void onEnable()
  {
    instance = this;
    Config.init();
    
    getProxy().getPluginManager().registerCommand(this, new Command_Whitelist());
    getProxy().getPluginManager().registerCommand(this, new Command_Maintenance());
    
    getProxy().getPluginManager().registerListener(this, new Listener_LoginEvent());
    getProxy().getPluginManager().registerListener(this, new Listener_ProxyPingEvent());
    
    getProxy().getConsole().sendMessage(new TextComponent("§a\n##     ##    ###    #### ##    ## ######## ######## ##    ##    ###    ##    ##  ######  ######## \n###   ###   ## ##    ##  ###   ##    ##    ##       ###   ##   ## ##   ###   ## ##    ## ##       \n#### ####  ##   ##   ##  ####  ##    ##    ##       ####  ##  ##   ##  ####  ## ##       ##       \n## ### ## ##     ##  ##  ## ## ##    ##    ######   ## ## ## ##     ## ## ## ## ##       ######   \n##     ## #########  ##  ##  ####    ##    ##       ##  #### ######### ##  #### ##       ##       \n##     ## ##     ##  ##  ##   ###    ##    ##       ##   ### ##     ## ##   ### ##    ## ##       \n##     ## ##     ## #### ##    ##    ##    ######## ##    ## ##     ## ##    ##  ######  ########\n"));
    
    getProxy().getConsole().sendMessage(new TextComponent("§e" + getDescription().getName() + " v." + getDescription().getVersion() + " | by " + getDescription().getAuthor()));
  }
  
  public void onDisable()
  {
    Config.shutdown();
    
    getProxy().getConsole().sendMessage(new TextComponent("§c\n##     ##    ###    #### ##    ## ######## ######## ##    ##    ###    ##    ##  ######  ######## \n###   ###   ## ##    ##  ###   ##    ##    ##       ###   ##   ## ##   ###   ## ##    ## ##       \n#### ####  ##   ##   ##  ####  ##    ##    ##       ####  ##  ##   ##  ####  ## ##       ##       \n## ### ## ##     ##  ##  ## ## ##    ##    ######   ## ## ## ##     ## ## ## ## ##       ######   \n##     ## #########  ##  ##  ####    ##    ##       ##  #### ######### ##  #### ##       ##       \n##     ## ##     ##  ##  ##   ###    ##    ##       ##   ### ##     ## ##   ### ##    ## ##       \n##     ## ##     ## #### ##    ##    ##    ######## ##    ## ##     ## ##    ##  ######  ########"));
  }
  
  public static Main5 getInstance()
  {
    return instance;
  }
}
package pl.inoshi.newyear.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import pl.inoshi.newyear.data.CooldownData;

public class PlayerCommandListener implements Listener {

    private final CooldownData cooldownData;

    public PlayerCommandListener(CooldownData cooldownData) {
        this.cooldownData = cooldownData;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        Player player = event.getPlayer();
        String playerName = player.getName();

        if (cooldownData.checkContainst(playerName)){
            if (cooldownData.getTime(playerName) < System.currentTimeMillis()){
                cooldownData.getCooldownMap().remove(playerName);
                cooldownData.addToCooldownMap(playerName);
                return;
            }
        } else {
            cooldownData.addToCooldownMap(playerName);
            return;
        }

        player.sendMessage(ChatColor.RED + "Musisz poczekac 3 minuty");
        event.setCancelled(true);

    }
}

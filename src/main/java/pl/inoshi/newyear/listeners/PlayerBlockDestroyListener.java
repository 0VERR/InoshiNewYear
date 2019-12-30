package pl.inoshi.newyear.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBlockDestroyListener implements Listener {



    @EventHandler
    public void onBlockDestroy(BlockBreakEvent event){
        Player player = event.getPlayer();
        if (!player.isOp()){
            event.setCancelled(true);
        }

    }
}

package pl.inoshi.newyear.tasks;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import pl.inoshi.newyear.countdowntime.Counter;

public class CounterTask implements Runnable {

    private Counter counter;

    public CounterTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {

        if (counter.calculate() == 0){
            String text = ChatColor.GREEN + "NOWY ROK";
            IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + text + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");

            PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
            PacketPlayOutTitle length = new PacketPlayOutTitle(5, 100, 5);

            Bukkit.getOnlinePlayers().forEach(player ->{

                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(length);
            });
        }
        String text = ChatColor.GREEN + "Do nowego roku zostalo: " + counter.calculate() + " sekund";
        IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + text + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");

        PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
        PacketPlayOutTitle length = new PacketPlayOutTitle(5, 20, 5);

        Bukkit.getOnlinePlayers().forEach(player ->{


        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(length);
        });
    }
}

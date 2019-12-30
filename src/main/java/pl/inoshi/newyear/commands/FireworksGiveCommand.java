package pl.inoshi.newyear.commands;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import pl.inoshi.newyear.fireworks.Fireworks;

public class FireworksGiveCommand implements CommandExecutor {

    private final Fireworks fireworks;

    public FireworksGiveCommand(Fireworks fireworks) {
        this.fireworks = fireworks;
    }

    String text = ChatColor.GREEN + "Odebrales zestaw Noworoczny";
    IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + text + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");

    PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
    PacketPlayOutTitle length = new PacketPlayOutTitle(5, 20, 5);


    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player player = (Player) sender;


        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(length);

        fireworks.getFireworksSet().forEach(x ->{
            player.getInventory().addItem(x);

        });
        return true;
    }
}

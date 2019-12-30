package pl.inoshi.newyear;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.inoshi.newyear.commands.FireworksGiveCommand;
import pl.inoshi.newyear.countdowntime.Counter;
import pl.inoshi.newyear.data.CooldownData;
import pl.inoshi.newyear.fireworks.Fireworks;
import pl.inoshi.newyear.listeners.PlayerBlockDestroyListener;
import pl.inoshi.newyear.listeners.PlayerBlockPlaceListener;
import pl.inoshi.newyear.listeners.PlayerCommandListener;
import pl.inoshi.newyear.tasks.CounterTask;

public class NewYearPlugin extends JavaPlugin {

    private Fireworks fireworks;
    private CooldownData cooldownData;

    public void onEnable(){
        cooldownData = new CooldownData();
        fireworks = new Fireworks();
        fireworks.createFireworks();
        Counter counter = new Counter();
        counter.calculate();



        getCommand("firework").setExecutor(new FireworksGiveCommand(fireworks));
        Bukkit.getScheduler().runTaskTimer(this, new CounterTask(counter), 20,20);

        getServer().getPluginManager().registerEvents(new PlayerBlockDestroyListener(),this);
        getServer().getPluginManager().registerEvents(new PlayerBlockPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerCommandListener(cooldownData), this);
    }
}

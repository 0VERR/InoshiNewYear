package pl.inoshi.newyear.data;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CooldownData {

    public HashMap<String, Long> getCooldownMap() {
        return cooldownMap;
    }

    private HashMap<String, Long> cooldownMap = new HashMap<>();

    public void addToCooldownMap(String playerName){
        cooldownMap.put(playerName,System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(180));
    }

    public boolean checkCooldown(String playerName){
        return cooldownMap.get(playerName) < System.currentTimeMillis();
    }

    public boolean checkContainst(String playerName){
        return cooldownMap.containsKey(playerName);
    }

    public long getTime(String playerName){
        return cooldownMap.get(playerName);
    }
}

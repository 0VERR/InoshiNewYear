package pl.inoshi.newyear.fireworks;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.HashSet;
import java.util.Set;

public class Fireworks {

    public Set<ItemStack> getFireworksSet() {
        return fireworksSet;
    }

    private Set<ItemStack> fireworksSet = new HashSet<>();

    public void createFireworks() {
        fireworksBuilder(Color.GREEN, FireworkEffect.Type.BALL_LARGE, 2);
        fireworksBuilder(Color.RED, FireworkEffect.Type.STAR,2);
        fireworksBuilder(Color.PURPLE, FireworkEffect.Type.BALL_LARGE,2);
        fireworksBuilder(Color.LIME, FireworkEffect.Type.BALL_LARGE,2);
        fireworksBuilder(Color.RED, FireworkEffect.Type.BALL_LARGE,2);
        fireworksBuilder(Color.RED, FireworkEffect.Type.STAR,2);
        fireworksBuilder(Color.ORANGE, FireworkEffect.Type.STAR,2);
        fireworksBuilder(Color.GRAY, FireworkEffect.Type.STAR,2);
        fireworksBuilder(Color.GREEN, FireworkEffect.Type.BALL_LARGE, 1);
        fireworksBuilder(Color.RED, FireworkEffect.Type.STAR,1);
        fireworksBuilder(Color.PURPLE, FireworkEffect.Type.BALL_LARGE,1);
        fireworksBuilder(Color.LIME, FireworkEffect.Type.BALL_LARGE,1);
        fireworksBuilder(Color.RED, FireworkEffect.Type.BALL_LARGE,1);
        fireworksBuilder(Color.RED, FireworkEffect.Type.STAR,1);
        fireworksBuilder(Color.ORANGE, FireworkEffect.Type.STAR,1);
        fireworksBuilder(Color.GRAY, FireworkEffect.Type.STAR,1);
        fireworksBuilder(Color.GREEN, FireworkEffect.Type.BALL_LARGE, 1);
    }

    public void fireworksBuilder(Color color, FireworkEffect.Type fireworkEffect, int power){
        ItemStack fireworkItemStack = new ItemStack(Material.FIREWORK,64);
        FireworkMeta fireworkMeta = (FireworkMeta) fireworkItemStack.getItemMeta();
        fireworkMeta.addEffect(FireworkEffect.builder().withColor(color).with(fireworkEffect).build());
        fireworkMeta.setPower(power);
        fireworkItemStack.setItemMeta(fireworkMeta);
        fireworksSet.add(fireworkItemStack);
    }
}

package snus.main;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class SnusCraft extends JavaPlugin{
	
	public void onEnable() {
		getLogger().info("enabled!");
		
		craft();
		Bukkit.getPluginManager().registerEvents(new Vkid(), this);
	}
	
	public void onDisable() {
		getLogger().info("disabled!");
	}
	
	private void craft() {
		ItemStack item = new ItemStack(Material.FIREBALL);
		ItemMeta meta = item.getItemMeta();
		Plugin plugin = SnusCraft.getPlugin(SnusCraft.class);
		meta.setDisplayName(ChatColor.RED + "SNUS(IS BAD!!!)");
		List<String> lore = new ArrayList<String>();
		lore.add("SNUUUS");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.KNOCKBACK, 1, true);
		NamespacedKey nsKey = new NamespacedKey(plugin, "123");
		item.setItemMeta(meta);
		ShapedRecipe s = new ShapedRecipe(nsKey, item);
		
		s.shape(new String[] {"A A", " B ", "A A"});
		s.setIngredient('A', Material.LEATHER);
		s.setIngredient('B', Material.ROTTEN_FLESH);
		Bukkit.getServer().addRecipe(s);
	}
}

package snus.main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Vkid implements Listener{
	@EventHandler
	public void use(PlayerInteractEvent e) {
		
		
		if(e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		if(e.getPlayer().getInventory().getItemInMainHand().getType() != Material.FIREBALL) return;
		
		Player p = e.getPlayer();
		
		ItemStack itemMain = p.getInventory().getItemInMainHand();
		
		if(!itemMain.getItemMeta().hasDisplayName()) return; 
		if (!itemMain.getItemMeta().hasLore())return;
		if (!itemMain.getItemMeta().getDisplayName().equals(ChatColor.RED + "SNUS(IS BAD!!!)")) return;
		if (!itemMain.getItemMeta().getLore().get(0).equals("SNUUUS")) return;
		e.setCancelled(true);
		remover(p);
		addPotion(p);
	}
	
	private void remover(Player p) {
		ItemStack itemMain = p.getInventory().getItemInMainHand();
		
		itemMain.setAmount(itemMain.getAmount() - 1);
		p.getInventory().setItemInMainHand(itemMain);;
		
	}
	private void addPotion(Player p) {
		p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 1000, 2));
		p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 2));
		p.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 10, 1));
		p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 2));
		p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 450, 2));
		p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1600, 1));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 2));
		p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 50, 0));
	}
	
}

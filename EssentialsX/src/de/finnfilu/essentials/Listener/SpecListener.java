package de.finnfilu.essentials.Listener;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!


import de.finnfilu.essentials.Commands.SpecCMD;
import de.finnfilu.essentials.Main.Data;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SpecListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getMaterial() == Material.BARRIER) {
            if (e.getItem().getItemMeta().getDisplayName() == "§4§lBEENDEN") {
                if (SpecCMD.sp.contains(p.getName())) {

                    e.setCancelled(true);

                    SpecCMD.sp.remove(p.getName());

                    p.getInventory().clear();

                    ItemStack[] getoldinv = SpecCMD.oldinv.get(p.getName());
                    Location getoldloc = SpecCMD.oldloc.get(p.getName());

                    p.setGameMode(GameMode.SURVIVAL);
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.showPlayer(p);
                    }
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                    p.sendMessage(Data.pre + "§7Beende Beobachten...");
                    p.getInventory().setContents(getoldinv);
                    p.teleport(getoldloc);


                }
            }
        }


    }

}

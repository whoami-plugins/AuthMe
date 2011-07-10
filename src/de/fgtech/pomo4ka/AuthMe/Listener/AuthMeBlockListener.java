package de.fgtech.pomo4ka.AuthMe.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

import de.fgtech.pomo4ka.AuthMe.AuthMe;

/**
 * AuthMe block listener
 *
 * @author pomo4ka
 */
public class AuthMeBlockListener extends BlockListener {
	private final AuthMe plugin;

	public AuthMeBlockListener(final AuthMe plugin) {
		this.plugin = plugin;
	}

    @Override
	public void onBlockPlace(BlockPlaceEvent event) {
        if(event.isCancelled()) {
            return;
        }
		Player players = event.getPlayer();
		if (!plugin.checkAuth(players)) {
			event.setCancelled(true);
		}
	}

	// NEW------------------
    @Override
	public void onBlockBreak(BlockBreakEvent event) {
        if(event.isCancelled()) {
            return;
        }
		Player players = event.getPlayer();

		if (!plugin.checkAuth(players)) {
			event.setCancelled(true);
		}
	}

}
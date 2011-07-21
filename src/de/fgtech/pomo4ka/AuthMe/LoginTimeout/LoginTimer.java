package de.fgtech.pomo4ka.AuthMe.LoginTimeout;

import org.bukkit.entity.Player;

import de.fgtech.pomo4ka.AuthMe.AuthMe;
import de.fgtech.pomo4ka.AuthMe.MessageHandler.MessageHandler;
import java.util.HashMap;

public class LoginTimer {

    private static class LoginTimerTask implements Runnable {

        private Player player;
        private AuthMe plugin;
        private int tick = 0;
        private int until;

        private LoginTimerTask(AuthMe plugin, Player player) {
            this.player = player;
            this.plugin = plugin;
            this.until = plugin.getSettings().loginTimeout();
        }

        @Override
        public void run() {
            tick += 5;

            if(tick > until) {
                if(player != null) {
                    if(!plugin.getPlayercache().isPlayerAuthenticated(player)
                       && plugin.getPlayercache().isPlayerRegistered(player)) {
                        player.kickPlayer("You took too long to login!");
                        MessageHandler.showInfo(player.getName()
                                                + " took to long to login!");
                    }
                }
                unscheduleLoginTimer(plugin, player);
            } else {
                if(plugin.getPlayercache().isPlayerAuthenticated(player)) {
                    unscheduleLoginTimer(plugin, player);
                    return;
                }
                if(plugin.getPlayercache().isPlayerRegistered(player)) {
                    player.sendMessage(plugin.getMessages().getMessage(
                            "Alert.Login"));
                    return;
                }
                if(plugin.getSettings().ForceRegistration()) {
                    player.sendMessage(plugin.getMessages().getMessage(
                            "Alert.Registration"));
                } else {
                    unscheduleLoginTimer(plugin, player);
                }
            }
        }
    }
    private final static HashMap<String, Integer> tasks = new HashMap<String, Integer>();

    public static void scheduleLoginTimer(AuthMe plugin, Player player) {
        if(plugin.getSettings().loginTimeout() <= 0) {
            return;
        }
        int id = plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(
                plugin, new LoginTimerTask(plugin, player), 100L, 100L);
        tasks.put(player.getName(), id);
    }

    public static void unscheduleLoginTimer(AuthMe plugin, Player player) {
        if(tasks.containsKey(player.getName())) {
            plugin.getServer().getScheduler().cancelTask(tasks.get(player.
                    getName()));
            tasks.remove(player.getName());
        }
    }
}

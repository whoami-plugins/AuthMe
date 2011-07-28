package de.fgtech.pomo4ka.AuthMe.PlayerCache;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayerCache {

    private Map<Player, PlayerData> playerDatatable = new HashMap<Player, PlayerData>();

    public PlayerCache() {
    }

    public void createCache(Player player, boolean registered,
            boolean authenticated, Location spawn) {

        if(!playerDatatable.containsKey(player)) {
            PlayerData data = new PlayerData(registered, authenticated, spawn);
            playerDatatable.put(player, data);
        }

    }

    public void removeCache(Player player) {
        if(playerDatatable.containsKey(player)) {
            playerDatatable.remove(player);
        }
    }

    public void recreateCache(Player player, Location spawn) {
        removeCache(player);
        createCache(player, false, false, spawn);
    }

    public PlayerData getPlayerData(Player player) {
        if(playerDatatable.containsKey(player)) {
            return playerDatatable.get(player);
        }
        return null;
    }

    public boolean isPlayerInCache(Player player) {
        if(playerDatatable.containsKey(player)) {
            return true;
        }
        return false;
    }

    public void setPlayerRegistered(Player player, boolean newvalue) {
        getPlayerData(player).setRegistered(newvalue);
    }

    public boolean isPlayerRegistered(Player player) {
        return isPlayerInCache(player) ? getPlayerData(player).isRegistered()
               : false;
    }

    public void setPlayerAuthenticated(Player player, boolean newvalue) {
        getPlayerData(player).setAuthenticated(newvalue);
    }

    public boolean isPlayerAuthenticated(Player player) {
        return isPlayerInCache(player) ? getPlayerData(player).isAuthenticated() : false;
    }
}

package de.fgtech.pomo4ka.AuthMe.PlayerCache;

import org.bukkit.Location;

public class PlayerData {

    private boolean registered;
    private boolean authenticated;
    private Location spawn;

    public PlayerData(boolean registered, boolean authenticated, Location spawn) {
        this.registered = registered;
        this.authenticated = authenticated;
        this.spawn = spawn;
    }

    public boolean isRegistered() {
        return registered;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setRegistered(boolean newvalue) {
        registered = newvalue;
    }

    public void setAuthenticated(boolean newvalue) {
        authenticated = newvalue;
    }

    public Location getSpawn() {
        return spawn;
    }
}

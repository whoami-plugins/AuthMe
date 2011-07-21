package de.fgtech.pomo4ka.AuthMe.PlayerCache;

public class PlayerData {

    private boolean registered;
    private boolean authenticated;

    public PlayerData(boolean registered, boolean authenticated) {
        this.registered = registered;
        this.authenticated = authenticated;
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
}
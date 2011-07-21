package de.fgtech.pomo4ka.AuthMe.DataSource;

import java.util.Map;

import java.util.HashMap;

public interface DataSource {

    public HashMap<String, String> loadAllAuths();

    public boolean saveAuth(String playername, String hash,
            Map<String, String> customInformation);

    public boolean updateAuth(String playername, String hash);

    public boolean removeAuth(String playername);

    public String loadHash(String playername);

    public boolean isPlayerRegistered(String playername);

    public int getRegisteredPlayerAmount();
}

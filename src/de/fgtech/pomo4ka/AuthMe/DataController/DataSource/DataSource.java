package de.fgtech.pomo4ka.AuthMe.DataController.DataSource;

import java.util.Map;

import de.fgtech.pomo4ka.AuthMe.DataController.RegistrationCache.RegistrationCache;

public abstract class DataSource {

	public abstract RegistrationCache loadAllAuths();
	public abstract boolean saveAuth(String playername, String hash, Map<String, String> customInformation);
	public abstract boolean updateAuth(String playername, String hash);
	public abstract boolean removeAuth(String playername);
	public abstract String loadHash(String playername);
	public abstract boolean isPlayerRegistered(String playername);
	public abstract int getRegisteredPlayerAmount();
	
}

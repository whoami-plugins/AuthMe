package de.fgtech.pomo4ka.AuthMe.DataController;

import java.util.Map;


import de.fgtech.pomo4ka.AuthMe.DataController.DataSource.DataSource;
import java.util.HashMap;

public class DataController {

	private DataSource datas;
	private HashMap<String,String> regcache;
	private boolean caching = false;

	public DataController(DataSource dataf, boolean caching) {
		this.datas = dataf;
		this.caching = caching;

		if (caching) {
			this.regcache = dataf.loadAllAuths();
		}
	}

	public boolean saveAuth(String playername, String hash,
			Map<String, String> customInformation) {
		boolean executed = datas.saveAuth(playername.toLowerCase(), hash,
				customInformation);

		if (caching && executed) {
            regcache.put(playername.toLowerCase(), hash);
		}
		return executed;
	}

	public boolean removeAuth(String playername) {
		boolean executed = datas.removeAuth(playername.toLowerCase());

		if (caching && executed) {
			regcache.remove(playername.toLowerCase());
		}
		return executed;
	}

	public boolean updateAuth(String playername, String hash) {
		boolean executed = datas.updateAuth(playername.toLowerCase(), hash);

		if (caching && executed) {
            regcache.put(playername.toLowerCase(), hash);
		}
		return executed;
	}

	public String getHash(String playername) {
		if (caching) {
			return regcache.get(playername.toLowerCase());
		}
		return datas.loadHash(playername.toLowerCase());
	}

	public boolean isPlayerRegistered(String playername) {
		if (caching) {
			return regcache.containsKey(playername.toLowerCase());
		}
		return datas.isPlayerRegistered(playername.toLowerCase());
	}

	public int getRegisteredPlayerAmount() {
		if (caching) {
			return regcache.size();
		}
		return datas.getRegisteredPlayerAmount();
	}

}

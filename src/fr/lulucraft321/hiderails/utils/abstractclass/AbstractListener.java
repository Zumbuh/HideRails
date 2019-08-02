/**
 * Copyright Java Code
 * All right reserved.
 *
 * @author lulucraft321
 */

package fr.lulucraft321.hiderails.utils.abstractclass;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import fr.lulucraft321.hiderails.HideRails;

public class AbstractListener implements Listener
{
	public AbstractListener() {
		Bukkit.getServer().getPluginManager().registerEvents(this, HideRails.getInstance());
	}
}

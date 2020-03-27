/**
 * Copyright Java Code
 * All right reserved.
 *
 * @author Nepta_
 */

package fr.lulucraft321.hiderails.configurations.configs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import fr.lulucraft321.hiderails.managers.FileConfigurationManager;
import fr.lulucraft321.hiderails.utils.abstractclass.AbstractLangConfig;

public class Hongrois extends FileConfigurationManager implements AbstractLangConfig
{
	@Override
	public void setupConfig()
	{
		// HU.yml
		FileConfigurationManager.huLangFile = new File(FileConfigurationManager.LANG_PATH, "HU.yml");
		if(!FileConfigurationManager.huLangFile.exists())
		{
			try {
				FileConfigurationManager.huLangFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Erreur lors de la creation du fichier de configuration \"" + FileConfigurationManager.huLangConfig.getName().toString() + "\" !");
				return;
			}

			FileConfigurationManager.huLangConfig = YamlConfiguration.loadConfiguration(FileConfigurationManager.huLangFile);
			FileConfigurationManager.huLangConfig.options().header("Köszönöm Zsomi-nak hogy leforditotta magyarra !").copyDefaults(true);
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "sender_type_error", "&cEzt a parancsot csak játékosként hajtható végre !");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "player_no_enough_permission", "&cNincs jogosultságod ehhez !");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "rail_success_change", "&2Kicserélted a sínt a következő blokkra: %blocktype% !");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "material_type_error", "&cEz a blokk nem létezik !");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "rail_error", "&cA keresett blokk nem sín !");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "rail_success_break", "&2Kiütöttél egy rejtett sínt !");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "rail_success_unhide", "&2Megjelenítetted a sineket !");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "water_protection_status_success_change", "&2Ez a(z) %status% státusza a víz alatti védelem ebben a világban %world%");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "invalid_worldname", "&cA világ neve hibás !");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "plugin_success_reloaded", "&aA plugin sikeresen reloadolva(újratöltve)!");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "water_protection_status_already", "&cA víz alatti védelem a(z) %world% világban %status%");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "no_backup", "&cNincsenek mentések !");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "return_backup_success", "&2Sikeresen vissza lett állítva a mentés !");
			//FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "worldedit_not_installed", "&cNincs letöltve a szerverre a WorldEdit plugin !");
			//FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "worldedit_no_selection", "&cElső lépés, hogy jelöld ki WorldEdit-el a területet !");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "hiderails_no_selection", "&cYou must first select region with wooden-axe!");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "hiderails_selection_pos", "&8You have selected position &e%pos%");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "selection_message_status", "&8You have &e%status% &8selection messages!");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "display_hidden_blocks", "&2Szamoda a(z) %hide% blokk rejtett !");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "invalid_player", "&cA játékos nem található !");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "update_found", "&bÙj frissitès elèrhető !\n&o%link%");
			FileConfigurationManager.huLangConfig.set(FileConfigurationManager.MSG_PATH + "kick_spam_hidden_block", "&cNe spameld a blokkokat !!");

			// Sauveguarde des modifs
			try {
				FileConfigurationManager.huLangConfig.save(FileConfigurationManager.huLangFile);
			} catch (IOException e) { System.err.println("Erreur lors de la sauveguarde du fichier de configuration \"" + FileConfigurationManager.huLangConfig.getName().toString() + "\" !"); }
		} else {
			FileConfigurationManager.huLangConfig = YamlConfiguration.loadConfiguration(FileConfigurationManager.huLangFile);
			FileConfigurationManager.huLangConfig.options().header("Köszönöm Zsomi-nak hogy leforditotta magyarra !").copyDefaults(true);
			checkConfContains(FileConfigurationManager.huLangConfig, "sender_type_error", "&cEzt a parancsot csak játékosként hajtható végre !");
			checkConfContains(FileConfigurationManager.huLangConfig, "player_no_enough_permission", "&cNincs jogosultságod ehhez !");
			checkConfContains(FileConfigurationManager.huLangConfig, "rail_success_change", "&2Kicserélted a sínt a következő blokkra: %blocktype% !");
			checkConfContains(FileConfigurationManager.huLangConfig, "material_type_error", "&cEz a blokk nem létezik !");
			checkConfContains(FileConfigurationManager.huLangConfig, "rail_error", "&cA keresett blokk nem sín !");
			checkConfContains(FileConfigurationManager.huLangConfig, "rail_success_break", "&2Kiütöttél egy rejtett sínt !");
			checkConfContains(FileConfigurationManager.huLangConfig, "rail_success_unhide", "&2Megjelenítetted a sineket !");
			checkConfContains(FileConfigurationManager.huLangConfig, "water_protection_status_success_change", "&2Ez a(z) %status% státusza a víz alatti védelem ebben a világban %world%");
			checkConfContains(FileConfigurationManager.huLangConfig, "invalid_worldname", "&cA világ neve hibás !");
			checkConfContains(FileConfigurationManager.huLangConfig, "plugin_success_reloaded", "&aA plugin sikeresen reloadolva(újratöltve)!");
			checkConfContains(FileConfigurationManager.huLangConfig, "water_protection_status_already", "&cA víz alatti védelem a(z) %world% világban %status%");
			checkConfContains(FileConfigurationManager.huLangConfig, "no_backup", "&cNincsenek mentések !");
			checkConfContains(FileConfigurationManager.huLangConfig, "return_backup_success", "&2Sikeresen vissza lett állítva a mentés !");
			//checkConfContains(FileConfigurationManager.huLangConfig, "worldedit_not_installed", "&cNincs letöltve a szerverre a WorldEdit plugin !");
			//checkConfContains(FileConfigurationManager.huLangConfig, "worldedit_no_selection", "&cElső lépés, hogy jelöld ki WorldEdit-el a területet !");
			checkConfContains(FileConfigurationManager.huLangConfig, "hiderails_no_selection", "&cYou must first select region with wooden-axe!");
			checkConfContains(FileConfigurationManager.huLangConfig, "hiderails_selection_pos", "&8You have selected position &e%pos%");
			checkConfContains(FileConfigurationManager.huLangConfig, "selection_message_status", "&8You have &e%status% &8selection messages!");
			checkConfContains(FileConfigurationManager.huLangConfig, "display_hidden_blocks", "&2Szamoda a(z) %hide% blokk rejtett !");
			checkConfContains(FileConfigurationManager.huLangConfig, "invalid_player", "&cA játékos nem található !");
			checkConfContains(FileConfigurationManager.huLangConfig, "update_found", "&bÙj frissitès elèrhető !\n&o%link%");
			checkConfContains(FileConfigurationManager.huLangConfig, "kick_spam_hidden_block", "&cNe spameld a blokkokat !!");

			// Sauveguarde des modifs
			try {
				FileConfigurationManager.huLangConfig.save(FileConfigurationManager.huLangFile);
			} catch (IOException e) { System.err.println("Erreur lors de la sauveguarde du fichier de configuration \"" + FileConfigurationManager.huLangConfig.getName().toString() + "\" !"); }
		}
		FileConfigurationManager.huLangConfig = YamlConfiguration.loadConfiguration(FileConfigurationManager.huLangFile);
		//
	}
}
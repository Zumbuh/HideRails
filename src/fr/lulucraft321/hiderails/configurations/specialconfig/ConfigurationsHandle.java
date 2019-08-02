/**
 * Copyright Java Code
 * All right reserved.
 *
 * @author Nepta_
 */

package fr.lulucraft321.hiderails.configurations.specialconfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

import org.bukkit.plugin.Plugin;

import fr.lulucraft321.hiderails.HideRails;

public class ConfigurationsHandle
{
	private final Plugin plugin = HideRails.getInstance();
	private final File path = plugin.getDataFolder();

	public Configuration createConfig(String fileName, List<String> header, String existingResource) throws IOException {
		final File f = new File(path, fileName);

		if (!path.exists()) {
			path.mkdirs();
		}

		if (!f.exists()) {
			if (existingResource == null) {
				f.createNewFile();
			} else {
				cloneConfig(fileName, existingResource);
			}
		}

		return new Configuration(f, header);
	}

	/**
	 * Clone existing ressource
	 * 
	 * @param fileName
	 * @param existingResource
	 */
	public void cloneConfig(String fileName, String existingResource) {
		final File confF = new File(path, fileName);
		final File confFile = new File(path, existingResource);

		if (confFile.exists()) {
			try (InputStream in = new FileInputStream(confFile)) {
				Files.copy(in, confF.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			new Exception("Le fichier de configuration " + fileName + " n'existe pas !");
		}
	}


	/**
	 * Serialize to avoid breaking comments
	 * 
	 * @param configString
	 * @return config content
	 */
	protected String prepareConfigString(String configString) {
		String[] lines = configString.split("\n");
		StringBuilder configLines = new StringBuilder("");
		
		for(String line : lines) {
			
			/*
			 * If file is new
			 */
			if (line.startsWith("_"))
			{
				// Fist line to Header
				if (line.startsWith(Configuration.headPrefix)) {
					configLines.append(line.replace(line, "#############################################################"));
				}
				// Text line to Header
				else if (line.startsWith(Configuration.headerPrefix)) {
					String ser_value = line.split(": ")[1].toString();
					
					// Number ok space between border and text
					// 60 is size of head (#####...) -1
					int nbr = ser_value.length();
					int bText = (60-nbr)/2;
					
					// even (pair)
					if ((nbr & 1) == 0) {
						configLines.append(line.replace(line, "#" + repeat(bText) + ser_value + repeat(bText-1) + "#"));
					}
					// odd (impair)
					else {
						configLines.append(line.replace(line, "#" + repeat(bText) + ser_value + repeat(bText) + "#"));
					}
					
				}
				// Retours � la ligne
				else if (line.startsWith(Configuration.voidPrefix)) {
					String ser_path = line.substring(0, line.split(": ")[0].length()).toString();
					configLines.append(line.replace(ser_path + ": " + Configuration.voidPrefix, ""));
				}
				// Commentaires
				else if (line.startsWith(Configuration.commPrefix)) {
					String ser_path = line.substring(0, line.split(": ")[0].length()).toString();
					configLines.append(line.replace(ser_path + ": ", "# "));
				}
				else {
					configLines.append(line);
				}
				
			}
			// Ligne de config
			else {
				configLines.append(line);
			}
			
			configLines.append("\n");
			
		}
		
		return configLines.toString();
	}
	
	private String repeat(int count) {
		// \0 is null character
		// Replace number with space
		return new String(new char[count]).replace("\0", " ");
	}



	/**
	 * Save commented config
	 */
	protected void saveConfig(String configString, File configFile) {
		final String configuration = this.prepareConfigString(configString);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(configFile));
			writer.write(configuration);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

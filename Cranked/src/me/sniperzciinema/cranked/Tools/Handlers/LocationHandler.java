
package me.sniperzciinema.cranked.Tools.Handlers;

import me.sniperzciinema.cranked.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;


public class LocationHandler {

	
	public static Location getObjectLocation(String loc) {
		String[] floc = loc.split(",");
		World world = Bukkit.getServer().getWorld(floc[0]);
		Location Loc = new Location(world, Double.valueOf(floc[1]),
				Double.valueOf(floc[2]), Double.valueOf(floc[3]));
		return Loc;
	}
	public static Location getPlayerLocation(String loc) {
		String[] floc = loc.split(",");
		World world = Bukkit.getServer().getWorld(floc[0]);
		Location Loc = new Location(world, Double.valueOf(floc[1]),
				Double.valueOf(floc[2])+.5, Double.valueOf(floc[3]),
				Float.valueOf(floc[4]), Float.valueOf(floc[5]));
		
		if (!Bukkit.getServer().getWorld(world.getName()).getChunkAt(Loc).isLoaded())
			Bukkit.getServer().getWorld(world.getName()).getChunkAt(Loc).load();
		return Loc;
	}
	

	public static String getLocationToString(Location loc) {
		double ix = loc.getX();
		double iy = loc.getY();
		double iz = loc.getZ();
		World world = loc.getWorld();
		float yaw = loc.getYaw();
		float pitch = loc.getPitch();
		String s = world.getName() + "," + ix + "," + iy + "," + iz+ "," + yaw+ "," + pitch;
		return s;
	}


	public static void saveLocation(Location loc, String saveto) {
		double ix = loc.getX();
		double iy = loc.getY();
		double iz = loc.getZ();
		World world = loc.getWorld();
		float yaw = loc.getYaw();
		float pitch = loc.getPitch();
		String s = world.getName() + "," + ix + "," + iy + "," + iz + "," + yaw + "," + pitch;
		Main.me.getConfig().set(saveto, s);
		Main.me.saveConfig();
	}

}

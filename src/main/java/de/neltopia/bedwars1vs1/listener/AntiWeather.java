package de.neltopia.bedwars1vs1.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class AntiWeather implements Listener {

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        if (!event.toWeatherState()) {
            return;
        }
        event.setCancelled(true);
        event.getWorld().setWeatherDuration(0);
        event.getWorld().setThundering(false);
    }
}

package com.mcstats;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.JsonObject;
import java.io.IOException;
import com.google.gson.JsonParser;

import static com.mcstats.NetworkUtils.postNewStat;

public class Minecraftstats implements ModInitializer {
	public static final String MOD_ID = "minecraftstats";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("MCStats loading");

        try {
            String jsonString = "{ 'name': 'Games Loaded', 'playerName': 'Draco', 'count': '1'}";
            JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonString);
            postNewStat("http://localhost:3001/stats/new", jsonObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
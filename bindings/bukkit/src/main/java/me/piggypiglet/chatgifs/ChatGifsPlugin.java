package me.piggypiglet.chatgifs;

import org.bukkit.plugin.java.JavaPlugin;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class ChatGifsPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        ChatGifs.builder()
                .main(this)
                .dataFolder(getDataFolder().getPath())
                .build()
                .init();
    }
}

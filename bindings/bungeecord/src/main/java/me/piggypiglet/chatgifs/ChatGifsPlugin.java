package me.piggypiglet.chatgifs;

import net.md_5.bungee.api.plugin.Plugin;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class ChatGifsPlugin extends Plugin {
    @Override
    public void onEnable() {
        ChatGifs.builder()
                .main(this)
                .dataFolder(getDataFolder().getPath())
                .build()
                .init();
    }
}

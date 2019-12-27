package me.piggypiglet.chatgifs;

import cn.nukkit.plugin.PluginBase;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class ChatGifsPlugin extends PluginBase {
    @Override
    public void onEnable() {
        ChatGifs.builder()
                .main(this)
                .dataFolder(getDataFolder().getPath())
                .build()
                .init();
    }
}

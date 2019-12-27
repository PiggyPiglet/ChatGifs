package me.piggypiglet.chatgifs;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;

import java.nio.file.Path;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
@Plugin(
        id = "chatgifs",
        name = "ChatGifs",
        version = "1.0.0",
        authors = "PiggyPiglet",
        url = "https://piggypiglet.me"
)
public final class ChatGifsPlugin {
    @Inject @ConfigDir(sharedRoot = false) private Path path;
    @Inject
    private Injector injector;

    @Listener
    public void onEnable(GameInitializationEvent e) {
        ChatGifs.builder()
                .main(this)
                .dataFolder(path.toString())
                .injector(injector)
                .build()
                .init();
    }
}

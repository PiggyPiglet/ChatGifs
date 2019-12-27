package me.piggypiglet.chatgifs.bootstrap;

import com.google.inject.Injector;
import me.piggypiglet.chatgifs.ChatGifs;
import me.piggypiglet.framework.Framework;
import me.piggypiglet.framework.utils.annotations.files.Config;
import me.piggypiglet.framework.utils.annotations.files.Lang;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class ChatGifsBootstrap {
    private final ChatGifs configuration;

    public ChatGifsBootstrap(ChatGifs configuration) {
        this.configuration = configuration;
    }

    public void start() {
        final Framework.FrameworkBuilder builder = Framework.builder()
                .main(configuration.getMain())
                .pckg("me.piggypiglet.chatgifs")
                .commandPrefixes("cg")
                .fileDir(configuration.getDataFolder())
                .file(true, "config", "/config.yml", "config.yml", Config.class)
                .file(true, "lang", "/lang.yml", "lang.yml", Lang.class)
                .customLang("lang", me.piggypiglet.chatgifs.lang.Lang.values());

        final Injector injector = configuration.getInjector();

        if (injector != null) {
            builder.injector(injector);
        }

        builder
                .build()
                .init();
    }
}

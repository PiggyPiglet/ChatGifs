package me.piggypiglet.chatgifs;

import com.google.inject.Injector;
import me.piggypiglet.chatgifs.bootstrap.ChatGifsBootstrap;
import me.piggypiglet.framework.utils.builder.BuilderUtils;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class ChatGifs {
    private final Object main;
    private final String dataFolder;
    private final Injector injector;

    private ChatGifs(Object main, String dataFolder, Injector injector) {
        this.main = main;
        this.dataFolder = dataFolder;
        this.injector = injector;
    }

    public Object getMain() {
        return main;
    }

    public String getDataFolder() {
        return dataFolder;
    }

    public Injector getInjector() {
        return injector;
    }

    public void init() {
        new ChatGifsBootstrap(this).start();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Object main = "d-main";
        private String dataFolder = "d-dataFolder";
        private Injector injector = null;

        private Builder() {}

        public Builder main(Object main) {
            this.main = main;
            return this;
        }

        public Builder dataFolder(String dataFolder) {
            this.dataFolder = dataFolder;
            return this;
        }

        public Builder injector(Injector injector) {
            this.injector = injector;
            return this;
        }

        public ChatGifs build() {
            BuilderUtils.checkVars("ChatGifs Builder", main, dataFolder);

            return new ChatGifs(main, dataFolder, injector);
        }
    }
}

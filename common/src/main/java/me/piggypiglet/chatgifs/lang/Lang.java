package me.piggypiglet.chatgifs.lang;

import me.piggypiglet.framework.lang.LangEnum;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public enum Lang implements LangEnum {
    RELOAD_ERROR("commands.reload.error"),
    RELOAD_SUCCESS("commands.reload.success"),

    GIF_ERROR("commands.gif.error"),
    GIF_UNKNOWN("commands.gif.unknown");

    private final String path;

    Lang(String path) {
        this.path = path;
    }

    @Override
    public String getPath() {
        return path;
    }
}

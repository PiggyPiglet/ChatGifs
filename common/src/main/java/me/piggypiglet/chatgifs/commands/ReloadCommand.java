package me.piggypiglet.chatgifs.commands;

import com.google.inject.Inject;
import me.piggypiglet.chatgifs.lang.Lang;
import me.piggypiglet.framework.file.FileManager;
import me.piggypiglet.framework.minecraft.commands.framework.MinecraftCommand;
import me.piggypiglet.framework.minecraft.user.MinecraftUser;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class ReloadCommand extends MinecraftCommand {
    @Inject private FileManager fileManager;

    public ReloadCommand() {
        super("reload");
        options.root()
                .description("Reload the plugin.")
                .usage("")
                .description("chatgifs.reload");
    }

    @Override
    protected boolean execute(MinecraftUser user, String[] args) {
        try {
            fileManager.update("config");
        } catch (Exception e) {
            user.sendMessage(Lang.RELOAD_ERROR);
            e.printStackTrace();
            return false;
        }

        user.sendMessage(Lang.RELOAD_SUCCESS);

        return true;
    }
}

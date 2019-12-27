package me.piggypiglet.chatgifs.commands;

import com.google.inject.Inject;
import me.piggypiglet.chatgifs.lang.Lang;
import me.piggypiglet.chatgifs.tasks.GifTask;
import me.piggypiglet.framework.file.framework.FileConfiguration;
import me.piggypiglet.framework.minecraft.commands.framework.MinecraftCommand;
import me.piggypiglet.framework.minecraft.user.MinecraftUser;
import me.piggypiglet.framework.task.Task;
import me.piggypiglet.framework.utils.annotations.files.Config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class GifCommand extends MinecraftCommand {
    @Inject @Config private FileConfiguration config;
    @Inject private Task task;

    public GifCommand() {
        super("gif");
        options.root()
                .usage("<gif>")
                .description("Show a gif.")
                .permissions("chatgifs.gif");
    }

    @Override
    protected boolean execute(MinecraftUser user, String[] args) {
        if (args.length > 0) {
            if (config.get(args[0]) == null) {
                user.sendMessage(Lang.GIF_UNKNOWN, args[0]);
                return true;
            }

            final FileConfiguration gif = config.getConfigSection(args[0]);
            final BlockingQueue<String> queue = gif.getStringList("keys").stream().map(s -> "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n" + s).collect(Collectors.toCollection(LinkedBlockingQueue::new));
            final GifTask gifTask = new GifTask(user, queue);
            final String millis = 1000 / gif.getInt("fps") + "ms";

            task.async(r -> {
                final boolean bool = gifTask.run();

                if (bool) {
                    task.async(r2 -> r.run(), millis, false);
                }
            });

            return true;
        }

        return false;
    }
}

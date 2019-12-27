package me.piggypiglet.chatgifs.tasks;

import me.piggypiglet.chatgifs.lang.Lang;
import me.piggypiglet.framework.user.User;

import java.util.concurrent.BlockingQueue;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class GifTask {
    private final User user;
    private final BlockingQueue<String> queue;

    public GifTask(User user, BlockingQueue<String> queue) {
        this.user = user;
        this.queue = queue;
    }

    public boolean run() {
        if (queue.isEmpty()) {
            return false;
        }

        try {
            user.sendMessage(queue.take());
        } catch (Exception e) {
            e.printStackTrace();
            user.sendMessage(Lang.GIF_ERROR);
        }

        return true;
    }
}

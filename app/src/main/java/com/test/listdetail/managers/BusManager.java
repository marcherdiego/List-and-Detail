package com.test.listdetail.managers;

import com.squareup.otto.Bus;

public class BusManager {
    private static final Bus BUS_INSTANCE = new MainPostingBus();

    private BusManager() {
    }

    public static Bus getInstance() {
        return BUS_INSTANCE;
    }

    public static void register(Object... objects) {
        for (Object o : objects) {
            if (o != null) {
                BUS_INSTANCE.register(o);
            }
        }
    }

    public static void unregister(Object... objects) {
        for (Object o : objects) {
            if (o != null) {
                BUS_INSTANCE.unregister(o);
            }
        }
    }
}

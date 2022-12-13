package com.techorzo.kwality.kitchen.setup;

public class BackUpHandler {

    public synchronized static BackUpHandler getInstance() {
        return _HOLDER._Instance;
    }

    /*
    ToDo:
        -> Handles backing up of data, how? No fucking clue
     */

    private static class _HOLDER {
        private static BackUpHandler _Instance = new BackUpHandler();
    }
}

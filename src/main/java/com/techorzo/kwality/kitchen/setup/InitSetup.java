package com.techorzo.kwality.kitchen.setup;

public class InitSetup {

    /*
    ToDo:
        -> Do Initial steps here
        -> May delete this later in favour of running this directly from Main Class
     */


    public synchronized static InitSetup getInstance() {
        return _HOLDER._Instance;
    }

    private static class _HOLDER {
        private static InitSetup _Instance = new InitSetup();
    }
}

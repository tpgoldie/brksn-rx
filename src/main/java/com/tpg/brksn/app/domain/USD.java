package com.tpg.brksn.app.domain;

public class USD extends Currency {

    private static final USD USD = new USD();

    public static USD USD() {
        return USD;
    }

    private USD() {
        super( "USD", "US Dollar", "$");
    }
}

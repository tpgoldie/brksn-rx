package com.tpg.brksn.app.domain;

public class GBP extends Currency {

    private static final GBP GBP = new GBP();

    public static GBP GBP() { return GBP; }

    private GBP() {
        super("GBP", "Pound Sterling", "£");
    }
}

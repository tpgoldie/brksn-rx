package com.tpg.brksn.app.domain;

import lombok.Getter;

@Getter
public abstract class Currency {

    private final String name;
    private final String description;
    private final String symbol;

    Currency(String name, String description, String symbol) {
        this.name = name;
        this.description = description;
        this.symbol = symbol;
    }
}

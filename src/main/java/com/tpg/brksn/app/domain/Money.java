package com.tpg.brksn.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Money {

    private Currency currency;
    private BigDecimal amount;
}

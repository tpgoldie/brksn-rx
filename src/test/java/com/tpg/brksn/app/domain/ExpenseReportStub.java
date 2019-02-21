package com.tpg.brksn.app.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExpenseReportStub implements ExpenseReport {
    private String description;
    private Money totalAmount;
    private LocalDate dateCreated;
    private ReportingPeriod reportingPeriod;
    private ReportStatus reportStatus;
}

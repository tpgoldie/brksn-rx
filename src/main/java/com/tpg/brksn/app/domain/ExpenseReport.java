package com.tpg.brksn.app.domain;

import java.time.LocalDate;

public interface ExpenseReport {

    Money getTotalAmount();

    String getDescription();

    LocalDate getDateCreated();

    ReportingPeriod getReportingPeriod();

    ReportStatus getReportStatus();
}

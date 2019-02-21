package com.tpg.brksn.app.domain;

import java.time.LocalDate;

public interface ExpenseReportFixture {

    default ExpenseReport expenseReport(String description, LocalDate dateCreated, ReportingPeriod reportingPeriod,
                                        Money amount, ReportStatus reportStatus) {
        ExpenseReportStub report = new ExpenseReportStub();

        report.setDescription(description);
        report.setReportingPeriod(reportingPeriod);
        report.setDateCreated(dateCreated);
        report.setReportStatus(reportStatus);
        report.setTotalAmount(amount);

        return report;
    }
}

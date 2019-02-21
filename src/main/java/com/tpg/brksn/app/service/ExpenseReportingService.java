package com.tpg.brksn.app.service;

import com.tpg.brksn.app.domain.ExpenseReport;

import java.util.List;

public interface ExpenseReportingService {

    List<ExpenseReport> getExpensesReports();
}

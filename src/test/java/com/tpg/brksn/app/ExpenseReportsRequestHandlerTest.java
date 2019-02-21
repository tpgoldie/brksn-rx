package com.tpg.brksn.app;

import com.tpg.brksn.app.domain.*;
import com.tpg.brksn.app.handlers.ExpenseReportsRequestHandler;
import com.tpg.brksn.app.service.ExpenseReportingService;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;

import static com.tpg.brksn.app.domain.GBP.GBP;
import static com.tpg.brksn.app.domain.ReportStatus.PROCESSED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseReportsRequestHandlerTest implements ExpenseReportFixture {

    private static final LocalDate NOW = LocalDate.now();

    @Mock
    private ExpenseReportingService expenseReportingService;

    @Mock
    private ServerRequest request;

    @InjectMocks
    private ExpenseReportsRequestHandler handler;

    private ExpenseReport expenseReport;

    @Before
    public void setUp() {

        ReportingPeriod reportingPeriod = new ReportingPeriod(NOW.minusMonths(3), NOW);
        Money amount = new Money(GBP(), new BigDecimal("2358.13"));

        expenseReport = expenseReport("Report 1", NOW, reportingPeriod, amount, PROCESSED);
    }

    @Test
    public void handleGetExpenseReportsSuccessfully() {

        when(expenseReportingService.getExpensesReports()).thenReturn(Collections.singletonList(expenseReport));

        Mono<ServerResponse> actual = handler.getExpenseReports(request);
        StepVerifier.create(actual)
            .assertNext(this::assertResult)
            .verifyComplete();
    }

    private void assertResult(ServerResponse result) {
        assertThat(result.statusCode()).isEqualTo(200);
    }
}

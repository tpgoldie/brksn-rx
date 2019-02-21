package com.tpg.brksn.app.routers;

import com.tpg.brksn.app.domain.ExpenseReport;
import com.tpg.brksn.app.domain.ExpenseReportStub;
import com.tpg.brksn.app.domain.Money;
import com.tpg.brksn.app.service.ExpenseReportingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

import static com.tpg.brksn.app.domain.GBP.GBP;
import static com.tpg.brksn.app.domain.ReportStatus.PROCESSED;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@RunWith(SpringRunner.class)
@WebFluxTest(ExpenseReportingRouter.class)
public class ExpenseReportingRouterTest {
    @Mock
    private ExpenseReport expenseReport;

    @MockBean
    private ExpenseReportingService expenseReportingService;

    @Autowired
    private WebTestClient webTestClient;

    private ExpenseReportingRouter router;

    @Before
    public void setUp() {

        expenseReport = new ExpenseReportStub();

        ((ExpenseReportStub) expenseReport).setDescription("Report 1");
        ((ExpenseReportStub) expenseReport).setDateCreated(LocalDate.now());
        ((ExpenseReportStub) expenseReport).setReportStatus(PROCESSED);
        ((ExpenseReportStub) expenseReport).setTotalAmount(new Money(GBP(), new BigDecimal("2358.13")));

        router = new ExpenseReportingRouter();
    }

    @Test
    public void getExpensesReports() {
        when(expenseReportingService.getExpensesReports()).thenReturn(Collections.singletonList(expenseReport));

        webTestClient.get().uri("/expenses/reports").accept(APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ExpenseReport.class).hasSize(1).contains(expenseReport);

    }
}

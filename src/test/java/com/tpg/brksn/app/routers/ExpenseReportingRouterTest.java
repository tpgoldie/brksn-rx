package com.tpg.brksn.app.routers;

import com.tpg.brksn.app.domain.ExpenseReport;
import com.tpg.brksn.app.domain.ExpenseReportFixture;
import com.tpg.brksn.app.domain.Money;
import com.tpg.brksn.app.domain.ReportingPeriod;
import com.tpg.brksn.app.handlers.ExpenseReportsRequestEndpoint;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.tpg.brksn.app.domain.GBP.GBP;
import static com.tpg.brksn.app.domain.ReportStatus.PROCESSED;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = {"dev_test"})
@WebFluxTest(ExpenseReportingRouter.class)
public class ExpenseReportingRouterTest implements ExpenseReportFixture {

    private static final LocalDate NOW = LocalDate.now();

    @Mock
    private ExpenseReport expenseReport;

    @MockBean
    private ExpenseReportsRequestEndpoint expenseReportsRequestEndpoint;

    @Autowired
    private WebTestClient webTestClient;

    @Before
    public void setUp() {

        Money money = new Money(GBP(), new BigDecimal("2358.13"));
        ReportingPeriod reportingPeriod = new ReportingPeriod(NOW.minusMonths(3), NOW);

        expenseReport = expenseReport("Report 1", LocalDate.now(), reportingPeriod, money, PROCESSED);
    }

    @Test
    @WithMockUser(username="brksn", password = "brksn-123")
    public void getExpensesReports() {

//        Mono<ServerResponse> response = Mono.create(ServerResponse.ok()
//                .contentType(APPLICATION_JSON).body(singletonList(expenseReport), List.class));
//
//        when(expenseReportsRequestEndpoint.getExpenseReports(isA(ServerRequest.class))).thenReturn(response);

        webTestClient
                .get().uri("/expenses/reports")
                .accept(APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ExpenseReport.class).hasSize(1).contains(expenseReport);

    }
}

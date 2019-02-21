package com.tpg.brksn.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes=BrksnAppApplication.class)
public class GetExpenseReportsIT {

    @LocalServerPort
    private int serverPort;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @WithMockUser(username="user-1", password = "pwd-1")
    public void getExpenseReports() {

        webTestClient.get().uri("/expenseReports")
                .accept(APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                    .jsonPath("$[0].expenseReports[0].name")
                    .isEqualTo("Expense Report 1");
    }
}

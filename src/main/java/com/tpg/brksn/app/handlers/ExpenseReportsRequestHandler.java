package com.tpg.brksn.app.handlers;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ExpenseReportsRequestHandler implements ExpenseReportsRequestEndpoint {

    public Mono<ServerResponse> getExpenseReports(ServerRequest request) {
        return null;
    }
}

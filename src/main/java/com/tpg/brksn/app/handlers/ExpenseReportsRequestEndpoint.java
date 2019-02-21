package com.tpg.brksn.app.handlers;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface ExpenseReportsRequestEndpoint {
    Mono<ServerResponse> getExpenseReports(ServerRequest request);
}

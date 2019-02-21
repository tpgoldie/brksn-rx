package com.tpg.brksn.app.routers;

import com.tpg.brksn.app.handlers.ExpenseReportsRequestHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;

@Configuration
public class ExpenseReportingRouter {
    public RouterFunction<ServerResponse> route(ExpenseReportsRequestHandler handler) {
        return nest(RequestPredicates.path("/brksn/expenses"),
                RouterFunctions.route(GET("/reports")
                        .and(accept(APPLICATION_JSON_UTF8)), handler::getExpenseReports));
    }
}

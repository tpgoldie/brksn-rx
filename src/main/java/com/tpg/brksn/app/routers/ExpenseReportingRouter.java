package com.tpg.brksn.app.routers;

import com.tpg.brksn.app.handlers.ExpenseReportsRequestEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;

@Configuration
public class ExpenseReportingRouter {
    public RouterFunction<ServerResponse> routes(ExpenseReportsRequestEndpoint endpoint) {
        return nest(path("/expenses"),
                getExpenseReports(endpoint));
    }

    private RouterFunction<ServerResponse> getExpenseReports(ExpenseReportsRequestEndpoint endpoint) {
//        return RouterFunctions.route(GET("/expenses/reports")
//                .and(accept(APPLICATION_JSON_UTF8)), endpoint::getExpenseReports);
        return RouterFunctions.route(GET("/reports"), endpoint::getExpenseReports);
    }
}

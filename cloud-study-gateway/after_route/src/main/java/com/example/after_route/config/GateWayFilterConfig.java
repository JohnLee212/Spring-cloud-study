package com.example.after_route.config;

import com.example.after_route.factory.RequestTimeGatewayFilterFactory;
import com.example.after_route.filter.HostAddrKeyResolver;
import com.example.after_route.filter.RequestTimeFilter;
import com.example.after_route.filter.TokenFilter;
import com.example.after_route.filter.UriKeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author John Lee
 * @Version 1.0
 * @Description GateWay过滤器配置
 * @date 2020/6/414:38
 */
@Configuration
public class GateWayFilterConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        // @formatter:off
        return builder.routes()
                .route(r -> r.path("/customer/**")
                        .filters(f -> f.filter(new RequestTimeFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("http://httpbin.org:80/get")
                        .order(0)
                        .id("customer_filter_router")
                )
                .build();
        // @formatter:on
    }

    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }

   /* @Bean
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }*/

   /* @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }*/
}

//package ch.demowebflux.config;
//
//import io.netty.handler.codec.http.HttpMethod;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@EnableWebFluxSecurity
//public class WebSecurityConfiguration {
//
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(
//            ServerHttpSecurity http) {
//        http.csrf().disable()
//                .authorizeExchange()
//                .pathMatchers("/**").permitAll()
//                .and()
//                .httpBasic();
//        return http.build();
//    }
//}

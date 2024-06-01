package com.personal.webflux.common;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class TestMonoFlux {
    @Test
    void testFlux() {
        Flux<?> fluxString = Flux.just("One","Two","Three").log();
        fluxString.subscribe(System.out::println);
    }
}

package com.personal.webflux.service;

import com.personal.webflux.model.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CustomerService {

    private static void sleepExecution(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Customer> getCustomer() {
        return IntStream.rangeClosed(1,10)
                .peek(CustomerService::sleepExecution)
                .peek(i -> System.out.println("Processing: " + i))
                .mapToObj(i -> new Customer(i, "customer"+i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomerReactive() {
        return Flux.range(1,10)
                .delayElements(Duration.ofMillis(1000))
                .doOnNext(i -> System.out.println("Processing Reactive: " + i))
                .map(i -> new Customer(i, "customer"+i));
    }
}

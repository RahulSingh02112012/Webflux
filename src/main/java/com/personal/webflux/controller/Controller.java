package com.personal.webflux.controller;

import com.personal.webflux.model.Customer;
import com.personal.webflux.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> getCustomer() {
        return customerService.getCustomer();
    }

    @GetMapping(value = "/reactive/customer", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getCustomerReactive() {
        return customerService.getCustomerReactive();
    }
}

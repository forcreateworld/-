package io.github.pj.cattletraceabilitybackend.service.interfaces;

import io.github.pj.cattletraceabilitybackend.entity.Customer;

public interface CustomerService {
    Customer findByUsername(String username);
    void register(String username, String password);
}
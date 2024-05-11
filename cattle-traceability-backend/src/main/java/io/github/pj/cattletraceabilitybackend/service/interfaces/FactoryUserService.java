package io.github.pj.cattletraceabilitybackend.service.interfaces;

import io.github.pj.cattletraceabilitybackend.entity.FactoryUser;

public interface FactoryUserService {
    FactoryUser findByUsername(String username);
    void register(String username, String password);
}

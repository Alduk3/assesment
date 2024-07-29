package com.riwi.assesment.infrastructure.abstract_services;

public interface Create <REQUEST, RESPONSE> {
    RESPONSE create(REQUEST request);
}

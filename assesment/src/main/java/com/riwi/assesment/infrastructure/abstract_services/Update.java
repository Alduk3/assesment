package com.riwi.assesment.infrastructure.abstract_services;

public interface Update <RESPONSE, REQUEST, ID>{
    RESPONSE update(REQUEST request, ID id);
}

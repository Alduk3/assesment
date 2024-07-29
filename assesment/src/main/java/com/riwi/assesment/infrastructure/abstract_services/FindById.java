package com.riwi.assesment.infrastructure.abstract_services;

public interface FindById <RESPONSE, ID>{
    RESPONSE getById(ID id);
}

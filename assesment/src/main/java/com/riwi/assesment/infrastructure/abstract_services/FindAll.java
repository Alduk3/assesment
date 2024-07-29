package com.riwi.assesment.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

public interface FindAll <RESPONSE>{
    Page<RESPONSE> getAll(int page, int size);
}

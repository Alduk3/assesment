package com.riwi.assesment.infrastructure.abstract_services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindAll <RESPONSE>{
    Page<RESPONSE> getAll(int page, int size);
}

package com.riwi.assesment.infrastructure.helpers;

import com.riwi.assesment.utils.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SupportServices <Entity>{
    public Entity findById(JpaRepository<Entity, String> repository, String id, String name) {
        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException(String.format("id not found: ", name)));
    }
}

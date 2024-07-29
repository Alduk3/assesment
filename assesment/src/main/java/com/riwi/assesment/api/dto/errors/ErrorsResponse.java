package com.riwi.assesment.api.dto.errors;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorsResponse extends BaseErrorResponse{
    private List<Map<String, String>> errors;
}

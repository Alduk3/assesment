package com.riwi.assesment.api.dto.response;

import com.riwi.assesment.domain.entities.History;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryOfUserResponse extends UserBasicResponse{
    private List<History> histories;
}

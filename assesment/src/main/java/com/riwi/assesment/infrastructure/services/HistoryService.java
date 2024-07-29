package com.riwi.assesment.infrastructure.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.assesment.api.dto.request.HistoryRequest;
import com.riwi.assesment.api.dto.response.HistoryResponse;
import com.riwi.assesment.domain.entities.History;
import com.riwi.assesment.domain.repositories.HistoryRepo;
import com.riwi.assesment.infrastructure.abstract_services.IHistoryService;
import com.riwi.assesment.infrastructure.mappers.HistoryMapper;
import com.riwi.assesment.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HistoryService implements IHistoryService {

    @Autowired
    private HistoryRepo historyRepo;

    @Autowired
    private final HistoryMapper historyMapper;

    @Override
    public HistoryResponse create(HistoryRequest request) {
        History history = historyMapper.toHistory(request);
        history.setRedemptionDate(new Date());
        History savedHistory = historyRepo.save(history);
        return historyMapper.toHistoryResponse(savedHistory);
    }

    @Override
    public void delete(String id) {
        historyRepo.deleteById(id);
    }

    @Override
    public Page<HistoryResponse> getAll(int page, int size) {
        Page<History> historyPage = historyRepo.findAll(PageRequest.of(page, size));
        return historyPage.map(historyMapper::toHistoryResponse);
    }

    @Override
    public HistoryResponse getById(String id) {
        History history = historyRepo.findById(id)
                .orElseThrow(() -> new BadRequestException("History not found"));
        return historyMapper.toHistoryResponse(history);
    }

    @Override
    public HistoryResponse update(HistoryRequest request, String id) {
        History history = historyRepo.findById(id)
                .orElseThrow(() -> new BadRequestException("History not found"));
        historyMapper.updateHistoryFromRequest(request, history);
        History updatedHistory = historyRepo.save(history);
        return historyMapper.toHistoryResponse(updatedHistory);
    }

}

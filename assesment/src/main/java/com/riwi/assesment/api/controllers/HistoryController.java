package com.riwi.assesment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.assesment.api.dto.request.HistoryRequest;
import com.riwi.assesment.api.dto.response.HistoryResponse;
import com.riwi.assesment.infrastructure.abstract_services.IHistoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/history")
@AllArgsConstructor
public class HistoryController {

    @Autowired
    private IHistoryService historyService;

    @GetMapping
    public ResponseEntity<Page<HistoryResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "NONE") String sortType) {

        Page<HistoryResponse> response = historyService.getAll(page - 1, size);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<HistoryResponse> get(@PathVariable String id) {
        HistoryResponse response = historyService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<HistoryResponse> insert(@Validated @RequestBody HistoryRequest request) {
        HistoryResponse response = historyService.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<HistoryResponse> update(@Validated @RequestBody HistoryRequest request,
            @PathVariable String id) {
        HistoryResponse response = historyService.update(request, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        historyService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

package com.riwi.assesment.infrastructure.abstract_services;

import com.riwi.assesment.api.dto.request.HistoryRequest;
import com.riwi.assesment.api.dto.response.HistoryResponse;

public interface IHistoryService
    extends Create<HistoryRequest, HistoryResponse>, 
        Delete<String>, FindAll<HistoryResponse>, 
        FindById<HistoryResponse, String>,
        Update<HistoryResponse, HistoryRequest, String>
{
  
}

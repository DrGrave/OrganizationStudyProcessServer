package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.SupportingDataForWork;

public interface SupportingDataForWorkService {
    void saveSupportingDataForWork(SupportingDataForWork supportingDataForWork);
    SupportingDataForWork getSupportingDataForWorkById(int id);

}

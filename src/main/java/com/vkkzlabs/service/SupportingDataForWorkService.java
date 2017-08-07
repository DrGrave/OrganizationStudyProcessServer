package com.vkkzlabs.service;

import com.vkkzlabs.entity.SupportingDataForWork;

public interface SupportingDataForWorkService {
    void saveSupportingDataForWork(SupportingDataForWork supportingDataForWork);
    SupportingDataForWork getSupportingDataForWorkById(int id);

}

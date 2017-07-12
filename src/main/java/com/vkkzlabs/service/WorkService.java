package com.vkkzlabs.service;

import com.vkkzlabs.entity.Work;

/**
 * Created by vadim on 11.07.17.
 */
public interface WorkService {
    void saveWork(Work work);
    Work getWorkByIdWork(int idWork);
}

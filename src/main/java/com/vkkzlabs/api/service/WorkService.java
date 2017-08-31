package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.Work;

import java.util.List;

/**
 * Created by vadim on 11.07.17.
 */
public interface WorkService {
    void saveWork(Work work);
    Work getWorkByIdWork(int idWork);

    List<Work> getWorksByIdUserAndIdSubject(int idProfessor, int idSubject);

    void changeWork(Work work);

    void deleteWork(Work work);
}

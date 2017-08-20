package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.Attorney;

/**
 * Created by vadim on 11.07.17.
 */
public interface AttorneyService {
    void saveAttorney(Attorney attorney);
    Attorney getAttorneyByIdAttorney(int idAttorney);
}

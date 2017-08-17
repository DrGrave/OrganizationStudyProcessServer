package com.vkkzlabs.api.service;


import com.vkkzlabs.api.entity.Chair;

public interface ChairService {
    void saveChair(Chair chair);
    Chair getChairById(int idChair);
}

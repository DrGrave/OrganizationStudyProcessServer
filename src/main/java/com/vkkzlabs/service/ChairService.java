package com.vkkzlabs.service;


import com.vkkzlabs.entity.Chair;

public interface ChairService {
    void saveChair(Chair chair);
    Chair getChairById(int idChair);
}

package com.vkkzlabs.service;


import com.vkkzlabs.entity.Gender;

public interface GenderService {
    void saveGender(Gender gender);
    Gender getGenderById(int idGender);
}

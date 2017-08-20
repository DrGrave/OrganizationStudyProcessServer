package com.vkkzlabs.api.service;


import com.vkkzlabs.api.entity.Gender;

public interface GenderService {
    void saveGender(Gender gender);
    Gender getGenderById(int idGender);
}

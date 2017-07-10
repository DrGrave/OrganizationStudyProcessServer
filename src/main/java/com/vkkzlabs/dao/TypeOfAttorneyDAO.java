package com.vkkzlabs.dao;

import com.vkkzlabs.entity.TypeOfAttorney;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface TypeOfAttorneyDAO extends CrudRepository<TypeOfAttorney, Long>{
    TypeOfAttorney getByIdTypeOfAttorney(int idTypeOfAttorney);
}

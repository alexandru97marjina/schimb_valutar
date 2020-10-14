package com.marjina.schimb_valutar.common.persistence.repositories;

import com.marjina.schimb_valutar.common.persistence.models.CurrencyDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyDictionaryRepository extends JpaRepository<CurrencyDictionary, Integer> {

    Optional<CurrencyDictionary> findFirstByCurrencyCode(String currencyCode);

}

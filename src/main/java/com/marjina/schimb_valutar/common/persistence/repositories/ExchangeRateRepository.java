package com.marjina.schimb_valutar.common.persistence.repositories;

import com.marjina.schimb_valutar.common.persistence.models.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {

    Optional<ExchangeRate> findByDateGreaterThanEqualAndCurrencyCode_CurrencyCode(Date date, String currencyCode);

}

package com.marjina.schimb_valutar.common.persistence.repositories;

import com.marjina.schimb_valutar.common.persistence.models.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Integer> {

}

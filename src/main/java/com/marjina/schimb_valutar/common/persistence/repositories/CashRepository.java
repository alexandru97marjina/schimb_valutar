package com.marjina.schimb_valutar.common.persistence.repositories;

import com.marjina.schimb_valutar.common.persistence.models.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CashRepository extends JpaRepository<Cash,Integer> {

    Optional<Cash> findByUser_UserNameAndCurrencyDictionary_CurrencyCode(String userName, String currencyCode);

}

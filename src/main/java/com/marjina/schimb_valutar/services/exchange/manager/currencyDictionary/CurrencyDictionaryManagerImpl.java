package com.marjina.schimb_valutar.services.exchange.manager.currencyDictionary;

import com.marjina.schimb_valutar.common.helper.exception.NotFoundException;
import com.marjina.schimb_valutar.common.persistence.models.CurrencyDictionary;
import com.marjina.schimb_valutar.common.persistence.repositories.CurrencyDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyDictionaryManagerImpl implements CurrencyDictionaryManager {

    @Autowired
    private CurrencyDictionaryRepository currencyDictionaryDAO;

    @Override
    public CurrencyDictionary getCurrencyDictionaryByCode(String code) throws NotFoundException {
        return  currencyDictionaryDAO.findFirstByCurrencyCode(code.toUpperCase()).orElseThrow(
                () -> new NotFoundException("Currency with code = " + code + "not found in database"));
    }

}

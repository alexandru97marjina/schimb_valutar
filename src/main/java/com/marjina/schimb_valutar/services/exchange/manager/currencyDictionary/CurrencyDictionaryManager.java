package com.marjina.schimb_valutar.services.exchange.manager.currencyDictionary;

import com.marjina.schimb_valutar.common.helper.exception.NotFoundException;
import com.marjina.schimb_valutar.common.persistence.models.CurrencyDictionary;

public interface CurrencyDictionaryManager {

    CurrencyDictionary getCurrencyDictionaryByCode(String code) throws NotFoundException;

}

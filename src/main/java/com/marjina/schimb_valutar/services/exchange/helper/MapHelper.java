package com.marjina.schimb_valutar.services.exchange.helper;

import com.marjina.schimb_valutar.common.helper.exception.NotFoundException;
import com.marjina.schimb_valutar.common.persistence.models.CurrencyExchange;
import com.marjina.schimb_valutar.common.persistence.models.ExchangeRate;
import com.marjina.schimb_valutar.services.exchange.dto.currencyExchange.CurrencyExchangeReqDTO;
import com.marjina.schimb_valutar.services.exchange.dto.exchangeRate.ExchangeRateReqDTO;

public interface MapHelper {

    ExchangeRate mapExchangeReqDTOToExchangeRate(ExchangeRateReqDTO exchangeRateReqDTO) throws NotFoundException;

    CurrencyExchange mapCurrencyExchangeReqDTOToCurrencyExchange(CurrencyExchangeReqDTO reqDTO) throws NotFoundException;

}

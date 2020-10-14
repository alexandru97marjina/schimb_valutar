package com.marjina.schimb_valutar.services.exchange.helper;

import com.marjina.schimb_valutar.common.helper.exception.NotFoundException;
import com.marjina.schimb_valutar.common.persistence.models.Cash;
import com.marjina.schimb_valutar.common.persistence.models.CurrencyExchange;
import com.marjina.schimb_valutar.common.persistence.models.ExchangeRate;
import com.marjina.schimb_valutar.services.exchange.dto.cashUpdate.CashUpdateReqDTO;
import com.marjina.schimb_valutar.services.exchange.dto.currencyExchange.CurrencyExchangeReqDTO;
import com.marjina.schimb_valutar.services.exchange.dto.exchangeRate.ExchangeRateReqDTO;

import java.text.ParseException;

public interface MapHelper {

    ExchangeRate mapExchangeReqDTOToExchangeRate(ExchangeRateReqDTO exchangeRateReqDTO) throws NotFoundException;

    CurrencyExchange mapCurrencyExchangeReqDTOToCurrencyExchange(CurrencyExchangeReqDTO reqDTO) throws NotFoundException;

    Cash mapCashUpdateReqDTOToCash(CashUpdateReqDTO reqDTO, Cash cash) throws NotFoundException, ParseException;

}

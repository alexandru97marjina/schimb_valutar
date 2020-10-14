package com.marjina.schimb_valutar.services.exchange;

import com.marjina.schimb_valutar.common.helper.exception.NotFoundException;
import com.marjina.schimb_valutar.services.exchange.dto.cashUpdate.CashUpdateReqDTO;
import com.marjina.schimb_valutar.services.exchange.dto.currencyExchange.CurrencyExchangeReqDTO;
import com.marjina.schimb_valutar.services.exchange.dto.currencyExchange.CurrencyExchangeResDTO;
import com.marjina.schimb_valutar.services.exchange.dto.exchangeRate.ExchangeRateListReqDTO;
import com.marjina.schimb_valutar.services.exchange.dto.exchangeRate.ExchangeRateResDTO;

import java.text.ParseException;

public interface ExchangeService {

    void saveExchangeRates(ExchangeRateListReqDTO exchangeRateListReqDTO);

    ExchangeRateResDTO getExchangeRate(String currencyCode) throws NotFoundException;

    CurrencyExchangeResDTO exchange(CurrencyExchangeReqDTO reqDTO) throws NotFoundException;

    void updateCashAmount(CashUpdateReqDTO reqDTO) throws NotFoundException, ParseException;

}

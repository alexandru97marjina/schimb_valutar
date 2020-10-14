package com.marjina.schimb_valutar.services.exchange.helper;

import com.marjina.schimb_valutar.common.helper.exception.NotFoundException;
import com.marjina.schimb_valutar.common.persistence.models.CurrencyDictionary;
import com.marjina.schimb_valutar.common.persistence.models.CurrencyExchange;
import com.marjina.schimb_valutar.common.persistence.models.ExchangeRate;
import com.marjina.schimb_valutar.services.exchange.dto.currencyExchange.CurrencyExchangeReqDTO;
import com.marjina.schimb_valutar.services.exchange.dto.exchangeRate.ExchangeRateReqDTO;
import com.marjina.schimb_valutar.services.exchange.manager.currencyDictionary.CurrencyDictionaryManager;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapHelperImpl implements MapHelper {

    @Autowired
    private CurrencyDictionaryManager currencyDictionaryManager;

    /**
     * Map ExchangeReqDTO to ExchangeRate
     *
     * @param exchangeRateReqDTO ExchangeReqDTO object
     * @return ExchangeRate
     * @throws NotFoundException in case of not found object in database
     */
    @Override
    public ExchangeRate mapExchangeReqDTOToExchangeRate(ExchangeRateReqDTO exchangeRateReqDTO) throws NotFoundException {
        CurrencyDictionary currencyCode = currencyDictionaryManager.getCurrencyDictionaryByCode(exchangeRateReqDTO.getCurrencyCode());

        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setCurrencyCode(currencyCode);
        exchangeRate.setBaseRate(exchangeRateReqDTO.getBaseRate());
        exchangeRate.setExchangeValue(exchangeRateReqDTO.getExchangeValue());
        exchangeRate.setDate(DateTime.now().withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).toDate());

        return exchangeRate;
    }

    @Override
    public CurrencyExchange mapCurrencyExchangeReqDTOToCurrencyExchange(CurrencyExchangeReqDTO reqDTO) throws NotFoundException {
        CurrencyDictionary currencyCode = currencyDictionaryManager.getCurrencyDictionaryByCode(reqDTO.getCurrencyCode());
        Double exchangeValue = reqDTO.getExchangeValue();
        Double amountReceived = reqDTO.getAmountReceived();

        CurrencyExchange currencyExchange = new CurrencyExchange();
        currencyExchange.setCurrencyCode(currencyCode);
        currencyExchange.setExchangeValue(exchangeValue);
        currencyExchange.setAmountReceived(amountReceived);
        currencyExchange.setAmountReleased(exchangeValue * amountReceived);

        return currencyExchange;
    }


}

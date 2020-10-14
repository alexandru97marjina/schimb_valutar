package com.marjina.schimb_valutar.services.exchange.dto.currencyExchange;

import com.marjina.schimb_valutar.common.persistence.models.CurrencyExchange;
import lombok.Data;

@Data
public class CurrencyExchangeResDTO {

    private String currencyCode;
    private Double exchangeValue;
    private Double amountReceived;
    private Double amountReleased;

    /**
     * Init CurrencyExchangeResDTO by currencyExchange
     *
     * @param currencyExchange CurrencyExchangeResDTO resDTO
     */
    public CurrencyExchangeResDTO(CurrencyExchange currencyExchange){
        this.currencyCode = currencyExchange.getCurrencyCode().getCurrencyCode();
        this.exchangeValue = currencyExchange.getExchangeValue();
        this.amountReceived = currencyExchange.getAmountReceived();
        this.amountReleased = currencyExchange.getAmountReleased();
    }

}

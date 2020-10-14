package com.marjina.schimb_valutar.services.exchange.dto.currencyExchange;

import lombok.Data;

@Data
public class CurrencyExchangeReqDTO {

    private String currencyCode;
    private Double exchangeValue;
    private Double amountReceived;

}

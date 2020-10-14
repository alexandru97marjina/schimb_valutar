package com.marjina.schimb_valutar.services.exchange.dto.exchangeRate;

import lombok.Data;

@Data
public class ExchangeRateReqDTO {

    private String currencyCode;
    private Integer baseRate;
    private Double exchangeValue;

}

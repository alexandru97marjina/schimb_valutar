package com.marjina.schimb_valutar.services.exchange.dto.exchangeRate;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ExchangeRateListReqDTO implements Serializable {

    private List<ExchangeRateReqDTO> exchangeRates;

}

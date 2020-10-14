package com.marjina.schimb_valutar.services.exchange.dto.cashUpdate;

import lombok.Data;

@Data
public class CashUpdateReqDTO {

    private String userName;
    private String currencyCode;
    private Double cashAmount;
    private String data;

}

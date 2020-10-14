package com.marjina.schimb_valutar.services.exchange.dto.exchangeRate;

import com.marjina.schimb_valutar.common.persistence.models.ExchangeRate;
import lombok.Data;

import static com.marjina.schimb_valutar.common.util.DateUtil.parseDateToString;
import static com.marjina.schimb_valutar.common.util.consts.GlobalConst.VALID_DATE_FORMAT;

@Data
public class ExchangeRateResDTO {

    private String currencyCode;
    private Integer baseRate;
    private Double exchangeValue;
    private String date;

    /**
     * Init ExchangeResDTO object from ExchangeRate
     *
     * @param exchangeRate ExchangeRate object
     */
    public ExchangeRateResDTO(ExchangeRate exchangeRate){
        this.currencyCode = exchangeRate.getCurrencyCode().getCurrencyCode();
        this.baseRate = exchangeRate.getBaseRate();
        this.exchangeValue = exchangeRate.getExchangeValue();
        this.date = parseDateToString(exchangeRate.getDate(),VALID_DATE_FORMAT);
    }

}

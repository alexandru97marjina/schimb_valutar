package com.marjina.schimb_valutar.services.exchange;

import com.marjina.schimb_valutar.common.helper.exception.NotFoundException;
import com.marjina.schimb_valutar.common.persistence.models.Cash;
import com.marjina.schimb_valutar.common.persistence.models.CurrencyExchange;
import com.marjina.schimb_valutar.common.persistence.models.ExchangeRate;
import com.marjina.schimb_valutar.common.persistence.repositories.CashRepository;
import com.marjina.schimb_valutar.common.persistence.repositories.CurrencyExchangeRepository;
import com.marjina.schimb_valutar.common.persistence.repositories.ExchangeRateRepository;
import com.marjina.schimb_valutar.services.exchange.dto.cashUpdate.CashUpdateReqDTO;
import com.marjina.schimb_valutar.services.exchange.dto.currencyExchange.CurrencyExchangeReqDTO;
import com.marjina.schimb_valutar.services.exchange.dto.currencyExchange.CurrencyExchangeResDTO;
import com.marjina.schimb_valutar.services.exchange.dto.exchangeRate.ExchangeRateListReqDTO;
import com.marjina.schimb_valutar.services.exchange.dto.exchangeRate.ExchangeRateResDTO;
import com.marjina.schimb_valutar.services.exchange.helper.MapHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.marjina.schimb_valutar.common.util.DateUtil.getCurrentDate;

@Service
@Transactional
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private MapHelper mapHelper;

    @Autowired
    private ExchangeRateRepository exchangeRateDAO;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeDAO;

    @Autowired
    private CashRepository cashDAO;

    /**
     * Save list of Exchange Rates in data base
     *
     * @param exchangeRateListReqDTO ExchangeListReqDTO object
     */
    @Override
    public void saveExchangeRates(ExchangeRateListReqDTO exchangeRateListReqDTO) {
        List<ExchangeRate> exchangeRates = exchangeRateListReqDTO.getExchangeRates().stream()
                .map(e -> {
                    try {
                        return mapHelper.mapExchangeReqDTOToExchangeRate(e);
                    } catch (NotFoundException notFoundException) {
                        notFoundException.printStackTrace();

                        return null;
                    }
                }).collect(Collectors.toList());

        //remove null object with invalid exchange code
        exchangeRates.removeAll(Collections.singleton(null));

        exchangeRateDAO.saveAll(exchangeRates);
    }

    /**
     * Get exchangeRate for currentDate by currencyCode
     *
     * @param currencyCode String currencyCode
     * @return ExchangeResDTO object
     * @throws NotFoundException in case of not found Exchange rate
     */
    @Override
    public ExchangeRateResDTO getExchangeRate(String currencyCode) throws NotFoundException {
        ExchangeRate exchangeRate = exchangeRateDAO.findByDateGreaterThanEqualAndCurrencyCode_CurrencyCode(
                getCurrentDate(), currencyCode).orElseThrow(() ->
                new NotFoundException("ExchangeRate for currentDate with currency code = "
                        + currencyCode + "not found in database"));

        return exchangeRate != null ? new ExchangeRateResDTO(exchangeRate) : null;
    }

    /**
     * Make a currency exchange
     *
     * @param reqDTO CurrencyExchangeReqDTO reqDTO
     * @return CurrencyExchangeResDTO
     * @throws NotFoundException in case of not found currency
     */
    @Override
    public CurrencyExchangeResDTO exchange(CurrencyExchangeReqDTO reqDTO) throws NotFoundException {
        CurrencyExchange currencyExchange = mapHelper.mapCurrencyExchangeReqDTOToCurrencyExchange(reqDTO);

        return new CurrencyExchangeResDTO(currencyExchangeDAO.save(currencyExchange));
    }

    /**
     * Update cash amount
     *
     * @param reqDTO CashUpdateReqDTO
     * @throws NotFoundException in case of not found currency or user
     * @throws ParseException    in case of parse exception
     */
    @Override
    public void updateCashAmount(CashUpdateReqDTO reqDTO) throws NotFoundException, ParseException {
        Cash cash = cashDAO.findByUser_UserNameAndCurrencyDictionary_CurrencyCode(reqDTO.getUserName(), reqDTO.getCurrencyCode())
                .orElse(new Cash());
        cash = mapHelper.mapCashUpdateReqDTOToCash(reqDTO, cash);

        cashDAO.save(cash);
    }

}

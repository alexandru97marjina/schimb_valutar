package com.marjina.schimb_valutar.controllers;

import com.marjina.schimb_valutar.common.dto.ResponseDTO;
import com.marjina.schimb_valutar.common.helper.exception.NotFoundException;
import com.marjina.schimb_valutar.services.exchange.ExchangeService;
import com.marjina.schimb_valutar.services.exchange.dto.cashUpdate.CashUpdateReqDTO;
import com.marjina.schimb_valutar.services.exchange.dto.currencyExchange.CurrencyExchangeReqDTO;
import com.marjina.schimb_valutar.services.exchange.dto.exchangeRate.ExchangeRateListReqDTO;
import com.marjina.schimb_valutar.services.exchange.dto.exchangeRate.ExchangeRateResDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

import java.text.ParseException;

import static com.marjina.schimb_valutar.common.util.consts.GlobalConst.SUCCESS;
import static java.util.Collections.emptyList;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    /**
     * Save exchange rates to db
     *
     * @return Response entity
     */
    @ApiOperation(value = "Save exchange rates to db")
    @PostMapping(value = "/rate")
    public ResponseEntity<ResponseDTO> saveExchangeRates(@RequestBody ExchangeRateListReqDTO exchangeRateListReqDTO) {
        exchangeService.saveExchangeRates(exchangeRateListReqDTO);

        return ResponseEntity.ok(new ResponseDTO<>(SUCCESS, null, null, emptyList()));
    }

    /**
     * Get exchange rate from db
     *
     * @return Response entity
     */
    @ApiOperation(value = "Get exchange rate from db")
    @GetMapping(value = "/rate")
    public ResponseEntity<ResponseDTO> getExchangeRate(@PathParam("currencyCode") String currencyCode) throws NotFoundException {
        ExchangeRateResDTO resDTO = exchangeService.getExchangeRate(currencyCode);

        return ResponseEntity.ok(new ResponseDTO<>(SUCCESS, resDTO, null, emptyList()));
    }

    /**
     * Make an exchange
     *
     * @return Response entity
     */
    @ApiOperation(value = "Make an exchange")
    @PostMapping()
    public ResponseEntity<ResponseDTO> exchange(@RequestBody CurrencyExchangeReqDTO reqDTO) throws NotFoundException {
        return ResponseEntity.ok(new ResponseDTO<>(SUCCESS, exchangeService.exchange(reqDTO), null, emptyList()));
    }

    /**
     * Update cash amount
     *
     * @return Response entity
     */
    @ApiOperation(value = "Update cash amount")
    @PutMapping("/update/cash")
    public ResponseEntity<ResponseDTO> updateCash(@RequestBody CashUpdateReqDTO reqDTO) throws NotFoundException, ParseException {
        exchangeService.updateCashAmount(reqDTO);

        return ResponseEntity.ok(new ResponseDTO<>(SUCCESS, null, null, emptyList()));
    }

}

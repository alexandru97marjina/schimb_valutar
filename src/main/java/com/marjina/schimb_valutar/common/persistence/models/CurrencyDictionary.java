package com.marjina.schimb_valutar.common.persistence.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "currency_dictionaries")
public class CurrencyDictionary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(name = "currency_code")
    private String currencyCode;

    private String name;

    @OneToMany(mappedBy = "currencyCode")
    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ExchangeRate> exchangeRates;

    @OneToMany(mappedBy = "currencyCode")
    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CurrencyExchange> currencyExchanges;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd H:i:s")
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd H:i:s")
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updatedAt;

}

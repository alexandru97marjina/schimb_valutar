package com.marjina.schimb_valutar.common.persistence.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@NoArgsConstructor
@Table(name = "exchange_rates")
public class ExchangeRate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(name = "base_rate")
    @ColumnDefault("0")
    private Integer baseRate;

    @Column(name = "exchange_value")
    @ColumnDefault("0.0")
    private Double exchangeValue;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date date;

    @ManyToOne(fetch = LAZY)
    @JsonBackReference
    @JoinColumn(name = "currency_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT), nullable = false)
    @ColumnDefault("0")
    private CurrencyDictionary currencyCode;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd H:i:s")
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd H:i:s")
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updatedAt;

}

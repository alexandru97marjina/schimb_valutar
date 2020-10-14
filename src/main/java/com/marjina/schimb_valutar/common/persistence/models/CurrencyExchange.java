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
@Table(name = "currency_exchanges")
public class CurrencyExchange implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(name = "exchange_value")
    private Double exchangeValue;

    @Column(name = "amount_received")
    private Double amountReceived;

    @Column(name = "amount_released")
    private Double amountReleased;

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

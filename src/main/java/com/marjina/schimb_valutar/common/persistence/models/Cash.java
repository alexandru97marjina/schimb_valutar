package com.marjina.schimb_valutar.common.persistence.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cash")
public class Cash implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(name = "cash_amount")
    private Double cashAmount;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "currency_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonBackReference
    private CurrencyDictionary currencyDictionary;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonBackReference
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date date;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd H:i:s")
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd H:i:s")
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updatedAt;

}

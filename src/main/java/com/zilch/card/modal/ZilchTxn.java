package com.zilch.card.modal;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@Entity()
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ZilchTxn {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String note;
    @Column(name = "price", precision = 19, scale = 4)
    private BigDecimal price;
    private Long customerId;
}

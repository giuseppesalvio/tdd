package com.arca.poc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContoCorrente {


    private String id;
    private Integer saldo;
}

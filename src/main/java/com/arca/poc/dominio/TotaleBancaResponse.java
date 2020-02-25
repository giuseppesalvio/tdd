package com.arca.poc.dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TotaleBancaResponse {

    public String codiceCliente;

    public BigDecimal totaleConto;
}

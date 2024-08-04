package br.com.gverga.domain;

import br.com.gverga.anotacao.TipoChave;

import java.math.BigDecimal;

public class Product implements  Persistente{
    @TipoChave("getCode")
    private Long code;
    private String name;
    private BigDecimal value;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}

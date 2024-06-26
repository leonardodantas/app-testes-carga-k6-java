package com.br.testes.carga.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private String id;
    private String name;
    private String code;
    private BigDecimal value;
    private String description;
    private Categories categories;

    public List<String> getCategoriesAsListString() {
        return categories.getValue().stream().map(String::toUpperCase).toList();
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                '}';
    }
}

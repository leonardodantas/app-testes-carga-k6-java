package com.br.testes.carga.infra.http.converters;

import com.br.testes.carga.domains.Categories;
import com.br.testes.carga.domains.Product;
import com.br.testes.carga.infra.http.jsons.requests.ProductRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductConverter implements Converter<ProductRequest, Product> {

    @Override
    public Product convert(final ProductRequest request) {
        return Product.builder()
                .name(request.name())
                .code(request.code().toUpperCase())
                .value(request.value())
                .description(request.description())
                .categories(convert(request.categories()))
                .build();
    }

    private Categories convert(final List<String> values) {
        final var valuesLowerCase = values.stream().map(String::toLowerCase).toList();
        return Categories.builder()
                .value(valuesLowerCase)
                .build();
    }
}

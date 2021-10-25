package br.com.slv.converters;

import java.math.BigDecimal;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ValorPersistenceConverter implements AttributeConverter<BigDecimal, Double> {

	@Override
	public Double convertToDatabaseColumn(BigDecimal preco) {
		return preco.doubleValue();
	}

	@Override
	public BigDecimal convertToEntityAttribute(Double preco) {
		return new BigDecimal(preco);
	}

}
